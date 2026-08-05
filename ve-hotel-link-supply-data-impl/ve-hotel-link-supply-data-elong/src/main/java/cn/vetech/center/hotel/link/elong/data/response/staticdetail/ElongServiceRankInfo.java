package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 14:12
 */
public class ElongServiceRankInfo {

    /**
     * 酒店服务总评分
     */
    @JsonProperty("SummaryScore")
    private String summaryScore;
    /**
     * 及时确认率
     */
    @JsonProperty("InstantConfirmScore")
    private String instantConfirmScore;
    /**
     * 预订成功率
     */
    @JsonProperty("BookingSuccessScore")
    private String bookingSuccessScore;
    /**
     * 用户投诉率
     */
    @JsonProperty("ComplaintScore")
    private String complaintScore;

    public String getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(String summaryScore) {
        this.summaryScore = summaryScore;
    }

    public String getInstantConfirmScore() {
        return instantConfirmScore;
    }

    public void setInstantConfirmScore(String instantConfirmScore) {
        this.instantConfirmScore = instantConfirmScore;
    }

    public String getBookingSuccessScore() {
        return bookingSuccessScore;
    }

    public void setBookingSuccessScore(String bookingSuccessScore) {
        this.bookingSuccessScore = bookingSuccessScore;
    }

    public String getComplaintScore() {
        return complaintScore;
    }

    public void setComplaintScore(String complaintScore) {
        this.complaintScore = complaintScore;
    }
}
