package cn.vetech.center.hotel.link.mtw.price.lowestprice.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:27
 */
public class MtwLowestPriceResponse extends MtwResponse {
    /**
     * result
     */
    @JsonProperty("result")
    private MtwLowestPriceResult result;

    public MtwLowestPriceResult getResult() {
        return result;
    }

    public void setResult(MtwLowestPriceResult result) {
        this.result = result;
    }
}
