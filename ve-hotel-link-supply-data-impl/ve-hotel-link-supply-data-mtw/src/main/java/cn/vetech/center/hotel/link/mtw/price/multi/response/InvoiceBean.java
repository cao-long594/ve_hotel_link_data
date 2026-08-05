package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class InvoiceBean {
    /**
     * tmcInvoiceMode
     */
    @JsonProperty("tmcInvoiceMode")
    private Integer tmcInvoiceMode;
    /**
     * invoiceMode
     */
    @JsonProperty("invoiceMode")
    private Integer invoiceMode;

    public Integer getTmcInvoiceMode() {
        return tmcInvoiceMode;
    }

    public void setTmcInvoiceMode(Integer tmcInvoiceMode) {
        this.tmcInvoiceMode = tmcInvoiceMode;
    }

    public Integer getInvoiceMode() {
        return invoiceMode;
    }

    public void setInvoiceMode(Integer invoiceMode) {
        this.invoiceMode = invoiceMode;
    }
}