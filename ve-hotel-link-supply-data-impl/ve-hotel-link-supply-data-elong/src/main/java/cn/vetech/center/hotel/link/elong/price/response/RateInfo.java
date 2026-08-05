package cn.vetech.center.hotel.link.elong.price.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class RateInfo {

    /***
     * 酒店ID	String(8)	N	这几个属性是业务主键
    @c/om.fasterxml.jackson.annotation.JsonProperty(")
     */
    @JsonProperty("HotelID")
    private String hotelID;
    /***
     * 房型ID	String(10)	N
     */
    @JsonProperty("RoomTypeId")
    private String roomTypeId;
    /***
     * 产品 ID	Int	N
     */
    @JsonProperty("RateplanId")
    private Integer rateplanId;
    /***
     * 开始时间	Date	N
     */
    @JsonProperty("StartDate")
    private String startDate;
    /***
     * 结束时间	Date	N
     */
    @JsonProperty("EndDate")
    private String endDate;
    /***
     * 供应商ID	String(8)	Y	v1.13新增
     */
    @JsonProperty("HotelCode")
    private String hotelCode;
    /***
     * 状态	Boolean	N	已废弃，总是返回true，返回的都是有效价格，请注意清理本地无效价格
     */
    @JsonProperty("Status")
    private Boolean status;
    /***
     * 平日卖价	Decimal	N	-1代表此房无价，无价和满房都不能进行预订
     */
    @JsonProperty("Member")
    private Double member;
    /***
     * 周末卖价	Decimal	N	同上
     */
    @JsonProperty("Weekend")
    private Double weekend;
    /***
     * 平日结算价	Decimal	N	同上，开通了结算价模式的接入方才可以使用
     */
    @JsonProperty("MemberCost")
    private Double memberCost;
    /***
     * 周末结算价	Decimal	N	同上，开通了结算价模式的接入方才可以使用
     */
    @JsonProperty("WeekendCost")
    private Double weekendCost;
    /***
     * 加床价	Decimal	Y	V1.01新增1代表不能加床，0-免费加床，大于0表示加床的费用
     */
    @JsonProperty("AddBed")
    private Double addBed;
    /***
     * 价格ID	Long	Y	V1.08新增
     */
    @JsonProperty("PriceID")
    private Long priceID;
    /***
     * 货币类型
     */
    @JsonProperty("CurrencyCode")
    private String currencyCode;

    public String getHotelID() {
        return hotelID;
    }

   public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getRateplanId() {
        return rateplanId;
    }

    public void setRateplanId(Integer rateplanId) {
        this.rateplanId = rateplanId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getMember() {
        return member;
    }

    public void setMember(Double member) {
        this.member = member;
    }

    public Double getWeekend() {
        return weekend;
    }

    public void setWeekend(Double weekend) {
        this.weekend = weekend;
    }

    public Double getMemberCost() {
        return memberCost;
    }

    public void setMemberCost(Double memberCost) {
        this.memberCost = memberCost;
    }

    public Double getWeekendCost() {
        return weekendCost;
    }

    public void setWeekendCost(Double weekendCost) {
        this.weekendCost = weekendCost;
    }

    public Double getAddBed() {
        return addBed;
    }

    public void setAddBed(Double addBed) {
        this.addBed = addBed;
    }

    public Long getPriceID() {
        return priceID;
    }

 public void setPriceID(Long priceID) {
        this.priceID = priceID;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}


  