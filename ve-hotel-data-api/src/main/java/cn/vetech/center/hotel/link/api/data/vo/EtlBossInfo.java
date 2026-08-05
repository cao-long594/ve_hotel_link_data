package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/22 11:06
 * @comment
 */
public class EtlBossInfo {
    /**
     * 籍贯省份ID
     */
    private String provinceID;
    /**
     * 籍贯省份名称
     */
    private String provinceName;
    /**
     * 描述正文
     */
    private String text;
    /**
     * 老板名字
     */
    private String name;

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
