package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:34
 */
public class ElongParkInfos {
    /**
     * 名称
     */
    private String title;
    /**
     * 描述
     */
    private List<String> desc;
    /**
     * 类型
     */
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
