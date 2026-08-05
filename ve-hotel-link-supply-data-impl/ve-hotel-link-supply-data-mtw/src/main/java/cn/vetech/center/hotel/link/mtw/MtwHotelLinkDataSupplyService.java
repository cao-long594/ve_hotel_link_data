package cn.vetech.center.hotel.link.mtw;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.vo.*;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.MtwHotelContentService;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.NewMtwHotelDetailService;
import cn.vetech.center.hotel.link.mtw.orderlist.MtwSqtOrderListService;
import cn.vetech.center.hotel.link.mtw.price.MtwHotelPriceService;
import cn.vetech.center.hotel.link.supply.base.IHotelLinkDataSupplyService;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MtwHotelLinkDataSupplyService implements IHotelLinkDataSupplyService {


    @Autowired
    private NewMtwHotelDetailService newMtwHotelDetailService;
    /**
     * 最低价
     */
     @Autowired
    private MtwHotelPriceService mtwHotelPriceService;

    @Autowired
    private MtwHotelContentService mtwHotelContentService;
    /**
     * 订单列表
     */
    @Autowired
    private MtwSqtOrderListService mtwSqtOrderListService;

    @Override
    public RestResponse<HotelInitVO> init(HotelBaseDTO dto) throws SystemException {
        return newMtwHotelDetailService.getDateBase(dto);
    }

    @Override
    public RestResponse<List<HotelIdVO>> getHotelIdList(HotelListDTO dto) throws SystemException {
        return newMtwHotelDetailService.getHotelIdList(dto);
    }

    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) throws SystemException {
        return mtwHotelContentService.getHotelDetailByIds(dto);
    }

    @Override
    public RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_SUPPORT);
    }

    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_SUPPORT);
    }

    /***
     * 获取最低价
     * @param dto 请求实体
     * @return 返回
     * @throws SystemException 异常
     */
    @Override
    public RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) throws SystemException {
        return mtwHotelPriceService.getHotelPrice(dto);
    }
        /**
     * 获取酒店列表
     *
     * @param dto 请求参数
     * @return response
     * @throws SystemException exception
     */
    @Override
    public RestResponse<LinkHotelOrderListVO> getOrderList(LinkHotelOrderListDTO dto) throws SystemException {
        return mtwSqtOrderListService.getOrderList(dto);
    }
}
