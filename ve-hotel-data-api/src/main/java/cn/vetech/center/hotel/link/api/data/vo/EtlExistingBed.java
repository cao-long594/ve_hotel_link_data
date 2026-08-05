package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/17 16:14
 * 共用现有床政策
 */
public class EtlExistingBed {
    /**
     * 最多共用现有床位的儿童数
     */
    private Integer maxOccupancy;

    /**
     *  共用条件
     */
    private List<EtlLimitInfo> limitInfos;
    /**
     * 费用
     */
    private List<EtlFee> fees;

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public List<EtlLimitInfo> getLimitInfos() {
        return limitInfos;
    }

    public void setLimitInfos(List<EtlLimitInfo> limitInfos) {
        this.limitInfos = limitInfos;
    }

    public List<EtlFee> getFees() {
        return fees;
    }

    public void setFees(List<EtlFee> fees) {
        this.fees = fees;
    }
}
