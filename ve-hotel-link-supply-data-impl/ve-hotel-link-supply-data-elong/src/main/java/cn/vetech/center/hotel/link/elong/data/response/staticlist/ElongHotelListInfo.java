package cn.vetech.center.hotel.link.elong.data.response.staticlist;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:07
 */
public class ElongHotelListInfo {

    /**
     * 酒店ID
     */
    @JsonProperty("HotelId")
    private String hotelId;
    /**
     * 酒店中文名称
     */
    @JsonProperty("HotelName")
    private String hotelName;
    /**
     * 酒店英文名称
     */
    @JsonProperty("HotelNameEn")
    private String hotelNameEn;
    /**
     * 酒店状态	    0:有效 1:无效 2:删除
     */
    @JsonProperty("HotelStatus")
    private String hotelStatus;
    /**
     * 酒店更新		0:酒店基础数据，1:房型数据，2:图片数据，4:供应商数据，多个用“;”隔开，以最后一次更新为主
     */
    @JsonProperty("Modification")
    private String modification;
    /**
     * 更新时间			酒店数据更新时间
     */
    @JsonProperty("UpdateTime")
    private String updateTime;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelNameEn() {
        return hotelNameEn;
    }

    public void setHotelNameEn(String hotelNameEn) {
        this.hotelNameEn = hotelNameEn;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
