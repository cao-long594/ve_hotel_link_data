package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:59
 */
public class MtwHotelGuestPoicy {

    /**
     *
     * 外宾政策
     * 0、无；
     * 1、酒店接待大陆、港澳台及外国客人；
     * 2、酒店仅接待大陆客人；
     * 3、酒店仅接待大陆和港澳台客人；
     */
    private MtwHotelCodeName guestType;

    /**
     * 儿童及加床政策描述信息
     */
    private String children;

    public MtwHotelCodeName getGuestType() {
        return guestType;
    }

    public void setGuestType(MtwHotelCodeName guestType) {
        this.guestType = guestType;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
