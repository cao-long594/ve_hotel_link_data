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
 * @since 2023/10/12 9:22
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HotelDescriptiveContent {
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
     * 酒店名称
     */
    @XmlAttribute(name = "HotelName")
    private String hotelName;
    /**
     * 品牌代码
     */
    @XmlAttribute(name = "BrandCode")
    private String brandCode;
    /**
     * 品牌名称
     */
    @XmlAttribute(name = "BrandName")
    private String brandName;
    /**
     * 静态消息的语言
     * zh-CN：中文
     * en-US：英文
     */
    @XmlAttribute(name = "LanguageCode")
    private String languageCode;
    /**
     * 酒店详情
     */
    @XmlElement(name = "HotelInfo")
    private BnpHotelInfo bnpHotelInfo;
    /**
     * 图片
     */
    @XmlElementWrapper(name = "MultimediaDescriptions")
    @XmlElement(name = "MultimediaDescription")
    private List<ImageMultimediaDescription> imageMultimediaDescriptions;
    /**
     * 联系信息
     */
    @XmlElementWrapper(name = "ContactInfos")
    @XmlElement(name = "ContactInfo")
    private List<ContactInfo> contactInfos;

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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public BnpHotelInfo getBnpHotelInfo() {
        return bnpHotelInfo;
    }

    public void setBnpHotelInfo(BnpHotelInfo bnpHotelInfo) {
        this.bnpHotelInfo = bnpHotelInfo;
    }

    public List<ImageMultimediaDescription> getImageMultimediaDescriptions() {
        return imageMultimediaDescriptions;
    }

    public void setImageMultimediaDescriptions(List<ImageMultimediaDescription> imageMultimediaDescriptions) {
        this.imageMultimediaDescriptions = imageMultimediaDescriptions;
    }

    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }
}
