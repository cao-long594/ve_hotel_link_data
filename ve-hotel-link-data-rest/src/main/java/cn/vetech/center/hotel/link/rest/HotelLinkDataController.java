package cn.vetech.center.hotel.link.rest;

import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.modules.utils.concurrent.ThreadUtil;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author wangkai
 * @since 2022/1/18
 */
@RestController
@RequestMapping("/ve-hotel-link-data/")
public class HotelLinkDataContrller {


    private final static Logger logger = LoggerFactory.getLogger(HotelLinkDataContrller.class);

    @Autowired
    private ConfigurableEnvironment env;

    /**
     *
     */
    private AtomicInteger count = new AtomicInteger(0);
    /**
     * 大于多少
     */
    private int maxcount = 20;

    @Autowired
    private  MessageSource messageSource;

    /**
     * @param sleepSecond sleepSecond
     * @return cn.vetech.charge.cloud.springcloud.api.RestResponse<java.lang.String>
     */
    @RequestMapping("/info")
    public RestResponse<String> getInfo(@RequestParam(defaultValue = "1", name = "sleepSecond") Integer sleepSecond) {
        if (count.incrementAndGet() > maxcount) {
            ThreadUtil.sleep(sleepSecond, TimeUnit.SECONDS);
        }
        return ApiRes.success();
    }






}
