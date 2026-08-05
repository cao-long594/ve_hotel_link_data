package cn.vetech.center.hotel.link.mtw.orderlist.response;

/**
 * @author xiaotengyu
 * @since 2023-09-08 16:58
 */
public class MtwSqtOrderListItem {

    /**
     * Long	是	314442083816943618	美团企业版订单ID
     */
    private String  sqtBizOrderId;
    /**
     * Integer	是	617	企业id
     */
    private String  entId;
    /**
     * Integer	是	4	美团企业版订单业务类型，该值同请求参数中sqtType
     */
    private String  orderType;
    /**
     * String	是	外卖	订单类型
     */
    private String  orderTypeName;
    /**
     * Integer	是	206	美团业务类型
     */
    private String  bizType;
    /**
     * String	是	美团外卖	美团业务类型
     */
    private String  bizTypeName;
    /**
     * String	是	6045253884937765	业务原始订单ID
     */
    private String  origOrderId;
    /**
     * Integer	否	227010	员工ID
     */
    private String  staffId;
    /**
     * String	否	张珊珊	员工名称
     */
    private String  staffName;
    /**
     * String	是	北京市	消费城市
     */
    private String  expenseCity;
    /**
     * String	是	35.40	订单金额：元
     */
    private String  orderAmount;
    /**
     * String	是	15.00	总支付金额：元（不包含服务费）
     */
    private String  totalPayAmount;
    /**
     * String	是	15.00	总退款金额：元 （不包含服务费）
     */
    private String  totalRefundAmount;
    /**
     * String	是	0.00	实际支付金额：元（不包含服务费）
     */
    private String  totalRealAmount;
    /**
     * String	是	35.40	企业支付金额：元 （不包含服务费）
     */
    private String  entPayAmount;
    /**
     * String	是	0.00	员工支付金额：元
     */
    private String  staffPayAmount;
    /**
     * String	是	0.00	企业退款金额：元 （不包含服务费）
     */
    private String  entRefundAmount;
    /**
     * String	是	0.00	员工退款金额：元
     */
    private String  staffRefundAmount;
    /**
     * String	是	0.00	偿还金额：元
     */
    private String  repayAmount;
    /**
     * String	否	0.00	随单收服务费：元，四舍五入保留2位小数
     */
    private String  realtimeServiceFee;
    /**
     * String	否	0.00	随单收服务费支付金额：元
     */
    private String  realtimeServiceFeePayAmount;
    /**
     * String	否	0.00	随单收服务费退款金额：元
     */
    private String  realtimeServiceFeeRefundAmount;
    /**
     * Integer	否	1	随单收服务费承担方式枚举： 0不扣预算，1扣预算
     */
    private String  realtimeServiceFeeMode;
    /**
     * String	否	0.00	后结算服务费：元，四舍五入保留2位小数
     */
    private String  afterServiceFee;
    /**
     * String	否	0.00	后结算服务费支付金额：元
     */
    private String  afterServiceFeePayAmount;
    /**
     * String	否	0.00	后结算服务费退款金额：元
     */
    private String  afterServiceFeeRefundAmount;
    /**
     * Integer	是	32	支付状态
     */
    private String  payStatus;
     /**
     * String	是	全额退款	支付状态
     */
    private String  payStatusName;
    /**
     * String	是	2019-10-01 16:40:34	订单时间
     */
    private String  orderTime;
    /**
     * String	否	2021-03-10 16:43:29	支付时间
     */
    private String  payTime;
    /**
     * String	否	xxxxxxxx	外部申请单号
     */
    private String  outerApplyNo;

    public String getSqtBizOrderId() {
        return sqtBizOrderId;
    }

    public void setSqtBizOrderId(String sqtBizOrderId) {
        this.sqtBizOrderId = sqtBizOrderId;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }
 /**
     * String	是	全额退款	支付状态
     */
    private String  payStatusName;
    /**
     * String	是	2019-10-01 16:40:34	订单时间
     */
    private String  orderTime;
    /**
     * String	否	2021-03-10 16:43:29	支付时间
     */
    private String  payTime;
    /**
     * String	否	xxxxxxxx	外部申请单号
     */
    private String  outerApplyNo;

    public String getSqtBizOrderId() {
        return sqtBizOrderId;
    }

    public void setSqtBizOrderId(String sqtBizOrderId) {
        this.sqtBizOrderId = sqtBizOrderId;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }
 public void setTotalRefundAmount(String totalRefundAmount) {
        this.totalRefundAmount = totalRefundAmount;
    }

    public String getTotalRealAmount() {
        return totalRealAmount;
    }

    public void setTotalRealAmount(String totalRealAmount) {
        this.totalRealAmount = totalRealAmount;
    }

    public String getEntPayAmount() {
        return entPayAmount;
    }

    public void setEntPayAmount(String entPayAmount) {
        this.entPayAmount = entPayAmount;
    }

    public String getStaffPayAmount() {
        return staffPayAmount;
    }

    public void setStaffPayAmount(String staffPayAmount) {
        this.staffPayAmount = staffPayAmount;
    }

    public String getEntRefundAmount() {
        return entRefundAmount;
    }

    public void setEntRefundAmount(String entRefundAmount) {
        this.entRefundAmount = entRefundAmount;
    }

    public String getStaffRefundAmount() {
        return staffRefundAmount;
    }

    public void setStaffRefundAmount(String staffRefundAmount) {
        this.staffRefundAmount = staffRefundAmount;
    }

    public String getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(String repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getRealtimeServiceFee() {
        return realtimeServiceFee;
    }

    public void setRealtimeServiceFee(String realtimeServiceFee) {
        this.realtimeServiceFee = realtimeServiceFee;
    }

    public String getRealtimeServiceFeePayAmount() {
        return realtimeServiceFeePayAmount;
    }

    public void setRealtimeServiceFeePayAmount(String realtimeServiceFeePayAmount) {
        this.realtimeServiceFeePayAmount = realtimeServiceFeePayAmount;
    }

    public String getRealtimeServiceFeeRefundAmount() {
        return realtimeServiceFeeRefundAmount;
    }
  public void setRealtimeServiceFeeRefundAmount(String realtimeServiceFeeRefundAmount) {
        this.realtimeServiceFeeRefundAmount = realtimeServiceFeeRefundAmount;
    }

    public String getRealtimeServiceFeeMode() {
        return realtimeServiceFeeMode;
    }

    public void setRealtimeServiceFeeMode(String realtimeServiceFeeMode) {
        this.realtimeServiceFeeMode = realtimeServiceFeeMode;
    }

    public String getAfterServiceFee() {
        return afterServiceFee;
    }

    public void setAfterServiceFee(String afterServiceFee) {
        this.afterServiceFee = afterServiceFee;
    }

    public String getAfterServiceFeePayAmount() {
        return afterServiceFeePayAmount;
    }

    public void setAfterServiceFeePayAmount(String afterServiceFeePayAmount) {
        this.afterServiceFeePayAmount = afterServiceFeePayAmount;
    }

    public String getAfterServiceFeeRefundAmount() {
        return afterServiceFeeRefundAmount;
    }

    public void setAfterServiceFeeRefundAmount(String afterServiceFeeRefundAmount) {
        this.afterServiceFeeRefundAmount = afterServiceFeeRefundAmount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusName() {
        return payStatusName;
    }

    public void setPayStatusName(String payStatusName) {
        this.payStatusName = payStatusName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOuterApplyNo() {
        return outerApplyNo;
    }

    public void setOuterApplyNo(String outerApplyNo) {
        this.outerApplyNo = outerApplyNo;
    }
}
