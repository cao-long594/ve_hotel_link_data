package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import cn.vetech.center.hotel.link.util.JacksonUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 *酒店基本信息。
 * @author xingyanyan
 * @since 2018-09-04
 */
public class MtwHotelBaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店id
     */
    @ApiModelProperty(value = "酒店id", dataType = "string")
    private Long hotelId;
    /**
     * 酒店名称
     */
    @ApiModelProperty(value = "酒店名称", dataType = "string")
    private String pointName;
    /**
     * 酒店描述信息
     */
    @ApiModelProperty(value = "酒店描述信息", dataType = "string")
    private String info;
    /**
     * 高德经度，取值为实际经度值*10的6次方取整
     */
    @ApiModelProperty(value = "高德经度，取值为实际经度值*10的6次方取整", dataType = "string")
    private Integer longitude;
    /**
     * 高德纬度，取值为实际纬度值*10的6次方取整
     */
    @ApiModelProperty(value = "高德纬度，取值为实际纬度值*10的6次方取整", dataType = "string")
    private Integer latitude;
    /**
     * 酒店地址
     */
    @ApiModelProperty(value = "酒店地址", dataType = "string")
    private String address;
    /**
     * 酒店所在城市名，如“上海市”
     */
    @ApiModelProperty(value = "酒店所在城市名，如“上海市”", dataType = "string")
    private String cityName;
    /**
     * 城市id与城市名、城市行政区id与行政区名的映射关系列表请联系分销平台获取
     */
    @ApiModelProperty(value = "城市id与城市名、城市行政区id与行政区名的映射关系列表请联系分销平台获取", dataType = "string")
    private Integer cityLocationId;
    /**
     * 酒店所在城市行政区名，如“松江区”
     */
    @ApiModelProperty(value = "酒店所在城市行政区名，如“松江区”", dataType = "string")
    private String locationName;
    /**
     * 城市行政区id
     */
    @ApiModelProperty(value = "城市行政区id", dataType = "string")
    private String locationId;
    /**
     * 酒店所在商圈名
     */
    @ApiModelProperty(value = "酒店所在商圈名", dataType = "string")
    private String bareaName;
    /**
     * 用户评分，10分制，取值为实际值*10如用户评分为4.2分，则avgscore=42
     */
    @ApiModelProperty(value = "用户评分，10分制，取值为实际值*10如用户评分为4.2分，则avgscore=42", dataType = "string")
    private Integer avgScore;
    /**
     * 酒店联系电话
     */
    @ApiModelProperty(value = "酒店联系电话", dataType = "string")
    private String phone;
    /**
     * 酒店填写的营业时间，无固定格式，如取值可以为“24小时”
     */
    @ApiModelProperty(value = "酒店填写的营业时间，无固定格式，如取值可以为“24小时”", dataType = "string")
    private String openInfo;
    /**
     * 酒店营业状态：0 营业中1 已关门2 筹建中3 暂停营业
     */
    @ApiModelProperty(value = "酒店营业状态：0 营业中1 已关门2 筹建中3 暂停营业", dataType = "string")
    private Integer closeStatus;
    /**
     * 首图信息，取值为图片的url地址
     */
    @ApiModelProperty(value = "首图信息，取值为图片的url地址", dataType = "string")
    private String frontImage;
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityLocationId() {
        return cityLocationId;
    }

    public void setCityLocationId(Integer cityLocationId) {
        this.cityLocationId = cityLocationId;
    }

    public String getLocationName() {
        return locationName;
    }
     public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getBareaName() {
        return bareaName;
    }

    public void setBareaName(String bareaName) {
        this.bareaName = bareaName;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenInfo() {
        return openInfo;
    }

    public void setOpenInfo(String openInfo) {
        this.openInfo = openInfo;
    }

    public Integer getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(Integer closeStatus) {
        this.closeStatus = closeStatus;
    }

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    @Override
    public String toString() {
        return JacksonUtils.toJsonWithNonEmpty(this);
    }
}
