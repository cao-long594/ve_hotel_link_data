package cn.vetech.center.hotel.link.mtw.price.multi;

import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.enums.CurrencyEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwHttp;
import cn.vetech.center.hotel.link.mtw.common.MtwResponseCodeEnum;
import cn.vetech.center.hotel.link.mtw.enums.MtwApiEnum;
import cn.vetech.center.hotel.link.mtw.price.multi.request.FilterBean;
import cn.vetech.center.hotel.link.mtw.price.multi.request.MtwMultiRequest;
import cn.vetech.center.hotel.link.mtw.price.multi.request.MtwMultiRequestData;
import cn.vetech.center.hotel.link.mtw.price.multi.request.RoomCriteriaBean;
import cn.vetech.center.hotel.link.mtw.price.multi.response.AvailabilityBean;
import cn.vetech.center.hotel.link.mtw.price.multi.response.MtwMultiResponse;
import cn.vetech.center.hotel.link.mtw.price.response.MtwHotelPriceResponse;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
**
 * @author chengwanshan
 * @since 2024/8/1 9:16
 */
@Service
public class MtwMultiService extends MtwHttp {
    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MtwMultiService.class);

    /**
     * @param dto    dto
     * @param config config
     * @return List<MtwHotelPriceResponse>
     */
    public List<MtwHotelPriceResponse> getLowPrice(HotelPriceDTO dto, MtwConfig config) {
        //3.组装请求对象
        MtwMultiRequest request = buildRequest(dto, config);
        //价格原始数据
        return Lists.partition(dto.getHotelIds(), NumConstant.NUM_10).stream().map(hotelIds -> {
            List<Long> longIds = hotelIds.stream().map(NumberUtils::toLong).collect(Collectors.toList());
            MtwMultiRequestData data = request.getData();
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
    }
    /**
     * @param request request
     * @return Optional<MtwHotelPriceResponse>
     */
    private Optional<MtwHotelPriceResponse> getHotelGoodsPrice(MtwMultiRequest request) {
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
            MtwMultiResponse response = JacksonUtils.parseNonEmpty(result, MtwMultiResponse.class);
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
            List<AvailabilityBean> mtHotelResult = response.getResult().getAvailability();
            if (CollectionUtils.isEmpty(mtHotelResult)) {
                logger.warn("最低价：美团网获取价格结果为空：{},", result);
                return Optional.empty();
            }
             priceResponse.setAvailabilityList(mtHotelResult);
            priceResponse.setPriceStrs(Collections.singletonList(result));
            return Optional.of(priceResponse);
        }
        return Optional.empty();
    }
    /**
     * @param dto    dto
     * @param config config
     * @return MtwMultiRequest
     */
    private MtwMultiRequest buildRequest(HotelPriceDTO dto, MtwConfig config) {
        MtwMultiRequest request = new MtwMultiRequest();
        request.setMethod(MtwApiEnum.HOTEL_SHOPPING_MULTI.getApi());
        MtwMultiRequestData data = new MtwMultiRequestData();
        //离店日期，格式为yyyy-MM-dd，与当前日期相差不能超过30天。
        data.setCheckin(dto.getStartDate());
        data.setCheckout(dto.getEndDate());
        data.setCurrency(CurrencyEnum.CNY.getCurrency());

        FilterBean filter = new FilterBean();
        filter.setProductType(NumConstant.NUM_1);
        data.setFilter(filter);

        RoomCriteriaBean roomCriteria = new RoomCriteriaBean();
        roomCriteria.setRoomCount(NumConstant.NUM_1);
        data.setRoomCriteria(roomCriteria);

        request.setData(data);
        request.setMtwConfig(config);
        return request;
    }
}
