package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 14:32
 * @comment
 */
public class EtlDescription {
    /**
     * 类别
     * SpecialTips 特别提示
     * ChildStayNotice 儿童提示
     */
    private String category;
    /**
     *  文本
     */
    private String text;

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
}
