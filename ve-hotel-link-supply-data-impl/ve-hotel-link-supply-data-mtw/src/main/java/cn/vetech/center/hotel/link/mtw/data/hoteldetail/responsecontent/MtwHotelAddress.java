package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:16
 */
public class MtwHotelAddress {
    /**
     *
     * 国家信息
     */
    private MtwHotelCodeName country;
    /**
     * 酒店所在省份，海外酒店返回空
     */
    private MtwHotelCodeName province;
    /**
     *
     * 酒店所在城市
     */
    private MtwHotelCodeName city;
    /**
     *
     * 酒店所在城市行政区名，如“松江区”，海外酒店返回空
     */
    private MtwHotelCodeName area;
    /**
     *
     * 酒店所在的商圈
     */
    private List<MtwHotelCodeName> businessDistricts;
    /**
     * 酒店详细地址
     */
    private MtwHotelCodeName addressLine;
/**
     *
     * 酒店的经纬度信
     */
    private List<MtwHotelAddressCoordinate> coordinates;

    public MtwHotelCodeName getCountry() {
        return country;
    }

    public void setCountry(MtwHotelCodeName country) {
        this.country = country;
    }

    public MtwHotelCodeName getProvince() {
        return province;
    }

    public void setProvince(MtwHotelCodeName province) {
        this.province = province;
    }

    public MtwHotelCodeName getCity() {
        return city;
    }

    public void setCity(MtwHotelCodeName city) {
        this.city = city;
    }

    public MtwHotelCodeName getArea() {
        return area;
    }

    public void setArea(MtwHotelCodeName area) {
        this.area = area;
    }

    public List<MtwHotelCodeName> getBusinessDistricts() {
        return businessDistricts;
    }

    public void setBusinessDistricts(List<MtwHotelCodeName> businessDistricts) {
        this.businessDistricts = businessDistricts;
    }

    public MtwHotelCodeName getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(MtwHotelCodeName addressLine) {
        this.addressLine = addressLine;
    }

    public List<MtwHotelAddressCoordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<MtwHotelAddressCoordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
