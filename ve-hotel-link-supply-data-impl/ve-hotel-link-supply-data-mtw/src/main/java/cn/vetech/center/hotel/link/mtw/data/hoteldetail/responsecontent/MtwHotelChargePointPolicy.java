package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:36
 */
public class MtwHotelChargePointPolicy {

    /**
     *
     * 充电车位政策项包括：
     * HAS_CHARGING_POINT：是否有充电车位；
     * CHARGING_POINT_LOCATION：充电车位位置；
     * CHARGING_POINT_TYPE：充电车位类型；
     * CHARGING_POINT_COUNT：充电车位数量；
     * CHARGING_POINT_DISTANCE：停车后步行距离；
     */
    private List<MtwHotelPolicyItem> policyItems;

    public List<MtwHotelPolicyItem> getPolicyItems() {
        return policyItems;
    }

    public void setPolicyItems(List<MtwHotelPolicyItem> policyItems) {
        this.policyItems = policyItems;
    }
}
