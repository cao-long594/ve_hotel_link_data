package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class BedGroupsBean {
    /**
     * bedType
     */
    @JsonProperty("bedType")
    private String bedType;
    /**
     * bedDesc
     */
    @JsonProperty("bedDesc")
    private String bedDesc;
    /**
     * bedCount
     */
    @JsonProperty("bedCount")
    private Integer bedCount;

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getBedDesc() {
        return bedDesc;
    }

    public void setBedDesc(String bedDesc) {
        this.bedDesc = bedDesc;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }
}
