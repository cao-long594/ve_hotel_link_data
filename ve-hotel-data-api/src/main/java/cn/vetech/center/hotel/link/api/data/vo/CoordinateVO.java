package cn.vetech.center.hotel.link.api.data.vo;

/**
 * 坐标类
 * @author pengyefei
 * @version 1.0
 * @since 2022/10/27 16:00
 */
public class CoordinateVO {
    /**
     * 百度经度
     */
    private String baiduLongitude;
    /**
     * 百度经度
     */
    private String baiduLatitude;
    /**
     * 谷歌经度
     */
    private String googleLongitude;
    /**
     * 谷歌纬度
     */
    private String googleLatitude;

    public String getBaiduLongitude() {
        return baiduLongitude;
    }

    public void setBaiduLongitude(String baiduLongitude) {
        this.baiduLongitude = baiduLongitude;
    }

    public String getBaiduLatitude() {
        return baiduLatitude;
    }

    public void setBaiduLatitude(String baiduLatitude) {
        this.baiduLatitude = baiduLatitude;
    }

    public String getGoogleLongitude() {
        return googleLongitude;
    }

    public void setGoogleLongitude(String googleLongitude) {
        this.googleLongitude = googleLongitude;
    }

    public String getGoogleLatitude() {
        return googleLatitude;
    }

    public void setGoogleLatitude(String googleLatitude) {
        this.googleLatitude = googleLatitude;
    }
}
