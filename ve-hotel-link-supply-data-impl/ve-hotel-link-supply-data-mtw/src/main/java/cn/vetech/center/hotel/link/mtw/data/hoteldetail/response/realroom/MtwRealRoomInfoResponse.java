package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

/**
 * @author xiaotengyu
 * @since 2021/7/28 14:07
 */
public class MtwRealRoomInfoResponse extends MtwResponse {

    /**
     * result
     */
    private MtwRealRoomResult result;

    public MtwRealRoomResult getResult() {
        return result;
    }

    public void setResult(MtwRealRoomResult result) {
        this.result = result;
    }
}
