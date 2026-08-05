package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

/**
 * @author xiaotengyu
 * @since 2024-03-26 14:33
 */
public class MtwHotelRealRoomResponse extends MtwResponse {

    /**
     * result
     */
    private MtwHotelRealRoomResult result;

    public MtwHotelRealRoomResult getResult() {
        return result;
    }

    public void setResult(MtwHotelRealRoomResult result) {
        this.result = result;
    }
}