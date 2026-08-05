package cn.vetech.center.hotel.link.mtw.price.request;

import cn.vetech.center.hotel.link.mtw.common.MtwRequest;

public class MtwHotelPriceRequest extends MtwRequest {

    /***
     * 请求方法
     */
    private String method;
    /**
     * 请求数据
     */
    private MtwRequestData data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public MtwRequestData getData() {
        return data;
    }

    public void setData(MtwRequestData data) {
        this.data = data;
    }
}