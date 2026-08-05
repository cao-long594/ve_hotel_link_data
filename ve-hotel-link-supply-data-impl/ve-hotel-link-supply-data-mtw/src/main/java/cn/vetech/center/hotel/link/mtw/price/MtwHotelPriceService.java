package cn.vetech.center.hotel.link.mtw.price;

import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelPriceEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwGeneralEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwHttp;
import cn.vetech.center.hotel.link.mtw.data.function.MtwHotelApiFunction;
import cn.vetech.center.hotel.link.mtw.enums.MtwApiEnum;
import cn.vetech.center.hotel.link.mtw.enums.MtwQueryDimensionEnum;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.MtwLowestPriceService;
import cn.vetech.center.hotel.link.mtw.price.multi.MtwMultiService;
import cn.vetech.center.hotel.link.mtw.price.multi.response.AvailProductBean;
import cn.vetech.center.hotel.link.mtw.price.multi.response.AvailabilityBean;
import cn.vetech.center.hotel.link.mtw.price.multi.response.InclusivePriceBean;
import cn.vetech.center.hotel.link.mtw.price.multi.response.InvoiceBean;
import cn.vetech.center.hotel.link.mtw.price.request.MtwHotelPriceRequest;
import cn.vetech.center.hotel.link.mtw.price.request.MtwRequestData;
import cn.vetech.center.hotel.link.mtw.price.response.MtwHotelPriceResponse;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.Breakfast;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.CancelRules;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.MtHotelResult;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.MtwGoods;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.PriceModel;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.charge.cloud.modules.utils.collection.ListUtil;
import cn.vetech.charge.cloud.modules.utils.mapper.BeanMapper;
import cn.vetech.charge.cloud.modules.utils.number.Arith;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

;

@Service
public class MtwHotelPriceService extends MtwHttp {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MtwHotelPriceService.class);

    /***
     * 调用美团网api
     */
    @Autowired
    private MtwHotelApiFunction mtwHotelApiFunction;

    private final int SIZE = 10;
    /**
     * 酒店列表接口获取最低价
     */
    @Autowired
    private MtwMultiService mtwMultiService;
    /**
     *
     */
    @Autowired
    private MtwLowestPriceService mtwLowestPriceService;

    /***
     * 获取最低价
     * @param dto 请求实体
     * @return 价格实体
     */
    public RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) {
        //1.获取配置
        MtwConfig config = getConfig(dto.getSupplier());
        //2.验证请求对象
        DataResponseEnum responseEnum = valData(config, dto);
        if (responseEnum != null) {
            return ApiRes.response(responseEnum);
        }
        return mtwLowestPriceService.getLowPrice(dto, config);

//        List<HotelPriceVO> hotelPriceVOS = null;
//        List<String> priceStrs = null;
//        if ("1".equals(config.getLowPriceType())) {
//            // 查询酒店列表页
//            List<MtwHotelPriceResponse> hotelPriceByHotelList = mtwMultiService.getLowPrice(dto, config);
//            //5.根据房源商返回的数据，组装HotelPriceResponseVO对象
//            hotelPriceVOS= hotelPriceByHotelList.stream().flatMap(apidata -> buildResponseMulti(apidata).stream()).collect(Collectors.toList());
//            priceStrs = hotelPriceByHotelList.stream().flatMap(apidata -> apidata.getPriceStrs().stream()).collect(Collectors.toList());
//        }else {
//            //3.组装请求对象
//            MtwHotelPriceRequest request = buildRequest(dto, config);
//            //4.请求房源商接口获取数据
//            List<MtwHotelPriceResponse> mtwApiData = getMtwApiData(request, dto);
//            //5.根据房源商返回的数据，组装HotelPriceResponseVO对象
//            hotelPriceVOS = mtwApiData.stream().flatMap(apidata -> buildResponse(apidata).stream()).collect(Collectors.toList());
//            priceStrs= mtwApiData.stream().flatMap(apidata -> apidata.getPriceStrs().stream()).collect(Collectors.toList());
//        }
//        HotelPriceResponseVO responseVO = new HotelPriceResponseVO();
//        responseVO.setHotelPriceVOS(hotelPriceVOS);
//        responseVO.setPriceResponse(priceStrs);
//        return ApiRes.success(responseVO);
    }

     /***
     * 获取配置
     * @param source
     * @return
     */
    public MtwConfig getConfig(Map<String, String> source) {
        if (source == null || source.size() < 1) {
            logger.error("未找到房源商或者房源商未开启 source:", source);
            return null;
        }
        return BeanMapper.map(source, MtwConfig.class);
    }

    /***
     * 验证数据
     * @param config
     * @param dto
     * @return
     */
    private DataResponseEnum valData(MtwConfig config, HotelPriceDTO dto) {
        if (config == null) {
            return DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED;
        }
        if (dto == null) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        if (CollectionUtils.isEmpty(dto.getHotelIds())) {
            return DataResponseEnum.PARAMETER_IS_EMPTY;
        }
        return null;
    }

    /**
     * 组装请求对象
     *
     * @param dto dto
     * @return 请求对象
     */
    private MtwHotelPriceRequest buildRequest(HotelPriceDTO dto, MtwConfig config) {
        MtwHotelPriceRequest request = new MtwHotelPriceRequest();
        request.setMethod(MtwApiEnum.HOTEL_GOODS_RP.getApi());
        MtwRequestData data = new MtwRequestData();
        //离店日期，格式为yyyy-MM-dd，与当前日期相差不能超过30天。
        data.setCheckinDate(dto.getStartDate());
        data.setCheckoutDate(dto.getEndDate());
        data.setGoodsType(NumConstant.NUM_1);
        data.setQueryInfoDimensions(Lists.newArrayList(MtwQueryDimensionEnum.LP.getVal()));
        request.setData(data);
        request.setMtwConfig(config);
        return request;
    }

    /***
     * 请求美团网接口，获取产品数据
     * @param request 请求
     * @param dto dot
     * @return 返回价格几何
     */
    private List<MtwHotelPriceResponse> getMtwApiData(MtwHotelPriceRequest request, HotelPriceDTO dto) {
        //价格原始数据
        return Lists.partition(dto.getHotelIds(), NumConstant.NUM_10).stream().map(hotelIds -> {
            List<Long> longIds = hotelIds.stream().map(NumberUtils::toLong).collect(Collectors.toList());
            MtwRequestData data = request.getData();
            data.setHotelIds(longIds);
            request.setData(data);
            try {
                //获取价格列表
                Optional<MtwHotelPriceResponse> opHotelGoodsPrice = mtwHotelApiFunction.getHotelGoodsPrice(request);
                return opHotelGoodsPrice.orElse(null);
            } catch (Exception ex) {
                logger.error("获取酒店价格api异常：ids：{}", JacksonUtils.toJsonWithDefault(hotelIds), ex);
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /***
     * 组装返回数据，返回
     * @return 最低价列表
     */
    private List<HotelPriceVO> buildResponse(MtwHotelPriceResponse response) {
        List<MtHotelResult> mtHotelResult = response.getMtHotelResult();
        if (CollectionUtils.isEmpty(mtHotelResult)) {
            return ListUtil.emptyList();
        }
        return mtHotelResult.stream().flatMap(priceResult -> {
            List<PriceModel> lowestPriceModels = priceResult.getLowestPriceModels();
            return lowestPriceModels.stream().map(good -> buildLowestPrice(good, priceResult.getHotelId())).collect(Collectors.toList()).stream();
        }).collect(Collectors.toList());
    }

    /**
     * 组装返回数据，返回
     *
     * @return 最低价列表
     */
    private List<HotelPriceVO> buildResponseMulti(MtwHotelPriceResponse response) {
        List<AvailabilityBean> mtHotelResult = response.getAvailabilityList();
        if (CollectionUtils.isEmpty(mtHotelResult)) {
            return ListUtil.emptyList();
        }
        List<HotelPriceVO> hotelPriceVOList = new ArrayList<>();
        for (AvailabilityBean availabilityBean : mtHotelResult) {
            List<AvailProductBean> availProduct = availabilityBean.getAvailProduct();
            if (CollectionUtils.isEmpty(availProduct)) {
                continue;
            }
            for (AvailProductBean availProductBean : availProduct) {
                List<HotelPriceVO> hotelPriceList = buildLowestPriceMulti(availProductBean, availabilityBean.getHotelId());
                if (CollectionUtils.isNotEmpty(hotelPriceList)) {
                    hotelPriceVOList.addAll(hotelPriceList);
                }
            }
        }
        return hotelPriceVOList;
    }

     /**
     * @param good    good
     * @param hotelId hotelId
     * @return List<HotelPriceVO>
     */
    private List<HotelPriceVO> buildLowestPriceMulti(AvailProductBean good, Integer hotelId) {
        List<HotelPriceVO> hotelPriceVOList = new ArrayList<>();
        List<InclusivePriceBean> inclusivePrice = good.getInclusivePrice();
        for (InclusivePriceBean inclusivePriceBean : inclusivePrice) {
            HotelPriceVO priceVO = new HotelPriceVO();
            priceVO.setHotelId(Objects.nonNull(hotelId) ? String.valueOf(hotelId) : null);
            //1.房间名称
            priceVO.setRoomName(HotelPriceEnum.ROOMNAME_OTHER.getMessage());
            //2.支付方式
            priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
            //3.日期、价格，房态
            priceVO.setDate(inclusivePriceBean.getDate());

            double price = Arith.div(inclusivePriceBean.getSalePrice() - inclusivePriceBean.getSubPrice(), 100d, 2);
            priceVO.setPrice(price);
            priceVO.setStatus(HotelPriceEnum.STATUS_OK.getCode());
            //4.取消类型
            buildCancelRule(priceVO, null);
            //5.早餐
            buildFreeMeal(priceVO, null);
            //6.活动类型
            priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
            //7.发票类型
            InvoiceBean invoice = good.getInvoice();
            if (Objects.nonNull(invoice.getInvoiceMode()) && invoice.getInvoiceMode().intValue() == NumConstant.NUM_1) {
                priceVO.setInvoiceModel(HotelPriceEnum.INVOICE_HOTEL.getCode());
            } else if (Objects.nonNull(invoice.getInvoiceMode())
                    && (invoice.getInvoiceMode().intValue() == NumConstant.NUM_2
                    || invoice.getInvoiceMode().intValue() == NumConstant.NUM_3)) {
                priceVO.setInvoiceModel(HotelPriceEnum.INVOICE_SUPPLER.getCode());
            }
            hotelPriceVOList.add(priceVO);
        }
        return hotelPriceVOList;
    }

    /**
     * 构建价格实体
     *
     * @param good 产品
     * @return 价格实体
     */
    private List<HotelPriceVO> buildPrice(MtwGoods good) {
        List<PriceModel> priceModels = good.getPriceModels();
        return priceModels.stream().map(priceModel -> {
            HotelPriceVO priceVO = new HotelPriceVO();
            priceVO.setHotelId(good.getHotelId());
            //1.房间名称
            buildRoomName(priceVO, good.getGoodsName());
            //2.支付方式
            buildPayment(priceVO);
            //3.日期、价格，房态
            buildDayPrice(priceVO, priceModel, good.getGoodsStatus());
            //4.取消类型
            buildCancelRule(priceVO, good.getCancelRules());
            //5.早餐
            buildFreeMeal(priceVO, good.getBreakfast());
            //6.活动类型
            priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
            return priceVO;
        }).collect(Collectors.toList());
    }

    /**
     * 构建价格实体
     *
     * @param priceModel 产品
     * @return 价格实体
     */
    private HotelPriceVO buildLowestPrice(PriceModel priceModel, String hotelId) {
        HotelPriceVO priceVO = new HotelPriceVO();
        priceVO.setHotelId(hotelId);
        //1.房间名称
        priceVO.setRoomName(HotelPriceEnum.ROOMNAME_OTHER.getMessage());
        //2.支付方式
        buildPayment(priceVO);
        //3.日期、价格，房态
        priceVO.setDate(priceModel.getDate());
        double price = Arith.div(priceModel.getLowestPrice(), 100d, 2);
        priceVO.setPrice(price);
        priceVO.setStatus(HotelPriceEnum.STATUS_OK.getCode());
        //4.取消类型
        buildCancelRule(priceVO, null);
        //5.早餐
        buildFreeMeal(priceVO, null);
        //6.活动类型
        priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
        return priceVO;
    }
    /**
     * 构建房间名称
     *
     * @param priceVO
     * @return data
     */
    private void buildRoomName(HotelPriceVO priceVO, String name) {
        priceVO.setRoomName(name);
    }

    /**
     * 构建付款类型
     *
     * @param priceVO
     * @return
     */
    private void buildPayment(HotelPriceVO priceVO) {
        priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
    }

    /***
     * 构建价格
     * @param priceVO
     * @param priceModel
     * @return
     */
    private void buildDayPrice(HotelPriceVO priceVO, PriceModel priceModel, String goodStatus) {

        priceVO.setDate(priceModel.getDate());
        Integer salePrice = priceModel.getSalePrice() == null ? 0 : priceModel.getSalePrice();
        Integer subPrice = priceModel.getSubPrice() == null ? 0 : priceModel.getSubPrice();
        double daytotal = Arith.div(salePrice - subPrice, 100d, 2);
        //预付的并且酒店开票的需要赋值,前端不能控润
        priceVO.setStatus(HotelPriceEnum.STATUS_OK.getCode());
        if (MtwGeneralEnum.StatusEnum.F.getVal().equals(goodStatus)) {
            priceVO.setStatus(HotelPriceEnum.STATUS_NO.getCode());
        }
        priceVO.setPrice(daytotal);
    }

    /***
     * 构建取消规则
     * @param priceVO
     * @return
     */
    private void buildCancelRule(HotelPriceVO priceVO, List<CancelRules> cancelRules) {
        if (ListUtil.isEmpty(cancelRules)) {
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            return;
        }
        cancelRules.stream().findFirst().ifPresent(cancel -> {
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            if (StringUtils.equalsIgnoreCase(cancel.getCancelType(), MtwGeneralEnum.StatusEnum.T.getVal())) {
                priceVO.setCancelType(HotelPriceEnum.CANCEL_TIME.getCode());
            }
        });
    }

    /***
     * 早餐解析
     * @param priceVO vo
     * @return data
     */
    private void buildFreeMeal(HotelPriceVO priceVO, List<Breakfast> breakfast) {
        priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
        if (ListUtil.isEmpty(breakfast)) {
            return;
        }
        breakfast.stream().findFirst().ifPresent(fast -> {
            String breakfastType = fast.getBreakfastType();
            if (StringUtils.equalsIgnoreCase(breakfastType, MtwGeneralEnum.StatusEnum.F.getVal())) {
                priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
                return;
            }
            if (StringUtils.equalsIgnoreCase(breakfastType, MtwGeneralEnum.StatusEnum.T.getVal())) {
                String breakfastNum = fast.getBreakfastNum();
                if (StringUtils.equalsIgnoreCase(breakfastNum, "1")) {
                    priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_SINGLE.getCode());
                } else if (StringUtils.equalsIgnoreCase(breakfastNum, "2")) {
                    priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_DOUBLE.getCode());
                } else {
                    priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_OTHER.getCode());
                }
            }
        });
    }

   /***
     * 处理早餐
     * @param breakfast
     * @return
     */
    private String dealBreakfast(Breakfast breakfast) {
        String meal = "0";
        if (StringUtils.equalsIgnoreCase("0", breakfast.getBreakfastType())) {
            meal = HotelPriceEnum.BREAKFAST_NO.getCode();
        } else if (StringUtils.equalsIgnoreCase("1", breakfast.getBreakfastType())) {
            meal = HotelPriceEnum.BREAKFAST_OTHER.getCode();
            if (StringUtils.equalsIgnoreCase("0", breakfast.getBreakfastNum())
                    || StringUtils.equalsIgnoreCase("1", breakfast.getBreakfastNum())
                    || StringUtils.equalsIgnoreCase("2", breakfast.getBreakfastNum())) {
                meal = breakfast.getBreakfastNum();
            }
        } else if ("2".equals(breakfast.getBreakfastType())) {
            meal = HotelPriceEnum.BREAKFAST_OTHER.getCode();
        }
        return meal;
    }
}
