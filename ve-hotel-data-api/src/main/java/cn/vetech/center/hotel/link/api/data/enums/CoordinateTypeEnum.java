package cn.vetech.center.hotel.link.api.data.enums;

/**
 * 坐标系类型枚举
 *
 * @author pengyefei
 * @version 1.0
 * @since 2022/10/27 15:47
 */
public enum CoordinateTypeEnum {
    BAIDU("B", "百度坐标系"),
    GOOGLE("G", "谷歌坐标系");
    /**
     * 坐标类型
     */
    private final String code;
    /**
     * 坐标名称
     */
    private final String name;

    private CoordinateTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

}
