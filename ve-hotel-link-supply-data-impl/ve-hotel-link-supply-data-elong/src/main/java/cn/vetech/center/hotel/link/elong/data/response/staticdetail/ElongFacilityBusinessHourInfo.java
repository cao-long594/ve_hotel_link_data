package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-06-05 14:00
 */
public class ElongFacilityBusinessHourInfo {

    /**
     * 设施营业时间类型	Enum Y	OpenDay：开放时间；CloseDay:关闭时间
     */
    @JsonProperty("OpenDayType")
    private String openDayType;
    /**
     * 设施营业时间开始时间	String	Y	HH:MM
     */
    @JsonProperty("StartTime")
    private String startTime;
    /**
     * 设施营业时间结束时间	String	Y	HH:MM
     */
    @JsonProperty("EndTime")
    private String endTime;
    /**
     * 设施营业时间周有效String	Y	适用星期几，从周一到周日 （如1110110表示周四、周日无效）
     */
    @JsonProperty("WeeklyIndex")
    private String weeklyIndex;

    public String getOpenDayType() {
        return openDayType;
    }

    public void setOpenDayType(String openDayType) {
        this.openDayType = openDayType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeeklyIndex() {
        return weeklyIndex;
    }

    public void setWeeklyIndex(String weeklyIndex) {
        this.weeklyIndex = weeklyIndex;
    }
}
