package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 返回酒店ID列表
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelCityIdVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市ID
     */
    @ApiModelProperty(value = "城市ID", dataType = "cityId")
    private String cityId;

    /**
     * 省份ID
     */
    @ApiModelProperty(value = "省份ID", dataType = "String")
    private String provinceId;
    /***
     * 是否国内；1:国内，0:国际
     */
    @ApiModelProperty(value = "是否国内；1:国内，0:国际", dataType = "Integer")
    private String gngj;


    public HotelCityIdVO() {
    }

    public HotelCityIdVO(String cityId) {
        this.cityId = cityId;
    }

    public HotelCityIdVO(String cityId, String provinceId) {
        this.cityId = cityId;
        this.provinceId = provinceId;
    }

    public HotelCityIdVO(String cityId, String provinceId, String gngj) {
        this.cityId = cityId;
        this.provinceId = provinceId;
        this.gngj = gngj;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
}
