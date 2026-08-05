package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2024-06-05 14:00
 */
public class ElongFacilityFeeInfo {

    /**
     * 设施费用类型	Enum Y	Paid：收费；Free：免费；None：未知
      */
    @JsonProperty("FeeChargeType")
    private String feeChargeType;
    /**
     * 设施费用明细	FeeDetail[]	Y
      */
    @JsonProperty("FeeDetail")
    private List<ElongFacilityFeeDetail> feeDetail;

    public String getFeeChargeType() {
        return feeChargeType;
    }

    public void setFeeChargeType(String feeChargeType) {
        this.feeChargeType = feeChargeType;
    }

    public List<ElongFacilityFeeDetail> getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(List<ElongFacilityFeeDetail> feeDetail) {
        this.feeDetail = feeDetail;
    }
}
