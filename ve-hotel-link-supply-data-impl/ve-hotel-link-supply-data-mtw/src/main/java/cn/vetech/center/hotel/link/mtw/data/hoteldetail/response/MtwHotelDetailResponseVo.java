package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

import java.util.List;

public class MtwHotelDetailResponseVo extends MtwResponse {

    public MtwHotelDetailVo result;

    public MtwHotelDetailVo getResult() {
        return result;
    }

    public void setResult(MtwHotelDetailVo result) {
        this.result = result;
    }
}
