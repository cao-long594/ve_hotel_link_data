package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author xiaotengyu
 * @since 2021/10/29 10:58
 */
public class HotelInfoGlobalVO {

    /**
     * 语种code
     */
    private String languageCode;

    /**
     * 房源编号
      */
    private String fybh;
    /**
     * 酒店ID
      */
    private String hotelid;
    /**
     * 酒店名称
      */
    private String jdmc;

    /**
     * 国家
     */
    private String szgj;

    /**
     * 省份
     */
    private String szsf;

    /**
     * 城市
     */
    private String szcs;

    /**
     * 地址
      */
    private String dz;
    /**
     * 简介
      */
    private String jj;
    /**
     * 特别提示
      */
    private String tbts;
    /**
     * 酒店政策列表
      */
    private String jdzclist;
    /**
     * 入住和离店政策描述
      */
    private String rzldPolicies;
    /**
     * 儿童政策
      */
    private String childPolicies;
    /**
     * 早餐政策
      */
    private String zcPolicies;
    /**
     * 宠物政策
      */
    private String petPolicies;
    /**
     * 支付方式
      */
    private String payCards;

    /**
     * 返回 结果字符串
     */
    private String hotelGlobalResponse;

    public String getHotelGlobalResponse() {
        return hotelGlobalResponse;
    }

    public void setHotelGlobalResponse(String hotelGlobalResponse) {
        this.hotelGlobalResponse = hotelGlobalResponse;
    }

    public String getSzgj() {
        return szgj;
    }

    public void setSzgj(String szgj) {
        this.szgj = szgj;
    }

    public String getSzsf() {
        return szsf;
    }

    public void setSzsf(String szsf) {
        this.szsf = szsf;
    }

    public String getSzcs() {
        return szcs;
    }

    public void setSzcs(String szcs) {
        this.szcs = szcs;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.lang