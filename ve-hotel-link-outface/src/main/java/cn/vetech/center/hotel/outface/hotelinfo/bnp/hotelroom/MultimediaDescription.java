package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 19:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MultimediaDescription {
    /**
     * 床型名称
     */
    @XmlElementWrapper(name = "TextItems")
    @XmlElement(name = "TextItem")
    private List<TextItem> textItems;

    public List<TextItem> getTextItems() {
        return textItems;
    }

    public void setTextItems(List<TextItem> textItems) {
        this.textItems = textItems;
    }
}
