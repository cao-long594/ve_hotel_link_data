package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/11 19:38
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OTA_HotelDescriptiveContentNotifRQ")
public class HotelDescriptiveContentNotifRQ {
    /**
     * 消息版本（最新为 3.4）
     */
    @XmlAttribute(name = "Version")
    private String version;
    /**
     * Production:生产环境
     * Test:测试环境
     */
    @XmlAttribute(name = "Target")
    private String target;
    /**
     * 酒店信息列表
     */
    @XmlElementWrapper(name = "HotelDescriptiveContents")
    @XmlElement(name = "HotelDescriptiveContent")
    private List<HotelDescriptiveContent> hotelDescriptiveContents;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<HotelDescriptiveContent> getHotelDescriptiveContents() {
        return hotelDescriptiveContents;
    }

    public void setHotelDescriptiveContents(List<HotelDescriptiveContent> hotelDescriptiveContents) {
        this.hotelDescriptiveContents = hotelDescriptiveContents;
    }
}
