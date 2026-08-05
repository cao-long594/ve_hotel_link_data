package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author xiaotengyu
 * @since 2023-09-02 15:02
 */
public class HotelGjInfoDetailVO {

    /**
     * 酒店ID
     */
    private String hotelId;

    /**
     * 基础设施列表
     */
    private String jcsslb;

    /**
     * 服务设施列表
     */
    private String fwsslb;

    /**
     * 房型设施列表
     */
    private String fxsslb;

    /**
     * 休闲设施列表
     */
    private String xxsslb;

    /**
     * 扩展信息  HotelGjExtTextInfo对象json格式字符串
     */
    private String extText;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getJcsslb() {
        return jcsslb;
    }

    public void setJcsslb(String jcsslb) {
        this.jcsslb = jcsslb;
    }

    public String getFwsslb() {
        return fwsslb;
    }

    public void setFwsslb(String fwsslb) {
        this.fwsslb = fwsslb;
    }

    public String getFxsslb() {
        return fxsslb;
    }

    public void setFxsslb(String fxsslb) {
        this.fxsslb = fxsslb;
    }

    public String getXxsslb() {
        return xxsslb;
    }

    public void setXxsslb(String xxsslb) {
        this.xxsslb = xxsslb;
    }

    public String getExtText() {
        return extText;
    }

    public void setExtText(String extText) {
        this.extText = extText;
    }
}
