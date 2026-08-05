package cn.vetech.center.hotel.link.elong.orderlist.response;

import cn.vetech.center.hotel.link.elong.orderdetail.response.ElongRefundDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/8/21 14:38
 */
public class ElongOrder {
    /**
     * 订单编号
     */
    @JsonProperty("OrderId")
    private String orderId;
    /**
     * 状态
     */
    @JsonProperty("Status")
    private String status;
    /**
     * 总价
     */
    @JsonProperty("TotalPrice")
    private String totalPrice;
    /**
     * 货币类型
     */
    @JsonProperty("CurrencyCode")
    private String currencyCode;
    /**
     * 酒店编号
     */
    @JsonProperty("HotelId")
    private String hotelId;
    /**
     * 酒店名称
     */
    @JsonProperty("HotelName")
    private String hotelName;
    /**
     * 房型编号
     */
    @JsonProperty("RoomTypeId")
    private String roomTypeId;
    /**
     * 房型名称
     */
    @JsonProperty("RoomTypeName")
    private String roomTypeName;
    /**
     * 产品编号
     */
    @JsonProperty("RatePlanId")
    private String ratePlanId;
    /**
     * 产品名称
     */
    @JsonProperty("RatePlanName")
    private String ratePlanName;
    /**
     * 入住日期
     */
    @JsonProperty("ArrivalDate")
    private String arrivalDate;
    /**
     * 离店日期
     */
    @JsonProperty("DepartureDate")
    private String departureDate;
    /**
     * 客人类型
     * All=统一价；
     * Chinese =内宾价，需提示客人“须持大陆身份证入住”；
     * OtherForeign =外宾价，需提示客人“须持国外护照入住”；
     * HongKong   =港澳台客人价，需提示客人“须持港澳台身份证入住”；
     * ChinaGuest =中宾价，需提示客人“须持中国身份证、护照入住”；
     */
    @JsonProperty("CustomerType")
    private String customerType;
    /**
     * 房间数量
     */
    @JsonProperty("NumberOfRooms")
    private String numberOfRooms;
    /**
     * 客人数量
     */
    @JsonProperty("NumberOfCustomers")
    private String numberOfCustomers;
    /**
     * 付款类型
 * SelfPay-前台现付、Prepay-预付
     */
    @JsonProperty("PaymentType")
    private String paymentType;
    /**
     * 最早到店时间
     */
    @JsonProperty("EarliestArrivalTime")
    private String earliestArrivalTime;
    /**
     * 最晚到店时间
     */
    @JsonProperty("LatestArrivalTime")
    private String latestArrivalTime;
    /**
     * 确认类型
     * NotAllowedConfirm   不允许确认(合作伙伴自查订单状态后自行联系客人)
     * SMS_cn  ----艺龙发短信给客人,出现订单问题的时候会主动联系
     * NoNeed -- 艺龙发短信给客人,出现订单问题的时候不主动联系
     * 注：除了NotAllowedConfirm，其余的选项艺龙都会发送短信，下单时如果输入了邮箱那么都会发送邮件
     */
    @JsonProperty("ConfirmationType")
    private String confirmationType;
    /**
     * 给酒店备注
     */
    @JsonProperty("NoteToHotel")
    private String noteToHotel;
    /**
     * 给艺龙备注
     */
    @JsonProperty("NoteToElong")
    private String noteToElong;
    /**
     * 多次退款详情
     */
    @JsonProperty("refundDetail")
    private ElongRefundDetail refundDetail;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getNumberOfCustomers() {
        return numberOfCustomers;
    }
public void setNumberOfCustomers(String numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getEarliestArrivalTime() {
        return earliestArrivalTime;
    }

    public void setEarliestArrivalTime(String earliestArrivalTime) {
        this.earliestArrivalTime = earliestArrivalTime;
    }

    public String getLatestArrivalTime() {
        return latestArrivalTime;
    }

    public void setLatestArrivalTime(String latestArrivalTime) {
        this.latestArrivalTime = latestArrivalTime;
    }

    public String getConfirmationType() {
        return confirmationType;
    }

    public void setConfirmationType(String confirmationType) {
        this.confirmationType = confirmationType;
    }

    public String getNoteToHotel() {
        return noteToHotel;
    }

    public void setNoteToHotel(String noteToHotel) {
        this.noteToHotel = noteToHotel;
    }

    public String getNoteToElong() {
        return noteToElong;
    }

    public void setNoteToElong(String noteToElong) {
        this.noteToElong = noteToElong;
    }

    public ElongRefundDetail getRefundDetail() {
        return refundDetail;
    }

    public void setRefundDetail(ElongRefundDetail refundDetail) {
        this.refundDetail = refundDetail;
    }
}
