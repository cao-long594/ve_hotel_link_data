package cn.vetech.center.hotel.link.mtw.price.request;

import java.util.List;

public class MtwRequestData {

    /***
     * 请求查询的酒店ID列表，一次最多查询10个
     */
    private List<Long> hotelIds;
    /***
     * 入住日期，格式为yyyy-MM-dd，不能早于当前日期。
     */
    private String checkinDate;
    /***
     * 离店日期，格式为yyyy-MM-dd，与当前日期相差不能超过30天。
     */
    private String checkoutDate;

    /**
     *
     * 产品类型：
     * 1 全日房
     * 2 钟点房
     * 3 全日房和钟点房
     */
    private Integer goodsType;

    /**
     * 需要查询的产品维度，共支持3种："BASE"：基础信息、"PRICE"：价格日历、"RS"：房态日历。按需传入所需产品维度，若该字段为空，则默认为只查询"BASE"、"PRICE"。 LP：最低价
     */
    private List<String> queryInfoDimensions;

    public List<String> getQueryInfoDimensions() {
        return queryInfoDimensions;
    }

    public void setQueryInfoDimensions(List<String> queryInfoDimensions) {
        this.queryInfoDimensions = queryInfoDimensions;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

}
