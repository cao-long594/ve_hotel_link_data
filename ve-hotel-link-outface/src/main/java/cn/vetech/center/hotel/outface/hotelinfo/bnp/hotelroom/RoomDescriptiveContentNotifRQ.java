package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

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
 * @since 2023/10/12 17:46
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OTA_HotelDescriptiveContentNotifRQ")
public class RoomDescriptiveContentNotifRQ {
    /**
     * 消息版本（最新为 3.4）
     */
    @XmlAttribute(name = "Version")
    private String version;
    /**
     * 内容列表
     */
    @XmlElementWrapper(name = "HotelDescriptiveContents")
    @XmlElement(name = "HotelDescriptiveContent")
    private List<RoomDescriptiveContent> roomDescriptiveContents;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<RoomDescriptiveContent> getRoomDescriptiveContents() {
        return roomDescriptiveContents;
    }

    public void setRoomDescriptiveContents(List<RoomDescriptiveContent> roomDescriptiveContents) {
        this.roomDescriptiveContents = roomDescriptiveContents;
    }
}
