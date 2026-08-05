package cn.vetech.center.hotel.link.api.data.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengwanshan
 * @since 2024/3/7 15:03
 */
public class HotelMapping {
    /**
     * 映射的房源编号
     * 映射酒店ID的房源类型 如:  Expedia：31200901； Booking：31200902； Agoda：31200903；
     */
    @ApiModelProperty(value = "映射酒店ID的房源类型 如:  Expedia：31200901； Booking：31200902； Agoda：31200903；")
    private String mapFybh;
    /**
     * 映射的房源名称
     */
    @ApiModelProperty(value = "映射的房源名称")
    private String mapFymc;
    /**
     * 映射的酒店id
     */
    @ApiModelProperty(value = "映射酒店的ID，如果mapFybh=31200901则这里的ID就是Expedia的id ")
    private String mapHotelId;

    public String getMapFybh() {
        return mapFybh;
    }

    public void setMapFybh(String mapFybh) {
        this.mapFybh = mapFybh;
    }

    public String getMapFymc() {
        return mapFymc;
    }

    public void setMapFymc(String mapFymc) {
        this.mapFymc = mapFymc;
    }

    public String getMapHotelId() {
        return mapHotelId;
    }

    public void setMapHotelId(String mapHotelId) {
        this.mapHotelId = mapHotelId;
    }
}
