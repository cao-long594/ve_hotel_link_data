package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 获取酒店最低价
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelPriceDTO extends HotelBaseDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    /**
     * 酒店ID集合
     * 标准供应商，酒店ID格式：携程ID_艺龙ID_美团ID
     */
    @ApiModelProperty(value = "酒店ID集合", dataType = "List")
    private List<String> hotelIds;

    /**
     * 开始日期 2020-12-30
     */
    @ApiModelProperty(value = "开始日期", dataType = "String")
    private String startDate;
    /**
     * 结束日期 2020-12-31"
     */
    @ApiModelProperty(value = "结束日期", dataType = "String")
    private String endDate;


    public List<String> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<String> hotelIds) {
        this.hotelIds = hotelIds;
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
}
