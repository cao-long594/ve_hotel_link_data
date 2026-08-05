package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:48
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FacilityInfo {
    /**
     * 房型列表
     */
    @XmlElementWrapper(name = "GuestRooms")
    @XmlElement(name = "GuestRoom")
    private List<GuestRoom> guestRooms;

    public List<GuestRoom> getGuestRooms() {
        return guestRooms;
    }

    public void setGuestRooms(List<GuestRoom> guestRooms) {
        this.guestRooms = guestRooms;
    }
}
