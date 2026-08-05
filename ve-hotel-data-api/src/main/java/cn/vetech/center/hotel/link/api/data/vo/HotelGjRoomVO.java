package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author xiaotengyu
 * @since 2022-12-15 14:01
 */
public class HotelGjRoomVO {

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
     * 特别提示英文
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
     * 窗户类型
     */
    private String windowType;
    /**
     * 窗户描述
     */
    private String windowDesc;

    public String getWindowType() {
        return windowType;
    }

    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

    public Stri