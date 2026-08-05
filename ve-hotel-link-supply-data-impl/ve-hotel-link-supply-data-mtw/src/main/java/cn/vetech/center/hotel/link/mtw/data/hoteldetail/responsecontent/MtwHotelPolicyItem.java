package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:33
 */
public class MtwHotelPolicyItem {
    /**
     *
     * 政策类型
     */
    private String type;
    /**
     *政策类型名称
     */
    private String value;
    /**
     *政策值
     */
    private String name;
    /**
     *政策描述信息
     */
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
