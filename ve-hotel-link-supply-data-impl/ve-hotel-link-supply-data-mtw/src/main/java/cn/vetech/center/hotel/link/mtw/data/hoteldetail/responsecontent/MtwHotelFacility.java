package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:43
 */
public class MtwHotelFacility {

    /**
     * 酒店设施类别：
     * HOTEL_SERVICE：酒店服务;
     * HOTEL_FACILITY:酒店设施;
     */
    private String category;

    private List<MtwHotelFacilityItem> facilityItems;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MtwHotelFacilityItem> getFacilityItems() {
        return facilityItems;
    }

    public void setFacilityItems(List<MtwHotelFacilityItem> facilityItems) {
        this.facilityItems = facilityItems;
    }
}
