package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/16 10:33
 * @comment
 */
public class EtlCoordinate {
    /**
     * 提供者
     * Unknown
     * Baidu
     */
    private String provider;
    /**
     * 经度
     */
    private String lng;
    /**
     * 维度
     */
    private String lat;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
