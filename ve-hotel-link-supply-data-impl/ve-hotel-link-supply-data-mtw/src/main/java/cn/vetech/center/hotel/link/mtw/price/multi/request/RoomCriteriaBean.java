package cn.vetech.center.hotel.link.mtw.price.multi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:11
 */
public class RoomCriteriaBean {
    /**
     * roomCount
     */
    @JsonProperty("roomCount")
    private Integer roomCount;
    /**
     * adultCount
     */
    @JsonProperty("adultCount")
    private Integer adultCount;
    /**
     * childCount
     */
    @JsonProperty("childCount")
    private Integer childCount;
    /**
     * childAges
     */
    @JsonProperty("childAges")
    private List<Integer> childAges;

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public List<Integer> getChildAges() {
        return childAges;
    }

    public void setChildAges(List<Integer> childAges) {
        this.childAges = childAges;
    }
}
