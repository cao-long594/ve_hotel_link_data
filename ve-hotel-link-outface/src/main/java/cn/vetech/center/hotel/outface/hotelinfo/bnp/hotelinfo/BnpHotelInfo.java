package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 9:33
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BnpHotelInfo {
    /**
     * 建造时间
     */
    @XmlAttribute(name = "WhenBuilt")
    private String whenBuilt;
    /**
     * 开业时间
     */
    @XmlAttribute(name = "Start")
    private String start;
    /**
     * 状态编码 Open 开业 (但没有此字段数据,暂不判断)
     */
    @XmlElement(name = "HotelStatusCode")
    private String hotelStatusCode;
    /**
     * 酒店名称
     */
    @XmlElement(name = "HotelName")
    private String hotelName;
    /**
     * 酒店简称
     */
    @XmlElement(name = "HotelShortName")
    private String hotelShortName;
    /**
     * 酒店坐标 谷歌的WGS84
     */
    @XmlElement(name = "Position")
    private Position position;
    /**
     * 酒店服务设施
     */
    @XmlElementWrapper(name = "Services")
    @XmlElement(name = "Service")
    private List<Service> services;

    public String getWhenBuilt() {
        return whenBuilt;
    }

    public void setWhenBuilt(String whenBuilt) {
        this.whenBuilt = whenBuilt;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getHotelStatusCode() {
        return hotelStatusCode;
    }

    public void setHotelStatusCode(String hotelStatusCode) {
        this.hotelStatusCode = hotelStatusCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelShortName() {
        return hotelShortName;
    }

    public void setHotelShortName(String hotelShortName) {
        this.hotelShortName = hotelShortName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
