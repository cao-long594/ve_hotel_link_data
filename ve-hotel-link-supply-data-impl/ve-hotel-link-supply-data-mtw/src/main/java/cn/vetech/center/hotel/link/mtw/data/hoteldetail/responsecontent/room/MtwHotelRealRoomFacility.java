package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room;

/**
 * @author xiaotengyu
 * @since 2024-07-29 9:11
 */
public class MtwHotelRealRoomFacility {

    /**
     * 设施服务编号ID
     */
    private String id;

    /**
     *
     * 设施服务名称，属性中文名
     */
    private String name;

    /**
     *设施属性值
     */
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
