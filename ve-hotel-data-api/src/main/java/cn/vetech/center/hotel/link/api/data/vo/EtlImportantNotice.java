package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 17:13
 * 重要提示
 */
public class EtlImportantNotice {
    /**
     * 重要提示分类:City,Hotel,PPRooms,FGRooms
     */
    private String category;
    /**
     * 提示内容
     */
    private String text;
    /**
     * 生效日期
     */
    private String start;
    /**
     * 失效日期
     */
    private String end;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
