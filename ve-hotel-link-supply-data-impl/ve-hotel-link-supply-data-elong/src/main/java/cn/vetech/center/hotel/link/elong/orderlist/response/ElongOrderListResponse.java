package cn.vetech.center.hotel.link.elong.orderlist.response;

import cn.vetech.center.hotel.link.elong.common.ElongResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/8/21 14:24
 */
public class ElongOrderListResponse extends ElongResponse {
    /**
     * 订单结果
     */
    @JsonProperty("Result")
   private ElongOrderResult result;

    public ElongOrderResult getResult() {
        return result;
    }

    public void setResult(ElongOrderResult result) {
        this.result = result;
    }
}
