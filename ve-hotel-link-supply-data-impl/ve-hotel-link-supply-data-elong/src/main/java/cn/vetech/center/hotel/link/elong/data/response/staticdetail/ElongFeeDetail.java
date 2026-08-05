package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:54
 */
public class ElongFeeDetail {
    /**
     * 设施费用金额
     */
    @JsonProperty("Amount")
    private String amount;
    /**
     * 设施费用币种
     */
    @JsonProperty("Currency")
    private String currency;
    /**
     * 设施费用类型
     * Time：次数；Minute：分钟；Quarter：一刻钟；HalfHour：半小时；Hour：小时；Day：天；Week：周；Person：人；Bed：床；Car：车；Bottle：瓶
     */
    @JsonProperty("FeeTimeType")
    private String feeTimeType;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFeeTimeType() {
        return feeTimeType;
    }

    public void setFeeTimeType(String feeTimeType) {
        this.feeTimeType = feeTimeType;
    }
}
