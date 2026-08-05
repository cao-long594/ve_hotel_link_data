package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom;

import java.util.List;
import java.util.Map;

/**
 * 美团物理房型
 * @author xiaotengyu
 * @since 2021/7/28 11:44
 */
public class MtwRealRoomResult {

    /**
     * realRoomInfos
     */
    private Map<Long,List<MtwRealRoomInfo>> realRoomInfos;

    public Map<Long, List<MtwRealRoomInfo>> getRealRoomInfos() {
        return realRoomInfos;
    }

    public void setRealRoomInfos(Map<Long, List<MtwRealRoomInfo>> realRoomInfos) {
        this.realRoomInfos = realRoomInfos;
    }
}
