package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/17 14:37
 * 加床政策
 */
public class EtlExtraBed {
    /**
     * 最多允许的加床数量
     */
    private Integer maxQuantity;
    /**
     *   加床类型
     *   1：加床；
     *   2：加婴儿床；
     *   3：加床/加婴儿床
     */
    private String extraBedType;
    /**
     * 最大加婴儿床数量
     */
    private String maxCribQuantity;

    /**
     * 费用
     */
    private List<EtlFee> fees;


    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getExtraBedType() {
        return extraBedType;
    }

    public void setExtraBedType(String extraBedType) {
        this.extraBedType = extraBedType;
    }

    public String getMaxCribQuantity() {
        return maxCribQuantity;
    }

    public void setMaxCribQuantity(String maxCribQuantity) {
        this.maxCribQuantity = maxCribQuantity;
    }

    public List<EtlFee> getFees() {
        return fees;
    }

    public void setFees(List<EtlFee> fees) {
        this.fees = fees;
    }
}
