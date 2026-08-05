package cn.vetech.center.hotel.link.mtw.price.multi.request;

import cn.vetech.center.hotel.link.mtw.common.MtwRequest;
import cn.vetech.center.hotel.link.mtw.price.request.MtwRequestData;

/**
 * @author chengwanshan
 * @since 2024/8/1 9:18
 */
public class MtwMultiRequest extends MtwRequest {

    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求数据
     */
    private MtwMultiRequestData data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public MtwMultiRequestData getData() {
        return data;
    }

    public void setData(MtwMultiRequestData data) {
        this.data = data;
    }
}
