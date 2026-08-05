package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author xiaotengyu
 * @since 2022-12-20 16:00
 */
public class EtlRoomMerge {

    /**
     * id
     */
    private String id;

    /**
     * 酒店id
     */
    private String hotelId;
    /**
     * 房源房型ID
     */
    private String roomId;
    /**
     * 房型名称
     */
    private String roomName;

    /**
     * 房型英文名称
     */
    private String roomEname;

    /**
     * 床型
     */
    private String bedType;
    /**
     * 楼层
     */
    private String floor;
    /**
     * 面积
     */
    private String acreage;
    /**
     * 房间数量
     */
    private String roomNumber;
    /**
     * 推荐入住人数
     */
    private String recommendOccupancy;
    /**
     * 房间描述
     */
    private String roomDesc;
    /**
     * 房型英文描述
     */
    private String roomEdesc;
    /**
     * 房型设施
     */
    private String roomFacility;
    /**
     * 特别提示
     */
    private String specialReminder;
    /**
     * 房型因为特别提示
     */
    private String specialEreminder;
    /**
     * 图片
     */
    private String pic;
    /**
     * 同步cps状态
     */
    private String syncCpsStatus;
    /**
     * 同步cps错误信息
     */
    private String syncCpsMsg;
    /**
     * 同步时间
     */
    private String syncDatetime;
    /**
     * 是否被修改：0.否 1.是
     */
    private String modifyFlag;
    /**
     * 床数
     */
    private String bedNumber;
    /**
     * 数据md5值
     */
    private String md5;
    /**
     * 创建时间
     */
    private String cjDatetime;
    /**
     * 修改时间
     */
    private String xgDatetime;

    /**
     * 允许加床 1:可加床 0:不可加床
     */
    private String  extraBed;

    /**
     * json 数据
     */
    private String jsonData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

 public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomEname() {
        return roomEname;
    }

    public void setRoomEname(String roomEname) {
        this.roomEname = roomEname;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRecommendOccupancy() {
        return recommendOccupancy;
    }

    public void setRecommendOccupancy(String recommendOccupancy) {
        this.recommendOccupancy = recommendOccupancy;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomEdesc() {
        return roomEdesc;
    }

    public void setRoomEdesc(String roomEdesc) {
        this.roomEdesc = roomEdesc;
    }

    public String getRoomFacility() {
        return roomFacility;
    }

    public void setRoomFacility(String roomFacility) {
        this.roomFacility = roomFacility;
    }

    public String getSpecialReminder() {
           return specialReminder;
    }

    public void setSpecialReminder(String specialReminder) {
        this.specialReminder = specialReminder;
    }

    public String getSpecialEreminder() {
        return specialEreminder;
    }

    public void setSpecialEreminder(String specialEreminder) {
        this.specialEreminder = specialEreminder;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSyncCpsStatus() {
        return syncCpsStatus;
    }

    public void setSyncCpsStatus(String syncCpsStatus) {
        this.syncCpsStatus = syncCpsStatus;
    }

    public String getSyncCpsMsg() {
        return syncCpsMsg;
    }

    public void setSyncCpsMsg(String syncCpsMsg) {
        this.syncCpsMsg = syncCpsMsg;
    }

    public String getSyncDatetime() {
        return syncDatetime;
    }

    public void setSyncDatetime(String syncDatetime) {
        this.syncDatetime = syncDatetime;
    }

    public String getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getCjDatetime() {
        return cjDatetime;
    }

    public void setCjDatetime(String cjDatetime) {
        this.cjDatetime = cjDatetime;
    }

    public String getXgDatetime() {
        return xgDatetime;
    }

    public void setXgDatetime(String xgDatetime) {
        this.xgDatetime = xgDatetime;
    }

    public String getExtraBed() {
        return extraBed;
    }

   public void setExtraBed(String extraBed) {
        this.extraBed = extraBed;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

}
