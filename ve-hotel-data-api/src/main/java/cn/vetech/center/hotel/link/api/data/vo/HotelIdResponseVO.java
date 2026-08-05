package cn.vetech.center.hotel.link.api.data.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author 6161
 * @date 2024/07/30
 */
public class HotelIdResponseVO {
    /**
     * 分页对象
     */
    @ApiModelProperty(value = "分页返回参数", dataType = "PageVO")
    private PageVO pageVO = new PageVO();
    /**
     * 酒店ID集合
     */
    @ApiModelProperty(value = "酒店ID集合", dataType = "List")
    private List<HotelIdVO> hotelIdVOList;

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }

    public List<HotelIdVO> getHotelIdVOList() {
        return hotelIdVOList;
    }

    public void setHotelIdVOList(List<HotelIdVO> hotelIdVOList) {
        this.hotelIdVOList = hotelIdVOList;
    }
}
