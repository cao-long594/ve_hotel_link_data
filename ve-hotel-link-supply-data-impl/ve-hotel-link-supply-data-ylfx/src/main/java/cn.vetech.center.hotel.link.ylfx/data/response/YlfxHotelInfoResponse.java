package cn.vetech.center.hotel.link.ylfx.data.response;

import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxBaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 6161
 * @date 2024/07/22
 */
public class YlfxHotelInfoResponse extends YlfxBaseResponse {
    /**
     * 酒店详情
     */
    @JsonProperty("data")
    private YlfxHotelInfo hotelInfo;

    public YlfxHotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(YlfxHotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
    }
}
