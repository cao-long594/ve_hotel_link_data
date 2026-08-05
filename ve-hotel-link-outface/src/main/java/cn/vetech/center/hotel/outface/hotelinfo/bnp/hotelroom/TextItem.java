package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 19:13
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TextItem {
    /**
     * 床型名称
     */
    @XmlElement(name = "Description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
