package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import java.util.List;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwRoomInfo {
    /**
     *房型基本信息。
     */
    private MtwRoomBaseInfo roomBaseInfo;
    /**
     *房型扩展信息。
     */
    private MtwRoomExtendInfo roomExtendInfo;
    /**
     *床型基本信息
     */
    private List<MtwRoomBedInfo> roomBedInfos;

    public MtwRoomBaseInfo getRoomBaseInfo() {
        return roomBaseInfo;
    }

    public void setRoomBaseInfo(MtwRoomBaseInfo roomBaseInfo) {
        this.roomBaseInfo = roomBaseInfo;
    }

    public MtwRoomExtendInfo getRoomExtendInfo() {
        return roomExtendInfo;
    }

    public void setRoomExtendInfo(MtwRoomExtendInfo roomExtendInfo) {
        this.roomExtendInfo = roomExtendInfo;
    }

    public List<MtwRoomBedInfo> getRoomBedInfos() {
        return roomBedInfos;
    }

    public void setRoomBedInfos(List<MtwRoomBedInfo> roomBedInfos) {
        this.roomBedInfos = roomBedInfos;
    }
}
