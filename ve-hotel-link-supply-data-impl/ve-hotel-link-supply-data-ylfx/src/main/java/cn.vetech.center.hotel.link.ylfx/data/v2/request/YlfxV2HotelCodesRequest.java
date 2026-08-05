package cn.vetech.center.hotel.link.ylfx.data.v2.request;

/**
 * V2 可同步酒店编码请求
 *
 * @author 6161
 * @date 2026/08/05
 */
public class YlfxV2HotelCodesRequest {
    /**
     * 客户编码
     */
    private String customerCode;
    /**
     * 国内酒店标识：1 国内
     */
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
