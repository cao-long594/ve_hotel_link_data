package cn.vetech.center.hotel.link.mtw.orderlist.request;

import cn.vetech.center.hotel.link.mtwsqt.common.MtwsqtRequest;

/**
 * @author xiaotengyu
 * @since 2023-09-08 15:41
 */
public class MtwSqtOrderListRequest extends MtwsqtRequest {

    /**
     * Integer	否	20	每页条数：默认20
     */
    private Integer pageSize;
    /**
     *     Integer	否	1	当前页码：默认1
     */
    private Integer pageNum;
    /**
     *     Integer	否	10	支付状态：10未支付，20已支付，31部分退款，32全额退款
     */
    private Integer payStatus;
    /**
     *     Integer	否	1	美团企业版业务类型：1 买单，16 新买单2 预定3 团购4 外卖5 打车10 酒店11 门票12 机票13 火车票14 电影票15 扫码消费19 优选20 买菜21 团好货22 盒餐23 现场就餐24 跑腿25 文印图文10000 线下订单特许报备11000 银联付款码
     */
    private Integer sqtType;
    /**
     *     Long	否	1569859200000	订单创建开始时间:13位时间戳
     */
    private Long orderTimeStart;
    /**
     * Long	否	1569859200000	订单创建结束时间：13位时间戳
     */
    private Long orderTimeEnd;
    /**
     *    	Long	否	1569859200000	订单更新开始时间：13位时间戳
     */
    private Long orderUpdateStart;
    /**
     *     Long	否	1569859200000	订单更新结束时间：13位时间戳
     */
    private Long orderUpdateEnd;
    /**
     * Long	否	1569859200000	订单支付开始时间：13位时间戳
     */
    private Long payTimeStart;
    /**
     *     Long	否	1569859200000	订单支付结束时间：13位时间戳
     */
    private Long payTimeEnd;
    /**
     * String	否	xxxxxxxx	外部申请单号(暂时只支持传入用餐申请)
     */
    private String outerApplyNo;
    /**
     *     String	否	xxxxxxxx	美团企业版出差申请单号
     */
    private String tripId;
    /**
     *     String	否	xxxxxxxx	美团企业版用车申请单号
     */
    private String sqtApplyNo;
    /**
     * String	否	ASE	排序类型, 按订单创建时间、订单ID排序，不填默认为倒序。ASE 表示正序,DESC 表示倒序
     */
    private String sortType;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getSqtType() {
        return sqtType;
    }

    public void setSqtType(Integer sqtType) {
        this.sqtType = sqtType;
    }

    public Long getOrderTimeStart() {
        return orderTimeStart;
    }

    public void setOrderTimeStart(Long orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    public Long getOrderTimeEnd() {
        return orderTimeEnd;
    }

    public void setOrderTimeEnd(Long orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    public Long getOrderUpdateStart() {
        return orderUpdateStart;
    }

    public void setOrderUpdateStart(Long orderUpdateStart) {
        this.orderUpdateStart = orderUpdateStart;
    }

    public Long getOrderUpdateEnd() {
        return orderUpdateEnd;
    }

    public void setOrderUpdateEnd(Long orderUpdateEnd) {
        this.orderUpdateEnd = orderUpdateEnd;
    }

    public Long getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(Long payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public Long getPayTimeEnd() {
        return payTimeEnd;
    }
    
    public void setPayTimeEnd(Long payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getOuterApplyNo() {
        return outerApplyNo;
    }

    public void setOuterApplyNo(String outerApplyNo) {
        this.outerApplyNo = outerApplyNo;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getSqtApplyNo() {
        return sqtApplyNo;
    }

    public void setSqtApplyNo(String sqtApplyNo) {
        this.sqtApplyNo = sqtApplyNo;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
