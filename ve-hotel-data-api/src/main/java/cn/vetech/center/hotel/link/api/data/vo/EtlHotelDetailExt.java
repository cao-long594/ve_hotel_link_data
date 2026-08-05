package cn.vetech.center.hotel.link.api.data.vo;




import java.util.List;

/**
 * @author lipeng on 2019/4/16 11:28
 */
public class EtlHotelDetailExt {

    /**
     * 临近路口
     */
    private String onAddress;
    /**
     * 邮编
     */
    private String postalCode;
    /**
     * 英文地址
     */
    private String ywdz;
    /**
     * 英文简介
     */
    private String ywjj;
    /**
     * 资质证件 URL图片地址
     */
    private String zzzj;
    /**
     * 酒店网站
     */
    private String website;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 酒店的客房数量
     */
    private Integer fjsl;
    /**
     * 酒店楼层高度
     */
    private String floor;
    /**
     * 是否是在线加盟酒店，0否 1是
     */
    private String isOnlineSignUp;
    /**
     * 卖家秀正文
     */
    private List<EtlSellerShowInfo> sellerShowInfos;
    /**
     * 酒店描述
     */
    private List<EtlHDescription> descriptions;
    /**
     * 周边设施
     */
    private List<EtlHotelNear> hotelNears;
    /**
     * 酒店政策
     */
    private List<EtlHotelPolicy> hotelPolicies;
    /**
     * 可用支付方式
     */
    private List<EtlPayCard> payCards;

    /**
     * 儿童和加床政策
     */
    private EtlChildAndExtraBedPolicy childAndExtraBedPolicy;
    /**
     * 到点时间
     */
    private EtlArrivalTimeLimitInfo arrivalTimeLimitInfo;
    /**
     * 离店时间
     */
    private EtlDepartureTimeLimitInfo departureTimeLimitInfo;
    /**
     * 重要提示
     */
    private List<EtlImportantNotice> importantNotices;
    /**
     * 视频
     */
    private List<EtlVideo> videos;
    /**
     * 老板信息
     */
    private List<EtlBossInfo> bossInfos;
    /**
     * 周边交通
     */
    private List<EtlTransportationInfo> transportationInfos;
    /**
     * 适用人群，0、仅内宾  1、外宾适用（含内宾和港澳台） 2、港澳台客人适用（含内宾，除港澳台以外的外国人不适用）3、香港客人适用（含内宾，除香港以外的外国人不适用） 4、台湾客人适用（含内宾，除台湾以外的外国人不适用）  5、澳门客人适用（含内宾，除澳门以外的外国人不适用）
     */
    private String applicablePeople;

    public String getApplicablePeople() {
        return applicablePeople;
    }

    public void setApplicablePeople(String applicablePeople) {
        this.applicablePeople = applicablePeople;
    }

    public String getOnAddress() {
        return onAddress;
    }

    public void setOnAddress(String onAddress) {
        this.onAddress = onAddress;
    }

    public String getYwjj() {
        return ywjj;
    }

    public void setYwjj(String ywjj) {
        this.ywjj = ywjj;
    }

    public String getZzzj() {
        return zzzj;
    }

    public void setZzzj(String zzzj) {
        this.zzzj = zzzj;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<EtlHDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<EtlHDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<EtlHotelNear> getHotelNears() {
        return hotelNears;
    }

    public void setHotelNears(List<EtlHotelNear> hotelNears) {
        this.hotelNears = hotelNears;
    }

    public List<EtlHotelPolicy> getHotelPolicies() {
        return hotelPolicies;
    }

    public void setHotelPolicies(List<EtlHotelPolicy> hotelPolicies) {
        this.hotelPolicies = hotelPolicies;
    }

    public List<EtlPayCard> getPayCards() {
        return payCards;
    }

    public void setPayCards(List<EtlPayCard> payCards) {
        this.payCards = payCards;
    }

    public EtlChildAndExtraBedPolicy getChildAndExtraBedPolicy() {
        return childAndExtraBedPolicy;
    }

    public void setChildAndExtraBedPolicy(EtlChildAndExtraBedPolicy childAndExtraBedPolicy) {
        this.childAndExtraBedPolicy = childAndExtraBedPolicy;
    }

    
    public EtlArrivalTimeLimitInfo getArrivalTimeLimitInfo() {
        return arrivalTimeLimitInfo;
    }

    public void setArrivalTimeLimitInfo(EtlArrivalTimeLimitInfo arrivalTimeLimitInfo) {
        this.arrivalTimeLimitInfo = arrivalTimeLimitInfo;
    }

    public EtlDepartureTimeLimitInfo getDepartureTimeLimitInfo() {
        return departureTimeLimitInfo;
    }

    public void setDepartureTimeLimitInfo(EtlDepartureTimeLimitInfo departureTimeLimitInfo) {
        this.departureTimeLimitInfo = departureTimeLimitInfo;
    }

    public List<EtlImportantNotice> getImportantNotices() {
        return importantNotices;
    }

    public void setImportantNotices(List<EtlImportantNotice> importantNotices) {
        this.importantNotices = importantNotices;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getYwdz() {
        return ywdz;
    }

    public void setYwdz(String ywdz) {
        this.ywdz = ywdz;
    }

    public List<EtlVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<EtlVideo> videos) {
        this.videos = videos;
    }

    public Integer getFjsl() {
        return fjsl;
    }

    public void setFjsl(Integer fjsl) {
        this.fjsl = fjsl;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getIsOnlineSignUp() {
        return isOnlineSignUp;
    }

    public void setIsOnlineSignUp(String isOnlineSignUp) {
        this.isOnlineSignUp = isOnlineSignUp;
    }

    public List<EtlSellerShowInfo> getSellerShowInfos() {
        return sellerShowInfos;
    }

    public void setSellerShowInfos(List<EtlSellerShowInfo> sellerShowInfos) {
        this.sellerShowInfos = sellerShowInfos;
    }

  public List<EtlBossInfo> getBossInfos() {
        return bossInfos;
    }

    public void setBossInfos(List<EtlBossInfo> bossInfos) {
        this.bossInfos = bossInfos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EtlTransportationInfo> getTransportationInfos() {
        return transportationInfos;
    }

    public void setTransportationInfos(List<EtlTransportationInfo> transportationInfos) {
        this.transportationInfos = transportationInfos;
    }
}
