package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class ProductBaseBean {
    /**
     * needCertificate
     */
    @JsonProperty("needCertificate")
    private Boolean needCertificate;
    /**
     * productStatus
     */
    @JsonProperty("productStatus")
    private Integer productStatus;
    /**
     * productLimitRule
     */
    @JsonProperty("productLimitRule")
    private String productLimitRule;
    /**
     * inventory
     */
    @JsonProperty("inventory")
    private Integer inventory;
    /**
     * confirmType
     */
    @JsonProperty("confirmType")
    private Integer confirmType;
    /**
     * productType
     */
    @JsonProperty("productType")
    private Integer productType;
    /**
     * productName
     */
    @JsonProperty("productName")
    private String productName;
    /**
     * paymentType
     */
    @JsonProperty("paymentType")
    private Integer paymentType;
     public Boolean getNeedCertificate() {
        return needCertificate;
    }

    public void setNeedCertificate(Boolean needCertificate) {
        this.needCertificate = needCertificate;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductLimitRule() {
        return productLimitRule;
    }

    public void setProductLimitRule(String productLimitRule) {
        this.productLimitRule = productLimitRule;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(Integer confirmType) {
        this.confirmType = confirmType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
}
