package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/6/23 10:34
 */
public class ElongRoomBedInfo {
    /**
     * 卧室床信息
     */
    @JsonProperty("RoomDetailBeds")
    private List<ElongRoomBedDetail> roomDetailBeds;
    /**
     * 客厅床信息
     */
    @JsonProperty("LivingRoomBeds")
    private List<ElongRoomBedDetail> livingRoomBeds;

    public List<ElongRoomBedDetail> getRoomDetailBeds() {
        return roomDetailBeds;
    }

    public void setRoomDetailBeds(List<ElongRoomBedDetail> roomDetailBeds) {
        this.roomDetailBeds = roomDetailBeds;
    }

    public List<ElongRoomBedDetail> getLivingRoomBeds() {
        return livingRoomBeds;
    }

    public void setLivingRoomBeds(List<ElongRoomBedDetail> livingRoomBeds) {
        this.livingRoomBeds = livingRoomBeds;
    }
}
