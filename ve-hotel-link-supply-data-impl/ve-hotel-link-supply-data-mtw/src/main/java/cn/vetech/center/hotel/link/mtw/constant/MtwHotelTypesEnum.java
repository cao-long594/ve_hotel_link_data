package cn.vetech.center.hotel.link.mtw.constant;

import cn.vetech.center.hotel.link.api.data.enums.HotelCategoryEnum;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chengwanshan
 * @since 2024/1/3 19:51
 */
public enum MtwHotelTypesEnum {
    /**
     * 1 -快捷酒店;
     */
    T_1("1", "快捷酒店", HotelCategoryEnum.EXPRESS_INN.getName(), HotelCategoryEnum.STANDARD_HOTEL.getName()),
    /**
     * 2 -商务酒店;
     */
    T_2("2", "商务酒店", HotelCategoryEnum.BUSINESS_HOTEL.getName(), HotelCategoryEnum.STANDARD_HOTEL.getName()),
    /**
     * 3 -主题酒店;
     */
    T_3("3", "主题酒店", HotelCategoryEnum.THEME_HOTEL.getName(), HotelCategoryEnum.STANDARD_HOTEL.getName()),
    /**
     * 4 -情侣酒店;
     */
    T_4("4", "情侣酒店", HotelCategoryEnum.ROMANTIC_HOTEL.getName(), HotelCategoryEnum.STANDARD_HOTEL.getName()),
    /**
     * 5 -公寓;
     */
    T_5("5", "公寓", HotelCategoryEnum.APARTMENT.getName()),
    /**
     * 6 -客栈;
     */
    T_6("6", "客栈", HotelCategoryEnum.INN.getName(), HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 7 -民宿;
     */
    T_7("7", "民宿", HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 8 -青年旅舍;
     */
    T_8("8", "青年旅舍", HotelCategoryEnum.HOTEL.getName()),
    /**
     * 9 -农家院;
     */
    T_9("9", "农家院", HotelCategoryEnum.AGRITAINMENT.getName(), HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 10-家庭旅馆;
     */
    T_10("10", "家庭旅馆", HotelCategoryEnum.HOTEL.getName()),
    /**
     * 11-招待所;
     */
    T_11("11", "招待所", HotelCategoryEnum.HOTEL.getName()),
    /**
     * 12-度假酒店;
     */
    T_12("12", "度假酒店", HotelCategoryEnum.SPECIALTY_HOTELS.getName(), HotelCategoryEnum.STANDARD_HOTEL.getName()),
    /**
     * 13-别墅;
     */
    T_13("13", "别墅", HotelCategoryEnum.VILLA.getName()),
    /**
     * 14-汽车旅馆;
     */
    T_14("14", "汽车旅馆", HotelCategoryEnum.HOTEL.getName()),
    /**
     * 15-小木屋;
     */
    T_15("15", "小木屋", HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 16-牧人小屋;
     */
    T_16("16", "牧人小屋", HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 17-山间小屋;
     */
    T_17("17", "山间小屋", HotelCategoryEnum.HOMESTAY.getName()),
    /**
     * 18-船屋;
     */
    T_18("18", "船屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 19-树屋;
     */
    T_19("19", "树屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 20-旅行车停车场;
     */
    T_20("20", "旅行车停车场", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 21-排屋;
      */
    T_21("21", "排屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 22-城堡;
     */
    T_22("22", "城堡", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 23-帐篷屋;
     */
    T_23("23", "帐篷屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 24-宫殿;
     */
    T_24("24", "宫殿", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 25-观光农业旅游;
     */
    T_25("25", "观光农业旅游", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 26-游轮;
     */
    T_26("26", "游轮", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    /**
     * 27-日式旅馆;
     */
    T_27("27", "日式旅馆", HotelCategoryEnum.RYOKAN.getName()),
    ;
    /**
     * code
     */
    private final String code;
    /**
     * name
     */
    private final String name;
    /**
     *
     */
    private final Set<String> veName;

    private MtwHotelTypesEnum(String code, String name, String veName) {
        this.code = code;
        this.name = name;
        this.veName = Sets.newHashSet(veName);
    }

    private MtwHotelTypesEnum(String code, String name, String... veName) {
        this.code = code;
        this.name = name;
        this.veName = Sets.newHashSet(veName);
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Set<String> getVeName() {
        return veName;
    }
     /**
     *
     */
    private static final Map<String, String> nameMap = new HashMap<>();
    /**
     *
     */
    private static final Map<String, Set<String>> veNameMap = new HashMap<>();

    static {
        for (MtwHotelTypesEnum categoryEnum : MtwHotelTypesEnum.values()) {
            nameMap.put(categoryEnum.code, categoryEnum.name);
            veNameMap.put(categoryEnum.code, categoryEnum.veName);
        }
    }

    public static Set<String> getVeNameByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        return veNameMap.get(code);
    }

    public static String getNameByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        return nameMap.get(code);
    }
}
