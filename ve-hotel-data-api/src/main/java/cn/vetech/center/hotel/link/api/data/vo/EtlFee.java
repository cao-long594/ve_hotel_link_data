package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/17 15:52
 * 费用
 */
public class EtlFee {
    /**
     * 类型
     （Child：儿童；Adult：成人）
     */
    private String category;
    /**
     * 床类型  加床政策独有
     * 1：加床；
     * 2：加婴儿床；
     * 3：加床/加婴儿床
     */
    private String bedType;
    /**
     * 是否免费
     */
    private Boolean isFree;
    /**
     * 收费率
     */
    private String chargeFrequency;
    /**
     * 收费单位
     */
    private String chargeUnit;
    /**
     * 人数 共用床政策独有
     */
    private Integer occupancy;

    /**
     * 早餐
     */
    private EtlMealInfo mealInfo;
    /**
     * 金额
     */
    private List<EtlAmount> amounts;
    /**
     * 规则
     */
    private List<EtlRangeLimit> rangeLimits;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
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

    public Integer getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Integer occupancy) {
        this.occupancy = occupancy;
    }

    public EtlMealInfo getMealInfo() {
        return mealInfo;
    }

    public void setMealInfo(EtlMealInfo mealInfo) {
        this.mealInfo = mealInfo;
    }

public List<EtlAmount> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<EtlAmount> amounts) {
        this.amounts = amounts;
    }

    public List<EtlRangeLimit> getRangeLimits() {
        return rangeLimits;
    }

    public void setRangeLimits(List<EtlRangeLimit> rangeLimits) {
        this.rangeLimits = rangeLimits;
    }
}
