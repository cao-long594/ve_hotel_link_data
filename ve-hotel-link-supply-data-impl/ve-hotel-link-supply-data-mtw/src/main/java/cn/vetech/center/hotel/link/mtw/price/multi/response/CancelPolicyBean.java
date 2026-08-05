package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class CancelPolicyBean {
    /**
     * cancelType
     */
    @JsonProperty("cancelType")
    private Integer cancelType;
    /**
     * moveUpCancelDays
     */
    @JsonProperty("moveUpCancelDays")
    private Integer moveUpCancelDays;

    public Integer getCancelType() {
        return cancelType;
    }

    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }

    public Integer getMoveUpCancelDays() {
        return moveUpCancelDays;
    }

    public void setMoveUpCancelDays(Integer moveUpCancelDays) {
        this.moveUpCancelDays = moveUpCancelDays;
    }
}
