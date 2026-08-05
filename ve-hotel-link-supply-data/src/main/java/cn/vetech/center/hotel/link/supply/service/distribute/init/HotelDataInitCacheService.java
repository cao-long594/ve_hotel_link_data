package cn.vetech.center.hotel.link.supply.service.distribute.init;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.enums.InitHotelEnum;
import cn.vetech.center.hotel.link.enums.CachePrefix;
import cn.vetech.charge.cloud.cache.api.IVeCacheManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;

/**
 * 控制init访问
 *
 * @author houya
 */
@Service
public class HotelDataInitCacheService {
    /**
     * 60分钟 正在运行的时间
     */
    private static final int RUNNERMAXMIN = 300;
    /**
     * 离上次完成的时间,上次完成后见过多少时间 可以继续 初始化 避免返回重复的调用初始化
     */
    private static final int RUNNEROVERTIME = 30;
    /**
     * 缓存
     */
    @Autowired
    private IVeCacheManage iVeCacheManage;

    /**
     * 开始
     *
     * @param dto
     * @return 1 需要等待  2 成功完成 3 需要执行 返回需要等待的
     */
    public int begin(HotelBaseDTO dto) {
        HotelDataInitVO hotelDataInitVO = (HotelDataInitVO) iVeCacheManage.getHash(CachePrefix.INIT_CACHE_PREFIX.getKeyPrefix(), dto.getFybh());
        if (hotelDataInitVO != null) {
            //正在进行 并且开始时间小于给定时间 2个小时,否则视为程序重启
            int min = VeDate.getTwoMin(VeDate.getStringDate(), hotelDataInitVO.getBeginTime());
            if ("1".equals(hotelDataInitVO.getStatus()) && min < RUNNERMAXMIN) {
                return InitHotelEnum.RUNNER.getStatus();
            }
            //如果是已完成状态, 并且完成时间在2个小时内的,算有效
            if ("2".equals(hotelDataInitVO.getStatus())) {
                int minend = VeDate.getTwoMin(VeDate.getStringDate(), hotelDataInitVO.getEndTime());
                if (minend <= RUNNEROVERTIME) {
                    return InitHotelEnum.COMPLETE.getStatus();
                }
            }
        } else {
            hotelDataInitVO = new HotelDataInitVO();
        }
       hotelDataInitVO.setBeginTime(VeDate.getStringDate());
        hotelDataInitVO.setStatus("1");
        hotelDataInitVO.setAccessTime(VeDate.getStringDate());
        hotelDataInitVO.setEndTime(null);
        iVeCacheManage.putHash(CachePrefix.INIT_CACHE_PREFIX.getKeyPrefix(), dto.getFybh(), hotelDataInitVO);
        return InitHotelEnum.COMPLETETHENRUNNER.getStatus();
    }

    /**
     * 结束
     *
     * @param dto
     */
    public void end(HotelBaseDTO dto, String status) {
        HotelDataInitVO hotelDataInitVO = (HotelDataInitVO) iVeCacheManage.getHash(CachePrefix.INIT_CACHE_PREFIX.getKeyPrefix(), dto.getFybh());
        if (hotelDataInitVO != null) {
            hotelDataInitVO.setStatus(status);
            hotelDataInitVO.setEndTime(VeDate.getStringDate());
            iVeCacheManage.putHash(CachePrefix.INIT_CACHE_PREFIX.getKeyPrefix(), dto.getFybh(), hotelDataInitVO);
        }
    }
}
