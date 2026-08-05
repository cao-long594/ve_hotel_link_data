package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:08
 */
public class MtwHotelBusinessHour {

    /**
     * 早餐日期对应的code，允许为空，空表示不限制日期。枚举值如下：
     * 0-星期一;
     * 1-星期二;
     * 2-星期三;
     * 3-星期四;
     * 4-星期五;
     * 5-星期六;
     * 6-星期日;
     */
    private String weekDay;

    /**
     * 早餐时间段。
     * 存储格式：hh:mm-hh:mm；以00:00-23:59为最大长度。
     */
    private List<String> times;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}
