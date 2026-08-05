package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:15
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageItem {
    /**
     * 图片
     */
    @XmlElement(name = "ImageFormat")
    private ImageFormat imageFormat;

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }
}
