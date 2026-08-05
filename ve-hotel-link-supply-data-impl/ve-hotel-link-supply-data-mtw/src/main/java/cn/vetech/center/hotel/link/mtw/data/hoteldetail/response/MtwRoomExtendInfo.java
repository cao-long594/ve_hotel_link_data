package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import java.util.Map;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwRoomExtendInfo {
    /**
     * 房间设施，key表示房间设施ID（ID对应设施参看房间设施），value="0"表示不提供该设施；value="1"表示提供该设施。
     */
    private Map<Integer, String> roomFacilities;

    public Map<Integer, String> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(Map<Integer, String> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }
}
