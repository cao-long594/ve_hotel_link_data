package cn.vetech.center.hotel.link.elong.price.request;

import cn.vetech.center.hotel.link.elong.common.ElongRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * yilogn
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class ElongDataRateRequest extends ElongRequest {

    /***
     * 酒店编号，最多10个,逗号分隔
     */
    @JsonProperty("HotelIds")
    private String hotelIds;
    /***
     * 付款类型 All - 全部 SelfPay - 前台现付 Prepay - 预付
     */
    @JsonProperty("PaymentType")
    private String paymentType;
    /***
     * 开始时间 大于等于昨天
     */
    @JsonProperty("StartDate")
    private String startDate;
    /***
     * 结束时间 	和开始时间不超过90天
     */
    @JsonProperty("EndDate")
    private String endDate;

    public String getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(String hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
}
