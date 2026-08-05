package cn.vetech.center.hotel.link.mtw.orderlist;

import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.dto.PageDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.Order;
import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.enums.HotelGysOrderStatusEnum;
import cn.vetech.center.hotel.link.mtw.orderlist.request.MtwSqtOrderListRequest;
import cn.vetech.center.hotel.link.mtw.orderlist.response.MtwSqtOrderListData;
import cn.vetech.center.hotel.link.mtw.orderlist.response.MtwSqtOrderListItem;
import cn.vetech.center.hotel.link.mtw.orderlist.response.MtwSqtOrderListResponse;
import cn.vetech.center.hotel.link.mtwsqt.common.MtwsqtConfig;
import cn.vetech.center.hotel.link.mtwsqt.common.MtwsqtGeneralEnum;
import cn.vetech.center.hotel.link.mtwsqt.common.MtwsqtHttp;
import cn.vetech.center.hotel.link.mtwsqt.common.OrderSqtTypeEnum;
import cn.vetech.center.hotel.link.supply.base.util.SupplierConfigUtils;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.VeDateUtils;
import cn.vetech.charge.cloud.modules.utils.collection.ListUtil;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * @author xiaotengyu
 * @since 2023-09-08 15:40
 */
@Service
public class MtwSqtOrderListService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 每页调试
     */
    private int size = NumConstant.NUM_20;

    /**
     *  http
     */
    @Autowired
    private MtwsqtHttp mtwsqtHttp;


        /**
     * 获取订单列表
     *
     * @param dto 请求dto
     * @return vo
     */
    public RestResponse<LinkHotelOrderListVO> getOrderList(LinkHotelOrderListDTO dto) {
        //1.构建请求对象
        if (Objects.isNull(dto) || StringUtils.isAnyBlank(dto.getXdrqs(), dto.getXdrqz()) || Objects.isNull(dto.getPageDTO())) {
            return ApiRes.response(DataResponseEnum.PARAMETER_IS_EMPTY);
        }
        MtwsqtConfig config = SupplierConfigUtils.parse(dto.getSupplier(), MtwsqtConfig.class);
        if (Objects.isNull(config)) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        }
        MtwSqtOrderListRequest orderListRequest = buildRequest(dto, config);
        String result = StringUtils.EMPTY;
        try{
            logger.info("config:{}", JacksonUtils.toJsonWithDefault(config));
            result = mtwsqtHttp.sendInvoke(orderListRequest, MtwsqtGeneralEnum.ApiEnum.ORDER_LIST_QUERY);
            logger.info("请求美团商企通订单列表返回结果：{}", result);
            MtwSqtOrderListResponse mtwSqtOrderListResponse = JacksonUtils.parseNonEmpty(result, MtwSqtOrderListResponse.class);
            if(Objects.isNull(mtwSqtOrderListResponse) || Objects.isNull(mtwSqtOrderListResponse.getData())){
                return ApiRes.response(DataResponseEnum.FAIL);
            }
            LinkHotelOrderListVO orderListVO = buildOrderListVo(mtwSqtOrderListResponse.getData());
            return ApiRes.success(orderListVO);
        }catch (Exception ex){
            logger.error("美团商企通查询订单列表;result:{}", result, ex);
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION);
        }
    }

     /**
     * 构建list
     * @param mtwSqtOrderListResponse response
     * @return vo
     */
    private LinkHotelOrderListVO buildOrderListVo(MtwSqtOrderListData mtwSqtOrderListResponse) {
        LinkHotelOrderListVO orderListVO = new LinkHotelOrderListVO();
        Long totalCount = mtwSqtOrderListResponse.getTotalCount();
        Integer pageNum = mtwSqtOrderListResponse.getPageNum();
        Integer pageSize = mtwSqtOrderListResponse.getPageSize();
        List<MtwSqtOrderListItem> result = mtwSqtOrderListResponse.getResult();
        PageVO vo = new PageVO();
        if(ListUtil.isEmpty(result)){
            orderListVO.setCount("0");
            vo.setLast(true);
            orderListVO.setPageVO(vo);
            return orderListVO;
        }
        orderListVO.setCount(String.valueOf(totalCount));
        if (pageNum * pageSize <= totalCount) {
            vo.setLast(false);
        }
        orderListVO.setPageVO(vo);
        List<Order> orders = result.stream().map(this::mapMtwSqtOrderListItemToOrder).collect(Collectors.toList());
        //订单列表
        orderListVO.setOrders(orders);
        return orderListVO;
    }

     /**
     * 构建list
     * @param mtwSqtOrderListResponse response
     * @return vo
     */
    private LinkHotelOrderListVO buildOrderListVo(MtwSqtOrderListData mtwSqtOrderListResponse) {
        LinkHotelOrderListVO orderListVO = new LinkHotelOrderListVO();
        Long totalCount = mtwSqtOrderListResponse.getTotalCount();
        Integer pageNum = mtwSqtOrderListResponse.getPageNum();
        Integer pageSize = mtwSqtOrderListResponse.getPageSize();
        List<MtwSqtOrderListItem> result = mtwSqtOrderListResponse.getResult();
        PageVO vo = new PageVO();
        if(ListUtil.isEmpty(result)){
            orderListVO.setCount("0");
            vo.setLast(true);
            orderListVO.setPageVO(vo);
            return orderListVO;
        }
        orderListVO.setCount(String.valueOf(totalCount));
        if (pageNum * pageSize <= totalCount) {
            vo.setLast(false);
        }
        orderListVO.setPageVO(vo);
        List<Order> orders = result.stream().map(this::mapMtwSqtOrderListItemToOrder).collect(Collectors.toList());
        //订单列表
        orderListVO.setOrders(orders);
        return orderListVO;
    }

     /**
     * 供应商原始订单状态转换成标准的订单状态
     *
     * @param orderStatus 供应商订单状态
     * @return HotelGysOrderStatusEnum
     */
    protected HotelGysOrderStatusEnum convert2HotelGysOrderStatus(String orderStatus) {
        if (StringUtils.isBlank(orderStatus)) {
            return null;
        }
        // 订单状态，0：预订；2：订单确认；3：订单取消；4：订单失败；5：立即确认订单待确认；6：二次确认订单待确认
        if (StringUtils.equals("10", orderStatus)) {
            return HotelGysOrderStatusEnum.BEFORE_CONFIRM;
        }
        if (StringUtils.equals("20", orderStatus) || StringUtils.equals("31", orderStatus)) {
            return HotelGysOrderStatusEnum.AFTER_CONFIRM;
        }
        if (StringUtils.equals("32", orderStatus)) {
            return HotelGysOrderStatusEnum.CANCEL;
        }
        return null;
    }

      /**
     * 构建请求对象
     *
     * @param dto    dto
     * @param config config
     * @return request
     */
    private MtwSqtOrderListRequest buildRequest(LinkHotelOrderListDTO dto, MtwsqtConfig config) {
        MtwSqtOrderListRequest orderListRequest = new MtwSqtOrderListRequest();
        PageDTO pageDTO = dto.getPageDTO();
        orderListRequest.setPageNum(pageDTO.getCurrent());
        orderListRequest.setPageSize(size);
        orderListRequest.setSqtType(OrderSqtTypeEnum.T10.getCode());
        Date begin = VeDateUtils.parse(dto.getXdrqs(), VeDateUtils.FMT_DAY);
        String xdrqz = VeDate.getPreDay(dto.getXdrqz(), NumConstant.NUM_1);
        Date end = VeDateUtils.parse(xdrqz, VeDateUtils.FMT_DAY);
        if (Objects.nonNull(begin)) {
            orderListRequest.setOrderTimeStart(begin.getTime());
        }
        if (Objects.nonNull(end)) {
            orderListRequest.setOrderTimeEnd(end.getTime());
        }
        orderListRequest.setMtwsqtConfig(config);
        return orderListRequest;
    }

}
