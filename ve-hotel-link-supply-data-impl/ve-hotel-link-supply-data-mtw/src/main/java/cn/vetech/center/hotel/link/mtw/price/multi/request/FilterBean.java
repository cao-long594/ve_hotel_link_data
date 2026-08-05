package cn.vetech.center.hotel.link.mtw.price.multi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:11
 */
public class FilterBean {
    /**
     * maximumPrice
     */
    @JsonProperty("maximumPrice")
    private Integer maximumPrice;
    /**
     * minimumPrice
     */
    @JsonProperty("minimumPrice")
    private Integer minimumPrice;
    /**
     * productType
     */
    @JsonProperty("productType")
    private Integer productType;

    public Integer getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(Integer maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }
}
