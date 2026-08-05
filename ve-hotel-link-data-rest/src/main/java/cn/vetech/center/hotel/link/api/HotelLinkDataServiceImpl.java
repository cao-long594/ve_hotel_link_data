package cn.vetech.center.hotel.link.api;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPoiListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderFlowDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.enums.InitHotelEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceVO;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.orderflow.LinkHotelOrderFlowVO;
import cn.vetech.center.hotel.link.api.data.vo.poi.LinkHotelPoiListVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.enums.CurrencyEnum;
import cn.vetech.center.hotel.link.supply.service.distribute.HotelDataDistributeService;
import cn.vetech.center.hotel.link.supply.service.distribute.init.HotelDataInitCacheService;
import cn.vetech.center.hotel.link.supply.service.exchangerate.ExchangeRateService;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.log.annotation.Log;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import io.swagger.annotations.Api;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 酒店基础数据接口
 * </p>
 *
 * @author wangkai
 * @since 2020/10/19
 */
@Api(tags = {"酒店基础数据接口"})
@RestController
@RequestMapping("/api/vehotellink/hoteldata")
public class HotelLinkDataServcieImpl implements IHotelLinkDataServcie {
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 分发
     */
    @Autowired
    private HotelDataDistributeService hotelDataDistributeService;

    /**
     * 控制初始并发
     */
    @Autowired
    private HotelDataInitCacheService hotelDataInitCacheService;

    /**
     * 汇率服务
     */
    @Autowired
    private ExchangeRateService exchangeRateService;


    @Override
    @Log(name = "初始供应商信息", logParam = true, time = true)
    public RestResponse<HotelInitVO> init(@RequestBody HotelBaseDTO dto) throws SystemException {
        //返回成功  返回 需要继续获取状态
        int rtn = hotelDataInitCacheService.begin(dto);
        if (rtn != InitHotelEnum.COMPLETETHENRUNNER.getStatus()) {
            HotelInitVO vo = new HotelInitVO();
            vo.setStatus(rtn);
            return new RestResponse<>(vo);
        }
        hotelDataDistributeService.init(dto);
        HotelInitVO vo = new HotelInitVO();
        vo.setStatus(InitHotelEnum.RUNNER.getStatus());
        return new RestResponse<>(vo);
    }

    @Override
    @Log(name = "获取供应商所有酒店ID", logParam = true, time = true)
    public RestResponse<List<HotelIdVO>> getHotelIdList(@RequestBody HotelListDTO dto) throws SystemException {
        return hotelDataDistributeService.getHotelIdList(dto);
    }

    @Override
    public RestResponse<HotelIdResponseVO> getHotelIdListByPage(@RequestBody HotelListDTO dto) throws SystemException {
        return hotelDataDistributeService.getHotelIdListByPage(dto);
    }

    @Override
    @Log(name = "根据酒店ID获取酒店详情", logParam = true, time = true)
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(@RequestBody HotelDetailHotleIdDTO dto) throws SystemException {
        return hotelDataDistributeService.getHotelDetailByHotelId(dto);
    }

    @Override
    @Log(name = "获取供应商所有城市ID", logParam = true, time = true)
    public RestResponse<List<HotelCityIdVO>> getCityIdList(@RequestBody HotelBaseDTO dto) throws SystemException {
        return hotelDataDistributeService.getCityIdList(dto);
    }


    @Override
    @Log(name = "根据城市ID获取酒店详情", logParam = true, time = true)
    public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(@RequestBody HotelDetailCityIdDTO dto) throws SystemException {
        return hotelDataDistributeService.getHotelDetailByCityId(dto);
    }

    @Override
    public RestResponse<HotelPriceResponseVO> getHotelPrice(@RequestBody HotelPriceDTO dto) throws SystemException {
        RestResponse<HotelPriceResponseVO> response = hotelDataDistributeService.getHotelPrice(dto);
        //处理币种不是CNY的价格 按照汇率转成人民币
        if (Objects.isNull(response) || !StringUtils.equals("200", response.getStatus()) || Objects.isNull(response.getResult())) {
            return response;
        }
        HotelPriceResponseVO result = response.getResult();
        List<HotelPriceVO> hotelPriceVOS = result.getHotelPriceVOS();
        if (CollectionUtils.isEmpty(hotelPriceVOS)) {
            return response;
        }
        List<HotelPriceVO> priceVOS = hotelPriceVOS.stream().filter(vo -> StringUtils.isNotBlank(vo.getCurrencyCode()) && !StringUtils.equals(vo.getCurrencyCode(), CurrencyEnum.CNY.getCurrency())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(priceVOS)) {
            return response;
        }
        List<HotelPriceVO> allVOList = hotelPriceVOS.stream().filter(vo -> StringUtils.isBlank(vo.getCurrencyCode()) || StringUtils.equals(vo.getCurrencyCode(), CurrencyEnum.CNY.getCurrency())).collect(Collectors.toList());
        priceVOS.forEach(vo -> {
            try {
                BigDecimal exchangeRate = exchangeRateService.getCpsChargeExchangeRate(dto.getPt(), vo.getCurrencyCode());
                //汇率等于1 不处理
                if (Objects.isNull(exchangeRate) || exchangeRate.compareTo(BigDecimal.ONE) == NumConstant.NUM_0) {
                    allVOList.add(vo);
                    return;
                }
                String transPrice = exchangeRateService.transPrice(String.valueOf(vo.getPrice()), exchangeRate);
                if (StringUtils.isBlank(transPrice)) {
                    return;
                }
                vo.setPrice(Double.parseDouble(transPrice));
                allVOList.add(vo);
            } catch (Exception e) {
                logger.error("【{}】最低价拉取转换人名币处理异常【{}】【】", JacksonUtils.toJsonWithNonEmpty(vo), e.getMessage(), e);
            }
        });
        result.setHotelPriceVOS(allVOList);
        response.setResult(result);
        return response;
    }
    @Override
    @Log(name = "获取供应商订单列表", logParam = true, time = true)
    public RestResponse<LinkHotelOrderListVO> orderList(@RequestBody LinkHotelOrderListDTO dto) throws SystemException {
        return hotelDataDistributeService.getOrderList(dto);
    }

    @Override
    public RestResponse<HotelIdResponseVO> getIncHotelIdListByPage(@RequestBody HotelListDTO dto) throws SystemException {
        return hotelDataDistributeService.getIncHotelIdListByPage(dto);
    }

    @Override
    public RestResponse<LinkHotelPoiListVO> getPoiListByPage(@RequestBody HotelPoiListDTO dto) throws SystemException {
        return hotelDataDistributeService.getPoiListByPage(dto);
    }

    @Override
    public RestResponse<LinkHotelOrderFlowVO> getOrderFlow(@RequestBody LinkHotelOrderFlowDTO dto) throws SystemException {
        return hotelDataDistributeService.getOrderFlow(dto);
    }
}
