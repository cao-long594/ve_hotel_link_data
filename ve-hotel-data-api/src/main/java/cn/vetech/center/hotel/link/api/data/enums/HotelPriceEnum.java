package cn.vetech.center.hotel.link.api.data.enums;

/**
 * 最低价枚举
 * @author houya
 */
public enum HotelPriceEnum {


    /**
     * 现付  到店付
     */
    PAYMENT_HOTEL("0", "现付"),
    /**
     * 预付
     */
    PAYMENT_ADVANCE("1", "预付"),


    /**
     * 单人房
     */
    ROOMNAME_SINGLE("单人房", "单人房"),
    /**
     * 双床房
     */
    ROOMNAME_TWIN("双床房", "双床房"),
    /**
     * 套房
     */
    ROOMNAME_SUITE("套房", "套房"),
    /**
     * 其他
     */
    ROOMNAME_OTHER("其他", "其他"),


    /**
     * 21不可取消
     */
    CANCEL_NOT("21", "不可取消"),
    /**
     * 22限时取消
     */
    CANCEL_TIME("22", "限时取消"),
    /**
     * 23免费取消
     */
    CANCEL_FREE("23", "免费取消"),

    /**
     * 活动 无
     */
    ACTIVITY_NO("0", "无"),
    /**
     * 活动 早订优惠
     */
    ACTIVITY_EARLY("1", "早订优惠"),
    /**
     * 活动 多间优惠
     */
    ACTIVITY_MULTI("2", "多间优惠"),
    /**
     * 活动 连住优惠
     */
    ACTIVITY_LIVE("3", "连住优惠"),
    /**
     * 活动 钟点房
     */
    ACTIVITY_HOUR("4", "钟点房"),
    /**
     * 活动 其他
     */
    ACTIVITY_OTHER("9", "其他"),

    /**
     * 满房
     */
    STATUS_FULL("2", "满房"),
    /**
     * 可预订
     */
    STATUS_OK("0", "可预订"),
    /**
     * 不可预订
     */
    STATUS_NO("7", "不可预订"),
    /**
     * 不展示
     */
    STATUS_NOSEE("8", "不展示"),


    /**
     * 0无早 1单早 2 双早 3其它
     */
    BREAKFAST_NO("0", "无早"),
    /**
     * 单早
     */
    BREAKFAST_SINGLE("1", "单早"),
    /**
     * 双早
     */
    BREAKFAST_DOUBLE("2", "双早"),
    /**
     * 其它
     */
    BREAKFAST_OTHER("3", "其它"),

    /**
     * 酒店开票
     */
    //0：酒店开票；1：服务商开票
    INVOICE_HOTEL("0","酒店开票"),

    /**
     * 服务商开票
     */
    INVOICE_SUPPLER("1","服务商开票"),





    ;
    /**
     * 响应码
     */
    private final String code;

    /**
     * 提示信息
     */
    private final String message;

    private HotelPriceEnum(String code, String message) {
        this.code = code;
  }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


}
