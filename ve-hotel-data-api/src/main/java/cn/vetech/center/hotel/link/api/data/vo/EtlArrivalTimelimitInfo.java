package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 17:06
 * @comment
 */
public class EtlArrivalTimeLimitInfo {
    /**
     * 最早到点时间
     */
    private String earliestTime;
    /**
     * 最晚到点时间
     */
    private String latestTime;
    /**
     * 是否必须
     */
    private Boolean isMustBe;

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

    public Boolean getMustBe() {
        return isMustBe;
    }

    public void setMustBe(Boolean mustBe) {
        isMustBe = mustBe;
    }
}
