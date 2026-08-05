package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:38
 */
public class ElongDepositPolicy {
    /**
     * 是否收取押金		1:是, 0:否, null:未知
     */
    @JsonProperty("DepositSwitch")
    private String depositSwitch;
    /**
     * 收取频次	    	1:固定金额，2:每间，3:每晚
     */
    @JsonProperty("Frequency")
    private String frequency;
    /**
     * 收取金额
     */
    @JsonProperty("Amount")
    private String amount;
    /**
     * 押金支付方式		1:现金，2:信用卡，3:借记卡，4:第三方平台
     */
    @JsonProperty("PayType")
    private List<String> payType;
    /**
     * 押金退还方式		0:不原路退还，1:原路退还
     */
    @JsonProperty("RefundType")
    private List<String> refundType;
    /**
     * 押金退还时间		0:当日退还，1:一周内退还，2:两周内退还
     */
    @JsonProperty("RefundTime")
    private String refundTime;
    /**
     * 押金币种	    	默认RMB
     */
    @JsonProperty("Currency")
    private String currency;

    public String getDepositSwitch() {
        return depositSwitch;
    }

    public void setDepositSwitch(String depositSwitch) {
        this.depositSwitch = depositSwitch;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<String> getPayType() {
        return payType;
    }

    public void setPayType(List<String> payType) {
        this.payType = payType;
    }

    public List<String> getRefundType() {
        return refundType;
    }

    public void setRefundType(List<String> refundType) {
        this.refundType = refundType;
    }

    public String getRefundTime() {
        return refundTime;
    }

public void setRefundTime(String refundTime) {
        this.refundTime = refundTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
