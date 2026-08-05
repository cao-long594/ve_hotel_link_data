package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:29
 */
public class ElongMealInfo {
    /**
     * 早餐类型		0.未知，1.不包含儿童早餐，2.包含儿童早餐
     */
    @JsonProperty("BreakfastType")
    private String breakfastType;

    public String getBreakfastType() {
        return breakfastType;
    }

    public void setBreakfastType(String breakfastType) {
        this.breakfastType = breakfastType;
    }
}
