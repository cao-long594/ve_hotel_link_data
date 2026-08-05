package cn.vetech.center.hotel.link.ylfx.data.v2;

import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.http.HttpClientUtilExt;
import cn.vetech.center.hotel.link.http.HttpService;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxConfig;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.UrlUtils;
import cn.vetech.center.hotel.link.ylfx.data.v2.request.YlfxV2HotelCodesRequest;
import cn.vetech.center.hotel.link.ylfx.data.v2.response.YlfxV2HotelCodesResponse;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 易旅分销 V2 酒店静态服务。
 */
@Service
public class YlfxV2HotelCodeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(YlfxV2HotelCodeService.class);
    private static final String API_VERSION_V2 = "v2";
    private static final String HOTEL_CODES_URI = "/open/static/hotelcodes";

    @Autowired
    private HttpService httpService;

    public static boolean isV2(YlfxConfig config) {
        return config != null && StringUtils.equalsIgnoreCase(API_VERSION_V2, config.getApiVersion());
    }

    public RestResponse<List<HotelIdVO>> getHotelIdList(YlfxConfig config) throws SystemException {
        String configError = validateConfig(config);
        if (StringUtils.isNotBlank(configError)) {
            LOGGER.warn("易旅分销 V2 酒店编码接口配置错误: {}", configError);
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, configError);
        }

        try {
            YlfxV2HotelCodesRequest request = new YlfxV2HotelCodesRequest();
            request.setCustomerCode(config.getCustomerCode());
            request.setDomestic(1);
            String url = UrlUtils.completeUrl(config.getUrl(), HOTEL_CODES_URI);
            String requestBody = JacksonUtils.toJsonWithNonEmpty(request);
            Map<String, String> headers = HttpClientUtilExt.headMapJson();
            headers.put("appid", config.getAppid());

            String responseBody = httpService.doPostBody(url, requestBody, headers);
            YlfxV2HotelCodesResponse response = JacksonUtils.parseNonEmpty(responseBody, YlfxV2HotelCodesResponse.class);
            if (response == null) {
                return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "易旅分销 V2 酒店编码接口响应为空");
            }
            if (!StringUtils.equals("200", response.getCode())) {
                return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, response.getMessage());
            }
            if (CollectionUtils.isEmpty(response.getData())) {
                return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "易旅分销 V2 酒店编码列表为空");
            }
            return ApiRes.success(convertHotelIds(response.getData()));
        } catch (Exception e) {
            LOGGER.error("易旅分销 V2 酒店编码接口异常", e);
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "易旅分销 V2 酒店编码接口异常");
        }
    }

    private String validateConfig(YlfxConfig config) {
        if (config == null || StringUtils.isAnyBlank(config.getUrl(), config.getAppid(),
                config.getSecret(), config.getCustomerCode())) {
            return "易旅分销 V2 配置不完整";
        }
        return null;
    }

    private List<HotelIdVO> convertHotelIds(List<String> hotelCodes) {
        return hotelCodes.stream()
                .filter(StringUtils::isNotBlank)
                .distinct()
                .map(hotelCode -> {
                    HotelIdVO hotelIdVO = new HotelIdVO();
                    hotelIdVO.setHotelId(hotelCode);
                    hotelIdVO.setGngj(GnGjTypeEnum.GN.getCode());
                    hotelIdVO.setUpdatedTime(VeDate.getStringDate());
                    return hotelIdVO;
                })
                .collect(Collectors.toList());
    }
}
