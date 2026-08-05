package cn.vetech.center.hotel.link.mtw.price.lowestprice.request;

import cn.vetech.center.hotel.link.mtw.common.MtwRequest;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:27
 */
public class MtwLowestPriceRequest extends MtwRequest {
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求数据
     */
    private MtwLowestPriceRequestData data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public MtwLowestPriceRequestData getData() {
        return data;
    }

    public void setData(MtwLowestPriceRequestData data) {
        this.data = data;
    }
}
