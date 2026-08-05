package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:31
 */
public class MtwHotelParkingPolicy {

    /**
     *
     * 停车场政策项包括：
     * HAS_PARKING：是否有停车场；
     * PARKING_LOCATION：停车场位置；
     * PARKING_TYPE：停车场类型；
     * PARKING_BOOK_TYPE：停车场预订；
     * PARKING_FEE_TYPE：停车场费用类型；
     * PARKING_FEE_UNIT：停车场收费单位；
     * PARKING_AMOUNT：停车场收费金额；
     * PARKING_COUNT：车位数量；
     * PARKING_DISTANCE：停车后步行距离；
     */
    private List<MtwHotelPolicyItem> policyItems;

    public List<MtwHotelPolicyItem> getPolicyItems() {
        return policyItems;
    }

    public void setPolicyItems(List<MtwHotelPolicyItem> policyItems) {
        this.policyItems = policyItems;
    }
}
