package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:27
 */
public class MtwHotelPetPolicy {

    /**
     * 是否允许带宠物：
     * 0-禁止；
     * 1-允许，不确认收费情况；
     * 2-允许，收费；
     * 3-允许，免费；
     */
    private String allowed;

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }
}
