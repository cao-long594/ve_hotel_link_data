package cn.vetech.center.hotel.link.api.data.enums;

/**
 * <p>
 * 获取酒店方式
 * </p>
 * @author wangkai
 * @since 2020/10/26
 */
public enum GetHotelMethodEnum {

    /**
     * 酒店ID
     */
    HOTEL_ID("1"),

    /**
     * 城市ID
     */
    CITY_ID("2"),;

    /**
     * 获取方式
     */
    private final String method;

   private GetHotelMethodEnum(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

}
