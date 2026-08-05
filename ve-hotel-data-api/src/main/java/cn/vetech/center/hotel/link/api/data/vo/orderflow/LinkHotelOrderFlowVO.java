package cn.vetech.center.hotel.link.api.data.vo.orderflow;

import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2021/7/5 19:48
 */
public class LinkHotelOrderFlowVO {
    /**
     * 分页对象
     */
    @ApiModelProperty(value = "分页返回参数", dataType = "PageVO")
    private PageVO pageVO = new PageVO();
    /**
     * 总数
     */
    private String total;
    /**
     * 支付流水集合
     */
    private List<PaymentInfo> paymentInfoList;

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PaymentInfo> getPaymentInfoList() {
        return paymentInfoList;
    }

    public void setPaymentInfoList(List<PaymentInfo> paymentInfoList) {
        this.paymentInfoList = paymentInfoList;
    }
}
