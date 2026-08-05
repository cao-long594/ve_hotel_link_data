package cn.vetech.center.hotel.link.mtw.data.hoteldetail.request;

import cn.vetech.center.hotel.link.mtw.common.MtwBaseRequest;
import cn.vetech.center.hotel.link.util.JacksonUtils;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-03-26 14:24
 */
public class MtwHotelRealRoomRequest extends MtwBaseRequest {

    /**
     * 酒店ID
     */
    private Long hotelId;
    /**
     * 物理房型ID
     */
    private List<Integer> realRoomIds;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<Integer> getRealRoomIds() {
        return realRoomIds;
    }

    public void setRealRoomIds(List<Integer> realRoomIds) {
        this.realRoomIds = realRoomIds;
    }

    /**
     * 转换成json字符串
     * @return json str
     */
    @Override
    public String toJson(){
        return JacksonUtils.toJsonWithDefault(this);
    }
}
