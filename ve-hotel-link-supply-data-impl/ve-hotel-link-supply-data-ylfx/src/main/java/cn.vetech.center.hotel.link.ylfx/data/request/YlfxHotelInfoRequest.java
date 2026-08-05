package cn.vetech.center.hotel.link.ylfx.data.request;

import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxBaseRequest;

/**
 * @author 6161
 * @date 2024/07/22
 */
public class YlfxHotelInfoRequest extends YlfxBaseRequest {
    /**
     * 酒店ID
     */
    private String hotelId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
