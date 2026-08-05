package cn.vetech.center.hotel.link.ylfx.data.v2.response;

import java.util.List;

/**
 * V2 可同步酒店编码响应
 *
 * @author 6161
 * @date 2026/08/05
 */
public class YlfxV2HotelCodesResponse {
    /**
     * 响应编码：200 成功
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 酒店编码列表
     */
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
