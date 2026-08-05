package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:16
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageFormat {
    /**
     * 图片地址
     */
    @XmlElement(name = "URL")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
