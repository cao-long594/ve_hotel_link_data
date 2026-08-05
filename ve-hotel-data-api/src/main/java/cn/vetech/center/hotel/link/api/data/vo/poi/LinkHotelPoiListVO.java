package cn.vetech.center.hotel.link.api.data.vo.poi;

import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2021/7/5 19:48
 */
public class LinkHotelPoiListVO {
    /**
     * 分页对象
     */
    @ApiModelProperty(value = "分页返回参数", dataType = "PageVO")
    private PageVO pageVO = new PageVO();
    /**
     * poi集合
     */
    private List<linkHotelPoiInfo> poiInfoList;

    public List<linkHotelPoiInfo> getPoiInfoList() {
        return poiInfoList;
    }

    public void setPoiInfoList(List<linkHotelPoiInfo> poiInfoList) {
        this.poiInfoList = poiInfoList;
    }

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }

    public LinkHotelPoiListVO() {
    }

    public LinkHotelPoiListVO(PageVO pageVO, List<linkHotelPoiInfo> poiInfoList) {
        this.pageVO = pageVO;
        this.poiInfoList = poiInfoList;
    }
}
