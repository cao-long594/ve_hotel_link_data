package cn.vetech.center.hotel.link.ylfx.data.v2;

import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeVO;
import cn.vetech.center.hotel.link.http.HttpClientUtilExt;
import cn.vetech.center.hotel.link.http.HttpService;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxConfig;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.UrlUtils;
import cn.vetech.center.hotel.link.ylfx.data.v2.request.YlfxV2HotelInfosRequest;
import cn.vetech.center.hotel.link.ylfx.data.v2.response.YlfxV2HotelInfosHotel;
import cn.vetech.center.hotel.link.ylfx.data.v2.response.YlfxV2HotelInfosResponse;
import cn.vetech.center.hotel.link.ylfx.data.v2.response.YlfxV2HotelInfosRoom;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.modules.utils.security.MD5Tool;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 易旅分销 V2 酒店静态详情服务
 *
 * @author 6161
 * @date 2026/08/05
 */
@Service
public class YlfxV2HotelDetailService {
    /**
     * 酒店静态信息接口地址
     */
    private static final String HOTEL_INFOS_URI = "/open/static/hotelinfos";
    /**
     * 单次请求酒店编码上限
     */
    private static final int BATCH_SIZE = 50;
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(YlfxV2HotelDetailService.class);
    /**
     * HTTP 请求服务
     */
    @Autowired
    private HttpService httpService;

    /**
     * 根据酒店编码列表获取酒店静态详情
     *
     * @param dto 标准静态详情请求
     * @param config 易旅分销配置
     * @return 标准静态详情响应
     * @throws SystemException 系统异常
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto, YlfxConfig config)
            throws SystemException {
        if (CollectionUtils.isEmpty(dto.getHotelIds())) {
            return ApiRes.response(DataResponseEnum.PARAMETER_IS_EMPTY);
        }
        try {
            List<HotelInfoVO> hotelInfoList = new ArrayList<>();
            for (int start = 0; start < dto.getHotelIds().size(); start += BATCH_SIZE) {
                YlfxV2HotelInfosRequest request = convertRequest(dto, config, start);
                String responseBody = sendRequest(request, config);
                YlfxV2HotelInfosResponse response = JacksonUtils.parseNonEmpty(responseBody, YlfxV2HotelInfosResponse.class);
                if (response == null || !StringUtils.equals("200", response.getCode())
                        || CollectionUtils.isEmpty(response.getData())) {
                    continue;
                }
                for (YlfxV2HotelInfosHotel hotel : response.getData()) {
                    hotelInfoList.add(convertHotelInfo(hotel, responseBody));
                }
            }
            HotelInfoResponseVO result = new HotelInfoResponseVO();
            result.setHotelInfoVOList(hotelInfoList);
            return ApiRes.success(result);
        } catch (Exception e) {
            LOGGER.error("易旅分销 V2 酒店静态详情接口异常", e);
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "易旅分销 V2 酒店详情接口异常");
        }
    }

    /**
     * 转换酒店静态详情请求
     *
     * @param dto 标准静态详情请求
     * @param config 易旅分销配置
     * @param start 起始下标
     * @return V2 酒店静态详情请求
     */
    private YlfxV2HotelInfosRequest convertRequest(HotelDetailHotleIdDTO dto, YlfxConfig config, int start) {
        YlfxV2HotelInfosRequest request = new YlfxV2HotelInfosRequest();
        request.setCustomerCode(config.getCustomerCode());
        request.setHotelCodes(dto.getHotelIds().subList(start, Math.min(start + BATCH_SIZE, dto.getHotelIds().size())));
        return request;
    }

    /**
     * 发送酒店静态详情请求
     *
     * @param request V2 酒店静态详情请求
     * @param config 易旅分销配置
     * @return 原始响应
     * @throws Exception 请求异常
     */
    private String sendRequest(YlfxV2HotelInfosRequest request, YlfxConfig config) throws Exception {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String appid = StringUtils.defaultIfBlank(config.getAppid(), config.getAppId());
        Map<String, String> headers = HttpClientUtilExt.headMapJson();
        headers.put("appid", appid);
        headers.put("timestamp", timestamp);
        headers.put("signature", MD5Tool.MD5Encode(MD5Tool.MD5Encode(appid + config.getSecret()) + timestamp));
        String baseUrl = StringUtils.defaultIfBlank(config.getNewUrl(), config.getUrl());
        String url = UrlUtils.completeUrl(baseUrl, HOTEL_INFOS_URI);
        String requestBody = JacksonUtils.toJsonWithNonEmpty(request);
        return httpService.doPostBody(url, requestBody, headers);
    }

    /**
     * 转换酒店静态信息
     *
     * @param hotel V2 酒店静态信息
     * @param raw 原始响应
     * @return 标准酒店静态信息
     */
    private HotelInfoVO convertHotelInfo(YlfxV2HotelInfosHotel hotel, String raw) {
        HotelInfoVO vo = new HotelInfoVO();
        vo.setHotelInfoResponse(raw);
        vo.setHotelId(hotel.getHotelCode());
        vo.setZwmc(hotel.getHotelNameCn());
        vo.setYwmc(hotel.getHotelNameEn());
        vo.setGngjlb(GnGjTypeEnum.GN.getCode());
        vo.setSzgjmc(hotel.getCountryName());
        vo.setSzsfcode(hotel.getProvinceCode());
        vo.setSzsfmc(hotel.getProvinceName());
        vo.setSzcscode(hotel.getCityCode());
        vo.setSzcsmc(hotel.getCityName());
        vo.setGddh(hotel.getTelephone());
        vo.setBdjd(hotel.getLongitude());
        vo.setBdwd(hotel.getLatitude());
        if (Integer.valueOf(2).equals(hotel.getSaleStatus())) {
            vo.setZt(HotelStatusEnum.DISABLE.getValue());
        }
        vo.setHotelRoomTypeVOList(convertRoomInfo(hotel));
        return vo;
    }

    /**
     * 转换酒店房型信息
     *
     * @param hotel V2 酒店静态信息
     * @return 标准酒店房型列表
     */
    private List<HotelRoomTypeVO> convertRoomInfo(YlfxV2HotelInfosHotel hotel) {
        List<HotelRoomTypeVO> rooms = new ArrayList<>();
        if (CollectionUtils.isEmpty(hotel.getRooms())) {
            return rooms;
        }
        for (YlfxV2HotelInfosRoom source : hotel.getRooms()) {
            HotelRoomTypeVO room = new HotelRoomTypeVO();
            room.setHotelid(hotel.getHotelCode());
            room.setFyfxid(source.getRoomCode());
            room.setFxmc(source.getRoomNameCn());
            rooms.add(room);
        }
        return rooms;
    }
}
