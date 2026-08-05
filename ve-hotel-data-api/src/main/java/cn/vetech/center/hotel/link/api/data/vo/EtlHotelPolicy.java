package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/16 11:22
 * 酒店政策
 */
public class EtlHotelPolicy {
    /**
     * 政策编码
     * CheckInCheckOut 入住离店
     * Child 儿童
     * Meal 早餐
     * Pet 宠物
     * FeeDescription  费用
     */
    private String code;
    /**
     * 政策描述
     */
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
