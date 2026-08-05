package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 14:21
 */
public class ElongAvailPolicyInfo {

    /***
     * 特殊政策开始日期
     */
    @JsonProperty("StartDate")
    private String startDate;
    /***
     * 特殊政策结束日期
     */
    @JsonProperty("EndDate")
    private String endDate;
    /***
     * 特殊政策中文描述
     */
    @JsonProperty("Description")
    private String description;
    /***
     * 特殊政策英文描述
     */
    @JsonProperty("DescriptionEn")
    private String descriptionEn;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
}
