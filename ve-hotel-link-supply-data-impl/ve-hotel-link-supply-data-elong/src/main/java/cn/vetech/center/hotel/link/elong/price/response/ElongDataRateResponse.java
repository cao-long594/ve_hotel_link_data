package cn.vetech.center.hotel.link.elong.price.response;

import cn.vetech.center.hotel.link.elong.common.ElongResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * @author xiaotengyu
 * @since 2021/03/03
 */
public class ElongDataRateResponse extends ElongResponse {

    /***
     * reslult
     */
    @JsonProperty("Result")
    private DataRateInfo result;

    public DataRateInfo getResult() {
        return result;
    }

    public void setResult(DataRateInfo result) {
        this.result = result;
    }
}
