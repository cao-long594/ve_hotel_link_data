package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author xiaotengyu
 * @since 2023-08-16 19:14
 */
public class HotelListDTO extends HotelBaseDTO implements Serializable {

    /**
     * 城市ID
     */
    @ApiModelProperty(value = "城市ID", dataType = "String")
    private String cityId;

    /**
     * 分页请求参数
     */
    @ApiModelProperty(value = "分页请求参数", dataType = "BasePage")
    private PageDTO pageDTO;
    /**
     * 增量接口，开始时间
     */
    private String startTime;
    /**
     * 增量接口，结束时间
     */
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }
}
