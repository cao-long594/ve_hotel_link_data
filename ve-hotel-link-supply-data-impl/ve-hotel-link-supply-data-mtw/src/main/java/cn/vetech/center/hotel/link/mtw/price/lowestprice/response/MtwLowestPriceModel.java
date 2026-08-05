package cn.vetech.center.hotel.link.mtw.price.lowestprice.response;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:37
 */
public class MtwLowestPriceModel {
    /**
     * 日期，格式为 yyyy-MM-dd
     */
    private String date;
    /**
     * 最低售卖价，单位分
     */
    private String lowestSalePrice;
    /**
     * 最低结算价，单位分；仅结算价分销商才会输出
     */
    private String lowestSettlePrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLowestSalePrice() {
        return lowestSalePrice;
    }

    public void setLowestSalePrice(String lowestSalePrice) {
        this.lowestSalePrice = lowestSalePrice;
    }

    public String getLowestSettlePrice() {
        return lowestSettlePrice;
    }

    public void setLowestSettlePrice(String lowestSettlePrice) {
        this.lowestSettlePrice = lowestSettlePrice;
    }
}
