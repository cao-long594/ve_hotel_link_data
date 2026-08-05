package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class RoomBean {
    /**
     * extraBed
     */
    @JsonProperty("extraBed")
    private Integer extraBed;
    /**
     * window
     */
    @JsonProperty("window")
    private Integer window;
    /**
     * roomId
     */
    @JsonProperty("roomId")
    private Integer roomId;
    /**
     * roomName
     */
    @JsonProperty("roomName")
    private String roomName;
    /**
     * bedGroups
     */
    @JsonProperty("bedGroups")
    private List<List<BedGroupsBean>> bedGroups;

    public Integer getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Integer extraBed) {
        this.extraBed = extraBed;
    }

    public Integer getWindow() {
        return window;
    }

    public void setWindow(Integer window) {
        this.window = window;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<List<BedGroupsBean>> getBedGroups() {
        return bedGroups;
    }

    public void setBedGroups(List<List<BedGroupsBean>> bedGroups) {
        this.bedGroups = bedGroups;
    }
}
