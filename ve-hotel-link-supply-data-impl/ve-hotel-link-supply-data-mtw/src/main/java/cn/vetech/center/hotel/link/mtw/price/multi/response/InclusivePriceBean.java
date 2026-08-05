package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class InclusivePriceBean {
    /**
     * date
     */
    @JsonProperty("date")
    private String date;
    /**
     * salePrice
     */
    @JsonProperty("salePrice")
    private Integer salePrice;
    /**
     * subPrice
     */
    @JsonProperty("subPrice")
    private Integer subPrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(Integer subPrice) {
        this.subPrice = subPrice;
    }
}
