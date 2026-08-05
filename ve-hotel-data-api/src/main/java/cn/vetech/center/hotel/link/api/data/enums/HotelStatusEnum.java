package cn.vetech.center.hotel.link.api.data.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 酒店使用状态枚举
 * </p>
 *
 * @author wangkai
 * @since 2020/10/26
 */
public enum HotelStatusEnum {
    /**
     * 可用
     */
    AVAILABLE("1"),
    /**
     * 不可用
     */
    DISABLE("0"),
    ;

    /**
     * 使用状态
     */
    private final String value;

    private HotelStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



    /**
     * 根据value 获取enum
     * @param value value
     * @return enum
     */
    public static HotelStatusEnum getByValue(String value) {
        if (StringUtils.isBlank(value)) {
            return HotelStatusEnum.AVAILABLE;
        }
        for (HotelStatusEnum hotelStatusEnum : HotelStatusEnum.values()) {
            if (StringUtils.equalsIgnoreCase(value, hotelStatusEnum.getValue())) {
                return hotelStatusEnum;
            }
        }
        return HotelStatusEnum.AVAILABLE;
    }
}
