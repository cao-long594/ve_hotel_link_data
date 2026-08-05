package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-12-20 16:00
 */
public class EtlHotelIRoomMergeDTO extends EtlHotelDTO{

    /**
     * roomMerges
     */
    private List<EtlRoomMerge> roomMerges;

    public List<EtlRoomMerge> getRoomMerges() {
        return roomMerges;
    }

    public void setRoomMerges(List<EtlRoomMerge> roomMerges) {
        this.roomMerges = roomMerges;
    }
}
