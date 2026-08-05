package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:04
 */
public class ElongHotelCloseTimes {
    /**
     * 开始时间
     */
    private String startDay;
    /**
     * 结束时间
     */
    private String endDay;
    /**
     * 原因
     */
    private String reason;
    /**
     * 原因描述
     */
    private String reasonName;


    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }
}
