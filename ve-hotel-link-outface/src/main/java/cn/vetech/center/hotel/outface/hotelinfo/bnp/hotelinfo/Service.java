package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 11:31
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {
    /**
     * 维度
     */
    @XmlAttribute(name = "Code")
    private String code;
    /**
     * 经度
     */
    @XmlAttribute(name = "ExistsCode")
    private String existsCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExistsCode() {
        return existsCode;
    }

    public void setExistsCode(String existsCode) {
        this.existsCode = existsCode;
    }
}
