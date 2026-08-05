package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class ServiceBean {
    /**
     * mealType
     */
    @JsonProperty("mealType")
    private List<MealTypeBean> mealType;
    /**
     * gifts
     */
    @JsonProperty("gifts")
    private List<?> gifts;

    public List<MealTypeBean> getMealType() {
        return mealType;
    }

    public void setMealType(List<MealTypeBean> mealType) {
        this.mealType = mealType;
    }

    public List<?> getGifts() {
        return gifts;
    }

    public void setGifts(List<?> gifts) {
        this.gifts = gifts;
    }
}
