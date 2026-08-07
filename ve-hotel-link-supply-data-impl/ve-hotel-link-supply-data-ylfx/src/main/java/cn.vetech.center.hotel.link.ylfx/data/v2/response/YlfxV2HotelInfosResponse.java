package cn.vetech.center.hotel.link.ylfx.data.v2.response;

import java.util.List;

/**
 * 易旅分销 V2 酒店静态信息响应
 *
 * @author 6161
 * @date 2026/08/05
 */
public class YlfxV2HotelInfosResponse {
    /**
     * 响应编码：200 成功
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 酒店静态信息列表
     */
    private List<YlfxV2HotelInfosHotel> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<YlfxV2HotelInfosHotel> getData() {
        return data;
    }

    public void setData(List<YlfxV2HotelInfosHotel> data) {
        this.data = data;
    }
}
