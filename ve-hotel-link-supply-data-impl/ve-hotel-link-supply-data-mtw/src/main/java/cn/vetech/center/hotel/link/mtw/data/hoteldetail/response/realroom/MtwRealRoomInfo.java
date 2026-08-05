package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom;

import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwPoiImage;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwRoomBedInfo;

import java.util.List;
import java.util.Map;

/**
 * @author xiaotengyu
 * @since 2021/7/28 14:46
 */
public class MtwRealRoomInfo {

    /**
     * realRoomBaseInfo
     */
    private MtwRealRoomBaseInfo realRoomBaseInfo;
    /**
     * goodsIds
     */
    private List<Long> goodsIds;
    /**
     * roomBedInfoList
     */
    private List<List<MtwRoomBedInfo>> roomBedInfoList;

    /**
     * roomFacilities
     */
    private Map<String,String> roomFacilities;

    /**
     * realRoomImageList
     */
    private List<MtwPoiImage> realRoomImageList;

    public List<MtwPoiImage> getRealRoomImageList() {
        return realRoomImageList;
    }

    public void setRealRoomImageList(List<MtwPoiImage> realRoomImageList) {
        this.realRoomImageList = realRoomImageList;
    }

    public Map<String, String> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(Map<String, String> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public MtwRealRoomBaseInfo getRealRoomBaseInfo() {
        return realRoomBaseInfo;
    }

    public void setRealRoomBaseInfo(MtwRealRoomBaseInfo realRoomBaseInfo) {
        this.realRoomBaseInfo = realRoomBaseInfo;
    }

    public List<Long> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Long> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public List<List<MtwRoomBedInfo>> getRoomBedInfoList() {
        return roomBedInfoList;
    }

    public void setRoomBedInfoList(List<List<MtwRoomBedInfo>> roomBedInfoList) {
        this.roomBedInfoList = roomBedInfoList;
    }
}
