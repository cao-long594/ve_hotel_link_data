package cn.vetech.center.hotel.link.mtw.price.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

public class MtwGoodPriceResponse extends MtwResponse {

    /***
     * 结果
     */
    private MtwPriceResult result;

    public MtwPriceResult getResult() {
        return result;
    }

    public void setResult(MtwPriceResult result) {
        this.result = result;
    }
}
