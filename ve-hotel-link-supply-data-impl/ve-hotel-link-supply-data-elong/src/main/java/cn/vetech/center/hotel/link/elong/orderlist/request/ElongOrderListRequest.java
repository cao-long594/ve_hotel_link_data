package cn.vetech.center.hotel.link.elong.orderlist.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/8/21 14:23
 */
public class ElongOrderListRequest {
    /**
     * 预定时间开始点
     */
    @JsonProperty("CreationTimeFrom")
    private String creationTimeFrom;
    /**
     * 预定时间结束点  预定时间范围尽量控制在一个月范围内，否则会超时
     */
    @JsonProperty("CreationTimeTo")
    private String creationTimeTo;
    /**
     * 酒店编号
     */
    @JsonProperty("HotelId")
    private String hotelId;
    /**
     * 房型编号
     */
    @JsonProperty("RoomTypeId")
    private String roomTypeId;
    /**
     * 	产品编号
     */
    @JsonProperty("RatePlanId")
    private String ratePlanId;
    /**
     * 入住日期开始点
     */
    @JsonProperty("ArrivalDateFrom")
    private String arrivalDateFrom;
    /**
     * 入住日期结束点
     */
    @JsonProperty("ArrivalDateTo")
    private String arrivalDateTo;
    /**
     * 离店日期开始点
     */
    @JsonProperty("DepartureDateFrom")
    private String departureDateFrom;
    /**
     * 离店日期结束点
     */
    @JsonProperty("DepartureDateTo")
    private String departureDateTo;
    /**
     * 最后更新时间开始点
     */
    @JsonProperty("MinUpdateTime")
    private String minUpdateTime;
    /**
     * 最后更新时间结束点
     */
    @JsonProperty("MaxUpdateTime")
    private String maxUpdateTime;
    /**
     * 联系人手机
     */
    @JsonProperty("Mobile")
    private String mobile;
    /**
     * 入住人姓名
     */
    @JsonProperty("CustomerName")
    private String customerName;
    /**
     * 订单状态
     */
    @JsonProperty("Status")
    private String status;
    /**
     * 分页页码
     */
    @JsonProperty("PageIndex")
    private int pageIndex;

    public String getCreationTimeFrom() {
        return creationTimeFrom;
    }

    public void setCreationTimeFrom(String creationTimeFrom) {
        this.creationTimeFrom = creationTimeFrom;
    }

 public String getCreationTimeTo() {
        return creationTimeTo;
    }

    public void setCreationTimeTo(String creationTimeTo) {
        this.creationTimeTo = creationTimeTo;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getArrivalDateFrom() {
        return arrivalDateFrom;
    }

    public void setArrivalDateFrom(String arrivalDateFrom) {
        this.arrivalDateFrom = arrivalDateFrom;
    }

    public String getArrivalDateTo() {
        return arrivalDateTo;
    }

    public void setArrivalDateTo(String arrivalDateTo) {
        this.arrivalDateTo = arrivalDateTo;
    }

    public String getDepartureDateFrom() {
        return departureDateFrom;
    }

    public void setDepartureDateFrom(String departureDateFrom) {
        this.departureDateFrom = departureDateFrom;
    }

    public String getDepartureDateTo() {
        return departureDateTo;
    }

    public void setDepartureDateTo(String departureDateTo) {
        this.departureDateTo = departureDateTo;
    }

    public String getMinUpdateTime() {
        return minUpdateTime;
    }

    public void setMinUpdateTime(String minUpdateTime) {
        this.minUpdateTime = minUpdateTime;
    }

    public String getMaxUpdateTime() {
        return maxUpdateTime;
    }

    public void setMaxUpdateTime(String maxUpdateTime) {
        this.maxUpdateTime = maxUpdateTime;
    }

    public String getMobile() {
        return mobile;
    }

   public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
