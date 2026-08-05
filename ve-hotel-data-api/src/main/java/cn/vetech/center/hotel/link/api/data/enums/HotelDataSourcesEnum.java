package cn.vetech.center.hotel.link.api.data.enums;

/**
 * @author chengwanshan
 * @since 2024/4/26 12:11
 */
public enum HotelDataSourcesEnum {

    /**
     * 通过供应商基础数据接口拉取
     */
    PULL("P", "通过供应商基础数据接口拉取"),
    /**
     * 手动拉取
     */
    HAND("H", "人工上传"),
    /**
     * 房源商通过上传接口推送
     */
    OUT_PUSH("O", "房源商通过上传接口推送"),
    ;

    /**
     * 值
     */
    private final String val;

    /**
     * 描述
     */
    private final String desc;


    HotelDataSourcesEnum(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }


    public String getDesc() {
        return desc;
    }

}
