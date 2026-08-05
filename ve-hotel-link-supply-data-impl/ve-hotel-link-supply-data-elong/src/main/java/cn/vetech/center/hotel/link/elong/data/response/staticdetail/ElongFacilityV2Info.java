package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:48
 */
public class ElongFacilityV2Info {
    /**
     * 设施Id	  可以通过hotel.dictionary接口获取字典
     */
    @JsonProperty("FacilityId")
    private String facilityId;
    /**
     * 设施名称
     */
    @JsonProperty("FacilityName")
    private String facilityName;
    /**
     * 设施收费信息
     */
    @JsonProperty("FeeInfo")
    private ElongFeeInfo feeInfo;
    /**
     * 设施营业时间
     */
    @JsonProperty("BusinessHourInfos")
    private List<ElongBusinessHourInfo> businessHourInfos;
    /**
     * 设施年龄限制信息
     */
    @JsonProperty("AgeLimitInfo")
    private ElongAgeLimitInfo ageLimitInfo;
    /**
     * 设施预约信息
     */
    @JsonProperty("ReservationInfo")
    private ElongReservationInfo reservationInfo;

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

    public ElongFeeInfo getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(ElongFeeInfo feeInfo) {
        this.feeInfo = feeInfo;
    }

    public List<ElongBusinessHourInfo> getBusinessHourInfos() {
        return businessHourInfos;
    }

    public void setBusinessHourInfos(List<ElongBusinessHourInfo> businessHourInfos) {
        this.businessHourInfos = businessHourInfos;
    }

    public ElongAgeLimitInfo getAgeLimitInfo() {
        return ageLimitInfo;
    }

    public void setAgeLimitInfo(ElongAgeLimitInfo ageLimitInfo) {
        this.ageLimitInfo = ageLimitInfo;
    }

  public ElongReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(ElongReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }
}
