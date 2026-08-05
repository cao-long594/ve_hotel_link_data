package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2021/2/5 11:19
 */
public class ElongRoomInfo {

    /**
     * 房型ID
     */
    @JsonProperty("RoomID")
    private String roomID;
    /**
     * 房型中文名称
     */
    @JsonProperty("RoomName")
    private String roomName;
    /**
     * 房型英文名称
     */
    @JsonProperty("RoomNameEn")
    private String roomNameEn;
    /**
     * 房型面积
     */
    @JsonProperty("Area")
    private String area;
    /**
     * 楼层
     */
    @JsonProperty("Floor")
    private String floor;
    /**
     * 上网情况
     */
    @JsonProperty("BroadnetAccess")
    private String broadnetAccess;
    /**
     * 上网费用
     */
    @JsonProperty("BroadnetFee")
    private String broadnetFee;
    /**
     * 床型中文名称
     */
    @JsonProperty("BedType")
    private String bedType;
    /**
     * 床型英文名称
     */
    @JsonProperty("BedTypeEn")
    private String bedTypeEn;
    /**
     * 中文描述
     */
    @JsonProperty("Description")
    private String description;
    /**
     * 英文描述
     */
    @JsonProperty("DescriptionEn")
    private String descriptionEn;
    /**
     * 中文备注
     */
    @JsonProperty("Comments")
    private String comments;
    /**
     * 英文备注
     */
    @JsonProperty("CommentsEn")
    private String commentsEn;
    /**
     * 房间最大入住人数
     */
    @JsonProperty("Capacity")
    private String capacity;
    /**
     * 房型数量
     */
    @JsonProperty("Amount")
    private String amount;
    /**
     * 房间设施列表
     */
    @JsonProperty("Facilities")
    private List<ElongFacilityInfo> facilities;
    /**
     * 窗户类型ID
     */
    @JsonProperty("WindowTypeId")
    private String windowTypeId;
    /**
     * 窗户类型描述
     */
    @JsonProperty("WindosType")
    private String windosType;
 /**
     * 设施
     */
    @JsonProperty("FacilityV2")
    private List<ElongFacilityType> facilityV2;
    /**
     * 新床型信息
     */
    @JsonProperty("RoomBed")
    private ElongRoomBed roomBed;

    public ElongRoomBed getRoomBed() {
        return roomBed;
    }

    public void setRoomBed(ElongRoomBed roomBed) {
        this.roomBed = roomBed;
    }

    public List<ElongFacilityType> getFacilityV2() {
        return facilityV2;
    }

    public void setFacilityV2(List<ElongFacilityType> facilityV2) {
        this.facilityV2 = facilityV2;
    }

    public String getWindowTypeId() {
        return windowTypeId;
    }

    public void setWindowTypeId(String windowTypeId) {
        this.windowTypeId = windowTypeId;
    }

    public String getWindosType() {
        return windosType;
    }

    public void setWindosType(String windosType) {
        this.windosType = windosType;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomNameEn() {
        return roomNameEn;
    }

    public void setRoomNameEn(String roomNameEn) {
        this.roomNameEn = roomNameEn;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBroadnetAccess() {
        return broadnetAccess;
    }

    public void setBroadnetAccess(String broadnetAccess) {
        this.broadnetAccess = broadnetAccess;
    }

    public String getBroadnetFee() {
        return broadnetFee;
    }

 public void setBroadnetFee(String broadnetFee) {
        this.broadnetFee = broadnetFee;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getBedTypeEn() {
        return bedTypeEn;
    }

    public void setBedTypeEn(String bedTypeEn) {
        this.bedTypeEn = bedTypeEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsEn() {
        return commentsEn;
    }

    public void setCommentsEn(String commentsEn) {
        this.commentsEn = commentsEn;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<ElongFacilityInfo> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<ElongFacilityInfo> facilities) {
        this.facilities = facilities;
    }
}

