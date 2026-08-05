package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:22
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo {
    /**
     * 地址信息
     */
    @XmlElementWrapper(name = "Addresses")
    @XmlElement(name = "Address")
    private List<Address> addresses;

    /**
     * 电话信息
     */
    @XmlElementWrapper(name = "Phones")
    @XmlElement(name = "Phone")
    private List<Phone> phones;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
