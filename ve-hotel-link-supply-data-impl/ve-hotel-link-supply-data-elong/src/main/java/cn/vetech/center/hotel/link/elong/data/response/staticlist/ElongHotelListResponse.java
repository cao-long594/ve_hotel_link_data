package cn.vetech.center.hotel.link.elong.data.response.staticlist;

import cn.vetech.center.hotel.link.elong.common.ElongResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:06
 */
public class ElongHotelListResponse extends ElongResponse {

    /***
     * q1212
     */
    @JsonProperty("Result")
    private ElongHotelListResult result;

    /**
     * 是否是最后一页
     */
    private Boolean last;

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public ElongHotelListResult getResult() {
        return result;
    }

    public void setResult(ElongHotelListResult result) {
        this.result = result;
    }
}
