package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 16:00
 * @comment
 */
public class EtlAmount {
    /**
     * 此条价格的所属类型，如：原币种价、自定义币种价
     * OriginalAmount
     */
    private String type;
    /**
     * 金额
     */
    private String amount;
    /**
     * 币种
     */
    private String currency;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
