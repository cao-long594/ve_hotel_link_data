package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 14:32
 * @comment
 */
public class EtlHDescription {
    /**
     * 酒店描述类型代码：1-简短描述；2-长篇描述
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
