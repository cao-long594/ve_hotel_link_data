package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/17 13:58
 * @comment 儿童政策
 */
public class EtlChildAndExtraBedPolicy {
    /**
     * 是否可携带儿童入住
     */
    private Boolean allowChildrenToStay;
    /**
     * 儿童是否可使用现有床位
     */
    private Boolean allowUseExistingBed;
    /**
     * 是否提供加床
     */
    private Boolean allowExtraBed;
    /**
     * 是否提供加婴儿床
     */
    private Boolean allowExtraCrib;
    /**
     * 描述
     */
    private List<EtlDescription> descriptions;
    /**
     * 加床政策
     */
    private EtlExtraBed extraBed;
    /**
     * 共用现有床政策
     */
    private EtlExistingBed existingBed;


    public Boolean getAllowChildrenToStay() {
        return allowChildrenToStay;
    }

    public void setAllowChildrenToStay(Boolean allowChildrenToStay) {
        this.allowChildrenToStay = allowChildrenToStay;
    }

    public Boolean getAllowUseExistingBed() {
        return allowUseExistingBed;
    }

    public void setAllowUseExistingBed(Boolean allowUseExistingBed) {
        this.allowUseExistingBed = allowUseExistingBed;
    }

    public Boolean getAllowExtraBed() {
        return allowExtraBed;
    }

    public void setAllowExtraBed(Boolean allowExtraBed) {
        this.allowExtraBed = allowExtraBed;
    }

    public Boolean getAllowExtraCrib() {
        return allowExtraCrib;
    }

    public void setAllowExtraCrib(Boolean allowExtraCrib) {
        this.allowExtraCrib = allowExtraCrib;
    }

    public List<EtlDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<EtlDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public EtlExtraBed getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(EtlExtraBed extraBed) {
        this.extraBed = extraBed;
    }

   public EtlExistingBed getExistingBed() {
        return existingBed;
    }

    public void setExistingBed(EtlExistingBed existingBed) {
        this.existingBed = existingBed;
    }
}
