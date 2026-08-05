package cn.vetech.center.hotel.link.api.data.vo;

import java.io.Serializable;

/**
 * @author lixuan
 * @since 2017/12/16.
 * 注意：以下2个字段为必传
 * 注意：以下2个字段为必传
 * 注意：以下2个字段为必传
 */
public class EtlHotelDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 房源商编号
     */
    private String fybh;

    /**
     * 房源商酒店id
     */
    private String fyjdid;
    /***
     * 房源简称
     */
    private String fyjc;

    /**
     *国内国际
     */
    private String gngj;

    public EtlHotelDTO() {
    }

    public EtlHotelDTO(String fybh, String fyjdid, String fyjc, String gngj) {
        this.fybh = fybh;
        this.fyjdid = fyjdid;
        this.fyjc = fyjc;
        this.gngj = gngj;
    }

    public String getFybh() {
        return fybh;
    }

    public void setFybh(String fybh) {
        this.fybh = fybh;
    }

    public String getFyjdid() {
        return fyjdid;
    }

    public void setFyjdid(String fyjdid) {
        this.fyjdid = fyjdid;
    }

    public String getFyjc() {
        return fyjc;
    }

    public void setFyjc(String fyjc) {
        this.fyjc = fyjc;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
    }
}
