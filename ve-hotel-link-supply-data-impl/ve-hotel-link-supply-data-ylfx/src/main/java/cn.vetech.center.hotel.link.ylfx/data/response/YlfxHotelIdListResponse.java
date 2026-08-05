package cn.vetech.center.hotel.link.ylfx.data.response;

import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxBaseResponse;

/**
 * @author 6161
 * @date 2024/07/19
 */
public class YlfxHotelIdListResponse extends YlfxBaseResponse {
    /**
     * 酒店列表数据
     */
    private YlfxHotelIdListData data;

    public YlfxHotelIdListData getData() {
        return data;
    }

    public void setData(YlfxHotelIdListData data) {
        this.data = data;
    }
}
