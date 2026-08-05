package cn.vetech.center.hotel.link.elong.orderlist;

import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.Order;
import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongHotelGeneralEnum;
import cn.vetech.center.hotel.link.elong.common.ElongHttp;
import cn.vetech.center.hotel.link.elong.orderdetail.response.ElongRefundDetail;
import cn.vetech.center.hotel.link.elong.orderlist.request.ElongOrderListRequest;
import cn.vetech.center.hotel.link.elong.orderlist.response.ElongOrder;
import cn.vetech.center.hotel.link.elong.orderlist.response.ElongOrderListResponse;
import cn.vetech.center.hotel.link.enums.HotelGysOrderStatusEnum;
import cn.vetech.center.hotel.link.supply.base.util.SupplierConfigUtils;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.VeDateUtils;
import cn.vetech.charge.base.CommonMagicNumber;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import java.util.Collections;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/8/21 17:35
 */
@Service
public class ElongOrderListService extends ElongHttp {
    /**
     * 日志工具
     */
    private final Logger logger = LoggerFactory.getLogger(ElongOrderListService.class);
    /**
     * 艺龙订单预订接口名
     */
  private final String method = "hotel.order.list";
    /**
     * 艺龙订单预订使用https
     */
    private final String http = "https";

    /**
     * 获取账单
     *
     * @param dto 请求参数
     * @return LinkHotelOrderListVO
     */
    public RestResponse<LinkHotelOrderListVO> orderList(LinkHotelOrderListDTO dto) {
        if (Objects.isNull(dto) || StringUtils.isAnyBlank(dto.getXdrqs(), dto.getXdrqz()) || Objects.isNull(dto.getPageDTO())) {
            return ApiRes.response(DataResponseEnum.PARAMETER_IS_EMPTY);
        }
        ElongConfig config = SupplierConfigUtils.parse(dto.getSupplier(), ElongConfig.class);
        if (Objects.isNull(config)) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        }
        LinkHotelOrderListVO vo = new LinkHotelOrderListVO();
        ElongOrderListRequest request = new ElongOrderListRequest();
        request.setCreationTimeFrom(dto.getXdrqs());
        request.setCreationTimeTo(VeDate.getNextDay(dto.getXdrqz(),CommonMagicNumber.STRING1));
        int pageIndex = dto.getPageDTO().getCurrent();
        request.setPageIndex(pageIndex);
        int size = CommonMagicNumber.INT10;
        try {
         String res = sendInvoke(method, JacksonUtils.toJsonWithNonEmpty(request), config, http, 0L);
            ElongOrderListResponse response = JacksonUtils.parseNonEmpty(res, ElongOrderListResponse.class);
            if (Objects.isNull(response)
                    || !StringUtils.equals(response.getCode(), CommonMagicNumber.STRING0)
                    || Objects.isNull(response.getResult())
                    || CollectionUtils.isEmpty(response.getResult().getOrders())) {
                logger.warn("艺龙获取账单失败;请求参数：【{}】,响应结果【{}】", JacksonUtils.toJsonWithNonEmpty(request), res);
                return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "响应结果为空");
            }
            int count = response.getResult().getCount();
            List<Order> orderList = convertOrder(response.getResult().getOrders());
            PageVO pageVO = new PageVO();
            if (count > pageIndex * size) {
                pageVO.setLast(Boolean.FALSE);
            }
            vo.setOrders(orderList);
            vo.setCount(String.valueOf(orderList.size()));
            vo.setPageVO(pageVO);
        } catch (Exception e) {
            logger.error("艺龙获取账单异常:请求参数：【{}】,异常信息【】", JacksonUtils.toJsonWithNonEmpty(request), e);
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, e.getMessage());
        }
        return ApiRes.success(vo);
    }

/**
     * 转换对账数据
     *
     * @param gysOrders 供应商账单集合
     */
    private List<Order> convertOrder(List<ElongOrder> gysOrders) {
        List<ElongOrder> orders = gysOrders.stream().filter(elongOrder -> !StringUtils.equals(ElongHotelGeneralEnum.ElongOrderStatusEnum.E.getCode(), elongOrder.getStatus())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(orders)){
            logger.warn("对账订单取消状态过滤后为空【{}】",JacksonUtils.toJsonWithNonEmpty(gysOrders));
            return Collections.emptyList();
        }
        return gysOrders.stream().map(gysOrder -> {
            Order order = new Order();
            order.setOrderId(gysOrder.getOrderId());
            order.setHotelId(gysOrder.getHotelId());
            order.setHotelName(gysOrder.getHotelName());
            order.setArrivalDate(VeDateUtils.convertDate(gysOrder.getArrivalDate()));
            order.setDepartureDate(VeDateUtils.convertDate(gysOrder.getDepartureDate()));
            order.setTrueStatus(gysOrder.getStatus());
            order.setNumberOfRooms(gysOrder.getNumberOfRooms());
            order.setTotalPrice(gysOrder.getTotalPrice());
            order.setStatus(ElongHotelGeneralEnum.ElongOrderStatusEnum.getGysOrderStatus(gysOrder.getStatus()));
            if (HotelGysOrderStatusEnum.CANCEL.getCode().equals(order.getStatus())) {
                return null;
            }
            if (Objects.nonNull(gysOrder.getRefundDetail())){
                ElongRefundDetail refundDetail = gysOrder.getRefundDetail();
                Double refundAmount = refundDetail.getRefundAmount();
                order.setRefundAmount(String.valueOf(refundAmount));
            }
            return order;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}