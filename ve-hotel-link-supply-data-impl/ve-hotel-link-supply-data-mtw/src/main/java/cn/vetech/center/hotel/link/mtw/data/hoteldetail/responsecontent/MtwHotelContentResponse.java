package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;

/**
 * @author xiaotengyu
 * @since 2022-08-18 15:50
 */
public class MtwHotelContentResponse extends MtwResponse {

    /**
     * 返回结果result
     */
    private MtwHotelContentResult result;

    public MtwHotelContentResult getResult() {
        return result;
    }

    public void setResult(MtwHotelContentResult result) {
        this.result = result;
    }
}
