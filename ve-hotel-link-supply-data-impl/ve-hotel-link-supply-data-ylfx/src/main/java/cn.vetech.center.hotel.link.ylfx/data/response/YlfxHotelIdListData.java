package cn.vetech.center.hotel.link.ylfx.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author 6161
 * @date 2024/07/19
 */
public class YlfxHotelIdListData {
    /**
     * 总数
     */
    private Integer total;
    /**
     * 第几页，从1开始
     */
    private Integer currentPage;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 每页大小，最小10，最大1000
     */
    private Integer pageSize;
    /**
     * 酒店信息列表
     */
    @JsonProperty("records")
    private List<YlfxHotelInfo> hotelInfoList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<YlfxHotelInfo> getHotelInfoList() {
        return hotelInfoList;
    }

    public void setHotelInfoList(List<YlfxHotelInfo> hotelInfoList) {
        this.hotelInfoList = hotelInfoList;
    }
}
