package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import java.util.Map;

/**酒店扩展信息。
 * @author xingyanyan on 2018/9/4.
 */
public class MtwHotelExtendInfo {
    /**
     *酒店设施，key表示酒店设施ID（ID对应设施参看酒店设施），value="0"表示不提供该设施；value="1"表示提供该设施。
     */
    private Map<String, String> hotelFacilities;
    /**
     * 酒店服务，key表示酒店服务ID（ID对应服务参看酒店服务），value="0"表示不提供该服务；value="1"表示提供该服务。
     */
    private Map<String, String> hotelService;
    /**
     *
     */
    private MtwPoiExtInfo poiExtInfo;

    public Map<String, String> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(Map<String, String> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

    public Map<String, String> getHotelService() {
        return hotelService;
    }

    public void setHotelService(Map<String, String> hotelService) {
        this.hotelService = hotelService;
    }

    public MtwPoiExtInfo getPoiExtInfo() {
        return poiExtInfo;
    }

    public void setPoiExtInfo(MtwPoiExtInfo poiExtInfo) {
        this.poiExtInfo = poiExtInfo;
    }
}
