package cn.vetech.center.hotel.link.ylfx;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GetHotelMethodEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.supply.base.IHotelLinkDataSupplyService;
import cn.vetech.center.hotel.link.supply.base.util.SupplierConfigUtils;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxConfig;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.ylfx.data.YlfxHotelDetailService;
import cn.vetech.center.hotel.link.ylfx.data.v2.YlfxV2HotelCodeService;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 6161
 * @date 2024/07/19
 */
@Service
public class YlfxHotelLinkDataSupplyService implements IHotelLinkDataSupplyService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(YlfxHotelLinkDataSupplyService.class);
    /**
     * 酒店静态
     */
    @Autowired
    private YlfxHotelDetailService hotelDetailService;
    /**
     * V2 酒店静态
     */
    @Autowired
    private YlfxV2HotelCodeService v2HotelCodeService;

    @Override
    public RestResponse<HotelInitVO> init(HotelBaseDTO dto) throws SystemException {
        return ApiRes.success(new HotelInitVO(GetHotelMethodEnum.HOTEL_ID));
    }

   @Override
    public RestResponse<List<HotelIdVO>> getHotelIdList(HotelListDTO dto) throws SystemException {
        YlfxConfig config = SupplierConfigUtils.parse(dto.getSupplier(), YlfxConfig.class);
        if ("v2".equals(config.getApiVersion())) {
            return v2HotelCodeService.getHotelIdList(config);
        }
        if (StringUtils.isNotBlank(config.getApiVersion())) {
            LOGGER.warn("易旅分销未知 apiVersion [{}]，回退旧版酒店编码接口", config.getApiVersion());
        }
        return hotelDetailService.getHotelIdList(config);
    }

    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) throws SystemException {
        YlfxConfig config = SupplierConfigUtils.parse(dto.getSupplier(), YlfxConfig.class);
        return hotelDetailService.getHotelDetailByHotelId(dto, config);
    }

    @Override
    public RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_SUPPORT);
    }

    @Override
    public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) throws SystemException {
        return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_SUPPORT);
    }
}
