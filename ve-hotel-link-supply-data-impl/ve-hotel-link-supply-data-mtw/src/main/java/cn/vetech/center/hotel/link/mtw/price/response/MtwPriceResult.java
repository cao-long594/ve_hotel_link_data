package cn.vetech.center.hotel.link.mtw.price.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

import java.util.List;

public class MtwPriceResult{

    /**
     * 价格列表
     */
    private List<MtwGoodPrice> goodsPrices;

    public List<MtwGoodPrice> getGoodsPrices() {
        return goodsPrices;
    }

    public void setGoodsPrices(List<MtwGoodPrice> goodsPrices) {
        this.goodsPrices = goodsPrices;
    }
}
