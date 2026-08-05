package cn.vetech.center.hotel.link.mtw.price.multi.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2024/8/1 9:18
 */
public class MtwMultiResponse extends MtwResponse {
    /**
     * result
     */
    @JsonProperty("result")
    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }
}
