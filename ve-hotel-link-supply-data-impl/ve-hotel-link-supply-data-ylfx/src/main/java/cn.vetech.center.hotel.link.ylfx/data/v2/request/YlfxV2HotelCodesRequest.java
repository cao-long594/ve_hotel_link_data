package cn.vetech.center.hotel.link.ylfx.data.v2.request;

/**
 * V2 synchronizable hotel code request.
 */
public class YlfxV2HotelCodesRequest {
    private String customerCode;
    private Integer domestic;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getDomestic() {
        return domestic;
    }

    public void setDomestic(Integer domestic) {
        this.domestic = domestic;
    }
}
