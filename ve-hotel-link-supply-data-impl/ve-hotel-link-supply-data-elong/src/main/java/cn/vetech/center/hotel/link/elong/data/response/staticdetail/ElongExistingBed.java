package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import cn.vetech.center.hotel.link.elong.data.response.Tel;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:18
 */
public class ElongDetailInfo {

    /***
     * 酒店ID
     */
    @JsonProperty("HotelId")
    private String hotelId;
    /***
     * 酒店中文名称
     */
    @JsonProperty("HotelName")
    private String hotelName;
    /***
     * 酒店英文名称
     */
    @JsonProperty("HotelNameEn")
    private String hotelNameEn;
    /***
     * 酒店状态
     */
    @JsonProperty("HotelStatus")
    private String hotelStatus;
    /***
     * 酒店中文曾用名
     */
    @JsonProperty("HotelUsedName")
    private String hotelUsedName;
    /***
     * 酒店英文曾用名
     */
    @JsonProperty("HotelUsedNameEn")
    private String hotelUsedNameEn;
    /***
     * 酒店当地中文名
     */
    @JsonProperty("HotelNameLocal")
    private String hotelNameLocal;
    /***
     * 酒店当地英文名
     */
    @JsonProperty("HotelNameLocalEn")
    private String hotelNameLocalEn;
    /***
     * 酒店中文简称
     */
    @JsonProperty("ShortName")
    private String shortName;
    /***
     * 酒店英文简称
     */
    @JsonProperty("ShortNameEn")
    private String shortNameEn;
    /***
     * 酒店中文地址
     */
    @JsonProperty("Address")
    private String address;
    /***
     * 酒店英文地址
     */
    @JsonProperty("AddressEn")
    private String addressEn;
    /***
     * 邮编
     */
    @JsonProperty("PostalCode")
    private String postalCode;
    /***
     * 挂牌星级
     */
    @JsonProperty("StarRate")
    private String starRate;
    /***
     * 艺龙推荐星级
     */
    @JsonProperty("Category")
    private String category;
    /***
     * 电话
     */
    @JsonProperty("Phone")
    private String phone;
    /***
     * 传真
     */
    @JsonProperty("Fax")
    private String fax;
     /***
     * 酒店邮箱地址
     */
    @JsonProperty("Email")
    private String email;
    /***
     * 酒店时区
     */
    @JsonProperty("Timezone")
    private String timezone;
    /***
     * 营业执照
     */
    @JsonProperty("Licenses")
    private List<String> licenses;
    /***
     * 开业时间
     */
    @JsonProperty("EstablishmentDate")
    private String establishmentDate;
    /***
     * 装修时间
     */
    @JsonProperty("RenovationDate")
    private String renovationDate;
    /***
     * 集团编号
     */
    @JsonProperty("GroupId")
    private String groupId;
    /***
     * 集团中文名称
     */
    @JsonProperty("GroupName")
    private String groupName;
    /***
     * 集团英文名称
     */
    @JsonProperty("GroupNameEn")
    private String groupNameEn;
    /***
     * 品牌编号
     */
    @JsonProperty("BrandId")
    private String brandId;
    /***
     * 品牌中文名称
     */
    @JsonProperty("BrandName")
    private String brandName;
    /***
     * 品牌英文名称
     */
    @JsonProperty("BrandNameEn")
    private String brandNameEn;
    /***
     * 是否经济型
     */
    @JsonProperty("IsEconomic")
    private String isEconomic;
    /***
     * 是否是公寓
     */
    @JsonProperty("IsApartment")
     private String isApartment;
    /***
     * 酒店入住的最早时间，例如14:00表示酒店在入住日当天14:00之后允许客人入住
     */
    @JsonProperty("ArrivalTime")
    private String arrivalTime;
    /***
     * 酒店离店的最晚时间，例如12:00表示客人必须在离店日当天12:00之前离店
     */
    @JsonProperty("DepartureTime")
    private String departureTime;
    /***
     * Google纬度
     */
    @JsonProperty("GoogleLat")
    private BigDecimal googleLat;
    /***
     * Google经度
     */
    @JsonProperty("GoogleLon")
    private BigDecimal googleLon;
    /***
     * Baidu纬度
     */
    @JsonProperty("BaiduLat")
    private BigDecimal baiduLat;
    /***
     * Baidu经度
     */
    @JsonProperty("BaiduLon")
    private BigDecimal baiduLon;
    /***
     * 国家Id
     */
    @JsonProperty("CountryId")
    private String countryId;
    /***
     * 国家中文名
     */
    @JsonProperty("CountryName")
    private String countryName;
    /***
     * 国家英文名
     */
    @JsonProperty("CountryNameEn")
    private String countryNameEn;
    /***
     * 主城市Id
     */
    @JsonProperty("CityId")
    private String cityId;
     /***
     * 城市中文名
     */
    @JsonProperty("CityName")
    private String cityName;
    /***
     * 城市英文名
     */
    @JsonProperty("CityNameEn")
    private String cityNameEn;
    /***
     * 关联城市
     */
    @JsonProperty("CityId2")
    private String cityId2;
    /***
     * 行政区Id
     */
    @JsonProperty("District")
    private String district;
    /***
     * 行政区中文名称
     */
    @JsonProperty("DistrictName")
    private String districtName;
    /***
     * 行政区英文名称
     */
    @JsonProperty("DistrictNameEn")
    private String districtNameEn;
    /***
     * 主商圈Id
     */
    @JsonProperty("BusinessZone")
    private String businessZone;
    /***
     * 主商圈中文名称
     */
    @JsonProperty("BusinessZoneName")
    private String businessZoneName;
    /***
     * 主商圈英文名称
     */
    @JsonProperty("BusinessZoneNameEn")
    private String businessZoneNameEn;
    /***
     * 附属商圈Id
     */
    @JsonProperty("BusinessZone2")
    private String businessZone2;
    /***
     * 附属商圈中文名
     */
    @JsonProperty("BusinessZone2Name")
    private String businessZone2Name;
    /***
     * 附属商圈英文名
     */
    @JsonProperty("BusinessZone2NameEn")
    private String businessZone2NameEn;
    /***
     * 酒店支持的信用卡
     */
    @JsonProperty("CreditCards")
    private String creditCards;
    /***
     * 酒店支持的信用卡英文
     */
    @JsonProperty("CreditCardsEn")
    private String creditCardsEn;
    /***
     * 酒店中文简介
     */
    @JsonProperty("IntroEditor")
    private String introEditor;
    /***
     * 英文简介
     */
    @JsonProperty("IntroEditorEn")
    private String introEditorEn;
    /***
     * 中文描述
     */
    @JsonProperty("Description")
    private String description;
    /***
     * 英文描述
     */
    @JsonProperty("DescriptionEn")
    private String descriptionEn;
    /***
     * 中文接机服务
     */
    @JsonProperty("AirportPickUpService")
    private String airportPickUpService;
    /***
     * 英文接机服务
     */
    @JsonProperty("AirportPickUpServiceEn")
    private String airportPickUpServiceEn;
    /***
     * 中文周边交通
     */
    @JsonProperty("Traffic")
    private String traffic;
    /***
     * 英文周边交通
     */
    @JsonProperty("TrafficEn")
    private String trafficEn;
    /***
     * 中文周边信息
     */
    @JsonProperty("Surroundings")
    private String surroundings;
    /***
     * 英文周边信息
     */
    @JsonProperty("SurroundingsEn")
    private String surroundingsEn;
    /***
     * 中文特色信息
     */
    @JsonProperty("Features")
    private String features;
    /***
     * 英文特色信息
     */
    @JsonProperty("FeaturesEn")
    private String featuresEn;
    /***
     * 酒店基础施列表
     */
    @JsonProperty("GeneralFacilities")
    private List<ElongFacilityInfo> generalFacilities;
    /***
     * 酒店休闲设施列表
     */
    @JsonProperty("RecreationFacilities")
    private List<ElongFacilityInfo> recreationFacilities;
    /***
     * 酒店服务设施列表
     */
    @JsonProperty("ServiceFacilities")
    private List<ElongFacilityInfo> serviceFacilities;
    /***
     * 预订须知列表
     */
    @JsonProperty("BookingNoticeFacilities")
    private List<ElongFacilityInfo> bookingNoticeFacilities;
    /***
     * 是否允许返现
     */
    @JsonProperty("HasCoupon")
    private String hasCoupon;
    /***
     * 酒店主题列表
     */
    @JsonProperty("Themes")
    private List<ElongThemeInfo> themes;
    /***
     * 客房总数量
     */
    @JsonProperty("RoomTotalAmount")
    private String roomTotalAmount;
     /***
     * 酒店类型
     */
    @JsonProperty("HotelTypes")
    private List<ElongHotelTypeInfo> hotelTypes;
    /***
     * 酒店服务指数
     */
    @JsonProperty("ServiceRank")
    private ElongServiceRankInfo serviceRank;
    /**
     * 停车信息
     */
    @JsonProperty("ParkInfos")
    private List<ElongParkInfos> parkInfos;
    /***
     * 电话信息
     */
    @JsonProperty("TelList")
    private List<Tel> telList;
    /**
     * 宠物政策
     */
    @JsonProperty("PetPolicy")
    private String petPolicy;
    /**
     * 新预定政策
     */
    @JsonProperty("Notices")
    private List<ElongNotices> notices;
    /**
     * 押金政策
     */
    @JsonProperty("DepositPolicy")
    private ElongDepositPolicy depositPolicy;
    /**
     * 入住方式
     */
    @JsonProperty("CheckinPolicies")
    private List<ElongCheckinPolicies> checkinPolicies;
    /**
     * 住宿规定
     */
    @JsonProperty("StayPolicy")
    private ElongStayPolicy stayPolicy;
    /**
     * 新V2设施
     */
    @JsonProperty("FacilityV2")
    private List<ElongFacilityV2> facilityV2;
    /**
     * 临时歇业
     */
    @JsonProperty("HotelCloseTimes")
    private List<ElongHotelCloseTimes> hotelCloseTimes;
    /**
     * 酒店标签
     * 酒店标签Id，可请求hotel.dictionary接口获取字典
     */
    @JsonProperty("HotelTags")
    private List<String> hotelTags;
    /**
     * 儿童政策
     */
    @JsonProperty("ChildPolicy")
    private ElongChildPolicy childPolicy;

    public List<ElongParkInfos> getParkInfos() {
        return parkInfos;
    }

    public void setParkInfos(List<ElongParkInfos> parkInfos) {
        this.parkInfos = parkInfos;
    }

    public String getPetPolicy() {
        return petPolicy;
    }

    public void setPetPolicy(String petPolicy) {
        this.petPolicy = petPolicy;
    }

    public List<ElongNotices> getNotices() {
        return notices;
    }

    public void setNotices(List<ElongNotices> notices) {
        this.notices = notices;
    }

    public ElongDepositPolicy getDepositPolicy() {
        return depositPolicy;
    }

    public void setDepositPolicy(ElongDepositPolicy depositPolicy) {
        this.depositPolicy = depositPolicy;
    }

    public List<ElongCheckinPolicies> getCheckinPolicies() {
        return checkinPolicies;
    }

    public void setCheckinPolicies(List<ElongCheckinPolicies> checkinPolicies) {
        this.checkinPolicies = checkinPolicies;
    }
public ElongStayPolicy getStayPolicy() {
        return stayPolicy;
    }

    public void setStayPolicy(ElongStayPolicy stayPolicy) {
        this.stayPolicy = stayPolicy;
    }

    public List<ElongFacilityV2> getFacilityV2() {
        return facilityV2;
    }

    public void setFacilityV2(List<ElongFacilityV2> facilityV2) {
        this.facilityV2 = facilityV2;
    }

    public List<ElongHotelCloseTimes> getHotelCloseTimes() {
        return hotelCloseTimes;
    }

    public void setHotelCloseTimes(List<ElongHotelCloseTimes> hotelCloseTimes) {
        this.hotelCloseTimes = hotelCloseTimes;
    }

    public List<String> getHotelTags() {
        return hotelTags;
    }

    public void setHotelTags(List<String> hotelTags) {
        this.hotelTags = hotelTags;
    }

    public ElongChildPolicy getChildPolicy() {
        return childPolicy;
    }

    public void setChildPolicy(ElongChildPolicy childPolicy) {
        this.childPolicy = childPolicy;
    }

    public List<Tel> getTelList() {
        return telList;
    }

    public void setTelList(List<Tel> telList) {
        this.telList = telList;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String getHotelUsedName() {
        return hotelUsedName;
    }

    public void setHotelUsedName(String hotelUsedName) {
        this.hotelUsedName = hotelUsedName;
    }

    public String getHotelUsedNameEn() {
        return hotelUsedNameEn;
    }

    public void setHotelUsedNameEn(String hotelUsedNameEn) {
        this.hotelUsedNameEn = hotelUsedNameEn;
    }

    public String getHotelNameLocal() {
        return hotelNameLocal;
    }

    public void setHotelNameLocal(String hotelNameLocal) {
        this.hotelNameLocal = hotelNameLocal;
    }

    public String getHotelNameLocalEn() {
        return hotelNameLocalEn;
    }

    public void setHotelNameLocalEn(String hotelNameLocalEn) {
        this.hotelNameLocalEn = hotelNameLocalEn;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortNameEn() {
        return shortNameEn;
    }

    public void setShortNameEn(String shortNameEn) {
        this.shortNameEn = shortNameEn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

 public String getStarRate() {
        return starRate;
    }

    public void setStarRate(String starRate) {
        this.starRate = starRate;
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
public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<String> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<String> licenses) {
        this.licenses = licenses;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getRenovationDate() {
        return renovationDate;
    }

    public void setRenovationDate(String renovationDate) {
        this.renovationDate = renovationDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupNameEn() {
        return groupNameEn;
    }

    public void setGroupNameEn(String groupNameEn) {
        this.groupNameEn = groupNameEn;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameEn() {
        return brandNameEn;
    }

 public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn;
    }

    public String getIsEconomic() {
        return isEconomic;
    }

    public void setIsEconomic(String isEconomic) {
        this.isEconomic = isEconomic;
    }

    public String getIsApartment() {
        return isApartment;
    }

    public void setIsApartment(String isApartment) {
        this.isApartment = isApartment;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public BigDecimal getGoogleLat() {
        return googleLat;
    }

    public void setGoogleLat(BigDecimal googleLat) {
        this.googleLat = googleLat;
    }

    public BigDecimal getGoogleLon() {
        return googleLon;
    }
     public void setGoogleLon(BigDecimal googleLon) {
        this.googleLon = googleLon;
    }

    public BigDecimal getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(BigDecimal baiduLat) {
        this.baiduLat = baiduLat;
    }

    public BigDecimal getBaiduLon() {
        return baiduLon;
    }

    public void setBaiduLon(BigDecimal baiduLon) {
        this.baiduLon = baiduLon;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public String getCityId2() {
        return cityId2;
    }

    public void setCityId2(String cityId2) {
        this.cityId2 = cityId2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictNameEn() {
        return districtNameEn;
    }

    public void setDistrictNameEn(String districtNameEn) {
        this.districtNameEn = districtNameEn;
    }

    public String getBusinessZone() {
        return businessZone;
    }

    public void setBusinessZone(String businessZone) {
        this.businessZone = businessZone;
    }

    public String getBusinessZoneName() {
        return businessZoneName;
    }
      public void setBusinessZoneName(String businessZoneName) {
        this.businessZoneName = businessZoneName;
    }

    public String getBusinessZoneNameEn() {
        return businessZoneNameEn;
    }

    public void setBusinessZoneNameEn(String businessZoneNameEn) {
        this.businessZoneNameEn = businessZoneNameEn;
    }

    public String getBusinessZone2() {
        return businessZone2;
    }

    public void setBusinessZone2(String businessZone2) {
        this.businessZone2 = businessZone2;
    }

    public String getBusinessZone2Name() {
        return businessZone2Name;
    }

    public void setBusinessZone2Name(String businessZone2Name) {
        this.businessZone2Name = businessZone2Name;
    }

    public String getBusinessZone2NameEn() {
        return businessZone2NameEn;
    }

    public void setBusinessZone2NameEn(String businessZone2NameEn) {
        this.businessZone2NameEn = businessZone2NameEn;
    }

    public String getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(String creditCards) {
        this.creditCards = creditCards;
    }

    public String getCreditCardsEn() {
        return creditCardsEn;
    }

    public void setCreditCardsEn(String creditCardsEn) {
        this.creditCardsEn = creditCardsEn;
    }

    public String getIntroEditor() {
        return introEditor;
    }

    public void setIntroEditor(String introEditor) {
        this.introEditor = introEditor;
    }

    public String getIntroEditorEn() {
        return introEditorEn;
    }

    public void setIntroEditorEn(String introEditorEn) {
        this.introEditorEn = introEditorEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

 public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getAirportPickUpService() {
        return airportPickUpService;
    }

    public void setAirportPickUpService(String airportPickUpService) {
        this.airportPickUpService = airportPickUpService;
    }

    public String getAirportPickUpServiceEn() {
        return airportPickUpServiceEn;
    }

    public void setAirportPickUpServiceEn(String airportPickUpServiceEn) {
        this.airportPickUpServiceEn = airportPickUpServiceEn;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getTrafficEn() {
        return trafficEn;
    }

    public void setTrafficEn(String trafficEn) {
        this.trafficEn = trafficEn;
    }

    public String getSurroundings() {
        return surroundings;
    }
     public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getAirportPickUpService() {
        return airportPickUpService;
    }

    public void setAirportPickUpService(String airportPickUpService) {
        this.airportPickUpService = airportPickUpService;
    }

    public String getAirportPickUpServiceEn() {
        return airportPickUpServiceEn;
    }

    public void setAirportPickUpServiceEn(String airportPickUpServiceEn) {
        this.airportPickUpServiceEn = airportPickUpServiceEn;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getTrafficEn() {
        return trafficEn;
    }

    public void setTrafficEn(String trafficEn) {
        this.trafficEn = trafficEn;
    }

    public String getSurroundings() {
        return surroundings;
    }
    public String getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(String hasCoupon) {
        this.hasCoupon = hasCoupon;
    }

    public List<ElongThemeInfo> getThemes() {
        return themes;
    }

    public void setThemes(List<ElongThemeInfo> themes) {
        this.themes = themes;
    }

    public String getRoomTotalAmount() {
        return roomTotalAmount;
    }

    public void setRoomTotalAmount(String roomTotalAmount) {
        this.roomTotalAmount = roomTotalAmount;
    }

    public List<ElongHotelTypeInfo> getHotelTypes() {
        return hotelTypes;
    }

    public void setHotelTypes(List<ElongHotelTypeInfo> hotelTypes) {
        this.hotelTypes = hotelTypes;
    }

    public ElongServiceRankInfo getServiceRank() {
        return serviceRank;
    }

    public void setServiceRank(ElongServiceRankInfo serviceRank) {
        this.serviceRank = serviceRank;
    }
}
