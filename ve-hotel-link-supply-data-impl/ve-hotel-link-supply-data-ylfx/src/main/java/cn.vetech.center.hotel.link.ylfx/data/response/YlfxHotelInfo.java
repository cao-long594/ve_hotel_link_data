package cn.vetech.center.hotel.link.ylfx.data.response;

/**
 * @author 6161
 * @date 2024/07/19
 */
public class YlfxHotelInfo {
    /**
     * 酒店ID
     */
    private String hotelId;
    /**
     * 酒店名称
     */
    private String hotelName;
    /**
     * 是否有效： 0. 无效 1. 有效
     */
    private Integer active;
    /**
     * 国家ID
     */
    private String countryId;
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 省ID
     */
    private String stateId;
    /**
     * 省名称
     */
    private String stateName;
    /**
     * 城市ID
     */
    private String cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;

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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void s