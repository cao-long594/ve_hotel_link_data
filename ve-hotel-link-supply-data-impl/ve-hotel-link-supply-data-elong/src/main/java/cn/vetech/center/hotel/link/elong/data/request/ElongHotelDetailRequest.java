package cn.vetech.center.hotel.link.elong.data.request;

import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:16
 */
public class ElongHotelDetailRequest extends ElongRequest {

    /***
     * 酒店ID
     */
    @JsonProperty("HotelId")
    private String hotelId;

    public ElongHotelDetailRequest(){

    }

    public ElongHotelDetailRequest(String hotelId, ElongConfig config){
        this.hotelId = hotelId;
        super.setConfig(config);
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
