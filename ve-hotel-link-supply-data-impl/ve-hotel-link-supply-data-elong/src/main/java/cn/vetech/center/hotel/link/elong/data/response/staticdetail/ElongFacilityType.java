package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-06-05 13:55
 */
public class ElongFacilityType {

    /**
     * 设施分类Id	Long	N
     */
    @JsonProperty("FacilityTypeId")
    private String facilityTypeId;

    /**
     * 设施分类名称	String	N
     */
    @JsonProperty("FacilityTypeName")
    private String facilityTypeName;

    /**
     * 设施信息
     */
    @JsonProperty("FacilityInfoList")
    private List<ElongFacilityTypeInfo> facilityInfoList;

    public String getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(String facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public List<ElongFacilityTypeInfo> getFacilityInfoList() {
        return facilityInfoList;
    }

    public void setFacilityInfoList(List<ElongFacilityTypeInfo> facilityInfoList) {
        this.facilityInfoList = facilityInfoList;
    }
}
