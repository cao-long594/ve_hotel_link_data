package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:58
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Feature {
    /**
     * 目前固定值为 BED，表示客房中床的特性
     */
    @XmlAttribute(name = "CodeDetail")
    private String codeDetail;
    /**
     * 尺寸单位
     */
    @XmlAttribute(name = "UnitOfMeasure")
    private String unitOfMeasure;
    /**
     * 尺寸值
     */
    @XmlAttribute(name = "UnitOfMeasureQuantity")
    private String unitOfMeasureQuantity;
    /**
     * 特性列表
     */
    @XmlElementWrapper(name = "MultimediaDescriptions")
    @XmlElement(name = "MultimediaDescription")
    private List<MultimediaDescription> multimediaDescriptions;

    public String getCodeDetail() {
        return codeDetail;
    }

    public void setCodeDetail(String codeDetail) {
        this.codeDetail = codeDetail;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getUnitOfMeasureQuantity() {
        return unitOfMeasureQuantity;
    }

    public void setUnitOfMeasureQuantity(String unitOfMeasureQuantity) {
        this.unitOfMeasureQuantity = unitOfMeasureQuantity;
    }

    public List<MultimediaDescription> getMultimediaDescriptions() {
        return multimediaDescriptions;
    }

    public void setMultimediaDescriptions(List<MultimediaDescription> multimediaDescriptions) {
        this.multimediaDescriptions = multimediaDescriptions;
    }
}