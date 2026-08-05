package cn.vetech.center.hotel.link.elong;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.elong.data.ElongHotelDetailService;
import cn.vetech.center.hotel.link.elong.data.HotelListService;
import cn.vetech.center.hotel.link.elong.orderlist.ElongOrderListService;
import cn.vetech.center.hotel.link.elong.price.ElongHotelPriceService;
import cn.vetech.center.hotel.link.supply.base.IHotelLinkDataSupplyService;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 艺龙房源静态数据实现
 * </p>
 *
 * @author wangkai
 * @since 2020/10/21
 */
@Service
public class ElongHotelLinkDataSupplyService implements IHotelLinkDataSupplyService {

    /**
     * 酒店详处理类
     */
    @Autowired
    private ElongHotelDetailService elongHotelDetailService;
    /***
     * 最低价
     */
    @Autowired
    private ElongHotelPriceService elongHotelPriceService;

  /**
     * 账单服务
     */
    @Autowired
    private ElongOrderListService elongOrderListService;
    /**
     * 酒店列表
     */
    @Autowired
    private HotelListService hotelListService;

    /**
     * 初始化供应商基础信息
     *
     * @param dto 入参
     * @return RestResponse
     */
    @Override
    public RestResponse<HotelInitVO> init(HotelBaseDTO dto) {
        return elongHotelDetailService.loadbaseData(dto);
    }

    @Override
    public RestResponse<List<HotelIdVO>> getHotelIdList(HotelListDTO dto) {
        List<HotelIdVO> allHotelId = elongHotelDetailService.getAllHotelId(dto);
        return ApiRes.success(allHotelId);
    }

    /**
     * 通过酒店ID获取酒店详情
     *
     * @param dto 入参
     * @return RestResponse
     */
    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) {
        return elongHotelDetailService.getHotelDetailByHotelId(dto);
    }

    @Override
    public RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) {
        return elongHotelDetailService.getCityIdList(dto);
    }

    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) {
        return elongHotelDetailService.getHotelDetailByCityId(dto);
    }

    /***
     * 最低价
     * @param dto
     * @return
     * @throws SystemException
     */
    @Override
    public RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) throws SystemException {
        return elongHotelPriceService.getHotelPrice(dto);
    }

    @Override
    public RestResponse<LinkHotelOrderListVO> getOrderList(LinkHotelOrderListDTO dto) throws SystemException {
        return elongOrderListService.orderList(dto);
    }

    @Override
    public RestResponse<HotelIdResponseVO> getIncrementHotelIdListByPage(HotelListDTO dto) throws SystemException {
        return hotelListService.getIncrHotelId(dto);
    }
}
