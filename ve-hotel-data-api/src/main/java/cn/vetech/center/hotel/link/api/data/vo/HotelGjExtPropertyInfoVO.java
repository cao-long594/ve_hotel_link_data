package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author xiaotengyu
 * @since 2023-09-02 15:22
 */
public class HotelGjExtPropertyInfoVO {

    /**
     * 类型Id
     */
    private String typeCode;
    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 名称
     */
    private String name;
    /**
     * 值 默认千米
     */
    private String value;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public HotelGjExtPropertyInfoVO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public HotelGjExtPropertyInfoVO() {
    }
}
