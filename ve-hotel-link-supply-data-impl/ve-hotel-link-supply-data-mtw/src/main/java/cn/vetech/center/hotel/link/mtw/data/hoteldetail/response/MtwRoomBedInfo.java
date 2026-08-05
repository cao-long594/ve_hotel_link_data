package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwRoomBedInfo {
    /**
     * 房型id
     */
    @ApiModelProperty(value = "房型id", dataType = "string")
    private Integer roomId;
    /**
     * 床型类型，如"超级大床"、"大床"等（附录给出了一些参考值）。
     */
    @ApiModelProperty(value = "bedType", dataType = "string")
    private String bedType;
    /**
     * 床型描述
     */
    @ApiModelProperty(value = "beddesc", dataType = "string")
    private String bedDesc;
    /**
     * 床型描述
     */
    @ApiModelProperty(value = "bedCount", dataType = "string")
    private String bedCount;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

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

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }
}
