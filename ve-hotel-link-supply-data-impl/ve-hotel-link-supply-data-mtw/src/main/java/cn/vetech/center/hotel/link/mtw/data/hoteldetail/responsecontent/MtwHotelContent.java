package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomBaseInfo;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:12
 */
public class MtwHotelContent {

    /**
     *
     * 酒店ID
     */
    private String hotelId;

    /**
     *
     * 酒店基本信息，包括酒店名称、地址、电话等信息
     */
    private MtwHotelBaseInfo baseInfo;

    /**
     *酒店详细信息，包括开业时间、品牌、评分、主题等信息
     */
    private MtwHotelDetailInfo detailInfo;

    /**
     *酒店通知，通知信息类型：
     * REMIND：酒店提示
     * IMPORTANT_NOTICE:重要通知
     * CITY_NOTICE:城市通知
     */
    private List<MtwHotelTypeValue> notices;

    /**
     *酒店政策
     */
    private MtwHotelContentPolicy policy;

    /**
     *
     * 酒店服务及设施，参见《酒店设施服务字典》
     */
    private List<MtwHotelFacility> facilities;

    /**
     *酒店图片信息
     */
    private List<MtwHotelImage> images;

    /**
     *
     * 物理房型基本信息
     */
    private List<MtwHotelRealRoomBaseInfo> roomBaseInfos;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public MtwHotelBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(MtwHotelBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public MtwHotelDetailInfo getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(MtwHotelDetailInfo detailInfo) {
        this.detailInfo = detailInfo;
    }

    public List<MtwHotelTypeValue> getNotices() {
        return notices;
    }

    public void setNotices(List<MtwHotelTypeValue> notices) {
        this.notices = notices;
    }

    public MtwHotelContentPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(MtwHotelContentPolicy policy) {
        this.policy = policy;
    }

    public List<MtwHotelFacility> getFacilities() {
        return facilities;
    }
public void setFacilities(List<MtwHotelFacility> facilities) {
        this.facilities = facilities;
    }

    public List<MtwHotelImage> getImages() {
        return images;
    }

    public void setImages(List<MtwHotelImage> images) {
        this.images = images;
    }

    public List<MtwHotelRealRoomBaseInfo> getRoomBaseInfos() {
        return roomBaseInfos;
    }

    public void setRoomBaseInfos(List<MtwHotelRealRoomBaseInfo> roomBaseInfos) {
        this.roomBaseInfos = roomBaseInfos;
    }
}
