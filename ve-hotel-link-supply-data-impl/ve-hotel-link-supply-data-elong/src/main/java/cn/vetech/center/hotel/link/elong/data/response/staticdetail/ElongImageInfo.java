package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:19
 */
public class ElongImageInfo {

    /**
     * 关联的房型ID
     */
    @JsonProperty("RoomID")
    private String roomID;
    /**
     * 图片类型
     * 1 - 餐厅 (Restaurant)
     * 2 - 休闲 (Recreation Facilities)
     * 3 - 会议室 (Meeting/Conference)
     * 5 - 外观 (Exterior)
     * 6 - 大堂/接待台   (Lobby/ Reception)
     * 8 - 客房 (Guest Room)
     * 10 - 其他 (Other Facilities)
     * 11 - 公共区域 (Public Area)
     * 12 - 周边景点 (Nearby Attractions)
     */
    @JsonProperty("Type")
    private String type;
    /**
     * 图片类型中文名
     */
    @JsonProperty("TypeName")
    private String typeName;
    /**
     * 图片类型英文名
     */
    @JsonProperty("TypeNameEn")
    private String typeNameEn;
    /**
     * 图片来源
     */
    @JsonProperty("AuthorType")
    private String authorType;
    /**
     * 是否是主图
     */
    @JsonProperty("IsCoverImage")
    private String isCoverImage;
    /**
     * 是否为房间主图
     */
    @JsonProperty("IsRoomCoverImage")
    private String isRoomCoverImage;
    /**
     * 图片地址列表
     */
    @JsonProperty("Locations")
    private List<ElongLocationInfo> locations;

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeNameEn() {
        return typeNameEn;
    }

    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
    }

    public String getAuthorType