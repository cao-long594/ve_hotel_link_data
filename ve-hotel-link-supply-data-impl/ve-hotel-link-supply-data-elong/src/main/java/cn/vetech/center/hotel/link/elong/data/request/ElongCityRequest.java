package cn.vetech.center.hotel.link.elong.data.request;

import cn.vetech.center.hotel.link.elong.common.ElongRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/4 21:27
 */
public class ElongCityRequest extends ElongRequest {


    /***
     * 每页个数
     */
    @JsonProperty("PageSize")
    private Integer pageSize;
    /***
     * 第几页
     */
    @JsonProperty("PageIndex")
    private Integer pageIndex;

    /***
     * 国家类型 默认0：所有城市、 1：国内 、2：国际
     */
    @JsonProperty("CountryType")
    private Integer countryType;
    /***
     *城市Id类型 默认0：所有Id，即搜索id+内容id;1:只返回内容Id
     * 注：搜素id、内容Id均支持hotel.list这样的动态接口搜索某个城市下的酒店；
     * 搜素Id不支持hotel.static.list静态接口搜索酒店，只有内容id支持hotel.static.list搜索酒店。
     * 以上只针对国内城市有效，国际可不传。
     */
    @JsonProperty("CityIdType")
    private Integer cityIdType;
    /***
     *是否需要Location
     */
    @JsonProperty("IsNeedLocation")
    private Boolean isNeedLocation;

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

    public Integer getCountryType() {
        return countryType;
    }

    public void setCountryType(Integer countryType) {
        this.countryType = countryType;
    }

    public Integer getCityIdType() {
        return cityIdType;
    }

    public void setCityIdType(Integer cityIdType) {
        this.cityIdType = cityIdType;
    }

    public Boolean getNeedLocation() {
        return isNeedLocation;
    }

    public void setNeedLocation(Boolean needLocation) {
        isNeedLocation = needLocation;
    }
}
