package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 酒店基础数据详情
 * </p>
 *
 * @author wangkai
 */
public class HotelDetailHotleIdDTO extends HotelBaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 酒店ID集合
     */
    @ApiModelProperty(value = "酒店ID集合", dataType = "List")
    private List<String> hotelIds;

    public List<String> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<String> hotelIds) {
        this.hotelIds = hotelIds;
    }
}
