package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 15:56
 * @comment
 */
public class EtlMealInfo {
    /**
     * 早餐类型
     * 0：未知；
     * 1：不包含儿童早餐；
     * 2：包含儿童早餐
     */
    private String breakfastType;

    public String getBreakfastType() {
        return breakfastType;
    }

    public void setBreakfastType(String breakfastType) {
        this.breakfastType = breakfastType;
    }
}
