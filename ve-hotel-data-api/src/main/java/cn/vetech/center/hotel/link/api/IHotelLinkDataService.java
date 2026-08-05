package cn.vetech.center.hotel.link.api;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPoiListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderFlowDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.orderflow.LinkHotelOrderFlowVO;
import cn.vetech.center.hotel.link.api.data.vo.poi.LinkHotelPoiListVO;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 酒店静态数据接口
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
@RequestMapping("/api/vehotellink/hoteldata")
public interface IHotelLinkDataServcie {


    /**
     * 初始化供应商信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "初始化供应商信息")
    @PostMapping(value = "/init")
    RestResponse<HotelInitVO> init(@RequestBody HotelBaseDTO dto) throws SystemException;

    /**
     * 根据供应商信息获取酒店ID列表
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "根据供应商信息获取酒店ID列表")
    @PostMapping(value = "/getHotelIdList")
    RestResponse<List<HotelIdVO>> getHotelIdList(@RequestBody HotelListDTO dto) throws SystemException;

    /**
     * 根据供应商信息获取酒店ID列表 分页
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "根据供应商信息获取酒店ID列表分页")
    @PostMapping(value = "/getHotelIdListByPage")
    RestResponse<HotelIdResponseVO> getHotelIdListByPage(@RequestBody HotelListDTO dto) throws SystemException;

    /**
     * 根据酒店ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "根据酒店ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息")
    @PostMapping(value = "/getHotelDetailByHotelId")
    RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(@RequestBody HotelDetailHotleIdDTO dto) throws SystemException;


    /**
     * 获取供应商城市ID,如果酒店ID和酒店详未分开的接口、可通过该接口实现
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
    */
    @ApiOperation(value = "获取供应商城市ID")
    @PostMapping(value = "/getCityIdList")
    RestResponse<List<HotelCityIdVO>> getCityIdList(@RequestBody HotelBaseDTO dto) throws SystemException;

    /**
     * 根据城市ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "根据城市ID列表获取获取酒店详信息，包活酒店基本信息和酒店房型信息")
    @PostMapping(value = "/getHotelDetailByCityId")
    RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(@RequestBody HotelDetailCityIdDTO dto) throws SystemException;


    /**
     * 通过酒店id集合和开始日期/结束日期获取酒店价格
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "通过酒店id集合和开始日期/结束日期获取酒店价格")
    @PostMapping(value = "/getHotelPrice")
    RestResponse<HotelPriceResponseVO> getHotelPrice(@RequestBody HotelPriceDTO dto) throws Exception;

    /**
     * 对账
     *
     * @param dto 1
     * @return 1
     */
    @ApiOperation(value = "对账")
    @PostMapping(value = "/orderList")
    RestResponse<LinkHotelOrderListVO> orderList(@RequestBody LinkHotelOrderListDTO dto) throws SystemException;

    /**
     * 根据供应商信息获取酒店ID增量列表 分页
     *
     * @param dto 入参
     * @return 回参
     * @throws SystemException 异常
     */
    @ApiOperation(value = "根据供应商信息获取酒店ID增量列表分页")
    @PostMapping(value = "/getIncHotelIdListByPage")
    RestResponse<HotelIdResponseVO> getIncHotelIdListByPage(@RequestBody HotelListDTO dto) throws SystemException;

    /**
     * poi
     *
     * @param dto 1
     * @return 1
     */
    @ApiOperation(value = "分页获取供应商酒店poi信息列表")
    @PostMapping(value = "/getPoiListByPage")
    RestResponse<LinkHotelPoiListVO> getPoiListByPage(@RequestBody HotelPoiListDTO dto) throws SystemException;

    /**
     * 拉取订单支付流水
     *
     * @param dto 1
     * @return 1
     */
    @ApiOperation(value = "拉取订单支付流水")
    @PostMapping(value = "/getOrderFlow")
    RestResponse<LinkHotelOrderFlowVO> getOrderFlow(@RequestBody LinkHotelOrderFlowDTO dto) throws SystemException;
}
