package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author gaojin
 */
@XmlRootElement(name = "HelpfulTips")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongHelpfulTips implements Serializable {
    /**
     *
     */
    @XmlValue
    private String helpfulTips;
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

    public String getHelpfulTips() {
        return helpfulTips;
    }

    public void setHelpfulTips(String helpfulTips) {
        this.helpfulTips = helpfulTips;
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
