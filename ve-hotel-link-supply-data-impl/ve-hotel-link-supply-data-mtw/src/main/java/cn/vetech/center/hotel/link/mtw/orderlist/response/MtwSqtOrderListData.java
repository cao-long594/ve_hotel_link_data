package cn.vetech.center.hotel.link.mtw.orderlist.response;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2023-09-12 14:34
 */
public class MtwSqtOrderListData {

    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 总条数
     */
    private Long totalCount;
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     * 记录列表
     */
    private List<MtwSqtOrderListItem> result;

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

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<MtwSqtOrderListItem> getResult() {
        return result;
    }

    public void setResult(List<MtwSqtOrderListItem> result) {
        this.result = result;
    }

}
