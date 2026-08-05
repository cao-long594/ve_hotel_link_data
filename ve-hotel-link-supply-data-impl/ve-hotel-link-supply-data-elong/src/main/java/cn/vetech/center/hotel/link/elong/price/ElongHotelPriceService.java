package cn.vetech.center.hotel.link.elong.price;

import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelPriceEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.data.common.util.RoomUtils;
import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongHttp;
import cn.vetech.center.hotel.link.elong.price.request.ElongDataRateRequest;
import cn.vetech.center.hotel.link.elong.price.request.ElongHotelPriceRequest;
import cn.vetech.center.hotel.link.elong.price.response.DataRateInfo;
import cn.vetech.center.hotel.link.elong.price.response.ElongDataRateResponse;
import cn.vetech.center.hotel.link.elong.price.response.ElongHotelPriceResponse;
import cn.vetech.center.hotel.link.elong.price.response.RateInfo;
import cn.vetech.center.hotel.link.elong.ratesearch.response.*;
import cn.vetech.center.hotel.link.enums.BusinessKeyEnum;
import cn.vetech.center.hotel.link.ratelimt.RateLimitClient;
import cn.vetech.center.hotel.link.ratelimt.RateLimiter;
import cn.vetech.center.hotel.link.ratelimt.RateLimiterUtil;
import cn.vetech.center.hotel.link.supply.service.mapping.HotelInfoService;
import cn.vetech.center.hotel.link.supply.service.mapping.model.HotelBaseInfo;
import cn.vetech.center.hotel.link.supply.service.mapping.model.RoomBaseInfo;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import cn.vetech.charge.cloud.modules.utils.mapper.BeanMapper;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/***
 * 艺龙最低价服务
 * @author xiaotengyu
 */
@Service
public class ElongHotelPriceService extends ElongHttp {

    /****
     *  日志
     */
    private Logger logger = LoggerFactory.getLogger(ElongHotelPriceService.class);

    /**
     * 查询报价
     */
    private final String hotelPriceUrl = "hotel.detail";
    /**
     * 静态查询价格接口
     */
    private final String staticDataRateUrl = "hotel.data.rate";

    /**
     * 艺龙查询报价使用http
     */
    private final String http = "http";

    /***
     * 调用服务重试次数
     */
    private final int repostIndex = 2;
    /***
     * 请求接口出错，线程暂停的毫秒数
     */
    private final int sleepMillis = 4000;
    /***
     * 每次查询酒店接口，酒店个数
     */
    private final int eachHotelIds = 9;
    /***
     * 服务
     */
    @Autowired
    private HotelInfoService hotelInfoService;
    /***
     * 最低价抓取
     */
    private final String zdjzq = "1";
    /***
     * client
     */
    @Autowired
    private RateLimitClient rateLimitClient;

     /***
     * 获取最低价
     * @param dto 请求
     * @return resposne
     */
    public RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) {
        //ElongConstant
        //1.获取配置
        ElongConfig config = getConfig(dto);
        //2.验证请求对象
        DataResponseEnum dataResponseEnum = valData(dto, config);
        if (dataResponseEnum != null) {
            return ApiRes.response(dataResponseEnum);
        }
        if (StringUtils.equalsIgnoreCase(config.getZdjzqfs(), zdjzq)) {
            ElongDataRateRequest request = buildRateRequest(dto, config);
            List<ElongHotelPriceResponse> priceResponses = getElongStaticPriceRespnse(dto, request);
            HotelPriceResponseVO responseVO = buildStatusResponse(priceResponses, config);
            return ApiRes.success(responseVO);
        }
        //3.组装请求对象
        ElongHotelPriceRequest request = buildRequest(dto, config);
        //3.请求房源商接口获取数据
        List<ElongHotelPriceResponse> priceResponses = getElongPriceRespnse(dto, request);
        //4.根据房源商返回的数据，组装HotelPriceResponseVO对象
        HotelPriceResponseVO responseVO = buildResponse(priceResponses);
        return ApiRes.success(responseVO);
    }

       /**
     * 构建请求
     *
     * @param dto    dto
     * @param config config
     * @return data
     */
    private ElongDataRateRequest buildRateRequest(HotelPriceDTO dto, ElongConfig config) {
        ElongDataRateRequest req = new ElongDataRateRequest();
        req.setConfig(config);
        req.setStartDate(dto.getStartDate());
        req.setEndDate(dto.getEndDate());
        req.setPaymentType("Prepay");
        return req;
    }

    /***
     * 获取配置
     * @param dto dto
     * @return config
     */
    private ElongConfig getConfig(HotelPriceDTO dto) {
        return BeanMapper.map(dto.getSupplier(), ElongConfig.class);
    }

    /***
     * 验证数据
     * @param dto 请求参数
     * @param config 配置
     * @return 返回验证结果
     */
     private DataResponseEnum valData(HotelPriceDTO dto, ElongConfig config) {
        if (config == null) {
            return DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED;
        }
        if (dto == null) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        if (CollectionUtils.isEmpty(dto.getHotelIds())) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        if (StringUtils.isBlank(dto.getStartDate())) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        if (StringUtils.isBlank(dto.getEndDate())) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        return null;
    }

    /***
     * 构建请求
     * @param dto dto
     * @param config config
     * @return response
     */
       private ElongHotelPriceRequest buildRequest(HotelPriceDTO dto, ElongConfig config) {
        ElongHotelPriceRequest req = new ElongHotelPriceRequest();
        req.setConfig(config);
        req.setArrivalDate(dto.getStartDate());
        req.setDepartureDate(dto.getEndDate());
        req.setPaymentType("Prepay");
        req.setOptions("4");
        if(StringUtils.equalsIgnoreCase(dto.getGngj(), GnGjTypeEnum.GJ.getCode())){
            req.setNumberOfAdults(NumConstant.NUM_1);
            req.setNumberOfRooms(NumConstant.NUM_1);
            req.setChildAges(new ArrayList<>());
            req.setSaveMajiaId(Boolean.TRUE);
        }
        return req;
    }

    /***
     * 获取艺龙价格数据
     * @param request request
     * @return op
     */
     private Optional<ElongHotelPriceResponse> getElongPriceData(ElongHotelPriceRequest request) {
        ElongConfig config = request.getConfig();
        AtomicInteger index = new AtomicInteger(NumConstant.NUM_0);
        String result = StringUtils.EMPTY;
        while (index.get() < repostIndex) {
            try {
                result = sendInvoke(hotelPriceUrl, request.toJson(), config, http, NumConstant.NUM_0);
                if (StringUtils.contains(request.getHotelIds(), "19543353")) {
                    logger.warn("最低价，request:【{}】;result:【{}】，zhmc【{}】", request.toJson(), result, config.getZhmc());
                }
                if (StringUtils.isBlank(result) || StringUtils.contains(result, "访问太频繁")) {
                    logger.warn("请求接口数据为空！request:{};result:{}，zhmc【{}】", request.toJson(), result, config.getZhmc());
                    index.addAndGet(1);
                    continue;
                }
                ElongRateSearchResponse response = JacksonUtils.parseNonEmpty(result, ElongRateSearchResponse.class);
                if (response == null || response.getResult() == null) {
                    logger.warn("请求接口数据为空！request:{};result:{}，zhmc【{}】", request.toJson(), result, config.getZhmc());
                    break;
                }
                if (CollectionUtils.isEmpty(response.getResult().getHotels())) {
                    logger.warn("请求接口数据为空！request:{};result:{}，zhmc【{}】", request.toJson(), result, config.getZhmc());
                    return Optional.empty();
                }
                ElongHotelPriceResponse priceResponse = new ElongHotelPriceResponse();
                priceResponse.setResult(result);
                priceResponse.setResponse(response);
                return Optional.ofNullable(priceResponse);
            } catch (Exception ex) {
                index.addAndGet(1);
                logger.error("最低价，调用艺龙接口异常，request:{};", request.toJson(), ex);
            }

   /***
     * 分批查询艺龙价格数据
     * @param dto 请求
     * @param request 请求
     * @return 数据
     */
    private List<ElongHotelPriceResponse> getElongStaticPriceRespnse(HotelPriceDTO dto, ElongDataRateRequest request) {
        List<String> hotelIds = dto.getHotelIds();
        List<List<String>> idids = Lists.partition(hotelIds, eachHotelIds);
        List<ElongHotelPriceResponse> priceResponses = new ArrayList<>();
        for (List<String> ids : idids) {
            request.setHotelIds(StringUtils.join(ids, ","));
            Optional<ElongHotelPriceResponse> opPriceResponse = getElongStaticDataRate(request);
            opPriceResponse.ifPresent(response -> {
                priceResponses.add(response);
            });
        }
        return priceResponses;
    }

    /***
     * 获取艺龙价格数据
     * @param request request
     * @return data
     */
    private Optional<ElongHotelPriceResponse> getElongStaticDataRate(ElongDataRateRequest request) {
        ElongConfig config = request.getConfig();
        AtomicInteger index = new AtomicInteger(NumConstant.NUM_0);
//        config.setUrl("api.elong.com/rest");
//        config.setVersion("1.32");
//        config.setLocal("zh_CN");
//        config.setUser("5e3aee0acc8f4ceea78054b0c115c359");
//        config.setAppKey("1c4a40677a47b1e2b7984e8c34e63633");
//        config.setSecretKey("7526191334158cef43fc3229dcd3dcd6");
//        config.setStaticUrl("http://api.elongstatic.com/");
//        config.setFyen("elong");

  while (index.get() < repostIndex) {
            try {
                String result = sendInvoke(staticDataRateUrl, request.toJson(), config, http, NumConstant.NUM_0);
                if (StringUtils.isBlank(result) || result.contains("访问太频繁")) {
                    logger.warn("请求接口数据为空！{}", result);
                    index.addAndGet(1);
                    ThreadUtil.sleep(sleepMillis);
                    continue;
                }
                ElongDataRateResponse response = JacksonUtils.parseNonEmpty(result, ElongDataRateResponse.class);
                if (response == null || response.getResult() == null) {
                    logger.warn("请求接口数据为空！{}", result);
                    ThreadUtil.sleep(sleepMillis);
                    index.addAndGet(1);
                    continue;
                }
                if (CollectionUtils.isEmpty(response.getResult().getRates())) {
                    logger.warn("请求接口数据为空！{}, zhmc:【{}】", result, config.getZhmc());
                    return Optional.ofNullable(null);
                }
                ElongHotelPriceResponse priceResponse = new ElongHotelPriceResponse();
                priceResponse.setResult(result);
                priceResponse.setRateResponse(response);
                return Optional.ofNullable(priceResponse);
            } catch (Exception ex) {
                index.addAndGet(NumConstant.NUM_1);
                logger.error("最低价，调用艺龙接口异常，request:{}", request.toJson(), ex);
            }
        }
        return Optional.ofNullable(null);
    }
  /***
     * 构建价格返回对象
     * @param priceResponses price
     * @param config config
     * @return response
     */
    private HotelPriceResponseVO buildStatusResponse(List<ElongHotelPriceResponse> priceResponses, ElongConfig config) {
        HotelPriceResponseVO response = new HotelPriceResponseVO();
        if (CollectionUtils.isEmpty(priceResponses)) {
            return response;
        }
        List<String> results = new ArrayList<>();
        List<HotelPriceVO> hotelPriceVOS = new ArrayList<>();
        for (ElongHotelPriceResponse priceResponse : priceResponses) {
            results.add(priceResponse.getResult());
            ElongDataRateResponse rateResponse = priceResponse.getRateResponse();
            hotelPriceVOS.addAll(getHotelStaticPriceVo(rateResponse, config));  //添加价格
        }
        response.setPriceResponse(results);
        response.setHotelPriceVOS(hotelPriceVOS);
        return response;
    }

    /***
     * 判断是否为周末
     * @param date 日期string
     * @return boolean
     */
    private Boolean isWeek(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int wk = dayOfWeek.getValue();
        if (wk == NumConstant.NUM_6 || wk == NumConstant.NUM_7) {
            return true;
        }
        return false;
    }

      /***
     * 解析价格
     * @param response response
     * @param config config
     * @return data
     */
    private List<HotelPriceVO> getHotelStaticPriceVo(ElongDataRateResponse response, ElongConfig config) {
        DataRateInfo dataRateInfo = response.getResult();
        List<RateInfo> rateInfos = dataRateInfo.getRates();
        List<HotelPriceVO> allHotelPriceVo = new ArrayList<>();
        Map<String, List<RateInfo>> listMap = rateInfos.stream().collect(Collectors.groupingBy(x -> x.getHotelID()));
        List<String> ids = new ArrayList<>();
        listMap.keySet().stream().forEach(id -> ids.add(id));
        // 注：房型名称暂未使用，暂时注释
        Map<String, HotelBaseInfo> hotelMap = new HashMap<>(0);
//        Map<String, HotelBaseInfo> hotelMap = hotelInfoService.getHotelMap(config, ids);
        listMap.forEach((hotelId, rates) -> {
            HotelBaseInfo baseInfo = hotelMap.get(hotelId);
            Map<String, List<RateInfo>> rateMap = rates.stream().collect(Collectors.groupingBy(z -> z.getRoomTypeId()));
            rateMap.forEach((roomId, rateInfs) -> {
                Map<String, List<RateInfo>> gdate = rateInfs.stream().collect(Collectors.groupingBy(z -> z.getEndDate()));
                gdate.forEach((date, rs) -> {
                    Optional<RateInfo> opRate = rs.stream().sorted(Comparator.comparing(RateInfo::getPriceID).reversed()).findFirst();
                    opRate.ifPresent(info -> {
                        allHotelPriceVo.addAll(buildStaticPrice(info, hotelId, baseInfo));
                    });
                });
            });
        });
        return allHotelPriceVo;
    }

    /***
     * 构建静态数据
     * @param rateInfo rate
     * @param hotelId hotelId
     * @param baseInfo baseInfo
     * @return data
     */
       private List<HotelPriceVO> buildStaticPrice(RateInfo rateInfo, String hotelId, HotelBaseInfo baseInfo) {
        List<HotelPriceVO> priceVOS = new ArrayList<>();
        String begin = timeToDate(rateInfo.getStartDate());
        String end = timeToDate(rateInfo.getEndDate());
        long days = VeDate.getDays(end, begin);
        HotelPriceVO priceVO = null;
        for (int i = 0; i <= days; i++) {
            priceVO = new HotelPriceVO();
            priceVO.setHotelId(hotelId);
            Map<String, RoomBaseInfo> roomMap = hotelInfoService.getRoomMap(baseInfo);
            priceVO.setRoomName(RoomUtils.convertRoomName(roomMap.get(rateInfo.getRoomTypeId())));
            priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
            //3.日期、价格，房态
            String ndate = VeDate.getNextDay(begin, String.valueOf(i));
            priceVO.setDate(ndate);
            Boolean wk = isWeek(ndate);
            priceVO.setPrice(wk ? rateInfo.getWeekend() : rateInfo.getMember());
            //4.取消类型
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            //5.早餐
            priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
            //6.活动类型
            priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
            priceVOS.add(priceVO);
        }
        return priceVOS;
    }

  private List<HotelPriceVO> buildStaticPrice(RateInfo rateInfo, String hotelId, HotelBaseInfo baseInfo) {
        List<HotelPriceVO> priceVOS = new ArrayList<>();
        String begin = timeToDate(rateInfo.getStartDate());
        String end = timeToDate(rateInfo.getEndDate());
        long days = VeDate.getDays(end, begin);
        HotelPriceVO priceVO = null;
        for (int i = 0; i <= days; i++) {
            priceVO = new HotelPriceVO();
            priceVO.setHotelId(hotelId);
            Map<String, RoomBaseInfo> roomMap = hotelInfoService.getRoomMap(baseInfo);
            priceVO.setRoomName(RoomUtils.convertRoomName(roomMap.get(rateInfo.getRoomTypeId())));
            priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
            //3.日期、价格，房态
            String ndate = VeDate.getNextDay(begin, String.valueOf(i));
            priceVO.setDate(ndate);
            Boolean wk = isWeek(ndate);
            priceVO.setPrice(wk ? rateInfo.getWeekend() : rateInfo.getMember());
            //4.取消类型
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            //5.早餐
            priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
            //6.活动类型
            priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
            priceVOS.add(priceVO);
        }
        return priceVOS;
    }

 /***
     * 获取价格
     * @param elongSearchRatePlans 价格
     * @param prepayRules 取消参数
     * @param valueAdds 早餐
     * @param name name
     * @return data
     */
    private List<HotelPriceVO> getRatePlans(List<ElongSearchRatePlan> elongSearchRatePlans
            , Map<String, ElongSearchPrepayRule> prepayRules
            , Map<String, ElongSearchValueAdd> valueAdds
            , String name) {
        List<HotelPriceVO> hotelPriceVOS = new ArrayList<>();
        for (ElongSearchRatePlan elongSearchRatePlan : elongSearchRatePlans) {
            List<ElongSearchNightlyRate> elongSearchNightlyRates = elongSearchRatePlan.getNightlyRates();
            if (CollectionUtils.isEmpty(elongSearchNightlyRates)) {
                continue;
            }
            for (ElongSearchNightlyRate elongSearchNightlyRate : elongSearchNightlyRates) {
                HotelPriceVO hotelPriceVO = buildPrice(elongSearchRatePlan, elongSearchNightlyRate, prepayRules, valueAdds, name);
                hotelPriceVOS.add(hotelPriceVO);
            }
        }
        return hotelPriceVOS;
    }

    /***
     * 构建价格
     * @param ratePlan 价格
     * @param nightlyRate 间夜
     * @param prepayRules 取消
     * @param valueAdds 早餐
     * @param name 房间名称
     * @return 价格
     */
     private HotelPriceVO buildPrice(ElongSearchRatePlan ratePlan
            , ElongSearchNightlyRate nightlyRate
            , Map<String, ElongSearchPrepayRule> prepayRules
            , Map<String, ElongSearchValueAdd> valueAdds
            , String name) {
        HotelPriceVO priceVO = new HotelPriceVO();
        priceVO.setHotelId("");  //hotel节点统一处理
        //1.房间名称
        priceVO = getRoomName(priceVO, name);
        //2.支付方式
        priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
        //3.日期、价格，房态
        priceVO = getDateAndPrice(nightlyRate, priceVO);
        //4.取消类型
        priceVO = getCancelRule(ratePlan, prepayRules, priceVO);
        //5.早餐
        priceVO = getBreakfast(priceVO, ratePlan, valueAdds);
        //6.活动类型：没有
        priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
        //发票类型
        if(StringUtils.equalsIgnoreCase(ratePlan.getInvoiceMode(),"Hotel")){
            priceVO.setInvoiceModel(HotelPriceEnum.INVOICE_HOTEL.getCode());
        }else if(StringUtils.equalsIgnoreCase(ratePlan.getInvoiceMode(),"Elong")){
            priceVO.setInvoiceModel(HotelPriceEnum.INVOICE_SUPPLER.getCode());
        }
        return priceVO;
    }

    /***
     * 获取房间名称
     * @param priceVO price
     * @param name name
     * @return data
     */
    private HotelPriceVO getRoomName(HotelPriceVO priceVO, String name) {
        priceVO.setRoomName(RoomUtils.convertRoomName(name));
        return priceVO;
    }

    /**
     * 获取早餐
     *
     * @param priceVO   pricevo
     * @param ratePlan  rateplan
     * @param valueAdds add
     * @return data
     */
    private HotelPriceVO getBreakfast(HotelPriceVO priceVO
            , ElongSearchRatePlan ratePlan
            , Map<String, ElongSearchValueAdd> valueAdds) {
        String ids = ratePlan.getValueAddIds();
        if (StringUtils.isBlank(ids)) {
            priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
            return priceVO;
        }
        String[] addIds = ids.split(",");
        for (int i = 0; i < addIds.length; i++) {
            ElongSearchValueAdd valueAddel = valueAdds.get(addIds[i]);
            if (valueAddel == null) {
                continue;
            }
            //如满足条件则优先取TypeCode为99的特殊早餐
            if (StringUtils.equals("99", valueAddel.getTypeCode())) {
                //先判断时间是否有效
                boolean flag = breakfastFlag(valueAddel, priceVO.getDate());
                if (flag) {
                    priceVO.setBreakfast(anlyBreakfast(valueAddel.getAmount()));
                    if (StringUtils.equals("false", valueAddel.getIsInclude())) {
                        priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
                    }
                    break;
                }
            } else if (StringUtils.equals("01", valueAddel.getTypeCode())) {
                priceVO.setBreakfast(anlyBreakfast(valueAddel.getAmount()));
            }
        }
        return priceVO;
    }

    /***
     * 解析取消规则
     * @param ratePlan 价格
     * @param prepayRules 取消规则集合
     * @param priceVO privevo
     * @return 取消规则
     */
     private HotelPriceVO getCancelRule(ElongSearchRatePlan ratePlan
            , Map<String, ElongSearchPrepayRule> prepayRules
            , HotelPriceVO priceVO) {
        priceVO = priceVO != null ? priceVO : new HotelPriceVO();
        if (StringUtils.isBlank(ratePlan.getPrepayRuleIds())) {
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            return priceVO;
        }
        String[] split = ratePlan.getPrepayRuleIds().split(",|，");
        ElongSearchPrepayRule prepayRule = prepayRules.get(split[0]);
        String formatRzrq = getDescriptionDate(prepayRule.getHour(), priceVO.getDate());
        String cancelRule = HotelPriceEnum.CANCEL_NOT.getCode();
        if ("PrepayNeedSomeDay".equals(prepayRule.getChangeRule())) {
            cancelRule = HotelPriceEnum.CANCEL_TIME.getCode();
            boolean flag = getFlagbyDate(formatRzrq);
            if (flag) {
                cancelRule = HotelPriceEnum.CANCEL_NOT.getCode();
            }
        } else if ("PrepayNeedOneTime".equals(prepayRule.getChangeRule())) {
            boolean flag = getFlagbyDate(prepayRule.getDateNum()
                    + " " + prepayRule.getTime());
            cancelRule = HotelPriceEnum.CANCEL_TIME.getCode();
            if (flag) {
                cancelRule = HotelPriceEnum.CANCEL_NOT.getCode();
            }
        }
        priceVO.setCancelType(cancelRule);
        return priceVO;
    }

    /**
     * 获取日期、价格，房态
     *
     * @param nightlyRate rate
     * @param priceVO     vo
     * @return data
     */
     private HotelPriceVO getDateAndPrice(ElongSearchNightlyRate nightlyRate, HotelPriceVO priceVO) {
        priceVO = priceVO != null ? priceVO : new HotelPriceVO();
        String price = nightlyRate.getMember();
        if (StringUtils.isNotBlank(nightlyRate.getCost()) && new BigDecimal(nightlyRate.getCost()).compareTo(BigDecimal.ZERO) > 0) {
            price = nightlyRate.getCost();
        }
        priceVO.setPrice(NumberUtils.toDouble(price));
        priceVO.setDate(timeToDate(nightlyRate.getDate()));
        if (StringUtils.equalsIgnoreCase("true", nightlyRate.getStatus())) {
            priceVO.setStatus(HotelPriceEnum.STATUS_OK.getCode());
        } else {
            priceVO.setStatus(HotelPriceEnum.STATUS_FULL.getCode());
        }
        return priceVO;
    }

    /***
     * 解析早餐个数
     * @param count coutn
     * @return data
     */
    private String anlyBreakfast(String count) {
        if (StringUtils.equalsIgnoreCase("0", count)
                || StringUtils.equalsIgnoreCase("1", count)
                || StringUtils.equalsIgnoreCase("2", count)
                || StringUtils.equalsIgnoreCase("3", count)) {
            return count;
        } else {
            return HotelPriceEnum.BREAKFAST_OTHER.getCode();
        }
    }

    /**
     * 判断早餐是否有效
     *
     * @param valueAddel valueAddel
     * @param rzrq       rzsj
     * @return 1
     */
    private boolean breakfastFlag(ElongSearchValueAdd valueAddel, String rzrq) {
        // 有效起始时间结束时间为空则无效
        String sDate = valueAddel.getStartDate();
        String eDate = valueAddel.getEndDate();
        if (StringUtils.isBlank(sDate) || StringUtils.isBlank(eDate)) {
            return false;
        } else {
            //2020-11-11T00:00:00+08:00
            sDate = sDate.split("T")[0];
            eDate = eDate.split("T")[0];
        }
        int day1 = VeDate.getTwoDay(rzrq, sDate);
        int day2 = VeDate.getTwoDay(rzrq, eDate);
        if (day1 >= 0 && day2 <= 0) {
            return true;
        }
        return false;
    }

       /**
     * 根据入住日期减去hour小时得到需要判断的日期
     *
     * @param hour 在Hour和Hour2之间按规则存在罚金，Hour2之后不能变更取消
     * @param rzrq 入住日期
     * @return 根据规则减去hour小时得到的日期
     */
    private String getDescriptionDate(String hour, String rzrq) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date rzrqDate = null;
        try {
            if (hour != null && !"".equals(hour)) {
                Date formatDateRzrq = format.parse(rzrq + " " + "00:00");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(formatDateRzrq);
                calendar.add(Calendar.HOUR, -Integer.parseInt(hour)); //减填负数
                rzrqDate = calendar.getTime();
                return format.format(rzrqDate);
            }
        } catch (ParseException e) {
            logger.error("日期转换异常,{}", e);
        }
        return rzrq + " " + "00:00";
    }

    /**
     * 判断取消规则日期是否大于当前日期
     *
     * @param formatRzrq 格式化需要输出的日期
     * @return ture为小于当前日期
     */
      private boolean getFlagbyDate(String formatRzrq) {
        boolean flag = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());
        try {
            Date formatRzrq1 = dateFormat.parse(formatRzrq);
            Date date1 = dateFormat.parse(date);
            return date1.after(formatRzrq1);
        } catch (ParseException e) {
            logger.error("日期转换异常,{}", e);
        }
        return flag;
    }

    /***
     * 时间字符串转日期字符串
     * @param longDate date
     * @return data
     */
    private String timeToDate(String longDate) {
        if (StringUtils.isBlank(longDate)) {
            return longDate;
        }
        String[] date = longDate.split("T");
        if (date != null && date.length == NumConstant.NUM_2) {
            return date[0];
        }
        String[] dateBank = longDate.split(" ");
        if (dateBank != null && dateBank.length == NumConstant.NUM_2) {
            return dateBank[0];
        }
        return longDate;
    }


    /***
     * 分批查询艺龙价格数据
     * @param dto 请求
     * @param request 请求
     * @return 数据
     */
    private List<ElongHotelPriceResponse> getElongPriceRespnse(HotelPriceDTO dto, ElongHotelPriceRequest request) {
        ElongConfig config = request.getConfig();
        //获取限流配置
        RateLimiter rateLimiter = RateLimiterUtil.getRateLimiter(config.getZhmc(), BusinessKeyEnum.ELONG_RATE, config.getRateTime(), config.getRateCapacity());
        List<String> hotelIds = dto.getHotelIds();
        List<List<String>> idids = Lists.partition(hotelIds, eachHotelIds);
        List<ElongHotelPriceResponse> priceResponses = new ArrayList<>();
        for (List<String> ids : idids) {
            boolean accquire = rateLimitClient.tryAccquire(rateLimiter);
            if (!accquire) {
                logger.error("最低价：艺龙接口限流超频控制；ids:{}", JacksonUtils.toJsonWithDefault(ids));
                continue;
            }
            request.setHotelIds(StringUtils.join(ids, ","));
            Optional<ElongHotelPriceResponse> opPriceResponse = getElongPriceData(request);
            opPriceResponse.ifPresent(response -> {
                priceResponses.add(response);
            });
        }
        return priceResponses;
    }

    /***
     * 构建价格返回对象
     * @param priceResponses price
     * @return data
     */
      private HotelPriceResponseVO buildResponse(List<ElongHotelPriceResponse> priceResponses) {
        HotelPriceResponseVO response = new HotelPriceResponseVO();
        if (CollectionUtils.isEmpty(priceResponses)) {
            return response;
        }
        List<String> results = new ArrayList<>();
        List<HotelPriceVO> hotelPriceVOS = new ArrayList<>();
        for (ElongHotelPriceResponse priceResponse : priceResponses) {
            results.add(priceResponse.getResult());
            ElongRateSearchResponse searchResponse = priceResponse.getResponse();
            hotelPriceVOS.addAll(getHotelPriceVo(searchResponse));  //添加价格
        }
        response.setPriceResponse(results);
        response.setHotelPriceVOS(hotelPriceVOS);
        return response;
    }


}
