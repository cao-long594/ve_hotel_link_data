package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;

/**
 * <p>
 * 返回酒店ID列表
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelIdVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店id
     */
    @ApiModelProperty(value = "酒店id", dataType = "String")
    private String hotelId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", dataType = "String")
    private String updatedTime;

    /***
     * 是否国内；1:国内，0:国际
     */
    @ApiModelProperty(value = "是否国内；1:国内，0:国际", dataType = "Integer")
    private String gngj;

    /**
     * 可用状态
     */
    @ApiModelProperty(value = "可用状态 0- 不可用 1-可用(默认)", dataType = "String")
    private String status = AVAILABLE.getValue();

    public HotelIdVO() {
    }

    public HotelIdVO(String hotelId, String updatedTime, HotelStatusEnum statusEnum) {
        this.hotelId = hotelId;
        this.updatedTime = updatedTime;
        this.status = statusEnum.getValue();
    }

    public HotelIdVO(String hotelId, String updatedTime) {
        this.hotelId = hotelId;
        this.updatedTime = updatedTime;
    }

    public HotelIdVO(String hotelId, String updatedTime, String gngj) {
        this.hotelId = hotelId;
        this.updatedTime = updatedTime;
        this.gngj = gngj;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void set