package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/6/23 10:45
 */
public class ElongRoomBedDetail {
    /**
     * 或分组
     * BedGroups链表的每个元素之间为“或”的关系 参见BedGroup节点
     */
    @JsonProperty("BedGroups")
    private List<ElongBedGroup> bedGroups;
    /**
     * 房间号
     */
    @JsonProperty("RoomIndex")
    private String roomIndex;

    public List<ElongBedGroup> getBedGroups() {
        return bedGroups;
    }

    public void setBedGroups(List<ElongBedGroup> bedGroups) {
        this.bedGroups = bedGroups;
    }

    public String getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(String roomIndex) {
        this.roomIndex = roomIndex;
    }
}
