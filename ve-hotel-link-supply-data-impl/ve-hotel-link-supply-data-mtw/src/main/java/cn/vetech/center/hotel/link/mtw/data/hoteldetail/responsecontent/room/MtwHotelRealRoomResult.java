package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-03-26 14:34
 */
public class MtwHotelRealRoomResult {

    /**
     * roomContents
     */
    private List<MtwHotelRealRoomResultContent> roomContents;

    public List<MtwHotelRealRoomResultContent> getRoomContents() {
        return roomContents;
    }

    public void setRoomContents(List<MtwHotelRealRoomResultContent> roomContents) {
        this.roomContents = roomContents;
    }
}
