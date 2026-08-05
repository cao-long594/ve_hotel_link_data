package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:14
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageMultimediaDescription {
    /**
     * 图片列表
     */
    @XmlElementWrapper(name = "ImageItems")
    @XmlElement(name = "ImageItem")
    private List<ImageItem> imageItems;

    public List<ImageItem> getImageItems() {
        return imageItems;
    }

    public void setImageItems(List<ImageItem> imageItems) {
        this.imageItems = imageItems;
    }
}
