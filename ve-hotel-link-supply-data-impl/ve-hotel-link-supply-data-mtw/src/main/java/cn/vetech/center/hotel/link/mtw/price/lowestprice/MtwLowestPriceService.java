package cn.vetech.center.hotel.link.mtw.price.lowestprice;

import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.enums.HotelPriceEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwHttp;
import cn.vetech.center.hotel.link.mtw.common.MtwResponseCodeEnum;
import cn.vetech.center.hotel.link.mtw.enums.MtwApiEnum;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.request.MtwLowestPriceRequest;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.request.MtwLowestPriceRequestData;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.response.MtwHotelLowestPrice;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.response.MtwLowestPriceModel;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.response.MtwLowestPriceResponse;
import cn.vetech.center.hotel.link.mtw.price.response.MtwHotelPriceResponse;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.MoneyUtils;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
/**
 * @author chengwanshan
 * @since 2025/10/24 14:20
 */
@Service
public class MtwLowestPriceService extends MtwHttp {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MtwLowestPriceService.class);

    /**
     * @param dto    dto
     * @param config config
     * @return List<MtwHotelPriceResponse>
     */
    public RestResponse<HotelPriceResponseVO> getLowPrice(HotelPriceDTO dto, MtwConfig config) {
        //3.组装请求对象
        MtwLowestPriceRequest request = buildRequest(dto, config);
        //价格原始数据
        List<MtwHotelPriceResponse> hotelPriceResponseList = Lists.partition(dto.getHotelIds(), NumConstant.NUM_10).stream().map(hotelIds -> {
            List<Long> longIds = hotelIds.stream().map(NumberUtils::toLong).collect(Collectors.toList());
            MtwLowestPriceRequestData data = request.getData();
            data.setHotelIds(longIds);
            request.setData(data);
            try {
                //获取价格列表
                Optional<MtwHotelPriceResponse> opHotelGoodsPrice = getHotelGoodsPrice(request);
                return opHotelGoodsPrice.orElse(null);
            } catch (Exception ex) {
                logger.error("获取酒店价格api异常：ids：{}", JacksonUtils.toJsonWithDefault(hotelIds), ex);
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        //5.根据房源商返回的数据，组装HotelPriceResponseVO对象
        List<HotelPriceVO> hotelPriceVOS = hotelPriceResponseList.stream().flatMap(apidata -> buildResponse(apidata).stream()).collect(Collectors.toList());
        List<String> priceStrs = hotelPriceResponseList.stream().flatMap(apidata -> apidata.getPriceStrs().stream()).collect(Collectors.toList());
        HotelPriceResponseVO responseVO = new HotelPriceResponseVO();
        responseVO.setHotelPriceVOS(hotelPriceVOS);
        responseVO.setPriceResponse(priceStrs);
        return ApiRes.success(responseVO);
    }

      private List<HotelPriceVO> buildResponse(MtwHotelPriceResponse response) {
        List<MtwHotelLowestPrice> hotelLowestPriceList = response.getHotelLowestPriceList();
        if (CollectionUtils.isEmpty(hotelLowestPriceList)) {
            return Collections.emptyList();
        }
        List<HotelPriceVO> hotelPriceVOList = new ArrayList<>();
        for (MtwHotelLowestPrice hotelLowestPrice : hotelLowestPriceList) {
            List<MtwLowestPriceModel> lowestPriceModels = hotelLowestPrice.getLowestPriceModels();
            if (CollectionUtils.isEmpty(lowestPriceModels)) {
                continue;
            }
            List<HotelPriceVO> hotelPriceList = buildLowestPrice(lowestPriceModels, hotelLowestPrice.getHotelId());
            if (CollectionUtils.isNotEmpty(hotelPriceList)) {
                hotelPriceVOList.addAll(hotelPriceList);
            }
        }
        return hotelPriceVOList;
    }

   private List<HotelPriceVO> buildLowestPrice(List<MtwLowestPriceModel> lowestPriceModels, String hotelId) {
        List<HotelPriceVO> hotelPriceVOList = new ArrayList<>();
        for (MtwLowestPriceModel lowestPriceModel : lowestPriceModels) {
            HotelPriceVO priceVO = new HotelPriceVO();
            priceVO.setHotelId(hotelId);
            //1.房间名称
            priceVO.setRoomName(HotelPriceEnum.ROOMNAME_OTHER.getMessage());
            //2.支付方式
            priceVO.setPayment(HotelPriceEnum.PAYMENT_ADVANCE.getCode());
            //3.日期、价格，房态
            priceVO.setDate(lowestPriceModel.getDate());
            String price = StringUtils.defaultIfBlank(lowestPriceModel.getLowestSettlePrice(), lowestPriceModel.getLowestSalePrice());
            Double priceYuan = MoneyUtils.fen2Yuan(price);
            priceVO.setPrice(Objects.isNull(priceYuan) ? -1F : priceYuan);
            priceVO.setStatus(HotelPriceEnum.STATUS_OK.getCode());
            //4.取消类型
            priceVO.setCancelType(HotelPriceEnum.CANCEL_NOT.getCode());
            //5.早餐
            priceVO.setBreakfast(HotelPriceEnum.BREAKFAST_NO.getCode());
            //6.活动类型
            priceVO.setActivityType(HotelPriceEnum.ACTIVITY_NO.getCode());
            hotelPriceVOList.add(priceVO);
        }
        return hotelPriceVOList;
    }

    
    /**
     * @param dto    dto
     * @param config config
     * @return MtwLowestPriceRequest
     */
    private MtwLowestPriceRequest buildRequest(HotelPriceDTO dto, MtwConfig config) {
        MtwLowestPriceRequest request = new MtwLowestPriceRequest();
        request.setMethod(MtwApiEnum.HOTEL_LOWEST_PRICE.getApi());
        MtwLowestPriceRequestData data = new MtwLowestPriceRequestData();
        //离店日期，格式为yyyy-MM-dd，与当前日期相差不能超过30天。
        data.setCheckinDate(dto.getStartDate());
        data.setCheckoutDate(dto.getEndDate());
        request.setData(data);
        request.setMtwConfig(config);
        return request;
    }

    /**
     * @param request request
     * @return Optional<MtwHotelPriceResponse>
     */
    private Optional<MtwHotelPriceResponse> getHotelGoodsPrice(MtwLowestPriceRequest request) {
        MtwHotelPriceResponse priceResponse = new MtwHotelPriceResponse();
        Map<String, String> map = new HashMap<>();
        map.put("method", request.getMethod());
        map.put("data", JacksonUtils.toJsonWithDefault(request.getData()));
        AtomicInteger repost = new AtomicInteger(0);
        //4次重试
        while (repost.get() < NumConstant.NUM_4) {
            MtwConfig config = request.getMtwConfig();
            String result = sendInvoke(map, config);
            logger.info("美团原始数据:{},{},{}", config.getPartnerId(), JacksonUtils.toJsonWithNonEmpty(map), result);
            if (StringUtils.isEmpty(result)) {
                logger.warn("最低价：美团网获取产品价格信息为空；request:{};", request.toJson());
                return Optional.empty();
            }
               if (StringUtils.contains(result, "超过配额")) {
                logger.warn("最低价：美团网获取产品价格信息超频；request:{};response:{}", request.toJson(), result);
                ThreadUtil.sleep(NumConstant.NUM_3000);
                repost.addAndGet(NumConstant.NUM_1);
                continue;
            }
            MtwLowestPriceResponse response = JacksonUtils.parseNonEmpty(result, MtwLowestPriceResponse.class);
            if (response == null) {
                logger.warn("最低价：美团网格式化价格结果有误，request:{};结果是：{}", request.toJson(), result);
                return Optional.empty();
            }
            if (StringUtils.equalsIgnoreCase(response.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                logger.warn("最低价：美团网获取产品价格信息超频；request:{};response:{}", request.toJson(), result);
                ThreadUtil.sleep(NumConstant.NUM_3000);
                repost.addAndGet(NumConstant.NUM_1);
                continue;
            }
            if (response.getResult() == null) {
                logger.warn("最低价：美团网获取价格结果为空：request:{};response:{},", request.toJson(), result);
                return Optional.empty();
            }
            List<MtwHotelLowestPrice> hotelLowestPriceList = response.getResult().getHotelLowestPriceList();
            if (CollectionUtils.isEmpty(hotelLowestPriceList)) {
                logger.warn("最低价：美团网获取价格结果为空：{},", result);
                return Optional.empty();
            }
            priceResponse.setHotelLowestPriceList(hotelLowestPriceList);
            priceResponse.setPriceStrs(Collections.singletonList(result));
            return Optional.of(priceResponse);
        }
        return Optional.empty();
    }

}
