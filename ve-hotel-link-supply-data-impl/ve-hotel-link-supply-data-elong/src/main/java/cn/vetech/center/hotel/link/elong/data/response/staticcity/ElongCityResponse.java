package cn.vetech.center.hotel.link.elong.data.response.staticcity;

import cn.vetech.center.hotel.link.elong.common.ElongResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 9:32
 */
public class ElongCityResponse extends ElongResponse {

    /**
     * result
     */
    @JsonProperty("Result")
    private ElongCityResult result;

    public ElongCityResult getResult() {
        return result;
    }

    public void setResult(ElongCityResult result) {
        this.result = result;
    }
}