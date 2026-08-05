package cn.vetech.center.hotel.link.mtw.constant;

import cn.vetech.center.hotel.link.enums.HotelWindowTypeEnum;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 美团窗户不利因素
 *
 * @author xiaotengyu
 * @since 2021/4/13 10:22
 */

public enum MtwWindowBadEnum {

    WB0("0", "朝向走廊", HotelWindowTypeEnum.CXZL),
    WB1("1", "装饰性假窗", HotelWindowTypeEnum.ZSXJC),
    WB2("2", "天窗", HotelWindowTypeEnum.TC),
    WB3("3", "窗户较小", HotelWindowTypeEnum.CHJX),
    WB4("4", "窗外是墙体", HotelWindowTypeEnum.CWSQT),
    WB5("5", "有窗但不能打开通风", HotelWindowTypeEnum.CLOSED_WIN),
    // 注意：1w下单接口中窗户未处理，等1w更新完成后，这里再放开
//    WB6("6", "飘窗", HotelWindowTypeEnum.BAY_WINDOW),
    WB7("7", "窗户位于走廊或过道", HotelWindowTypeEnum.CXZL),
//    WB8("8", "窗户可打开通风，且窗外是开放的户外环境", null),
//    WB9("9", "落地窗", HotelWindowTypeEnum.FRENCH_WINDOW),
//    WB10("10", "阁楼窗", null),

    ;

    private MtwWindowBadEnum(String code, String name, HotelWindowTypeEnum windowTypeEnum) {
        this.code = code;
        this.name = name;
        this.windowTypeEnum = windowTypeEnum;
    }

    private final String code;
    private final String name;
    private final HotelWindowTypeEnum windowTypeEnum;

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    public HotelWindowTypeEnum getWindowTypeEnum() {
        return windowTypeEnum;
    }

    private final static Map<String, HotelWindowTypeEnum> WINDOW_TYPE_ENUM_MAP = new HashMap<>();

    static {
        for (MtwWindowBadEnum windowBadEnum : MtwWindowBadEnum.values()) {
            WINDOW_TYPE_ENUM_MAP.put(windowBadEnum.getCode(), windowBadEnum.getWindowTypeEnum());
        }
    }
    /**
     * 获取bycode
     *
     * @param code code
     * @return op
     */
    public static Optional<HotelWindowTypeEnum> getByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return Optional.empty();
        }
        return Arrays.stream(HotelWindowTypeEnum.values())
                .filter(window -> StringUtils.equalsIgnoreCase(window.getBh(), code))
                .findFirst();
    }

    /**
     * 获取窗户不利因素
     *
     * @param codes codes
     * @return list
     */
    public static List<HotelWindowTypeEnum> toVeWindowType(String[] codes) {
        if (ArrayUtils.isEmpty(codes)) {
            return Collections.emptyList();
        }
        return Arrays.stream(codes)
                .map(WINDOW_TYPE_ENUM_MAP::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

