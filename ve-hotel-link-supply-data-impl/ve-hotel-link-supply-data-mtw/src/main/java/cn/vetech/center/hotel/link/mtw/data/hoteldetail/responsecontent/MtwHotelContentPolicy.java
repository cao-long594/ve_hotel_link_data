package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:55
 */
public class MtwHotelContentPolicy {

    /**
     * 入住政策
     */
    private MtwHotelStartEnd checkinPolicy;
    /**
     *
     * 离店政策
     */
    private MtwHotelStartEnd checkOutPolicy;

    /**
     * 住客政策
     */
    private MtwHotelGuestPoicy guestPolicy;

    /**
     *
     * 早餐政策
     */
    private MtwHotelBreakfastPolicy breakfastPolicy;

    /**
     *
     * 宠物政策。
     */
    private MtwHotelPetPolicy petPolicy;

    /**
     *
     * 停车场政策（具体参见停车场政策字典）
     */
    private List<MtwHotelParkingPolicy> parkingPolicies;
 /**
     *
     * 充电车位政策（具体参见充电车位政策字典）
     */
    private List<MtwHotelChargePointPolicy> chargePointPolicies;

    public MtwHotelStartEnd getCheckinPolicy() {
        return checkinPolicy;
    }

    public void setCheckinPolicy(MtwHotelStartEnd checkinPolicy) {
        this.checkinPolicy = checkinPolicy;
    }

    public MtwHotelStartEnd getCheckOutPolicy() {
        return checkOutPolicy;
    }

    public void setCheckOutPolicy(MtwHotelStartEnd checkOutPolicy) {
        this.checkOutPolicy = checkOutPolicy;
    }

    public MtwHotelGuestPoicy getGuestPolicy() {
        return guestPolicy;
    }

    public void setGuestPolicy(MtwHotelGuestPoicy guestPolicy) {
        this.guestPolicy = guestPolicy;
    }

    public MtwHotelBreakfastPolicy getBreakfastPolicy() {
        return breakfastPolicy;
    }

    public void setBreakfastPolicy(MtwHotelBreakfastPolicy breakfastPolicy) {
        this.breakfastPolicy = breakfastPolicy;
    }

    public MtwHotelPetPolicy getPetPolicy() {
        return petPolicy;
    }

    public void setPetPolicy(MtwHotelPetPolicy petPolicy) {
        this.petPolicy = petPolicy;
    }

    public List<MtwHotelParkingPolicy> getParkingPolicies() {
        return parkingPolicies;
    }

    public void setParkingPolicies(List<MtwHotelParkingPolicy> parkingPolicies) {
        this.parkingPolicies = parkingPolicies;
    }

    public List<MtwHotelChargePointPolicy> getChargePointPolicies() {
        return chargePointPolicies;
    }

    public void setChargePointPolicies(List<MtwHotelChargePointPolicy> chargePointPolicies) {
        this.chargePointPolicies = chargePointPolicies;
    }
}