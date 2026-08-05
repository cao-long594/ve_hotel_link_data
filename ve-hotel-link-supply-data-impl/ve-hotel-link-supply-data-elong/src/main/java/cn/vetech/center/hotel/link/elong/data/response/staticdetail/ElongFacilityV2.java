package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:45
 */
public class ElongFacilityV2 {
    /**
     * 设施分类Id     可以通过hotel.dictionary接口获取字典
     */
    @JsonProperty("FacilityTypeId")
    private String facilityTypeId;
    /**
     * 设施分类名称
     */
    @JsonProperty("FacilityTypeName")
    private String facilityTypeName;
    /**
     * 设施信息
     */
    @JsonProperty("FacilityInfoList")
    private List<ElongFacilityV2Info> facilityInfoList;

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

    public List<ElongFacilityV2Info> getFacilityInfoList() {
        return facilityInfoList;
    }

    public void setFacilityInfoList(List<ElongFacilityV2Info> facilityInfoList) {
        this.facilityInfoList = facilityInfoList;
    }
}
