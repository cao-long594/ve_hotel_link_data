package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since 2024-06-05 13:55
 */
public class ElongFacilityAgeLimitInfo {

    /**
     * 设施使用最小年龄	String Y
     */
    @JsonProperty("MinAge")
    private String minage;
    /**
     * 设施使用最大年龄	String	Y
     */
    @JsonProperty("MaxAge")
    private String maxage;

    public String getMinage() {
        return minage;
    }

    public void setMinage(String minage) {
        this.minage = minage;
    }

    public String getMaxage() {
        return maxage;
    }

    public void setMaxage(String maxage) {
        this.maxage = maxage;
    }
}