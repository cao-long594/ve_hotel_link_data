package cn.vetech.center.hotel.outface.hotelinfo.bnp.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/12/18 15:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OTA_HotelDescriptiveContentNotifRS")
public class HotelDescriptiveContentNotifRS {
    @XmlAttribute(name = "Version")
    private String version = "1.0";
    @XmlAttribute(name = "xmlns")
    private String xmlns="http://www.opentravel.org/OTA/2003/05";
    @XmlAttribute(name = "xmlns:xsi")
    private String xmlnSxsi="http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "xsi:schemaLocation")
    private String xsiSchemaLocation="http://www.opentravel.org/OTA/2003/05";
    @XmlElement(name = "Success")
    private NotifRSSuccess success;

    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getXmlnSxsi() {
        return xmlnSxsi;
    }

    public void setXmlnSxsi(String xmlnSxsi) {
        this.xmlnSxsi = xmlnSxsi;
    }

    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }

    public void setXsiSchemaLocation(String xsiSchemaLocation) {
        this.xsiSchemaLocation = xsiSchemaLocation;
    }

    public NotifRSSuccess getSuccess() {
        return success;
    }

    public void setSuccess(NotifRSSuccess success) {
        this.success = success;
    }
}
