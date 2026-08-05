package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:13
 */
public class MtwHotelBaseInfo {

    /**
     * String 是 全季酒店（北京望京店） 酒店名称
     */
    private String name;
    /**
     * String 否 酒店英文名称
     */
    private String nameEn;
    /**
     *  String 否 15904071558 酒店联系电话
     */
    private String phone;
    /**
     *  boolean  否 false 酒店是否可订。false:不可订，true:可订
     */
    private String bookable;

    /**
     *  Address 是  酒店位置信息, 酒店所在城市、省份、行政区、经纬度、详细地址信息等
     */
    private MtwHotelAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBookable() {
        return bookable;
    }

    public void setBookable(String bookable) {
        this.bookable = bookable;
    }

    public MtwHotelAddress getAddress() {
        return address;
    }

    public void setAddress(MtwHotelAddress address) {
        this.address = address;
    }
}
