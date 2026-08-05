package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 14:11
 */
public class ElongHotelTypeInfo {

    /***
     * 酒店类型ID
     */
    @JsonProperty("HotelTypeId")
    private String hotelTypeId;
    /***
     * 酒店类型中文名称
     */
    @JsonProperty("HotelTypeName")
    private String hotelTypeName;
    /***
     * 酒店类型英文名称
     */
    @JsonProperty("HotelTypeNameEn")
    private String hotelTypeNameEn;

    public String getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(String hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public String getHotelTypeName() {
        return hotelTypeName;
    }

    public void setHotelTypeName(String hotelTypeName) {
        this.hotelTypeName = hotelTypeName;
    }

    public String getHotelTypeNameEn() {
        return hotelTypeNameEn;
    }

    public void setHotelTypeNameEn(String hotelTypeNameEn) {
        this.hotelTypeNameEn = hotelTypeNameEn;
    }
}
