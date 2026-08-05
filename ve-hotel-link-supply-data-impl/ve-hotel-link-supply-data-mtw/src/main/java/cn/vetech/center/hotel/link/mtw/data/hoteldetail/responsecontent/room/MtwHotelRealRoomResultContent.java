package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelImage;

import java.util.List;
import java.util.Map;

/**
 * @author xiaotengyu
 * @since 2024-03-26 14:34
 */
public class MtwHotelRealRoomResultContent {

    /**
     * base info
     */
    private MtwHotelRealRoomBaseInfo baseInfo;
    /**
     * 图片
     */
    private List<MtwHotelImage> images;
    /**
     * 房型设施
     */
    private Map<String, MtwHotelRealRoomFacility> facilities;

    public Map<String, MtwHotelRealRoomFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Map<String, MtwHotelRealRoomFacility> facilities) {
        this.facilities = facilities;
    }

    public MtwHotelRealRoomBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(MtwHotelRealRoomBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<MtwHotelImage> getImages() {
        return images;
    }

    public void setImages(List<MtwHotelImage> images) {
        this.images = images;
    }
}
