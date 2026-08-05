package cn.vetech.center.hotel.link.elong.constant;

import cn.vetech.center.hotel.link.api.constant.SymbolConstant;
import cn.vetech.center.hotel.link.api.data.enums.HotelCategoryEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengwanshan
 * @since 2024/1/4 16:03
 */
public enum ElongHotelTypeEnum {
    HT_679("679", "酒店", HotelCategoryEnum.STANDARD_HOTEL.getName()),
    HT_680("680", "公寓", HotelCategoryEnum.APARTMENT.getName()),
    HT_681("681", "客栈/民宿", HotelCategoryEnum.HOMESTAY.getName()),
    HT_682("682", "农家乐", StringUtils.joinWith(SymbolConstant.COMMA, HotelCategoryEnum.AGRITAINMENT.getName(), HotelCategoryEnum.HOMESTAY.getName())),
    HT_1303("1303", "特色住宿", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1304("1304", "青年旅舍", HotelCategoryEnum.HOTEL.getName()),
    HT_1305("1305", "别墅", HotelCategoryEnum.VILLA.getName()),
    HT_1306("1306", "客栈", StringUtils.joinWith(SymbolConstant.COMMA, HotelCategoryEnum.INN.getName(), HotelCategoryEnum.HOMESTAY.getName())),
    HT_1403("1403", "连锁酒店", null),
    HT_1404("1404", "休闲度假", HotelCategoryEnum.SPECIALTY_HOTELS.getName()),
    HT_1405("1405", "住宿加早餐旅馆", HotelCategoryEnum.HOTEL.getName()),
    HT_1406("1406", "旅舍", HotelCategoryEnum.HOTEL.getName()),
    HT_1407("1407", "汽车旅馆", HotelCategoryEnum.HOTEL.getName()),
    HT_1408("1408", "特色小屋", HotelCategoryEnum.HOMESTAY.getName()),
    HT_1409("1409", "排屋", HotelCategoryEnum.HOMESTAY.getName()),
    HT_1410("1410", "日式旅店", HotelCategoryEnum.RYOKAN.getName()),
    HT_1411("1411", "摩洛哥特色旅馆", HotelCategoryEnum.MOROCCAN_STYLE_HOTELS.getName()),
    HT_1412("1412", "Safari/帐篷屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1413("1413", "船屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1414("1414", "游轮", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1415("1415", "城堡", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1416("1416", "宫殿", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName()),
    HT_1417("1417", "树屋", HotelCategoryEnum.FEATURED_ACCOMMODATION.getName())
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
    private final String veName;

    private ElongHotelTypeEnum(String code, String name, String veName) {
        this.code = code;
        this.name = name;
        this.veName = veName;
    }
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getVeName() {
        return veName;
    }

    /**
     *
     */
    private static final Map<String, String> nameMap = new HashMap<>();
    /**
     *
     */
    private static final Map<String, String> veNameMap = new HashMap<>();

    static {
        for (ElongHotelTypeEnum categoryEnum : ElongHotelTypeEnum.values()) {
            nameMap.put(categoryEnum.code, categoryEnum.name);
            veNameMap.put(categoryEnum.code, categoryEnum.veName);
        }
    }

    public static String getVeNameByCode(String code) {
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
