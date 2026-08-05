package cn.vetech.center.hotel.link.mtw.price.lowestprice.request;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:32
 */
public class MtwLowestPriceRequestData {

    /**
     * 请求查询的酒店 ID列表，一次最多查询10 个； 默认查询 poi 下可订全日房的最低价
     */
    private List<Long> hotelIds;
    /**
     * 入住日期，格式为 yyyy-MM-dd，不能早于当前日期
     */
    private String checkinDate;
    /**
     * 离店日期，格式为 yyyy-MM-dd，与当前日期相差不能超过 30 天
     */
    private String checkoutDate;

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
