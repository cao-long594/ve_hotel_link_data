package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 酒店基础数据详情
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelDetailCityIdDTO extends HotelBaseDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 分页请求参数
     */
    @ApiModelProperty(value = "分页请求参数", dataType = "BasePage")
    private PageDTO pageDTO;

    /**
     * 城市ID集合
     */
    @ApiModelProperty(value = "城市ID", dataType = "String")
    private String cityId;

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

}
