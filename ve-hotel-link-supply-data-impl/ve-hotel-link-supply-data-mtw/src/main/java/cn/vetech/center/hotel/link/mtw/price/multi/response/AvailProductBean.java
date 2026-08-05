package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class AvailProductBean {
    /**
     * bookingRule
     */
    @JsonProperty("bookingRule")
    private List<BookingRuleBean> bookingRule;
    /**
     * productId
     */
    @JsonProperty("productId")
    private Integer productId;
    /**
     * service
     */
    @JsonProperty("service")
    private ServiceBean service;
    /**
     * cancelPolicy
     */
    @JsonProperty("cancelPolicy")
    private List<CancelPolicyBean> cancelPolicy;
    /**
     * guarantee
     */
    @JsonProperty("guarantee")
    private List<?> guarantee;
    /**
     * currency
     */
    @JsonProperty("currency")
    private String currency;
    /**
     * invoice
     */
    @JsonProperty("invoice")
    private InvoiceBean invoice;
    /**
     * room
     */
    @JsonProperty("room")
    private RoomBean room;
    /**
     * productBase
     */
    @JsonProperty("productBase")
    private ProductBaseBean productBase;
    /**
     * inclusivePrice
     */
    @JsonProperty("inclusivePrice")
    private List<InclusivePriceBean> inclusivePrice;
    /**
     * promotion
     */
    @JsonProperty("promotion")
    private List<?> promotion;

    public List<BookingRuleBean> getBookingRule() {
        return bookingRule;
    }

    public void setBookingRule(List<BookingRuleBean> bookingRule) {
        this.bookingRule = bookingRule;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
 public ServiceBean getService() {
        return service;
    }

    public void setService(ServiceBean service) {
        this.service = service;
    }

    public List<CancelPolicyBean> getCancelPolicy() {
        return cancelPolicy;
    }

    public void setCancelPolicy(List<CancelPolicyBean> cancelPolicy) {
        this.cancelPolicy = cancelPolicy;
    }

    public List<?> getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(List<?> guarantee) {
        this.guarantee = guarantee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public InvoiceBean getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceBean invoice) {
        this.invoice = invoice;
    }

    public RoomBean getRoom() {
        return room;
    }

    public void setRoom(RoomBean room) {
        this.room = room;
    }

    public ProductBaseBean getProductBase() {
        return productBase;
    }

    public void setProductBase(ProductBaseBean productBase) {
        this.productBase = productBase;
    }

    public List<InclusivePriceBean> getInclusivePrice() {
        return inclusivePrice;
    }

    public void setInclusivePrice(List<InclusivePriceBean> inclusivePrice) {
        this.inclusivePrice = inclusivePrice;
    }

    public List<?> getPromotion() {
        return promotion;
    }

    public void setPromotion(List<?> promotion) {
        this.promotion = promotion;
    }
}
