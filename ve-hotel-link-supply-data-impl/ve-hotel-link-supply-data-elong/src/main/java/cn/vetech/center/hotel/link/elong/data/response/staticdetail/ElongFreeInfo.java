package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:52
 */
public class ElongFeeInfo {
    /**
     * 设施费用类型
     * Paid：收费；Free：免费；None：未知
     */
    @JsonProperty("FeeChargeType")
    private String feeChargeType;
    /**
     * 设施费用明细
     */
    @JsonProperty("FeeDetail")
    private List<ElongFeeDetail> feeDetail;

    public String getFeeChargeType() {
        return feeChargeType;
    }

    public void setFeeChargeType(String feeChargeType) {
        this.feeChargeType = feeChargeType;
    }

    public List<ElongFeeDetail> getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(List<ElongFeeDetail> feeDetail) {
        this.feeDetail = feeDetail;
    }
}
