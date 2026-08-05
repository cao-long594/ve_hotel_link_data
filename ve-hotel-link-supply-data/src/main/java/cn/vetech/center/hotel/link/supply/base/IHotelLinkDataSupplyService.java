package cn.vetech.center.hotel.link.supply.base;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPoiListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderFlowDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.orderflow.LinkHotelOrderFlowVO;
import cn.vetech.center.hotel.link.api.data.vo.poi.LinkHotelPoiListVO;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;

import java.util.List;

/**
 * <p>
 * 酒店基础数据接口、各供应商实现该接口即可
 * </p>
 *
 * @author wangkai
 * @since 2020/10/19
 */
public interface IHotelLinkDataSupplyService {

    /**
     * 接口实现类名称后缀
     * 前缀为 供应商英文简称
     */
    String NAME = "HotelLinkDataSupplyService";


    /**
     * 初始化供应商信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    RestResponse<HotelInitVO> init(HotelBaseDTO dto) throws SystemException;


    /**
     * 根据供应商信息获取酒店ID列表
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    RestResponse<List<HotelIdVO>> getHotelIdList(HotelListDTO dto) throws SystemException;

    /**
     * 根据供应商信息获取酒店ID列表 分页
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    default RestResponse<HotelIdResponseVO> getHotelIdListByPage(HotelListDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }

    /**
     * 根据供应商信息获取酒店ID增量列表 分页
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    default RestResponse<HotelIdResponseVO> getIncrementHotelIdListByPage(HotelListDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }

    /**
     * 根据酒店ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) throws SystemException;


    /**
     * 获取供应商城市ID
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) throws SystemException;

    /**
     * 根据城市ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) throws SystemException;

    /**
     * 最低价获取价格
     *
     * @param dto 请求参数
     * @return RestResponse
     * @throws SystemException
     */
    default RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) throws SystemException {

        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }

    /**
     * 获取账单
     *
     * @param dto 请求参数
     * @return RestResponse
* @throws SystemException SystemException
     */
    default RestResponse<LinkHotelOrderListVO> getOrderList(LinkHotelOrderListDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }

    /**
     * 分页获取供应商酒店poi信息列表
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 系统异常
     */
    default RestResponse<LinkHotelPoiListVO> getPoiListByPage(HotelPoiListDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }

    /**
     * 拉取订单支付流水
     *
     * @param dto 请求参数
     * @return RestResponse
     * @throws SystemException SystemException
     */
    default RestResponse<LinkHotelOrderFlowVO> getOrderFlow(LinkHotelOrderFlowDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
    }
}
