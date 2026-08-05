package cn.vetech.center.hotel.link.api.data.enums;

public enum  GnGjTypeEnum {

    GN("1", "国内"),
    GJ("0", "国际");

    private final String code;
    private final String name;

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    private GnGjTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
