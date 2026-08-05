package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2023-09-02 15:05
 */
public class HotelGjExtTextInfo {

    /**
     * 周边交通
     */
    private List<HotelGjExtPropertyInfoVO> nearbyTraffics;
    /**
     * 周边地标
     */
    private List<HotelGjExtPropertyInfoVO> nearbyPlaces;
    /**
     * 热门地标
     */
    private List<HotelGjExtPropertyInfoVO> topPlaces;
    /**
     * 入住办理起始时间
     */
    private String checkInFrom;
    /**
     * 入住办理截止时间
     */
    private String checkInUntil;
    /**
     * 退房办理截止时间
     */
    private String checkOutUntil;
    /**
     * 退房办理起始时间
     */
    private String checkOutFrom;
    /**
     *退房办理截止时间
     */
    private String receptionOpenUntil;

    /**
     * 机场接送服务费
     */
    private String airportTransferFee;
    /**
     * 距离市中心
     */
    private String distanceFromCityCenter;
    /**
     * 前往机场需时（分钟）
     */
    private String travelTimeToAirport;
    /**
     * 楼层总数
     */
    private String numberOfFloors;
    /**
     * 餐厅总数
     */
    private String numberOfRestaurants;
    /**
     * 客房总数
     */
    private String numberOfRooms;
    /**
     * 客房电压（伏特）
     */
    private String roomVoltage;
    /**
     * 建成年份
     */
    private String yearPropertyOpened;
    /**
     * 最近装修年份
     */
    private String mostRecentRenovation;
    /**
     * 早餐费（若房费未含）
     */
    private String breakfastIncludedRoomPrice;
    /**
     * 每日网络服务费
     */
    private String dailyInternetFee;
    /**
     * 无烟客房/楼层
     */
    private String nonSmokingFloors;
    /**
     * 酒店政策
     */
    private List<EtlHotelPolicy> hotelPolicies;
    /**
     * 可用支付方式
     */
    private List<EtlPayCard> payCards;
    /**
     * 重要提示
     */
    private List<EtlImportantNotice> importantNotices;
    /**
     * 临近路口
     */
    private String onAddress;
    /**
     * 混淆地址
     * 注意，这个字段不为空，表示地址需要模糊处理，预订下单之前只能展示这个 混淆地址obfuscationAddress，下单成功后才能展示完整的地址
     */
    private String obfuscationAddress;

    public String getObfuscationAddress() {
        return obfuscationAddress;
    }

    public void setObfuscationAddress(String obfuscationAddress) {
        this.obfuscationAddress = obfuscationAddress;
    }

    public String getOnAddress() {
        return onAddress;
    }

    public void setOnAddress(String onAddress) {
        this.onAddress = onAddress;
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

    public List<EtlImportantNotice> getImportantNotices() {
        return importantNotices;
    }

    public void setImportantNotices(List<EtlImportantNotice> importantNotices) {
        this.importantNotices = importantNotices;
    }

    public String getBreakfastIncludedRoomPrice() {
        return breakfastIncludedRoomPrice;
    }

    public void setBreakfastIncludedRoomPrice(String breakfastIncludedRoomPrice) {
        this.breakfastIncludedRoomPrice = breakfastIncludedRoomPrice;
    }

    public String getDailyInternetFee() {
        return dailyInternetFee;
    }

    public void setDailyInternetFee(String dailyInternetFee) {
        this.dailyInternetFee = dailyInternetFee;
    }

    public String getNonSmokingFloors() {
        return nonSmokingFloors;
    }

    public void setNonSmokingFloors(String nonSmokingFloors) {
        this.nonSmokingFloors = nonSmokingFloors;
    }

    public String getCheckOutFrom() {
        return checkOutFrom;
    }

    public void setCheckOutFrom(String checkOutFrom) {
        this.checkOutFrom = checkOutFrom;
    }

    public String getReceptionOpenUntil() {
        return receptionOpenUntil;
    }

    public void setReceptionOpenUntil(String receptionOpenUntil) {
        this.receptionOpenUntil = receptionOpenUntil;
    }

    public String getCheckInUntil() {
        return checkInUntil;
    }

    public void setCheckInUntil(String checkInUntil) {
        this.checkInUntil = checkInUntil;
    }

    public String getMostRecentRenovation() {
        return mostRecentRenovation;
    }

    public void setMostRecentRenovation(String mostRecentRenovation) {
        this.mostRecentRenovation = mostRecentRenovation;
    }

    public List<HotelGjExtPropertyInfoVO> getNearbyTraffics() {
        return nearbyTraffics;
    }

    public void setNearbyTraffics(List<HotelGjExtPropertyInfoVO> nearbyTraffics) {
        this.nearbyTraffics = nearbyTraffics;
    }

    public List<HotelGjExtPropertyInfoVO> getNearbyPlaces() {
        return nearbyPlaces;
    }

    public void setNearbyPlaces(List<HotelGjExtPropertyInfoVO> nearbyPlaces) {
        this.nearbyPlaces = nearbyPlaces;
    }

    public List<HotelGjExtPropertyInfoVO> getTopPlaces() {
        return topPlaces;
    }

    public void setTopPlaces(List<HotelGjExtPropertyInfoVO> topPlaces) {
        this.topPlaces = topPlaces;
    }

    public String getCheckInFrom() {
        return checkInFrom;
    }

    public void setCheckInFrom(String checkInFrom) {
        this.checkInFrom = checkInFrom;
    }

    public String getCheckOutUntil() {
        return checkOutUntil;
    }

    public void setCheckOutUntil(String checkOutUntil) {
        this.checkOutUntil = checkOutUntil;
    }

    public String getAirportTransferFee() {
        return airportTransferFee;
    }

    public void setAirportTransferFee(String airportTransferFee) {
        this.airportTransferFee = airportTransferFee;
    }

    public String getDistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    public void setDistanceFromCityCenter(String distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    public String getTravelTimeToAirport() {
        return travelTimeToAirport;
    }

    public void setTravelTimeToAirport(String travelTimeToAirport) {
        this.travelTimeToAirport = travelTimeToAirport;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getNumberOfRestaurants() {
        return numberOfRestaurants;
    }

    public void setNumberOfRestaurants(String numberOfRestaurants) {
        this.numberOfRestaurants = numberOfRestaurants;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getRoomVoltage() {
        return roomVoltage;
    }

    public void setRoomVoltage(String roomVoltage) {
        this.roomVoltage = roomVoltage;
    }

    public String getYearPropertyOpened() {
        return yearPropertyOpened;
    }

    public void setYearPropertyOpened(String yearPropertyOpened) {
        this.yearPropertyOpened = yearPropertyOpened;
    }
}
