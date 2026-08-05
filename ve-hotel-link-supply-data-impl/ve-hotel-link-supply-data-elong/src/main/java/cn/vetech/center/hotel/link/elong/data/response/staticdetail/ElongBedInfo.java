package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/6/23 10:49
 */
public class ElongBedInfo {
    /**
     * 床型id
     */
    @JsonProperty("BedTypeId")
    private String bedTypeId;
    /**
     * 床宽，单位：m
     */
    @JsonProperty("BedWidth")
    private String bedWidth;
    /**
     * 床的数量
     */
    @JsonProperty("BedCount")
    private String bedCount;
    /**
     * 床的名称
     */
    @JsonProperty("BedName")
    private String bedName;
    /**
     * 备注
     */
    @JsonProperty("Remark")
    private String remark;

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getBedWidth() {
        return bedWidth;
    }

    public void setBedWidth(String bedWidth) {
        this.bedWidth = bedWidth;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
