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
 * 易旅分销 V2 酒店静态服务
 *
 * @author 6161
 * @date 2026/08/05
 */
@Service
public class YlfxV2HotelCodeService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(YlfxV2HotelCodeService.class);
    /**
     * 可同步酒店编码接口
     */
    private static final String HOTEL_CODES_URI = "/open/static/hotelcodes";

    /**
     * HTTP 请求服务
     */
    @Autowired
    private HttpService httpService;

    /**
     * 获取可同步酒店编码列表
     *
     * @param config 供应商配置
     * @return 酒店编码列表
     * @throws SystemException 系统异常
     */
    public RestResponse<List<HotelIdVO>> getHotelIdList(YlfxConfig config) throws SystemException {
        if (!checkConfig(config)) {
            LOGGER.warn("易旅分销 V2 酒店编码接口供应商配置不完整");
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
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

    /**
     * 校验 V2 接口配置
     *
     * @param config 供应商配置
     * @return true：校验通过；false：校验失败
     */
    private boolean checkConfig(YlfxConfig config) {
        if (config == null || StringUtils.isAnyBlank(config.getUrl(), config.getAppid(),
                config.getSecret(), config.getCustomerCode())) {
            return false;
        }
        return true;
    }

    /**
     * 转换标准酒店编码
     *
     * @param hotelCodes 易旅酒店编码
     * @return 标准酒店编码
     */
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
