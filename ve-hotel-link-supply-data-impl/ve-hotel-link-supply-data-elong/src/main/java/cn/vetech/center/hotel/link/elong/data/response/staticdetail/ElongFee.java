package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:25
 */
public class ElongFee {
    /**
     * 收费金额	    	该节点为空时表示价格未知
     */
    @JsonProperty("Amount")
    private List<ElongAmount> amount;
    /**
     * 收费频率	    	Daily每晚；PerStay每次入住
     */
    @JsonProperty("ChargeFrequency")
    private String chargeFrequency;
    /**
     * 收费单位	    	PerPerson每人
     */
    @JsonProperty("ChargeUnit")
    private String chargeUnit;
    /**
     * 早餐信息	      废弃，儿童早餐信息查看ChildBreakfast节点
     */
    @JsonProperty("MealInfo")
    private ElongMealInfo mealInfo;
    /**
     * 使用儿童范围
     */
    @JsonProperty("RangeLimit")
    private List<ElongRangeLimit> rangeLimit;

    public List<ElongAmount> getAmount() {
        return amount;
    }

    public void setAmount(List<ElongAmount> amount) {
        this.amount = amount;
    }

    public String getChargeFrequency() {
        return chargeFrequency;
    }

    public void setChargeFrequency(String chargeFrequency) {
        this.chargeFrequency = chargeFrequency;
    }

    public String getChargeUnit() {
        return chargeUnit;
    }

    public void setChargeUnit(String chargeUnit) {
        this.chargeUnit = chargeUnit;
    }

    public ElongMealInfo getMealInfo() {
        return mealInfo;
    }

    public void setMealInfo(ElongMealInfo mealInfo) {
        this.mealInfo = mealInfo;
    }

    public List<ElongRangeLimit> getRangeLimit() {
        return rangeLimit;
    }

    public void setRangeLimit(List<ElongRangeLimit> rangeLimit) {
        this.rangeLimit = rangeLimit;
    }
}
