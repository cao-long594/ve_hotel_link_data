package cn.vetech.center.hotel.link.elong.data.response.staticcity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/8 14:57
 */
public class ElongCityResult {

    /***
     *城市数量
     */
    @JsonProperty("Count")
    private Integer count;
    /***
     *城市结果
     */
    @JsonProperty("Citys")
    private List<ElongCityInfo> citys;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ElongCityInfo> getCitys() {
        return citys;
    }

    public void setCitys(List<ElongCityInfo> citys) {
        this.citys = citys;
    }

}