package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:47
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomDescriptiveContent {
    /**
     * 集团代码
     */
    @XmlAttribute(name = "ChainCode")
    private String chainCode;
    /**
     * 酒店代码
     */
    @XmlAttribute(name = "HotelCode")
    private String hotelCode;
    /**
     * 静态消息的语言
     * zh-CN：中文
     * en-US：英文
     */
    @XmlAttribute(name = "LanguageCode")
    private String languageCode;
    /**
     * 设施信息
     */
    @XmlElement(name = "FacilityInfo")
    private FacilityInfo facilityInfo;

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public FacilityInfo getFacilityInfo() {
        return facilityInfo;
    }

    public void setFacilityInfo(FacilityInfo facilityInfo) {
        this.facilityInfo = facilityInfo;
    }
}
