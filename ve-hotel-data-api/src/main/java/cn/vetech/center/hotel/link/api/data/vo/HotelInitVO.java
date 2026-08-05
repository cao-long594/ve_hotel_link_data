package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.center.hotel.link.api.data.enums.GetHotelMethodEnum;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 酒店初始化 返回对象
 * </p>
 *
 * @author wangkai
 * @since 2020/10/26
 */

public class HotelInitVO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 酒店详获取方式 1-通过酒店ID 2-通过城市ID （该字段已取消使用，暂不删除，后续可再次使用）
     */
    @ApiModelProperty(value = "酒店详的获取方式 1-通过酒店ID 2-通过城市ID", dataType = "string")
    private String hotelDetailBy;

    /**
     * 正在执行状态
     */
    @ApiModelProperty(value = " 1 正在执行  2 执行完成", dataType = "int")
    private Integer status;

    public HotelInitVO() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public HotelInitVO(GetHotelMethodEnum methodEnum) {
        this.hotelDetailBy = methodEnum.getMethod();
    }

    public String getHotelDetailBy() {
        return hotelDetailBy;
    }

    public void setHotelDetailBy(String hotelDetailBy) {
        this.hotelDetailBy = hotelDetailBy;
    }
}



