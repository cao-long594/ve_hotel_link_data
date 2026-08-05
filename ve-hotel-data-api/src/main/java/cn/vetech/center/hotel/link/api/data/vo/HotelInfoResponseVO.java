package cn.vetech.center.hotel.link.api.data.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>
 * 酒店详情响应体
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelInfoResponseVO {

    /**
     * 分页对象
     */
    @ApiModelProperty(value = "分页返回参数", dataType = "PageVO")
    private PageVO pageVO = new PageVO();

    /**
     * 酒店详集合
     */
    @ApiModelProperty(value = "酒店详情集合", dataType = "List")
    private List<HotelInfoVO> hotelInfoVOList;
    /**
     * 国际酒店详情集合
     */
    @ApiModelProperty(value = "国际酒店详情集合", dataType = "List")
    private List<HotelGJInfoVO> hotelGJInfoVOList;
    /**
     * 酒店国际化数据
     */
    @ApiModelProperty(value = "酒店国际化数据", dataType = "List")
    private List<HotelInfoGlobalVO> hotelInfoGlobalVOS;

    public HotelInfoResponseVO() {
    }

    public HotelInfoResponseVO(PageVO pageVO, List<HotelInfoVO> hotelInfoVOList) {
        this.pageVO = pageVO;
        this.hotelInfoVOList = hotelInfoVOList;
    }

    public HotelInfoResponseVO(PageVO pageVO, List<HotelInfoVO> hotelInfoVOList, List<HotelGJInfoVO> hotelGJInfoVOList) {
        this.pageVO = pageVO;
        this.hotelInfoVOList = hotelInfoVOList;
        this.hotelGJInfoVOList = hotelGJInfoVOList;
    }

    public HotelInfoResponseVO(List<HotelInfoVO> hotelInfoVOList) {
        this.hotelInfoVOList = hotelInfoVOList;
    }

    public List<HotelGJInfoVO> getHotelGJInfoVOList() {
        return hotelGJInfoVOList;
    }

    public void setHotelGJInfoVOList(List<HotelGJInfoVO> hotelGJInfoVOList) {
        this.hotelGJInfoVOList = hotelGJInfoVOList;
    }

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }

    public List<HotelInfoVO> getHotelInfoVOList() {
        return hotelInfoVOList;
    }

    public void setHotelInfoVOList(List<HotelInfoVO> hotelInfoVOList) 