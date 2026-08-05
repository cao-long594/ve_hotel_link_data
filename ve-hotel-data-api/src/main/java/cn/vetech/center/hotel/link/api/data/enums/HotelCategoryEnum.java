package cn.vetech.center.hotel.link.api.data.enums;

/**
 * 注意：只处理非标准酒店，如：民宿、公寓、旅店等
 * @author chengwanshan
 * @since 2023/11/30 14:44
 */
public enum HotelCategoryEnum {
    /**
     * 酒店
     */
    STANDARD_HOTEL("酒店"),
    /**
     * 度假村
     */
    RESORT("度假村"),
    /**
     * 生态酒店
     */
    ECO_HOTEL("生态酒店"),
    /**
     * 快捷酒店
     */
    EXPRESS_INN("快捷酒店"),
    /**
     * 商务酒店
     */
    BUSINESS_HOTEL("商务酒店"),
    /**
     * 主题酒店
     */
    THEME_HOTEL("主题酒店"),
    /**
     * 浪漫之旅
     */
    ROMANTIC_HOTEL("浪漫之旅"),
    /**
     * 日式旅馆
     */
    RYOKAN("日式旅馆"),
    /**
     * 摩洛哥式酒店
     */
    MOROCCAN_STYLE_HOTELS("摩洛哥式酒店"),
    /**
     * 旅馆
     */
    HOTEL("旅馆"),
    /**
     * 公寓
     */
    APARTMENT("公寓"),
    /**
     * 酒店公寓
     */
    HOTEL_APARTMENTS("酒店公寓"),
    /**
     * 别墅
     */
    VILLA("别墅"),
    /**
     * 民宿
     */
    HOMESTAY("民宿"),
    /**
     * 客栈
     */
    INN("客栈"),
    /**
     * 农家乐
     */
    AGRITAINMENT("农家乐"),
    /**
     * 特色住宿
     */
    FEATURED_ACCOMMODATION("特色住宿"),
    /**
     * 特色酒店
     */
    SPECIALTY_HOTELS("特色酒店"),
    /**
     * 露营地
     */
    CAMPSITE("露营地"),

    ;

    private final String name;

    private HotelCategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
