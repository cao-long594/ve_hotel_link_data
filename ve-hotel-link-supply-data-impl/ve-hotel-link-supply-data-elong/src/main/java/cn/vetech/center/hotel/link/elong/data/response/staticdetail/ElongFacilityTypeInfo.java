package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-06-05 13:58
 */
public class ElongFacilityTypeInfo {

    /**
     * 设施Id	Long	N
     */
    @JsonProperty("FacilityId")
    private String facilityId;
    /**
     * 设施名称	String	N
     */
    @JsonProperty("FacilityName")
    private String facilityName;
    /**
     * 设施收费信息
     */
    @JsonProperty("FeeInfo")
    private List<ElongFacilityFeeInfo> feeInfo;
    /**
     * 设施营业时间	BusinessHourInfo[]	Y
     */
    @JsonProperty("BusinessHourInfos")
    private List<ElongFacilityBusinessHourInfo> businessHourInfos;
    /**
     * 设施年龄限制信息
     */
    @JsonProperty("AgeLimitInfo")
    private ElongFacilityAgeLimitInfo ageLimitInfo;
    /**
     * 设施预约信息	RestaurantInfo	Y
     */
    @JsonProperty("RestaurantInfo")
    private ElongFacilityRestaurantInfo restaurantInfo;

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public List<ElongFacilityFeeInfo> getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(List<ElongFacilityFeeInfo> feeInfo) {
        this.feeInfo = feeInfo;
    }

    public List<ElongFacilityBusinessHourInfo> getBusinessHourInfos() {
        return businessHourInfos;
    }

    public void setBusinessHourInfos(List<ElongFacilityBusinessHourInfo> businessHourInfos) {
        this.businessHourInfos = businessHourInfos;
    }

    public ElongFacilityAgeLimitInfo getAgeLimitInfo() {
        return ageLimitInfo;
    }

    public void setAgeLimitInfo(ElongFacilityAgeLimitInfo ageLimitInfo) {
        this.ageLimitInfo = ageLimitInfo;
    }

    public ElongFacilityRestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(ElongFacilityRestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }
}
