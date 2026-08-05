package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:32
 */
public class ElongExtraBedPolicy {
    /**
     * 加床类型	        	1： 加床； 2：加婴儿床
     */
    @JsonProperty("BedType")
    private String bedType;
    /**
     * 收费频率	        	1：每晚 2：每次入住
     */
    @JsonProperty("ChargeFrequency")
    private String chargeFrequency;
    /**
     * 收费类型	        	1：明确价格；2：占房费比
     */
    @JsonProperty("ChargeType")
    private String chargeType;
    /**
     * 加床费用币种
     */
    @JsonProperty("Currency")
    private String currency;
    /**
     * 收费金额或比例
     */
    @JsonProperty("Fee")
    private String fee;
    /**
     * 年龄范围左
     */
    @JsonProperty("RangeFrom")
    private String rangeFrom;
    /**
     * 年龄范围右
     */
    @JsonProperty("RangeTo")
    private String rangeTo;


    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getChargeFrequency() {
        return chargeFrequency;
    }

    public void setChargeFrequency(String chargeFrequency) {
        this.chargeFrequency = chargeFrequency;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(String rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public String getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(String rangeTo) {
        this.rangeTo = rangeTo;
    }
}
