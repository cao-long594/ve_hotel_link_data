package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import java.util.List;

public class MtwHotelIdVo {

    /***
     * maxId标记值，用于下一页查询。当maxId为-1时，表示已经查询到最后一页
     */
    private Long maxId;
    private List<Long> hotelIds;

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }
}
