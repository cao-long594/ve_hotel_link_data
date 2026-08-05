package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import java.util.List;

/**
 * @author xingyanyan on 2018/9/4.
 */
public class MtwHotelDetail {
    /**
     *酒店基本信息。
     */
    private MtwHotelBaseInfo baseInfo;
    /**
     *酒店扩展信息。
     */
    private MtwHotelExtendInfo extendInfo;
    /**
     *酒店房型信息。
     */
    private List<MtwRoomInfo> roomInfos;
    /**
     *酒店图片信息。
     */
    private List<MtwPoiImage> poiImages;
    /**
     *
     */
    private Long hotelId;

    public MtwHotelBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(MtwHotelBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public MtwHotelExtendInfo getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(MtwHotelExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }

    public List<MtwRoomInfo> getRoomInfos() {
        return roomInfos;
    }

    public void setRoomInfos(List<MtwRoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
    }

    public List<MtwPoiImage> getPoiImages() {
        return poiImages;
    }

    public void setPoiImages(List<MtwPoiImage> poiImages) {
        this.poiImages = poiImages;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
