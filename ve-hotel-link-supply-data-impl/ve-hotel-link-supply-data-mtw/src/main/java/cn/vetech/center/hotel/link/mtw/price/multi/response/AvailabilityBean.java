package cn.vetech.center.hotel.link.mtw.price.multi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 10:45
 */
public class AvailabilityBean {
    /**
     * availProduct
     */
    @JsonProperty("availProduct")
    private List<AvailProductBean> availProduct;
    /**
     * hotelId
     */
    @JsonProperty("hotelId")
    private Integer hotelId;

    public List<AvailProductBean> getAvailProduct() {
        return availProduct;
    }

    public void setAvailProduct(List<AvailProductBean> availProduct) {
        this.availProduct = availProduct;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}
