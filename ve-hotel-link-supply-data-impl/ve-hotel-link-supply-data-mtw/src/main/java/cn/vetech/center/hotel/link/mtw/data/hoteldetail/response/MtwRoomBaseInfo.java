package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwRoomBaseInfo {
    private static final long serialVersionUID = 1L;
    /**
     * 房型id
     */
    @ApiModelProperty(value = "房型id", dataType = "string")
    private Integer roomId;
    /**
     * 酒店id。
     */
    @ApiModelProperty(value = "酒店id。", dataType = "string")
    private Long hotelId;
    /**
     * 房型类型0 大床间（单间）1 单人间（单间）2 双床间（单间）3 三人间（单间）4 套房5 独栋6 床位房
     */
    @ApiModelProperty(value = "房型类型0 大床间（单间）1 单人间（单间）2 双床间（单间）3 三人间（单间）4 套房5 独栋6 床位房", dataType = "string")
    private Integer roomType;
    /**
     * 房型名称。
     */
    @ApiModelProperty(value = "房型名称。", dataType = "string")
    private String roomName;
    /**
     * 房间特色描述文案，多个文案间以半角逗号分隔，如"刘德华住过的房间,隔音效果佳"
     */
    @ApiModelProperty(value = "房间特色描述文案，多个文案间以半角逗号分隔，如刘德华住过的房间, 隔音效果佳", dataType = "string")
    private String roomDesc;
    /**
     * 房间可用面积
     */
    @ApiModelProperty(value = "房间可用面积", dataType = "string")
    private String useableArea;
    /**
     * 房间最大容纳人数。
     */
    @ApiModelProperty(value = "房间最大容纳人数。", dataType = "string")
    private String capacity;
     /**
     * 房间窗户情况：0 有窗1 部分有窗2 无窗
     */
    @ApiModelProperty(value = "房间窗户情况：0 有窗1 部分有窗2 无窗", dataType = "string")
    private Integer window;
    /**
     * 窗景描述。
     */
    @ApiModelProperty(value = "窗景描述。", dataType = "string")
    private String windowView;
    /**
     * 窗户不利因素：0 朝向走廊1 装饰性假窗2 天窗3 窗户较小4 窗外是墙体
     */
    @ApiModelProperty(value = "窗户不利因素：0 朝向走廊1 装饰性假窗2 天窗3 窗户较小4 窗外是墙体", dataType = "string")
    private String windowBad;
    /**
     * 加床情况：0 不可加床1 可以加床
     */
    @ApiModelProperty(value = "加床情况：0 不可加床1 可以加床", dataType = "string")
    private Integer extraBed;
    /**
     * 房间所在楼层，如"2"、"2-3"
     */
    @ApiModelProperty(value = "房间所在楼层，如2、2-3", dataType = "string")
    private String floor;
    /**
     * 房间上网方式：0 无法上网1 无线wifi2 有线宽带3 无线wifi和有线宽带
     */
    @ApiModelProperty(value = "房间上网方式：0 无法上网1 无线wifi2 有线宽带3 无线wifi和有线宽带", dataType = "string")
    private Integer internetWay;
    /**
     * 平日参考价，单位为分。
     */
    @ApiModelProperty(value = "平日参考价，单位为分。", dataType = "bigdecimal")
    private Integer weekdayPrice;
    /**
     * 周末参考价，单位为分。
     */
    @ApiModelProperty(value = "周末参考价，单位为分。", dataType = "bigdecimal")
    private Integer weekendPrice;
    /**
     * 房型状态：0 无效1 有效
     */
    @ApiModelProperty(value = "房型状态：0 无效1 有效", dataType = "string")
    private Integer status;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
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

    public Integer getWindow() {
        return window;
    }

    public void setWindow(Integer window) {
        this.window = window;
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

    public Integer getWeekdayPrice() {
        return weekdayPrice;
    }

    public void setWeekdayPrice(Integer weekdayPrice) {
        this.weekdayPrice = weekdayPrice;
    }

    public Integer getWeekendPrice() {
        return weekendPrice;
    }

    public void setWeekendPrice(Integer weekendPrice) {
        this.weekendPrice = weekendPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
