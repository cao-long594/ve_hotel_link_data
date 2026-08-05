package cn.vetech.center.hotel.link.elong.price.request;

import cn.vetech.center.hotel.link.elong.common.ElongRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class ElongHotelPriceRequest extends ElongRequest {

    /**
     * 入住日期
     */
    @JsonProperty("ArrivalDate")
    private String arrivalDate;
    /***
     * 离店日期
     */
    @JsonProperty("DepartureDate")
    private String departureDate;
    /**
     * 酒店ID列表
     */
    @JsonProperty("HotelIds")
    private String hotelIds;
    /***
     * 其他条件
     */
    @JsonProperty("Options")
    private String options;
    /***
     * 支付方式
     */
    @JsonProperty("PaymentType")
    private String paymentType;
    /***
     * 产品编码
     */
    @JsonProperty("RatePlanId")
    private String ratePlanId;

    /**
     * 成人数，国际专用
     */
    @JsonProperty("NumberOfAdults")
    private Integer numberOfAdults;

    /**
     * 房间数 国际专用
     */
    @JsonProperty("NumberOfRooms")
    private Integer numberOfRooms;
    /**
     * 儿童年龄
     */
    @JsonProperty("ChildAges")
    private List<Integer> childAges;
    /**
     * 会员openId
     */
    @JsonProperty("OpenId")
    private String openId;
    /**
     * 是否保存Littlemajiaid  国际特有字段, 当需要请求可定时，该字段设置为true，才能进行可定验证
     */
    @JsonProperty("SaveMajiaId")
    private Boolean saveMajiaId;

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Integer> getChildAges() {
        return childAges;
    }

    public void setChildAges(List<Integer> childAges) {
        this.childAges = childAges;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

   
    public Boolean getSaveMajiaId() {
        return saveMajiaId;
    }

    public void setSaveMajiaId(Boolean saveMajiaId) {
        this.saveMajiaId = saveMajiaId;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getRatePlanId() {
        return ratePlanId;
    }

    public void setRatePlanId(String ratePlanId) {
        this.ratePlanId = ratePlanId;
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

    public String getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(String hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
