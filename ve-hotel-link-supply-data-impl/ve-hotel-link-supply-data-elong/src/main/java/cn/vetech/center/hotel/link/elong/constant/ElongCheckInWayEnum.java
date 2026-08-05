package cn.vetech.center.hotel.link.elong.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:55
 */
public enum ElongCheckInWayEnum {
    FRONTDESK("frontdesk", "请到前台领取钥匙/门卡", false),
    RECEPTION("reception", "住宿方会有专人等侯迎接", false),
    PASSWORD("password", "住宿方会提供住宿的进门密码", true),
    KEYBOX("keybox", "住宿方会将钥匙存放于隐蔽处，并会在你入住前提供详细说明", true),
    KEYHIDE("keyhide", "住宿方会将钥匙存在保管箱内，并会在你入住前提供详细说明", true),
    INSTRUCTION("instruction", "住宿方会在你入住前提供详细说明", true),
    CONTACTUS("contactus", "【注】本酒店/民宿务必提前联系，确认入住事宜，否则可能影响入住", true),
    OTHER("other", "其他", false),
    ;

    /**
     *
     */
    private final String code;
    /**
     *
     */
    private final String name;
    /**
     * 是否自助入住无前台
     */
    private final boolean sfzzrzwqt;

    private ElongCheckInWayEnum(String code, String name, boolean sfzzrzwqt) {
        this.code = code;
        this.name = name;
        this.sfzzrzwqt = sfzzrzwqt;
    }

    private static Map<String, ElongCheckInWayEnum> codeMap = new HashMap<>();

    static {
        for (ElongCheckInWayEnum wayEnum:ElongCheckInWayEnum.values()) {
            codeMap.put(wayEnum.getCode(), wayEnum);
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isSfzzrzwqt() {
        return sfzzrzwqt;
    }

    public static boolean getSfzzrzwqt(String code) {
        ElongCheckInWayEnum wayEnum = codeMap.get(code);
        if (Objects.isNull(wayEnum)) {
            return false;
        }
        return wayEnum.isSfzzrzwqt();
    }
}