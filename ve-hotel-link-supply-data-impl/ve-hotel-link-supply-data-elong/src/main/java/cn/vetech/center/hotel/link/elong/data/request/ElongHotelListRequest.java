package cn.vetech.center.hotel.link.elong.data.request;

import cn.vetech.center.hotel.link.elong.common.ElongRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since 2021/2/5 10:44
 */
public class ElongHotelListRequest extends ElongRequest {

    /***
     *开始时间
     */
    @JsonProperty("StartTime")
    private String startTime;
    /***
     *结束时间
     */
    @JsonProperty("EndTime")
    private String endTime;
    /***
     *城市id   	城市id，只能传入1个
     */
    @JsonProperty("CityId")
    private String cityId;
    /***
     *每页数据量	 默认：1000，每页抓去的数据量
     */
    @JsonProperty("PageSize")
    private Integer pageSize;
    /***
     *页码	从1开始
     */
    @JsonProperty("PageIndex")
    private Integer pageIndex;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
