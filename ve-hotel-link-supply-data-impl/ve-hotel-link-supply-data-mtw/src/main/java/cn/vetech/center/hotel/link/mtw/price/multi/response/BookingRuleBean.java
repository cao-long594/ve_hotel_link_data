package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class BookingRuleBean {
    /**
     * serialCheckinMax
     */
    @JsonProperty("serialCheckinMax")
    private Integer serialCheckinMax;
    /**
     * serialCheckinMin
     */
    @JsonProperty("serialCheckinMin")
    private Integer serialCheckinMin;
    /**
     * roomCountMin
     */
    @JsonProperty("roomCountMin")
    private Integer roomCountMin;
    /**
     * earliestBookingDays
     */
    @JsonProperty("earliestBookingDays")
    private Integer earliestBookingDays;
    /**
     * inEndDate
     */
    @JsonProperty("inEndDate")
    private Integer inEndDate;
    /**
     * latestBookingDays
     */
    @JsonProperty("latestBookingDays")
    private Integer latestBookingDays;
    /**
     * inStartDate
     */
    @JsonProperty("inStartDate")
    private Integer inStartDate;
    /**
     * isDaybreakBooking
     */
    @JsonProperty("isDaybreakBooking")
    private Integer isDaybreakBooking;
    /**
     * roomCountMax
     */
    @JsonProperty("roomCountMax")
    private Integer roomCountMax;

    public Integer getSerialCheckinMax() {
        return serialCheckinMax;
    }

    public void setSerialCheckinMax(Integer serialCheckinMax) {
        this.serialCheckinMax = serialCheckinMax;
    }

    public Integer getSerialCheckinMin() {
        return serialCheckinMin;
    }

    public void setSerialCheckinMin(Integer serialCheckinMin) {
        this.serialCheckinMin = serialCheckinMin;
    }

    public Integer getRoomCountMin() {
        return roomCountMin;
    }

    public void setRoomCountMin(Integer roomCountMin) {
        this.roomCountMin = roomCountMin;
    }

    public Integer getEarliestBookingDays() {
        return earliestBookingDays;
    }

    public void setEarliestBookingDays(Integer earliestBookingDays) {
        this.earliestBookingDays = earliestBookingDays;
    }

    public Integer getInEndDate() {
        return inEndDate;
    }

    public void setInEndDate(Integer inEndDate) {
        this.inEndDate = inEndDate;
    }

    public Integer getLatestBookingDays() {
        return latestBookingDays;
    }
 public void setLatestBookingDays(Integer latestBookingDays) {
        this.latestBookingDays = latestBookingDays;
    }

    public Integer getInStartDate() {
        return inStartDate;
    }

    public void setInStartDate(Integer inStartDate) {
        this.inStartDate = inStartDate;
    }

    public Integer getIsDaybreakBooking() {
        return isDaybreakBooking;
    }

    public void setIsDaybreakBooking(Integer isDaybreakBooking) {
        this.isDaybreakBooking = isDaybreakBooking;
    }

    public Integer getRoomCountMax() {
        return roomCountMax;
    }

    public void setRoomCountMax(Integer roomCountMax) {
        this.roomCountMax = roomCountMax;
    }
}
