package cn.vetech.center.hotel.link.elong.data.response.staticcity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 9:33
 */
public class ElongStaticLocation {

    /***
     * LocationID
     */
    @JsonProperty("LocationID")
    private String locationID;

    /***
     * Location中文名称
     */
    @JsonProperty("LocationName")
    private String locationName;

    /***
     * Location英文名称
     */
    @JsonProperty("LocationNameEn")
    private String locationNameEn;

    /***
     * Location类型	 1:行政区2:商圈3:标示物
     */
    @JsonProperty("LocationType")
    private String locationType;

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationNameEn() {
        return locationNameEn;
    }

    public void setLocationNameEn(String locationNameEn) {
        this.locationNameEn = locationNameEn;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}