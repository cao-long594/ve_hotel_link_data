package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 获取酒店最低价
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelPriceResponseVO extends HotelBaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 供应商酒店基本信息 原始数据
     */
    @ApiModelProperty(value = "通讯原始数据, 循环请求,添加add到List中", dataType = "list")
    private List<String> priceResponse = new ArrayList<>();
    /**
     * 每日报价
     */
    @ApiModelProperty(value = "每日报价", dataType = "list")
    private List<HotelPriceVO> hotelPriceVOS;

    /**
     * 原始返回数据
     *
     * @param res 返回数据
     */
    public void addPriceResponse(String res) {
        if (res != null) {
            priceResponse.add(res);
        }
    }

    public List<String> getPriceResponse() {
        return priceResponse;
    }

    public void setPriceResponse(List<String> priceResponse) {
        this.priceResponse = priceResponse;
    }

    public List<HotelPriceVO> getHotelPriceVOS() {
        return hotelPriceVOS;
    }

    public void setHotelPriceVOS(List<HotelPriceVO> hotelPriceVOS) {
        this.hotelPriceVOS = hotelPriceVOS;
    }
}
