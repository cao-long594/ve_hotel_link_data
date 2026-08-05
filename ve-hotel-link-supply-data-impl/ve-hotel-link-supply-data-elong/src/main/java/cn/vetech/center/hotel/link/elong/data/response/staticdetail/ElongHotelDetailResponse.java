package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import cn.vetech.center.hotel.link.elong.common.ElongResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:18
 */
public class ElongHotelDetailResponse extends ElongResponse {

    /**
     * 12
     */
    @JsonProperty("Result")
    private ElongHotelDetailResult result;

    public ElongHotelDetailResult getResult() {
        return result;
    }

    public void setResult(ElongHotelDetailResult result) {
        this.result = result;
    }
}
