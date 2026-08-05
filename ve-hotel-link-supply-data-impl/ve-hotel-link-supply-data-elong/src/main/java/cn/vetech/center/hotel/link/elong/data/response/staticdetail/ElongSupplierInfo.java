package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:19
 */
public class ElongSupplierInfo {

    /***
     * 供应商ID
     */
    @JsonProperty("SupplierID")
    private String supplierID;
    /***
     * 对应供应商编码
     */
    @JsonProperty("HotelCode")
    private String hotelCode;
    /***
     * 星期开始设置
     */
    @JsonProperty("WeekendStart")
    private String weekendStart;
    /***
     * 星期结束设置
     */
    @JsonProperty("WeekendEnd")
    private String weekendEnd;
    /***
     * 即时确认的销售房型
     */
    @JsonProperty("InstantRoomTypes")
    private String instantRoomTypes;
    /***
     * 供应商有效状态
     */
    @JsonProperty("Status")
    private String status;
    /***
     * 酒店使用库存和价格的方式
     */
    @JsonProperty("InvokeType")
    private String invokeType;
    /***
     * 特殊政策
     */
    @JsonProperty("AvailPolicy")
    private ElongAvailPolicyInfo availPolicy;
    /***
     * 温馨提示
     */
    @JsonProperty("HelpfulTip")
    private ElongHelpFulTipInfo helpfulTip;

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getWeekendStart() {
        return weekendStart;
    }

    public void setWeekendStart(String weekendStart) {
        this.weekendStart = weekendStart;
    }

    public String getWeekendEnd() {
        return weekendEnd;
    }

    public void setWeekendEnd(String weekendEnd) {
        this.weekendEnd = weekendEnd;
    }

    public String getInstantRoomTypes() {
        return instantRoomTypes;
    }

      public void setInstantRoomTypes(String instantRoomTypes) {
        this.instantRoomTypes = instantRoomTypes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType;
    }

    public ElongAvailPolicyInfo getAvailPolicy() {
        return availPolicy;
    }

    public void setAvailPolicy(ElongAvailPolicyInfo availPolicy) {
        this.availPolicy = availPolicy;
    }

    public ElongHelpFulTipInfo getHelpfulTip() {
        return helpfulTip;
    }

    public void setHelpfulTip(ElongHelpFulTipInfo helpfulTip) {
        this.helpfulTip = helpfulTip;
    }
}
