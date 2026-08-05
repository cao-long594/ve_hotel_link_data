package cn.vetech.center.hotel.link.elong.data.response.staticcity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/5 9:33
 */
public class ElongCityInfo {

    /**
     * 城市ID
     */
    @JsonProperty("CityId")
    private String cityID;
    /**
     * 城市中文名称
     */
    @JsonProperty("CityName")
    private String cityName;
    /**
     * 城市英文名称
     */
    @JsonProperty("CityNameEn")
    private String cityNameEn;
    /**
     * 城市维度
     */
    @JsonProperty("CityLatitude")
    private String cityLatitude;
    /**
     * 城市经度
     */
    @JsonProperty("CityLongitude")
    private String cityLongitude;
    /**
     * 省份ID
     */
    @JsonProperty("ProvinceID")
    private String provinceID;
    /**
     * 省份中文名称
     */
    @JsonProperty("ProvinceName")
    private String provinceName;
    /**
     * 省份英文名称
     */
    @JsonProperty("ProvinceNameEn")
    private String provinceNameEn;
    /**
     * 国家ID
     */
    @JsonProperty("CountryID")
    private String countryID;
     /**
     * 国家编码
     */
    @JsonProperty("CountryCode")
    private String countryCode;
    /**
     * 国家中文名称
     */
    @JsonProperty("CountryName")
    private String countryName;
    /**
     * 国家英文名称
     */
    @JsonProperty("CountryNameEn")
    private String countryNameEn;
    /**
     * Location数据，包含行政区、商圈、标示物
     */
    @JsonProperty("Locations")
    private List<ElongStaticLocation> locations;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public String getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(String cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    public String getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(String cityLongitude) {
        this.cityLongitude = cityLongitude;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceNameEn() {
        return provinceNameEn;
    }

    public void setProvinceNameEn(String provinceNameEn) {
        this.provinceNameEn = provinceNameEn;
    }

    public String getCountryID() {
        return countryID;
    }

   public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public List<ElongStaticLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ElongStaticLocation> locations) {
        this.locations = locations;
    }
}
