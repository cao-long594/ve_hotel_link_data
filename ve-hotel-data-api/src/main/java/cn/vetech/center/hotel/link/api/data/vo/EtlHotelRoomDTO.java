package cn.vetech.center.hotel.link.api.data.vo;



import java.util.List;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lixuan
 * @since 2017-12-19
 */

public class EtlHotelRoomDTO extends EtlHotelDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 单个房源商酒店的房型集合
     */
    private List<EtlHotelRoom> roomList;

    public List<EtlHotelRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<EtlHotelRoom> roomList) {
        this.roomList = roomList;
    }


}
