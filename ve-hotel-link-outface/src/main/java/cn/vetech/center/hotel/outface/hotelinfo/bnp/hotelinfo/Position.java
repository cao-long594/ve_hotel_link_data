package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 10:37
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {
    /**
     * 维度
     */
    @XmlAttribute(name = "Latitude")
    private String latitude;
    /**
     * 经度
     */
    @XmlAttribute(name = "Longitude")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
