package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:50
 */
public class MtwHotelRealRoomBaseInfo {

    /**
     *物理房型ID
     */
    private String realRoomId;
    /**
     *酒店ID
     */
    private String hotelId;
    /**
     *房型名称
     */
    private String name;
    /**
     * 房型英文名称
     */
    private String nameEn;
    /**
     *
     * 房间可用面积
     */
    private String useAbleArea;
    /**
     *
     * 房间所在楼层
     */
    private String floor;
    /**
     *
     * 房型状态：
     * 0：无效；
     * 1：有效；
     */
    private String status;
     /**
     * 加床情况：
     * false：不可加床；
     * true：可以加床；
     */
    private Boolean allowExtraBed;
    /**
     * 上网方式：
     * 0：无法上网；
     * 1：无线WIFI；
     * 2：有线宽带；
     * 3：无线WIFI和有线宽带；
     * 4：免费无线WIFI；
     * 5：房间内高速上网；
     */
    private Integer internetAccess;

    /**
     *
     * 房间描述信息
     */
    private MtwHotelRealRoomDescription descriptions;

    /**
     *
     * 房间容纳人数
     */
    private MtwHotelRealRoomOccupancy occupancy;

    /**
     *
     * 窗户信息
     */
    private MtwHotelRealRoomWindow window;

    /**
     *
     * 床型基本信息。外层数组的元素之间是"或"关系，内层数组的元素之间是"且"关系
     */
      private List<List<MtwHotelRealRoomBedInfo>> bedGroups;

    public String getRealRoomId() {
        return realRoomId;
    }

    public void setRealRoomId(String realRoomId) {
        this.realRoomId = realRoomId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getUseAbleArea() {
        return useAbleArea;
    }

    public void setUseAbleArea(String useAbleArea) {
        this.useAbleArea = useAbleArea;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
public Boolean getAllowExtraBed() {
        return allowExtraBed;
    }

    public void setAllowExtraBed(Boolean allowExtraBed) {
        this.allowExtraBed = allowExtraBed;
    }

    public Integer getInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(Integer internetAccess) {
        this.internetAccess = internetAccess;
    }

    public MtwHotelRealRoomDescription getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(MtwHotelRealRoomDescription descriptions) {
        this.descriptions = descriptions;
    }

    public MtwHotelRealRoomOccupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(MtwHotelRealRoomOccupancy occupancy) {
        this.occupancy = occupancy;
    }

    public MtwHotelRealRoomWindow getWindow() {
        return window;
    }

    public void setWindow(MtwHotelRealRoomWindow window) {
        this.window = window;
    }

    public List<List<MtwHotelRealRoomBedInfo>> getBedGroups() {
        return bedGroups;
    }

    public void setBedGroups(List<List<MtwHotelRealRoomBedInfo>> bedGroups) {
        this.bedGroups = bedGroups;
    }
}
