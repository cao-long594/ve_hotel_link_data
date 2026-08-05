package cn.vetech.center.hotel.link.elong.data.response.staticlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/8 15:47
 */
public class ElongHotelListResult {

    /**
     * 酒店的数量
     */
    @JsonProperty("Count")
    private Integer count;
    /***
     * 	城市下酒店列表
     */
    @JsonProperty("Hotels")
    private List<ElongHotelListInfo> hotels;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ElongHotelListInfo> getHotels() {
        return hotels;
    }

    public void setHotels(List<ElongHotelListInfo> hotels) {
        this.hotels = hotels;
    }
}
