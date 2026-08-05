package cn.vetech.center.hotel.link.mtw.price.lowestprice.response;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:36
 */
public class MtwHotelLowestPrice {
    /**
     * 酒店 id
     */
    private String hotelId;
    /**
     * 酒店最低价日历模型
     */
    private List<MtwLowestPriceModel> lowestPriceModels;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public List<MtwLowestPriceModel> getLowestPriceModels() {
        return lowestPriceModels;
    }

    public void setLowestPriceModels(List<MtwLowestPriceModel> lowestPriceModels) {
        this.lowestPriceModels = lowestPriceModels;
    }
}