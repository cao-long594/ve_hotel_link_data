package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class ResultBean {
    /**
     * 产品信息
     */
    @JsonProperty("availability")
    private List<AvailabilityBean> availability;

    public List<AvailabilityBean> getAvailability() {
        return availability;
    }

    public void setAvailability(List<AvailabilityBean> availability) {
        this.availability = availability;
    }
}
