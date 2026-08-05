package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:00
 */
public class ElongReservationInfo {
    /**
     * 设施预约限制	    	T：需要预约；F：无需预约
     */
    @JsonProperty("Reserve")
    private String reserve;
    /**
     * 提前预约时间
     */
    @JsonProperty("Time")
    private String time;
    /**
     * 提前预约时间单位		Dia：天；Hora：小时；Minuto：分钟
     */
    @JsonProperty("TimeUnit")
    private String timeUnit;

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }
}
