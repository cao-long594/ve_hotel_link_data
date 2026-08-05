package cn.vetech.center.hotel.outface.hotelinfo.bnp;

import cn.vetech.center.hotel.outface.hotelinfo.bnp.common.HotelDescriptiveContentNotifRS;
import cn.vetech.center.hotel.outface.hotelinfo.bnp.common.NotifRSSuccess;
import cn.vetech.center.hotel.outface.lowprice.ReceiveLowPriceController;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import com.google.common.util.concurrent.AtomicLongMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/11 16:31
 */
@Api(tags = {"BNP酒店数据推送"})
@RestController
@RequestMapping("/push/bnp")
public class BnpPushHotelDataController {
    /**
     * 日志工具
     */
    private Logger logger = LoggerFactory.getLogger(BnpPushHotelDataController.class);
    /**
     * bnp数据推送服务
     */
    @Autowired
    private BnpPushHotelDataService pushHotelDataService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    private AtomicLongMap<String> countMap = AtomicLongMap.create();
    /**
     * BNP酒店详情数据推送
     *
     * @return ReceiveResponse
     */
    @ApiOperation(value = "BNP酒店数据推送")
    @PostMapping(value = "/uploadHotelInfo", consumes = "text/xml; charset=UTF-8")
    public HotelDescriptiveContentNotifRS uploadHotelInfo() throws IOException {
        String req = IOUtils.toString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        recordCountAndSize("hotelInfo", StringUtils.length(req));
        pushHotelDataService.uploadHotelInfo(req);
        return success();
    }

    /**
     * BNP房型数据推送
     *
     * @return ReceiveResponse
     */
    @ApiOperation(value = "BNP房型数据推送")
    @PostMapping(value = "/uploadRoomInfo", consumes = "text/xml; charset=UTF-8")
    public HotelDescriptiveContentNotifRS uploadRoomInfo() throws IOException {
        String req = IOUtils.toString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        recordCountAndSize("roomInfo", StringUtils.length(req));
        pushHotelDataService.uploadRoomInfo(req);
        return success();
    }
    /**
     * 成功返回
     *
     * @return HotelContentNotifResponse
     */
    private HotelDescriptiveContentNotifRS success() {
        HotelDescriptiveContentNotifRS notifRS = new HotelDescriptiveContentNotifRS();
        NotifRSSuccess notifRSSuccess = new NotifRSSuccess();
        notifRS.setSuccess(notifRSSuccess);
        return notifRS;
    }

    public  void recordCountAndSize(String type,long length){
        try {
            String shortmm = VeDate.getStringDateShortmm();
            String countKey = String.join("-", shortmm, type, "count");
            String sizeKey= String.join("-", shortmm, type, "length");
            if (!countMap.containsKey(countKey)){
                logger.info("当前记录的数据推送大小以及次数:{}",countMap);
            }
            if (countMap.size()>120){
                logger.info("记录清除前记录的请求信息和大小：{}", countMap);
                countMap.clear();
            }
            countMap.incrementAndGet(countKey);
            countMap.addAndGet(sizeKey, length);
        }catch (Exception e){
                logger.error("记录日志出现异常",e);
        }
    }


}
