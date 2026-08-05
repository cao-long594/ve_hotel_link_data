ackage cn.vetech.center.hotel.link.mtw.price.multi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2024/8/1 9:20
 */
public class MtwMultiRequestData {
    /**
     * filter
     */
    @JsonProperty("filter")
    private FilterBean filter;
    /**
     * checkin
     */
    @JsonProperty("checkin")
    private String checkin;
    /**
     * hotelIds
     */
    @JsonProperty("hotelIds")
    private List<Long> hotelIds;
    /**
     * currency
     */
    @JsonProperty("currency")
    private String currency;
    /**
     * checkout
     */
    @JsonProperty("checkout")
    private String checkout;
    /**
     * roomCriteria
     */
    @JsonProperty("roomCriteria")
    private RoomCriteriaBean roomCriteria;
    /**
     * 产品ID，最多一次100个
     */
    private List<Long> productIds;

    public FilterBean getFilter() {
        return filter;
    }

    public void setFilter(FilterBean filter) {
        this.filter = filter;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public RoomCriteriaBean getRoomCriteria() {
        return roomCriteria;
    }

    public void setRoomCriteria(RoomCriteriaBean roomCriteria) {
        this.roomCriteria = roomCriteria;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
