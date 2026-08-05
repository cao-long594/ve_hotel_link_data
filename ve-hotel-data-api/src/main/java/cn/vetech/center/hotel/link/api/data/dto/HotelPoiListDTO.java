package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author xiaotengyu
 * @since 2023-08-16 19:14
 */
public class HotelPoiListDTO extends HotelBaseDTO implements Serializable {
    /**
     * 分页请求参数
     */
    @ApiModelProperty(value = "分页请求参数", dataType = "BasePage")
    private PageDTO pageDTO;

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }
}
