package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2021/7/5 19:33
 */
public class LinkHotelOrderFlowDTO extends HotelBaseDTO {
    /**
     * 分页请求参数
     */
    @ApiModelProperty(value = "分页请求参数", dataType = "BasePage")
    private PageDTO pageDTO;
    /**
     * 查询开始日期
     */
    private String startDate;
    /**
     * 查询结束日期
     */
    private String endDate;
    /**
     * 本地订单号集合
     */
    private List<String> localOrderIdList;
    /**
     * 供应订单号集合
     */
    private List<String> supplierOrderIdList;

    public PageDTO getPageDTO() {
        return pageDTO;
    }

    public void setPageDTO(PageDTO pageDTO) {
        this.pageDTO = pageDTO;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getLocalOrderIdList() {
        return localOrderIdList;
    }

    public void setLocalOrderIdList(List<String> localOrderIdList) {
        this.localOrderIdList = localOrderIdList;
    }

    public List<String> getSupplierOrderIdList() {
        return supplierOrderIdList;
    }

    public void setSupplierOrderIdList(List<String> supplierOrderIdList) {
        this.supplierOrderIdList = supplierOrderIdList;
    }
}
