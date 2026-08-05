package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/16 11:27
 * 可用支付方式
 */
public class EtlPayCard {
    /**
     * 支付方式编号，枚举参考HotelDataPayCardEnum，用于前端展示支付方式图标
     */
    private String cardType;
    /**
     * 支付名称
     */
    private String cardName;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
