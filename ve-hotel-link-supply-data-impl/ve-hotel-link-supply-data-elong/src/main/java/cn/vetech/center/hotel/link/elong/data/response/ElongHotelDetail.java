package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 艺龙酒店祥
 *
 * @author gaojin
 */
@XmlRootElement(name = "Detail")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongHotelDetail implements Serializable {
    /**
     * ID
     */
    @XmlTransient
    private String hotelid;
    /**
     * 名称
     */
    @XmlElement(name = "Name")
    private String name;
    /**
     * 地址
     */
    @XmlElement(name = "Address")
    private String address;
    /**
     * 邮编
     */
    @XmlElement(name = "PostalCode")
    private String postalcode;
    /**
     * 挂牌星级
     */
    @XmlElement(name = "StarRate")
    private String starrate;
    /**
     * 艺龙推荐星级
     */
    @XmlElement(name = "Category")
    private String category;
    /**
     * 电话
     */
    @XmlElement(name = "Phone")
    private String phone;
    /**
     * 传真
     */
    @XmlElement(name = "Fax")
    private String fax;
    /**
     * 开业时间。年-月。“1900-01”表示无值
     */
    @XmlElement(name = "EstablishmentDate")
    private String establishmentdate;
    /**
     * 装修时间。年-月。“1900-01”表示无值
     */
    @XmlElement(name = "RenovationDate")
    private String renovationdate;
    /**
     * 集团编号
     */
    @XmlElement(name = "GroupId")
    private String groupid;
    /**
     * 品牌编号。参考品牌数据
     */
    @XmlElement(name = "BrandId")
    private String brandid;
    /**
     * 是否经济型
     */
    @XmlElement(name = "IsEconomic")
    private String iseconomic;
    /**
     * 是否是公寓
     */
    @XmlElement(name = "IsApartment")
    private String isapartment;
    /**
     * Google经纬度
     */
    @XmlElement(name = "GoogleLat")
    private String googlelat;
    /**
     * Google经纬度
     */
    @XmlElement(name = "GoogleLon")
    private String googlelon;
    /**
     * 百度纬度
     */
    @XmlElement(name = "BaiduLat")
    private String baidulat;
      /**
     * 百度经度
     */
    @XmlElement(name = "BaiduLon")
    private String baidulon;
    /**
     * 城市
     */
    @XmlElement(name = "CityId")
    private String cityid;
    /**
     * 关联城市
     */
    @XmlElement(name = "CityId2")
    private String cityid2;
    /**
     * 行政区
     */
    @XmlElement(name = "District")
    private String district;
    /**
     * 主商圈
     */
    @XmlElement(name = "BusinessZone")
    private String businesszone;
    /**
     * 附属商圈
     */
    @XmlElement(name = "BusinessZone2")
    private String businesszone2;
    /**
     * 酒店支持的信用卡
     */
    @XmlElement(name = "CreditCards")
    private String creditcards;
    /**
     * 介绍信息
     */
    @XmlElement(name = "IntroEditor")
    private String introeditor;
    /**
     * 描述
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 接机服务
     */
    @XmlElement(name = "AirportPickUpService")
    private String airportpickupservice;
    /**
     * 服务设施
     */
    @XmlElement(name = "GeneralAmenities")
    private String generalamenities;
    /**
     * 房间设施
     */
    @XmlElement(name = "RoomAmenities")
    private String roomamenities;
    /**
     * 休闲设施
     */
    @XmlElement(name = "RecreationAmenities")
    private String recreationamenities;
    /**
     * 会议设施
     */
    @XmlElement(name = "ConferenceAmenities")
    private String conferenceamenities;
    /**
     * 餐饮设施
     */
    @XmlElement(name = "DiningAmenities")
    private String diningAmenities;
    /**
     * 周边交通
     */
    @XmlElement(name = "Traffic")
    private String traffic;
     /**
     * 周边信息
     */
    @XmlElement(name = "Surroundings")
    private String surroundings;
    /**
     * 特色信息
     */
    @XmlElement(name = "Features")
    private String features;
    /**
     *
     */
    @XmlElement(name = "Facilities")
    private String facilities;
    /**
     * 酒店服务指数
     */
    @XmlElement(name = "ServiceRank")
    private ElongServiceRank servicerank;
    /**
     * 是否允许返现
     */
    @XmlElement(name = "HasCoupon")
    private String hascoupon;
    /**
     * 服务设施
     */
    @XmlElement(name = "FacilitiesV2")
    private ElongFacilitiesV2 facilitiesV2;
    /**
     * 逗号分隔的数字； 具体数字对应的属性
     */
    @XmlElement(name = "Themes")
    private String themes;
    /**
     * 客房总数量
     */
    @XmlElement(name = "RoomTotalAmount")
    private String roomtotalamount;
    /**
     * 为空默认为OPEN。OPEN: 可以销售；CLOSE: 已经关闭。
     */
    @XmlElement(name = "HotelStatus")
    private String hotelstatus;

     public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getStarrate() {
        return starrate;
    }

    public void setStarrate(String starrate) {
        this.starrate = starrate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(String establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    public String getRenovationdate() {
        return renovationdate;
    }

    public void setRenovationdate(String renovationdate) {
        this.renovationdate = renovationdate;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

  public String getIseconomic() {
        return iseconomic;
    }

    public void setIseconomic(String iseconomic) {
        this.iseconomic = iseconomic;
    }

    public String getIsapartment() {
        return isapartment;
    }

    public void setIsapartment(String isapartment) {
        this.isapartment = isapartment;
    }

    public String getGooglelat() {
        return googlelat;
    }

    public void setGooglelat(String googlelat) {
        this.googlelat = googlelat;
    }

    public String getGooglelon() {
        return googlelon;
    }

    public void setGooglelon(String googlelon) {
        this.googlelon = googlelon;
    }

    public String getBaidulat() {
        return baidulat;
    }

    public void setBaidulat(String baidulat) {
        this.baidulat = baidulat;
    }

    public String getBaidulon() {
        return baidulon;
    }

    public void setBaidulon(String baidulon) {
        this.baidulon = baidulon;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCityid2() {
        return cityid2;
    }

    public void setCityid2(String cityid2) {
        this.cityid2 = cityid2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBusinesszone() {
        return businesszone;
    }

    public void setBusinesszone(String businesszone) {
        this.businesszone = businesszone;
    }

    public String getBusinesszone2() {
        return businesszone2;
    }

    public void setBusinesszone2(String businesszone2) {
        this.businesszone2 = businesszone2;
    }

    public String getCreditcards() {
        return creditcards;
    }
   public void setCreditcards(String creditcards) {
        this.creditcards = creditcards;
    }

    public String getIntroeditor() {
        return introeditor;
    }

    public void setIntroeditor(String introeditor) {
        this.introeditor = introeditor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAirportpickupservice() {
        return airportpickupservice;
    }

    public void setAirportpickupservice(String airportpickupservice) {
        this.airportpickupservice = airportpickupservice;
    }

    public String getGeneralamenities() {
        return generalamenities;
    }

    public void setGeneralamenities(String generalamenities) {
        this.generalamenities = generalamenities;
    }

    public String getRoomamenities() {
        return roomamenities;
    }

    public void setRoomamenities(String roomamenities) {
        this.roomamenities = roomamenities;
    }

    public String getRecreationamenities() {
        return recreationamenities;
    }

    public void setRecreationamenities(String recreationamenities) {
        this.recreationamenities = recreationamenities;
    }

    public String getConferenceamenities() {
        return conferenceamenities;
    }

    public void setConferenceamenities(String conferenceamenities) {
        this.conferenceamenities = conferenceamenities;
    }

    public String getDiningAmenities() {
        return diningAmenities;
    }

    public void setDiningAmenities(String diningAmenities) {
        this.diningAmenities = diningAmenities;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getSurroundings() {
        return surroundings;
    }

    public void setSurroundings(String surroundings) {
        this.surroundings = surroundings;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFacilities() {
        return facilities;
    }

  public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public ElongServiceRank getServicerank() {
        return servicerank;
    }

    public void setServicerank(ElongServiceRank servicerank) {
        this.servicerank = servicerank;
    }

    public String getHascoupon() {
        return hascoupon;
    }

    public void setHascoupon(String hascoupon) {
        this.hascoupon = hascoupon;
    }

    public ElongFacilitiesV2 getFacilitiesV2() {
        return facilitiesV2;
    }

    public void setFacilitiesV2(ElongFacilitiesV2 facilitiesV2) {
        this.facilitiesV2 = facilitiesV2;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getRoomtotalamount() {
        return roomtotalamount;
    }

    public void setRoomtotalamount(String roomtotalamount) {
        this.roomtotalamount = roomtotalamount;
    }

    public String getHotelstatus() {
        return hotelstatus;
    }

    public void setHotelstatus(String hotelstatus) {
        this.hotelstatus = hotelstatus;
    }
}
