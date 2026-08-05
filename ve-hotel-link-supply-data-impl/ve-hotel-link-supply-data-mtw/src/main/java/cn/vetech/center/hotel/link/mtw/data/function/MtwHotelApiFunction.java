package cn.vetech.center.hotel.link.mtw.data.function;

import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.mtw.common.MtwBaseRequest;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwHttp;
import cn.vetech.center.hotel.link.mtw.common.MtwResponseCodeEnum;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelDetailResponseVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelIdResponseVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelIdVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom.MtwRealRoomInfoResponse;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom.MtwRealRoomResult;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelContentResponse;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomResponse;
import cn.vetech.center.hotel.link.mtw.enums.MtwApiEnum;
import cn.vetech.center.hotel.link.mtw.price.request.MtwHotelPriceRequest;
import cn.vetech.center.hotel.link.mtw.price.response.MtwHotelPriceResponse;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.MtHotelResult;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.MtwRateSearchResponse;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.charge.cloud.modules.utils.collection.CollectionUtil;
import cn.vetech.charge.cloud.modules.utils.collection.ListUtil;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author xiaotengyu
 * @since 2021/7/28 11:45
 */
@Component
public class MtwHotelApiFunction extends MtwHttp {

    /**
     * logger
     */
    private final Logger logger = LoggerFactory.getLogger(MtwHotelApiFunction.class);

    /***
     * 分页获取酒店ID
     * @param config 配置
     * @param maxId 查询上一页时返回的maxId标记值, 查询第一页时该值为0
     * @param pageSize 每页大小
     * @return data
     */
    public Optional<MtwHotelIdVo> getHotelListByPage(MtwConfig config, Long maxId, long pageSize) {
        int respost = NumConstant.NUM_0;
        while (respost < NumConstant.NUM_10) {
         try {
                Map<String, String> param = new HashMap<>();
                JSONObject data = new JSONObject();
                data.put("maxId", maxId);
                data.put("pageSize", pageSize);
                param.put("method", "hotel.poi.list");
                param.put("data", data.toString());
                String result = sendInvoke(param, config);
                if (StringUtils.isBlank(result)) {
                    logger.warn("基础数据：美团拉取酒店列表有误：maxId:{},pageSize:{};param:{};response:{}", maxId, pageSize, param, result);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    respost++;
                    continue;
                }
                //超频
                if (StringUtils.contains(result, "超过配额")
                        || StringUtils.contains(result, "请求接口被限流")) {
                    logger.warn("基础数据：美团拉取酒店列表有误：maxId:{},pageSize:{};param:{};response:{}", maxId, pageSize, param, result);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    respost++;
                    continue;
                }
                MtwHotelIdResponseVo responseVo = JacksonUtils.parseNonEmpty(result, MtwHotelIdResponseVo.class);
                //格式化数据为空
                if (responseVo == null) {
                    logger.warn("基础数据：美团拉取酒店列表有误：maxId:{},pageSize:{};param:{};response:{}", maxId, pageSize, param, result);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    respost++;
                    continue;
                }
                //超频
                if (StringUtils.equalsIgnoreCase(responseVo.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                    logger.warn("基础数据：美团拉取酒店列表有误：maxId:{},pageSize:{};param:{};response:{}", maxId, pageSize, param, result);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    respost++;
                    continue;
                }
                if (responseVo.getResult() == null
                        || responseVo.getResult().getHotelIds() == null
                        || responseVo.getResult().getHotelIds().size() < 1) {
                    logger.warn("基础数据：美团拉取酒店列表数据为空：maxId:{},pageSize:{};param:{};response:{}", maxId, pageSize, param, result);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    respost++;
                    continue;
                }
                return Optional.ofNullable(responseVo.getResult());
            } catch (Exception ex) {
                logger.error("分页获取酒店列表异常", ex);
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

     /***
     * 根据酒店iDs 查询酒店详情
     * @param config config
     * @param ids 酒店ID
     * @return data
     */
    public Optional<MtwHotelDetailResponseVo> getHotelDetailByIds(MtwConfig config, List<Long> ids) {
        int repost = NumConstant.NUM_0;
        while (repost < NumConstant.NUM_4) {
            JSONArray hotelIds = new JSONArray();
            Map<String, String> param = new HashMap<>();
            try {
                hotelIds.addAll(ids);
                JSONObject data = new JSONObject();
                //查询策略：strategy
                //1 基础信息
                //2 扩展信息
                //4 房型信息
                //8 图片信息
                //策略值可进行加和以查询多项信息 如：
                //9 查询基础信息和图片信息
                //15 查询全部信息
                data.put("strategy", NumConstant.NUM_1 + NumConstant.NUM_2 + NumConstant.NUM_8);
                data.put("hotelIds", hotelIds);
                param.put("data", data.toString());
                param.put("method", "hotel.detail");
                String responseStr = sendInvoke(param, config);
                 //返回结果为空
                if (StringUtils.isBlank(responseStr)) {
                    logger.warn("基础数据：美团查询酒店详情为空:id:{};param:{}", hotelIds.toJSONString(), JacksonUtils.toJsonWithDefault(param));
                    return Optional.empty();
                }
                //超频
                if (StringUtils.contains(responseStr, "超过配额")
                        || StringUtils.contains(responseStr, "请求接口被限流")) {
                    logger.warn("基础数据：美团查询酒店详情超频:id:{};param:{}；response:{}", hotelIds.toJSONString(), JacksonUtils.toJsonWithDefault(param), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                MtwHotelDetailResponseVo responseVo = JacksonUtils.parseNonEmpty(responseStr, MtwHotelDetailResponseVo.class);
                //格式化数据为空
                if (responseVo == null) {
                    logger.warn("基础数据：美团查询酒店详情有误:id:{};param:{}；response:{}", hotelIds.toJSONString(), JacksonUtils.toJsonWithDefault(param), responseStr);
                    return Optional.empty();
                }
                //超频
                if (StringUtils.equalsIgnoreCase(responseVo.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                    logger.warn("基础数据：美团查询酒店详情超频:id:{};param:{}；response:{}", hotelIds.toJSONString(), JacksonUtils.toJsonWithDefault(param), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                 //返回酒店数据为空
                if (responseVo.getResult() == null
                        || responseVo.getResult().getHotelDetails() == null
                        || responseVo.getResult().getHotelDetails().size() < 1) {
                    logger.warn("基础数据：美团查询酒店详情数据为空:id:{};param:{}；response:{}", hotelIds.toJSONString(), JacksonUtils.toJsonWithDefault(param), responseStr);
                    return Optional.empty();
                }
                return Optional.ofNullable(responseVo);
            } catch (Exception ex) {
                logger.error("根据酒店iDs 查询酒店详情ids:{}", ids, ex);
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
 /***
     * 获取美团网产品信息
     * @param request 请求
     * @return 返回
     * @throws Exception 异常
     */
    public Optional<MtwHotelPriceResponse> getHotelGoodsPrice(MtwHotelPriceRequest request) throws Exception {
        MtwHotelPriceResponse priceResponse = new MtwHotelPriceResponse();
        Map map = new HashedMap();
        map.put("method", request.getMethod());
        map.put("data", JacksonUtils.toJsonWithDefault(request.getData()));
        AtomicInteger repost = new AtomicInteger(0);
        //4次重试
        while (repost.get() < NumConstant.NUM_4) {
            MtwConfig config = request.getMtwConfig();
            String result = sendInvoke(map, config);
            logger.info("美团原始数据:{},{},{}", config.getPartnerId(), map.toString(), result);
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
            MtwRateSearchResponse response = JacksonUtils.parseNonEmpty(result, MtwRateSearchResponse.class);
            if (response == null) {
                logger.warn("最低价：美团网格式化价格结果有误，request:{};结果是：{};request:{}", request.toJson(), result);
                return Optional.empty();
            }
            if (StringUtils.equalsIgnoreCase(response.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                logger.warn("最低价：美团网获取产品价格信息超频；request:{};response:{}", request.toJson(), result);
                ThreadUtil.sleep(NumConstant.NUM_3000);
                repost.addAndGet(NumConstant.NUM_1);
                continue;
            }
             if (response.getMtHotelGoods() == null) {
                logger.warn("最低价：美团网获取价格结果为空：request:{};response:{},", request.toJson(), result);
                return Optional.empty();
            }
            List<MtHotelResult> mtHotelResult = response.getMtHotelGoods().getMtHotelResult();
            if (CollectionUtils.isEmpty(mtHotelResult)) {
                logger.warn("最低价：美团网获取价格结果为空：{},", result);
                return Optional.empty();
            }
            priceResponse.setMtHotelResult(mtHotelResult);
            priceResponse.setPriceStrs(Arrays.asList(result));
            return Optional.ofNullable(priceResponse);
        }
        return Optional.empty();
    }

    /**
    * realRoomInfo
     *
     * @param config   config
     * @param hotelIds hotelIdd
     * @return Optional
     */
    public Optional<MtwRealRoomResult> getRealRoomInfo(MtwConfig config, List<Long> hotelIds) {
        if (CollectionUtil.isEmpty(hotelIds)) {
            return Optional.empty();
        }
        try {
            JSONObject data = new JSONObject();
            JSONArray ids = new JSONArray();
            ids.addAll(hotelIds);
            data.put("hotelIds", ids);
            Map<String, String> param = new HashMap<>();
            param.put("data", data.toString());
            param.put("method", "hotel.realroom.info");
            String result = sendInvoke(param, config);
            if (StringUtils.isEmpty(result)) {
                logger.warn("美团网，查询物理房型返回空；result：", result);
                return Optional.empty();
            }
            MtwRealRoomInfoResponse response = JacksonUtils.parseNonEmpty(result, MtwRealRoomInfoResponse.class);
            if (response == null) {
                logger.warn("美团网，查询物理房型格式化返回空；result：", result);
                return Optional.empty();
            }
            if (StringUtils.equalsIgnoreCase(response.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                logger.warn("美团网：美团网获取物理房型信息超频；ids:{};response:{}", JacksonUtils.toJsonWithDefault(hotelIds), result);
                return Optional.empty();
            }
            if (response.getResult() == null) {
                logger.warn("美团网：获取房型信息为空：request:{};response:{},", JacksonUtils.toJsonWithDefault(hotelIds), result);
                return Optional.empty();
            }
            if (org.springframework.util.CollectionUtils.isEmpty(response.getResult().getRealRoomInfos())) {
                logger.warn("美团网：获取房型信息为空：request:{};response:{},", JacksonUtils.toJsonWithDefault(hotelIds), result);
                return Optional.empty();
            }
            return Optional.ofNullable(response.getResult());
        } catch (Exception ex) {
            logger.error("美团网，查询物理房型异常；ids:{}", JacksonUtils.toJsonWithDefault(hotelIds), ex);
        }
        return Optional.empty();
    }

    /**
     * 获取酒店详情
     *
     * @param baseRequest request
     * @return op
     */
    public Optional<MtwHotelContentResponse> getHotelDetailByIds(MtwBaseRequest baseRequest) {
        int repost = NumConstant.NUM_0;
        while (repost < NumConstant.NUM_4) {
            repost++;
            try {
                MtwConfig config = baseRequest.getConfig();
                MtwApiEnum mtwApiEnum = baseRequest.getMtwApiEnum();
                Map<String, String> param = new HashMap<>();
                param.put("data", baseRequest.toJson());
                param.put("method", mtwApiEnum.getApi());
                String responseStr = sendInvoke(param, config);
                 //返回结果为空
                if (StringUtils.isBlank(responseStr)) {
                    logger.warn("基础数据：美团查询酒店详情为空:request:{}", baseRequest.toJson());
                    return Optional.empty();
                }
                //超频
                if (StringUtils.contains(responseStr, "超过配额")
                        || StringUtils.contains(responseStr, "请求接口被限流")) {
                    logger.warn("基础数据：美团查询酒店详情超频:reuqest:{}；response:{}", baseRequest.toJson(), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                MtwHotelContentResponse responseVo = JacksonUtils.parseNonEmpty(responseStr, MtwHotelContentResponse.class);
                //格式化数据为空
                if (Objects.isNull(responseVo)) {
                    logger.warn("基础数据：美团查询酒店详情有误request:{}；response:{}", baseRequest.toJson(), responseStr);
                    return Optional.empty();
                }
                //超频
                if (StringUtils.equalsIgnoreCase(responseVo.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                    logger.warn("基础数据：美团查询酒店详情超频request:{}；response:{}", baseRequest.toJson(), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                //返回酒店数据为空
                if (Objects.isNull(responseVo.getResult()) || ListUtil.isEmpty(responseVo.getResult().getHotelContents())) {
                    logger.warn("基础数据：美团查询酒店详情数据为空request{}；response:{}", baseRequest.toJson(), responseStr);
                    return Optional.empty();
                }
                return Optional.ofNullable(responseVo);
            } catch (Exception ex) {
                logger.error("根据酒店iDs 查询酒店详情ids:{}", baseRequest.toJson(), ex);
            }
        }
        return Optional.empty();
    }
    
    /**
     * 获取酒店详情
     *
     * @param baseRequest request
     * @return op
     */
    public Optional<MtwHotelRealRoomResponse> getHotelRealRoomById(MtwBaseRequest baseRequest) {
        int repost = NumConstant.NUM_0;
        while (repost < NumConstant.NUM_4) {
            repost++;
            try {
                MtwConfig config = baseRequest.getConfig();
                MtwApiEnum mtwApiEnum = baseRequest.getMtwApiEnum();
                Map<String, String> param = new HashMap<>();
                param.put("data", baseRequest.toJson());
                param.put("method", mtwApiEnum.getApi());
                String responseStr = sendInvoke(param, config);
                //返回结果为空
                if (StringUtils.isBlank(responseStr)) {
                    logger.warn("基础数据：美团查询酒店详情为空:request:{}", baseRequest.toJson());
                    return Optional.empty();
                }
                //超频
                if (StringUtils.contains(responseStr, "超过配额")
                        || StringUtils.contains(responseStr, "请求接口被限流")) {
                    logger.warn("基础数据：美团查询酒店详情超频:reuqest:{}；response:{}", baseRequest.toJson(), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                MtwHotelRealRoomResponse responseVo = JacksonUtils.parseNonEmpty(responseStr, MtwHotelRealRoomResponse.class);
                //格式化数据为空
                if (Objects.isNull(responseVo)) {
                    logger.warn("基础数据：美团查询酒店详情有误request:{}；response:{}", baseRequest.toJson(), responseStr);
                    return Optional.empty();
                }
                //超频
                if (StringUtils.equalsIgnoreCase(responseVo.getCode(), MtwResponseCodeEnum.C1200.getCode())) {
                    logger.warn("基础数据：美团查询酒店详情超频request:{}；response:{}", baseRequest.toJson(), responseStr);
                    ThreadUtil.sleep(NumConstant.NUM_3000);
                    repost++;
                    continue;
                }
                //返回酒店数据为空
                if (Objects.isNull(responseVo.getResult()) || ListUtil.isEmpty(responseVo.getResult().getRoomContents())) {
                    logger.warn("基础数据：美团查询酒店详情数据为空request{}；response:{}", baseRequest.toJson(), responseStr);
                    return Optional.empty();
                }
                return Optional.ofNullable(responseVo);
            } catch (Exception ex) {
                logger.error("根据酒店iDs 查询酒店详情ids:{}", baseRequest.toJson(), ex);
            }
        }
        return Optional.empty();
    }

}
