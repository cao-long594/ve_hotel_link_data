package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <p>
 * 酒店GEO
 * </p>
 * @author wangkai
 * @since 2020/10/23
 */
@XmlRootElement(name = "HotelGeo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongHotelGeo {
    /**
     * 国家
     */
    @XmlAttribute(name = "Country")
    private String country;
    /**
     *省份名称
     */
    @XmlAttribute(name = "ProvinceName")
    private String provinceName;
    /**
     *省份ID
     */
    @XmlAttribute(name = "ProvinceId")
    private String provinceId;
    /**
     *城市名称
     */
    @XmlAttribute(name = "CityName")
    private String cityName;
    /**
     *城市编码
     */
    @XmlAttribute(name = "CityCode")
    private String cityCode;

    /**
     * 行政区
     */
    @XmlElementWrapper(name = "Districts")
    @XmlElement(name = "Location")
    private List<ElongHotelLocation> districts;

    /**
     * 商业区
     */
    @XmlElementWrapper(name = "CommericalLocations")
    @XmlElement(name = "Location")
    private List<ElongHotelLocation> commericalLocations;
    /**
     * 周边建筑
     */
    @XmlElementWrapper(name = "LandmarkLocations")
    @XmlElement(name = "Location")
    private List<ElongHotelLocation> landmarkLocations;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceId() {
        return provinceId;
    }
    
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public List<ElongHotelLocation> getDistricts() {
        return districts;
    }

    public void setDistricts(List<ElongHotelLocation> districts) {
        this.districts = districts;
    }

    public List<ElongHotelLocation> getCommericalLocations() {
        return commericalLocations;
    }

    public void setCommericalLocations(List<ElongHotelLocation> commericalLocations) {
        this.commericalLocations = commericalLocations;
    }

    public List<ElongHotelLocation> getLandmarkLocations() {
        return landmarkLocations;
    }

    public void setLandmarkLocations(List<ElongHotelLocation> landmarkLocations) {
        this.landmarkLocations = landmarkLocations;
    }
}
