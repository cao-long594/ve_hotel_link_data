package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author gaojin
 */
@XmlRootElement(name = "ServiceRank")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongServiceRank implements Serializable {
    /**
     * 酒店服务总评分
     */
    @XmlAttribute(name = "SummaryScore")
    private String summaryscore;
    /**
     * 服务总评分与同城的水平的对比
     */
    @XmlAttribute(name = "SummaryRate")
    private String summaryrate;
    /**
     * 及时确认率
     */
    @XmlAttribute(name = "InstantConfirmScore")
    private String instantconfirmscore;
    /**
     * 及时确认率与同城的水平的对比
     */
    @XmlAttribute(name = "InstantConfirmRate")
    private String instantconfirmrate;
    /**
     * 预订成功率
     */
    @XmlAttribute(name = "BookingSuccessScore")
    private String bookingsuccessscore;
    /**
     * 预订成功率与同城的水平的对比
     */
    @XmlAttribute(name = "BookingSuccessRate")
    private String bookingsuccessrate;
    /**
     * 用户投诉率
     */
    @XmlAttribute(name = "ComplaintScore")
    private String complaintscore;
    /**
     * 用户投诉率与同城的水平的对比
     */
    @XmlAttribute(name = "ComplaintRate")
    private String complaintrate;

    public String getSummaryscore() {
        return summaryscore;
    }

    public void setSummaryscore(String summaryscore) {
        this.summaryscore = summaryscore;
    }

    public String getSummaryrate() {
        return summaryrate;
    }

    public void setSummaryrate(String summaryrate) {
        this.summaryrate = summaryrate;
    }

    public String getInstantconfirmscore() {
        return instantconfirmscore;
    }

  public void setInstantconfirmscore(String instantconfirmscore) {
        this.instantconfirmscore = instantconfirmscore;
    }

    public String getInstantconfirmrate() {
        return instantconfirmrate;
    }

    public void setInstantconfirmrate(String instantconfirmrate) {
        this.instantconfirmrate = instantconfirmrate;
    }

    public String getBookingsuccessscore() {
        return bookingsuccessscore;
    }

    public void setBookingsuccessscore(String bookingsuccessscore) {
        this.bookingsuccessscore = bookingsuccessscore;
    }

    public String getBookingsuccessrate() {
        return bookingsuccessrate;
    }

    public void setBookingsuccessrate(String bookingsuccessrate) {
        this.bookingsuccessrate = bookingsuccessrate;
    }

    public String getComplaintscore() {
        return complaintscore;
    }

    public void setComplaintscore(String complaintscore) {
        this.complaintscore = complaintscore;
    }

    public String getComplaintrate() {
        return complaintrate;
    }

    public void setComplaintrate(String complaintrate) {
        this.complaintrate = complaintrate;
    }
}
