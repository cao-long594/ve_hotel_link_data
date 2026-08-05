package cn.vetech.center.hotel.link.mtw.price.response;

import cn.vetech.center.hotel.link.mtw.common.MtwResponse;
import cn.vetech.center.hotel.link.mtw.price.lowestprice.response.MtwHotelLowestPrice;
import cn.vetech.center.hotel.link.mtw.price.multi.response.AvailabilityBean;
import cn.vetech.center.hotel.link.mtw.ratesearch.response.MtHotelResult;

import java.util.List;

public class MtwHotelPriceResponse extends MtwResponse {

    /***
     * 房源商返回的原始字符串
     */
    private List<String> priceStrs;
     /**
     * 价格返回对象
     */
    private List<MtHotelResult> mtHotelResult;
    /**
     * 价格返回对象
     */
    private List<AvailabilityBean> availabilityList;
    /**
     * 价格返回对象
     */
    private List<MtwHotelLowestPrice> hotelLowestPriceList;

    public List<MtwHotelLowestPrice> getHotelLowestPriceList() {
        return hotelLowestPriceList;
    }

    public void setHotelLowestPriceList(List<MtwHotelLowestPrice> hotelLowestPriceList) {
        this.hotelLowestPriceList = hotelLowestPriceList;
    }

    public List<String> getPriceStrs() {
        return priceStrs;
    }

    public void setPriceStrs(List<String> priceStrs) {
        this.priceStrs = priceStrs;
    }

    public List<MtHotelResult> getMtHotelResult() {
        return mtHotelResult;
    }

    public void setMtHotelResult(List<MtHotelResult> mtHotelResult) {
        this.mtHotelResult = mtHotelResult;
    }

    public List<AvailabilityBean> getAvailabilityList() {
        return availabilityList;
    }

    public void setAvailabilityList(List<AvailabilityBean> availabilityList) {
        this.availabilityList = availabilityList;
    }
}
