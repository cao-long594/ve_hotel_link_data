package cn.vetech.center.hotel.link.mtw.orderlist.response;

import cn.vetech.center.hotel.link.mtwsqt.common.MtwsqtResponse;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2023-09-08 15:41
 */
public class MtwSqtOrderListResponse extends MtwsqtResponse {

    /**
     * data
     */
    private MtwSqtOrderListData data;

    public MtwSqtOrderListData getData() {
        return data;
    }

    public void setData(MtwSqtOrderListData data) {
        this.data = data;
    }
}
