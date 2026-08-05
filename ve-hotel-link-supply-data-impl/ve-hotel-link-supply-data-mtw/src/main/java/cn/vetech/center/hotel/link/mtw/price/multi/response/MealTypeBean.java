package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class MealTypeBean {
    /**
     * codeX
     */
    @JsonProperty("code")
    private String codeX;
    /**
     * endDate
     */
    @JsonProperty("endDate")
    private Integer endDate;
    /**
     * count
     */
    @JsonProperty("count")
    private Integer count;
    /**
     * startDate
     */
    @JsonProperty("startDate")
    private Integer startDate;
    /**
     * desc
     */
    @JsonProperty("desc")
    private String desc;

    public String getCodeX() {
        return codeX;
    }

    public void setCodeX(String codeX) {
        this.codeX = codeX;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
