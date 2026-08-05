package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:55
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TypeRoom {
    /**
     * 房间面积
     */
    @XmlAttribute(name = "SizeMeasurement")
    private String sizeMeasurement;
    /**
     * 所在楼层
     */
    @XmlAttribute(name = "Floor")
    private String floor;

    public String getSizeMeasurement() {
        return sizeMeasurement;
    }

    public void setSizeMeasurement(String sizeMeasurement) {
        this.sizeMeasurement = sizeMeasurement;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
