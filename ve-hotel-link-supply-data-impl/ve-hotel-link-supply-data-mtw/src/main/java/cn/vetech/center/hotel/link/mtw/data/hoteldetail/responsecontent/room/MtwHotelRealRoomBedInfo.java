package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

/**
 * @author xiaotengyu
 * @since 2022-08-18 18:00
 */
public class MtwHotelRealRoomBedInfo {

    /**
     *
     * 如"超级大床"、"大床"等
     * 床型类型，参见《床型类型字典》
     */
    private String type;
    /**
     *
     * 如"1.5x2.0米"、"1.8x2.0米"等
     * 床型描述，参见《床型类型字典》
     */
    private String description;
    /**
     * 床数
     */
    private String count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
