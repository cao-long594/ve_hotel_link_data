package cn.vetech.center.hotel.link.mtw.price.lowestprice.response;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/10/24 14:34
 */
public class MtwLowestPriceResult {
    /**
     *
     */
    private List<MtwHotelLowestPrice> hotelLowestPriceList;

    public List<MtwHotelLowestPrice> getHotelLowestPriceList() {
        return hotelLowestPriceList;
    }

    public void setHotelLowestPriceList(List<MtwHotelLowestPrice> hotelLowestPriceList) {
        this.hotelLowestPriceList = hotelLowestPriceList;
    }
}
