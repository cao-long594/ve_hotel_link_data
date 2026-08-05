package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/6/23 10:33
 */
public class ElongRoomBed {
    /**
     *
     */
    @JsonProperty("RoomBedInfo")
    private List<ElongRoomBedInfo> roomBedInfoList;

    public List<ElongRoomBedInfo> getRoomBedInfoList() {
        return roomBedInfoList;
    }

    public void setRoomBedInfoList(List<ElongRoomBedInfo> roomBedInfoList) {
        this.roomBedInfoList = roomBedInfoList;
    }
}
