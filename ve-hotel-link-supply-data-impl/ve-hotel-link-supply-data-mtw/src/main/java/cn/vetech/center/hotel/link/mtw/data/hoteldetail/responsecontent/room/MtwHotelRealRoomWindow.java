package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:55
 */
public class MtwHotelRealRoomWindow {

    /**
     *房间窗户情况：
     * 0：有窗；
     * 1：部分有窗；
     * 2：无窗；
     */
    private Integer hasWindow;
    /**
     * 窗景描述
     */
    private String description;
    /**
     * 窗户不利因素，可能有多个，多个不利因素以逗号分隔：
     * 0：朝向走廊；
     * 1：装饰性假窗；
     * 2：天窗；
     * 3：窗户较小；
     * 4：窗外是墙体；
     */
    private String disadvantage;

    public Integer getHasWindow() {
        return hasWindow;
    }

    public void setHasWindow(Integer hasWindow) {
        this.hasWindow = hasWindow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage;
    }
}