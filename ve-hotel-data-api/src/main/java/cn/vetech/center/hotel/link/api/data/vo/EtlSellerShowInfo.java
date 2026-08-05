package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/22 19:11
 * @comment
 */
public class EtlSellerShowInfo {
    /**
     * 卖家秀描述类型
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
