package cn.vetech.center.hotel.link.ylfx.data.request;

import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxBaseRequest;

/**
 * @author 6161
 * @date 2024/07/19
 */
public class YlfxHotelIdListRequest extends YlfxBaseRequest {
    /**
     * 第几页，从1开始
     */
    private Integer currentPage;
    /**
     * 每页大小，最小10，最大1000
     */
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
