package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 酒店位置
 * </p>
 * @author wangkai
 * @since 2020/10/23
 */
@XmlRootElement(name = "Location")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongHotelLocation {
    /**
     * id
     */
    @XmlAttribute(name = "Id")
    private String id;
    /**
     * 名称
     */
    @XmlAttribute(name = "Name")
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
