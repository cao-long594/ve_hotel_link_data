package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:58
 */
public class ElongAgeLimitInfo {
    /**
     * 设施使用最小年龄
     */
    @JsonProperty("MinAge")
    private String minAge;
    /**
     * 设施使用最大年龄
     */
    @JsonProperty("MaxAge")
    private String maxAge;

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }
}
