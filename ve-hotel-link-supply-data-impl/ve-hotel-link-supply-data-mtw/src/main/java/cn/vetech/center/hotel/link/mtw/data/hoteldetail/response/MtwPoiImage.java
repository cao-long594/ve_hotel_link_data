package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwPoiImage {

    /**
     * typeid=9时非空，标示本图片对应的房型id
     */
    @ApiModelProperty(value = "typeid=9时非空，标示本图片对应的房型id", dataType = "string")
    private Integer roomId;
    /**
     * 图片url地址
     */
    @ApiModelProperty(value = "图片url地址", dataType = "string")
    private String url;
    /**
     * 图片描述
     */
    @ApiModelProperty(value = "图片描述", dataType = "string")
    private String imgDesc;
    /**
     * 图片类型1:环境，9：客房，19：配套设施，32：大厅，34：外观，10：其他
     */
    @ApiModelProperty(value = "图片类型1:环境，9：客房，19：配套设施，32：大厅，34：外观，10：其他", dataType = "string")
    private String typeId;
    /**
     * 图片类型名称，如"客房"、"外观"、"公共设施"、"大厅"、"其他"等
     */
    @ApiModelProperty(value = "图片类型名称，如客房、外观、公共设施、大厅、其他等", dataType = "string")
    private String typeName;
/**
     * isFront
     */
    private Integer isFront;

    public Integer getIsFront() {
        return isFront;
    }

    public void setIsFront(Integer isFront) {
        this.isFront = isFront;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
