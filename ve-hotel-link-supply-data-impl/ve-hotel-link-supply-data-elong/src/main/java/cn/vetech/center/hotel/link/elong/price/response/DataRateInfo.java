package cn.vetech.center.hotel.link.elong.price.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class DataRateInfo {

    /***
     * 12
     */
    @JsonProperty("Rates")
    private List<RateInfo> rates;

    public List<RateInfo> getRates() {
        return rates;
    }

    public void setRates(List<RateInfo> rates) {
        this.rates = rates;
    }
}
