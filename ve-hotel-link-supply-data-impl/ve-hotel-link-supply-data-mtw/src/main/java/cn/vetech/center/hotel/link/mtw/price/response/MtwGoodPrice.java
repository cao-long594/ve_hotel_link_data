package cn.vetech.center.hotel.link.mtw.price.response;

import cn.vetech.center.hotel.link.mtw.ratesearch.response.PriceModel;

import java.util.List;

public class MtwGoodPrice {
    /**
     * 产品ID
     */
    private String goodsId;
    /***
     * 酒店ID
     */
    private String hotelId;

    /**
     * 最低价实体
     */
    private List<PriceModel> lowestPriceModels;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public List<PriceModel> getLowestPriceModels() {
        return lowestPriceModels;
    }

    public void setLowestPriceModels(List<PriceModel> lowestPriceModels) {
        this.lowestPriceModels = lowestPriceModels;
    }
}