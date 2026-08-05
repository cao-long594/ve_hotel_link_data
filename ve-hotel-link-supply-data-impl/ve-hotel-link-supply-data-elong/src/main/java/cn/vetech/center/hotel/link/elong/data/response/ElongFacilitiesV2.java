package cn.vetech.center.hotel.link.elong.data.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author gaojinn
 */
@XmlRootElement(name = "FacilitiesV2")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongFacilitiesV2 implements Serializable {
    /**
     * 酒店基础设施
     */
    @XmlElement(name = "GeneralAmenities")
    private String generalamenities;
    /**
     * 酒店休闲设施
     */
    @XmlElement(name = "RecreationAmenities")
    private String recreationamenities;
    /**
     * 酒店服务设施
     */
    @XmlElement(name = "ServiceAmenities")
    private String serviceamenities;

    public String getGeneralamenities() {
        return generalamenities;
    }

    public void setGeneralamenities(String generalamenities) {
        this.generalamenities = generalamenities;
    }

    public String getRecreationamenities() {
        return recreationamenities;
    }

    public void setRecreationamenities(String recreationamenities) {
        this.recreationamenities = recreationamenities;
    }

    public String getServiceamenities() {
        return serviceamenities;
    }

    public void setServiceamenities(String serviceamenities) {
        this.serviceamenities = serviceamenities;
    }
}
