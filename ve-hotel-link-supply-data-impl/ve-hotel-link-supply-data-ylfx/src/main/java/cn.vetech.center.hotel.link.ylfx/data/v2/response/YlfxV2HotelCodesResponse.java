package cn.vetech.center.hotel.link.ylfx.data.v2.response;

import java.util.List;

/**
 * V2 standard response for synchronizable hotel codes.
 */
public class YlfxV2HotelCodesResponse {
    private String code;
    private String message;
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
