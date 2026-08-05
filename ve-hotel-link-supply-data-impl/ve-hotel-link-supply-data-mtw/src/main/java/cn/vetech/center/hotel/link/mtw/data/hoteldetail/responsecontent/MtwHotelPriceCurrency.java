package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:03
 */
public class MtwHotelPriceCurrency {

    /**
     *
     * 金额，单位元
     */
    private String price;

    /**
     *
     * 币种, 目前只有人民币
     */
    private String currency;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
