package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:43
 */
public class MtwHotelFacilityItem {

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
