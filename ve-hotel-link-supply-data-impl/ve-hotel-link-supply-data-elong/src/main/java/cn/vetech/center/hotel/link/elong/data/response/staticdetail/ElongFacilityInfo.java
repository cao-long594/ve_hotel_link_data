package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 13:59
 */
public class ElongFacilityInfo {

    /***
     * 设施ID
     */
    @JsonProperty("FacilityId")
    private String facilityId;
    /***
     * 设施中文名称
     */
    @JsonProperty("FacilityName")
    private String facilityName;
    /***
     * 设施英文名称
     */
    @JsonProperty("FacilityNameEn")
    private String facilityNameEn;

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

    public String getFacilityNameEn() {
        return facilityNameEn;
    }

    public void setFacilityNameEn(String facilityNameEn) {
        this.facilityNameEn = facilityNameEn;
    }
}
