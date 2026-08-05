package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:19
 */
public class ElongChildBreakfast {
    /**
     * 是否有单独儿童早餐		T有；F无；T时解析ChildBreakfast节点的其他信息
     */
    @JsonProperty("SetSeparately")
    private String setSeparately;
    /**
     * 范围类型	        	Age：年龄；Height：身高
     */
    @JsonProperty("RangeType")
    private String rangeType;
    /**
     * 货币类型
     */
    @JsonProperty("Currenry")
    private String currenry;
    /**
     * 儿童早餐详细信息
     */
    @JsonProperty("ChildBreakfastDetails")
    private List<ElongChildBreakfastDetails> childBreakfastDetails;

    public String getSetSeparately() {
        return setSeparately;
    }

    public void setSetSeparately(String setSeparately) {
        this.setSeparately = setSeparately;
    }

    public String getRangeType() {
        return rangeType;
    }

    public void setRangeType(String rangeType) {
        this.rangeType = rangeType;
    }

    public String getCurrenry() {
        return currenry;
    }

    public void setCurrenry(String currenry) {
        this.currenry = currenry;
    }

    public List<ElongChildBreakfastDetails> getChildBreakfastDetails() {
        return childBreakfastDetails;
    }

    public void setChildBreakfastDetails(List<ElongChildBreakfastDetails> childBreakfastDetails) {
        this.childBreakfastDetails = childBreakfastDetails;
    }
}
 public void setAllowChildrenToStaLimitOfChildAge(String allowChildrenToStaLimitOfChildAge) {
        this.allowChildrenToStaLimitOfChildAge = allowChildrenToStaLimitOfChildAge;
    }

    public ElongChildBreakfast getChildBreakfast() {
        return childBreakfast;
    }

    public void setChildBreakfast(ElongChildBreakfast childBreakfast) {
        this.childBreakfast = childBreakfast;
    }

    public String getAllowUseExistingBedV2() {
        return allowUseExistingBedV2;
    }

    public void setAllowUseExistingBedV2(String allowUseExistingBedV2) {
        this.allowUseExistingBedV2 = allowUseExistingBedV2;
    }

    public ElongExistingBed getExistingBed() {
        return existingBed;
    }

    public void setExistingBed(ElongExistingBed existingBed) {
        this.existingBed = existingBed;
    }

    public String getExtraBedLimit() {
        return extraBedLimit;
    }

    public void setExtraBedLimit(String extraBedLimit) {
        this.extraBedLimit = extraBedLimit;
    }

    public String getExtraCribLimit() {
        return extraCribLimit;
    }

    public void setExtraCribLimit(String extraCribLimit) {
        this.extraCribLimit = extraCribLimit;
    }

    public List<ElongExtraBedPolicy> getExtraBedPolicy() {
        return extraBedPolicy;
    }

    public void setExtraBedPolicy(List<ElongExtraBedPolicy> extraBedPolicy) {
        this.extraBedPolicy = extraBedPolicy;
    }
}
