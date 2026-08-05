package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:22
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    /**
     * 地址
     */
    @XmlElement(name = "AddressLine")
    private String addressLine;
    /**
     * 城市名称
     */
    @XmlElement(name = "CityName")
    private String cityName;
    /**
     * 邮编
     */
    @XmlElement(name = "PostalCode")
    private String postalCode;
    /**
     * 国家名称
     */
    @XmlElement(name = "CountryName")
    private String countryName;

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
