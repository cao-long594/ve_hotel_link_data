package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom;

/**
 * @author xiaotengyu
 * @since 2021/7/28 11:45
 */
public class MtwRealRoomBaseInfo {

    /**
     * 物理房型ID。
     */
    private String realRoomId;
    /**
     * 房型类型废弃。床型信息请从roomBedInfoList来获取
     */
    private String roomType;
    /**
     * 逻辑房型名称, 可能为空。
     */
    private String roomName;
    /**
     * 房间描述。
     */
    private String roomDesc;
    /**
     * 房间可用面积。
     */
    private String useableArea;
    /**
     * 房间最大容纳人数。
     */
    private String capacity;
    /**
     * 房间窗户情况：
     * 0 有窗
     * 1 部分有窗
     * 2 无窗
     */
    private Integer window;

    /**
     * 	窗景描述。
     */
    private String windowView;
    /**
     * 	窗户不利因素：
     *  0 朝向走廊
     * 1 装饰性假窗
     * 2 天窗
     * 3 窗户较小
     * 4 窗外是墙体
     */
    private String windowBad;

    /**
     * 	加床情况：
     * 0 不可加床
     * 1 可以加床
     */
    private Integer extraBed;

    /**
     * 房间所在楼层，如"2"、"2-3"
     */
    private String floor;
    /**
     * 房间上网方式：
     * 0 无法上网
     * 1 无线WIFI
     * 2 有线宽带
     * 3 无线WIFI和有线宽带
     * 4 免费无线WIFI
     * 5 房间内高速上网
     */
    private Integer internetWay;
    /**
     * 房型状态：
     * 0 无效
     * 1 有效
     */
    private String status;

    /**
     * 房间最大容纳儿童人数(限5岁及以下儿童入住)。
     */
    private String childCapacity;

    public String getRealRoomId() {
        return realRoomId;
    }

    public void setRealRoomId(String realRoomId) {
        this.realRoomId = realRoomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }
     public String getUseableArea() {
        return useableArea;
    }

    public void setUseableArea(String useableArea) {
        this.useableArea = useableArea;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getWindowView() {
        return windowView;
    }

    public void setWindowView(String windowView) {
        this.windowView = windowView;
    }

    public String getWindowBad() {
        return windowBad;
    }

    public void setWindowBad(String windowBad) {
        this.windowBad = windowBad;
    }

    public Integer getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Integer extraBed) {
        this.extraBed = extraBed;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getInternetWay() {
        return internetWay;
    }

    public void setInternetWay(Integer internetWay) {
        this.internetWay = internetWay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChildCapacity() {
        return childCapacity;
    }

    public void setChildCapacity(String childCapacity) {
        this.childCapacity = childCapacity;
    }

    public Integer getWindow() {
        return window;
    }

    public void setWindow(Integer window) {
        this.window = window;
    }
}
