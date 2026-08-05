package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:26
 */
public class MtwHotelAddressCoordinate {

    /**
     *
     * 坐标类型：
     * "GAODE" ：高德
     * "BAIDU"：百度
     * "MAPBAR"：图吧
     * "GOOGLE"：谷歌
     */
    private String provider;

    /**
     *
     * 酒店位置经度(经度*10的6次方)
     */
    private String longitude;

    /**
     * 酒店位置纬度(纬度*10的6次方)
     */
    private String latitude;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
