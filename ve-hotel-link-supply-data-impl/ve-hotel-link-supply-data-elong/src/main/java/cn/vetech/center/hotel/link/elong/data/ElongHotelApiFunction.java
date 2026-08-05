package cn.vetech.center.hotel.link.elong.data;

import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongFeignHttp;
import cn.vetech.center.hotel.link.elong.common.ElongHttp;
import cn.vetech.center.hotel.link.elong.data.request.ElongCityRequest;
import cn.vetech.center.hotel.link.elong.data.request.ElongHotelDetailRequest;
import cn.vetech.center.hotel.link.elong.data.request.ElongHotelListRequest;
import cn.vetech.center.hotel.link.elong.data.response.staticcity.ElongCityResponse;
import cn.vetech.center.hotel.link.elong.data.response.staticcity.ElongCityResult;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongHotelDetailResponse;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongHotelDetailResult;
import cn.vetech.center.hotel.link.elong.data.response.staticlist.ElongHotelListResponse;
import cn.vetech.center.hotel.link.elong.data.response.staticlist.ElongHotelListResult;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaotengyu
 * @since 2021/2/4 21:00
 */
@Component
public class ElongHotelApiFunction extends ElongHttp {

    /***
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(ElongHotelApiFunction.class);
    /**
     * 艺龙feign请求
     */
    @Autowired
    private ElongFeignHttp elongFeignHttp;
    /***
     * https
     */
    private final String http = "https";

    /***
     * 获取城市城市
     */
  private final String methodStaticSity = "hotel.static.city";
    /***
     *  获取酒店列表
     */
    private final String methodHotelList = "hotel.static.list";
    /***
     * 获取酒店详情
     */
    private final String methodHotelDetail = "hotel.static.info";

    /***
     * 获取静态城市数据
     * @param request 请求实体
     * @return 返回response
     */
    public Optional<ElongCityResponse> getHotelStaticCity(ElongCityRequest request) {
        ElongConfig config = request.getConfig();
        try {

            String result = sendInvoke(methodStaticSity, request.toJson(), config, http, NumConstant.NUM_0);
            Optional<ElongCityResponse> cityResponse = Optional.ofNullable(result).map(str -> JacksonUtils.parseNonEmpty(str, ElongCityResponse.class));
            Optional<ElongCityResult> cityResultOpt = cityResponse.map(ElongCityResponse::getResult);
            if (!cityResultOpt.isPresent()) {
                logger.warn("艺龙：请求城市静态数据为空,请求参数：{},响应数据：{}", request.toJson(), result);
                return Optional.empty();
            }
            return cityResponse;
        } catch (Exception ex) {
            logger.error("艺龙请求城市静态数据异常：{}", request.toJson(), ex);
        }
        return Optional.empty();
    }
 /***
     *  获取酒店列表
     * @param request 请求
     * @return 返回response
     */
    public Optional<ElongHotelListResponse> getHotelStaticList(ElongHotelListRequest request) {
        ElongConfig config = request.getConfig();
        int index = 0;
        Boolean last = true;
        for (; ; ) {
            index++;
            if (index > NumConstant.NUM_5) {
                break;
            }
            try {
                //String result = elongFeignHttp.doGet(config, methodHotelList, request.toJson());
                String result = sendInvoke(methodHotelList, request.toJson(), config, http, NumConstant.NUM_0);
                if (StringUtils.isEmpty(result) || StringUtils.contains(result, "访问太频繁")) {
                    logger.warn("艺龙：请求酒店列表静态数据为空：{};result:{}", request.toJson(), result);
                    last = false;
                    ThreadUtil.sleep(NumConstant.NUM_2,TimeUnit.SECONDS);
                    continue;
                }
                ElongHotelListResponse response = JacksonUtils.parseNonEmpty(result, ElongHotelListResponse.class);
                if (response == null) {
                    logger.warn("艺龙：请求酒店列表静态数据，json格式化为空：request{};response:{}", request.toJson(), result);
                    return Optional.empty();
                }
                ElongHotelListResult elongHotelListResult = response.getResult();
                if (elongHotelListResult == null) {
                    logger.warn("艺龙：请求酒店列表静态数据，json格式化为空：request{};response:{}", request.toJson(), result);
                    last = true;
                    continue;
                }
                if (CollectionUtils.isEmpty(elongHotelListResult.getHotels())) {
                    logger.warn("艺龙：请求酒店列表静态数据，酒店实体实体为空：request{};response:{}", request.toJson(), result);
                    return Optional.empty();
                }
                return Optional.ofNullable(response);
         } catch (Exception ex) {
                logger.error("艺龙：查询酒店列表异常:{}", request.toJson(), ex);
                last = true;
            }
        }
        ElongHotelListResponse listResponse = new ElongHotelListResponse();
        listResponse.setLast(last);
        return Optional.of(listResponse);
    }

     /**
     * 获取艺龙酒店详情
     *
     * @param request request
     * @return response
     */
    public Optional<ElongHotelDetailResponse> getHotelStaticDetail(ElongHotelDetailRequest request) {
        ElongConfig config = request.getConfig();
        int repost = NumConstant.NUM_0;
        String result = StringUtils.EMPTY;
        while (repost < NumConstant.NUM_5) {
            repost++;
            try {
                result = sendInvoke(methodHotelDetail, request.toJson(), config, http, NumConstant.NUM_0);
                if (StringUtils.isEmpty(result) || StringUtils.contains(result, "访问太频繁")) {
                    logger.warn("艺龙：请求酒店详情静态数据为空：request:{},result:{}", request.toJson(), result);
                    ThreadUtil.sleep(NumConstant.NUM_2, TimeUnit.SECONDS);
                    continue;
                }
                ElongHotelDetailResponse response = JacksonUtils.parseNonEmpty(result, ElongHotelDetailResponse.class);
                if (response == null) {
                    logger.warn("艺龙：请求酒店详情静态数据，json格式化为空：request{};response:{}", request.toJson(), result);
                    return Optional.empty();
                }
                ElongHotelDetailResult hotelDetailResult = response.getResult();
                if (hotelDetailResult == null) {
                    logger.warn("艺龙：请求酒店详情静态数据，json格式化为空：request{};response:{}", request.toJson(), result);
                    return Optional.empty();
                }
                if (hotelDetailResult.getDetail() == null) {
                    logger.warn("艺龙：请求酒店详情静态数据，酒店实体实体为空：request{};response:{}", request.toJson(), result);
                    return Optional.empty();
                }
                return Optional.ofNullable(response);
            } catch (Exception ex) {
                logger.error("艺龙：查询静态数据异常：request:{};result:{}", request.toJson(), result, ex);
            }
        }
        return Optional.empty();
    }


}
