package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 17:08
 * @comment 离店政策
 */
public class  EtlDepartureTimeLimitInfo {
    /**
     * 最早离店时间
     */
    private String earliestTime;
    /**
     * 最晚离店时间
     */
    private String latestTime;

    public String getEarliestTime() {
        return earliestTime;
    }

    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }
}
