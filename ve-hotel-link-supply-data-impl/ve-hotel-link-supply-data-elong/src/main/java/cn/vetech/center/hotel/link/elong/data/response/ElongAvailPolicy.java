package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author gaojin
 */
@XmlRootElement(name = "AvailPolicy")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongAvailPolicy implements Serializable {
    /**
     *
     */
    @XmlValue
    private String availPolicy;
    /**
     * 开始日期
     */
    @XmlAttribute(name = "StartDate")
    private String startDate;
    /**
     * 结束日期
     */
    @XmlAttribute(name = "EndDate")
    private String endDate;

    public String getAvailPolicy() {
        return availPolicy;
    }

    public void setAvailPolicy(String availPolicy) {
        this.availPolicy = availPolicy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
