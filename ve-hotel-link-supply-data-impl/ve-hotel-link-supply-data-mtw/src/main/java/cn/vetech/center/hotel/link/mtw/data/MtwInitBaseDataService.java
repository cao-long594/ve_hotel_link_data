package cn.vetech.center.hotel.link.mtw.data.hoteldetail;

import cn.vetech.center.hotel.link.enums.CachePrefix;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.supply.base.cache.HotelBaseDataCacheService;
import cn.vetech.charge.cloud.modules.utils.collection.MapUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * @author xiaotengyu
 * @since 2021/8/30 21:12
 */
@Service
public class MtwInitBaseDataService {

    @Autowired
    private HotelBaseDataCacheService hotelBaseDataCacheService;  //获取缓存

    private Map<String, Object> facitoryMap = new HashedMap();

    /**
     * 国内城市 供应商的
     *
     * @param config
     */
    public void putFacilities(MtwConfig config, Map<String, Object> facilitiesMap) {
        hotelBaseDataCacheService.put(CachePrefix.FACILITIE_CACHE_PREFIX, config, facilitiesMap);
    }

    /***
     * 根据国内城市 ID 获取城市
     * @param config
     * @param cid
     * @return
     */
    public String getFacilityBywbbh(MtwConfig config, String wbbh) {
        if(MapUtil.isNotEmpty(facitoryMap)){
            Object obj = facitoryMap.get(wbbh);
            if (Objects.nonNull(obj)) {
                return String.valueOf(obj);
            }
        }
        Object object = hotelBaseDataCacheService.get(CachePrefix.FACILITIE_CACHE_PREFIX, config, wbbh);
        if (Objects.nonNull(object)) {
            facitoryMap.put(wbbh, object);
            return String.valueOf(object);
        }else{
            facitoryMap.put(wbbh, StringUtils.EMPTY);
        }
        return StringUtils.EMPTY;
    }

}
