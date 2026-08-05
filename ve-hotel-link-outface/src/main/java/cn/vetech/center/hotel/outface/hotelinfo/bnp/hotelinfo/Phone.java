package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:27
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
    /**
     * 号码
     */
    @XmlAttribute(name = "PhoneNumber")
    private String phoneNumber;
    /**
     * 3 Fax(传真)  5 Mobile(手机)
     */
    @XmlAttribute(name = "PhoneTechType")
    private String phoneTechType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneTechType() {
        return phoneTechType;
    }

    public void setPhoneTechType(String phoneTechType) {
        this.phoneTechType = phoneTechType;
    }
}
