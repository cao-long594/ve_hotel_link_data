package cn.vetech.center.hotel.link.api;

import cn.vetech.center.hotel.link.api.ratesearch.dto.LinkHotelRateSearchDTO;
import cn.vetech.center.hotel.link.api.ratesearch.vo.LinkHotelRateSearchVO;
import cn.vetech.center.hotel.link.api.validategn.dto.LinkHotelValidateGnDTO;
import cn.vetech.center.hotel.link.api.validategn.vo.LinkHotelValidateGnVO;
import cn.vetech.center.hotel.link.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.supply.service.ratesearch.RateSearchAsyncService;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.log.annotation.Log;
import cn.vetech.charge.cloud.modules.utils.base.ExceptionUtil;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipeng
 */
@Api(tags = {"酒店查询预订标准接口"})
@RestController
@RequestMapping("/api/vehotellink")
public class HotelLinkServiceImpl extends AbstractHotelLinkService {

    /**
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelLinkServiceImpl.class);


    @Autowired
    private RateSearchAsyncService rateSearchAsyncService;

    /**
     * asms10000、cps使用
     *
     * @param dto 1
     * @return 1
     */
    //拿掉这里记录通用日志 CPS 调用会出现重复记录
    // @CommonLog(jkzh = "查询报价",jkmc = "RateSearch",ddlx = DdlxEnum.DDLX0300_0,jklx = JklxEnum.CX_1001)
    @Log(name = "查询报价")
    @Override
    public RestResponse<LinkHotelRateSearchVO> rateSearchSingle(@RequestBody LinkHotelRateSearchDTO dto) {
        try {
            return new RestResponse<>(rateSearchAsyncService.rateSearchForAsmsAndCps(dto));
        } catch (Exception e) {
            LOGGER.error("查询报价接口异常", e);
            return ApiRes.response(DataResponseEnum.SYSTEM_ERROR, ExceptionUtil.stackTraceText(e));
        }
    }

    @Override
    public RestResponse<LinkHotelValidateGnVO> validateGn(LinkHotelValidateGnDTO dto) {
        return ApiRes.success();
    }


}
