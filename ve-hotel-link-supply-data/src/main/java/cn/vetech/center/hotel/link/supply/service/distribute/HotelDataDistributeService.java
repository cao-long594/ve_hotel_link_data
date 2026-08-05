package cn.vetech.center.hotel.link.supply.service.distribute;

import cn.vetech.center.hotel.link.api.LinkHotelDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPoiListDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelPriceDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderFlowDTO;
import cn.vetech.center.hotel.link.api.data.dto.LinkHotelOrderListDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelPriceResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.LinkHotelOrderListVO;
import cn.vetech.center.hotel.link.api.data.vo.orderflow.LinkHotelOrderFlowVO;
import cn.vetech.center.hotel.link.api.data.vo.poi.LinkHotelPoiListVO;
import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.api.enums.PtEnum;
import cn.vetech.center.hotel.link.supply.base.IHotelLinkDataSupplyService;
import cn.vetech.center.hotel.link.supply.base.exception.HotelConfigExcetion;
import cn.vetech.center.hotel.link.supply.base.exception.SupplyBusinessException;
import cn.vetech.center.hotel.link.supply.base.exception.SupplyServiceException;
import cn.vetech.center.hotel.link.supply.service.distribute.config.HotelConfigDistributeService;
import cn.vetech.center.hotel.link.supply.service.distribute.init.HotelDataInitCacheService;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.JsonMapperUtil;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.modules.utils.collection.MapUtil;
import cn.vetech.charge.cloud.modules.utils.http.VeHttpRequestRetryHandler;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * <p>
 * 静态数据分发
 * </p>
 *
 * @author wangkai
 * @since 2020/10/19
 */
@Service
public class HotelDataDistributeService {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelDataDistributeService.class);

    /**
     * 注入酒店接口实现
     */
    @Autowired
    private Map<String, IHotelLinkDataSupplyService> staticDataServiceMap;

    /**
     * 配置获取
     */
    @Autowired
    private HotelConfigDistributeService hotelConfigDistributeService;

    /**
     * 控制初始并发
     */
    @Autowired
    private HotelDataInitCacheService hotelDataInitCacheService;

    /**
     * 初始化供应商基础信息
     *
     * @param dto 入参
     * @return RestResponse
     * @throws SystemException 系统异常
     */
    @Async
    public Future<RestResponse<HotelInitVO>> init(@RequestBody HotelBaseDTO dto) throws SystemException {
        RestResponse<HotelInitVO> restResponse;
        String status = "0";
        try {
            restResponse = getServiceAndConfig(dto, true).init(dto);
            if (restResponse.isSuccess()) {
                status = "2";
            } else {
                LOGGER.error("供应商:{}初始化失败，失败信息:{}", dto.getFybh(), restResponse.getMessage());
            }
        } catch (HotelConfigExcetion e) {
            LOGGER.error("供应商静态数据初始化获取供应商配置异常，请求参数:【{}】", JsonMapperUtil.toJsonStr(dto), e);
            restResponse = new RestResponse<>(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            LOGGER.error("供应商静态数据初始化未找到对应实现类，请求参数:【{}】", JsonMapperUtil.toJsonStr(dto), e);
            restResponse = new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            LOGGER.error("供应商静态数据初始化SupplyBusinessException异常，请求参数:【{}】", JsonMapperUtil.toJsonStr(dto), e);
            restResponse = ApiRes.fail(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("供应商静态数据初始化异常，请求参数:【{}】", JsonMapperUtil.toJsonStr(dto), e);
            restResponse = ApiRes.fail(e.getMessage());
        } finally {
            hotelDataInitCacheService.end(dto, status);
        }
        return new AsyncResult<>(restResponse);
    }

    /**
     * 获取供应商酒店id列表
     *
     * @param dto dto
     * @return RestResponse
     * @throws SystemException SystemException
     */
    public RestResponse<List<HotelIdVO>> getHotelIdList(HotelListDTO dto) throws SystemException {
        try {
            return getServiceAndConfig(dto, true).getHotelIdList(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }

    }

    /**
     * 获取供应商酒店id列表 分页
     *
     * @param dto dto
     * @return RestResponse
     * @throws SystemException SystemException
     */
    public RestResponse<HotelIdResponseVO> getHotelIdListByPage(HotelListDTO dto) throws SystemException {
        try {
            IHotelLinkDataSupplyService supplyService = getServiceAndConfig(dto, true);
            //优先调用分页获取酒店列表 没有实现则使用普通获取
            RestResponse<HotelIdResponseVO> responsePage = supplyService.getHotelIdListByPage(dto);
            if (Objects.isNull(responsePage) || StringUtils.equals(responsePage.getCode().getCode(), DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED.getCode())) {
                LOGGER.warn("分页获取酒店列表不支持或调用失败，service:【{}】，请求参数:【{}】，响应参数；【{}】", supplyService.getClass().getName(), JsonMapperUtil.toJsonStr(dto), JsonMapperUtil.toJsonStr(responsePage));
                //普通获取
                RestResponse<List<HotelIdVO>> restResponseId = supplyService.getHotelIdList(dto);
                RestResponse<HotelIdResponseVO> voRestResponse = new RestResponse<>(restResponseId.getCode());
                if (CollectionUtils.isNotEmpty(restResponseId.getResult())) {
                    HotelIdResponseVO responseVO = new HotelIdResponseVO();
                    responseVO.setHotelIdVOList(restResponseId.getResult());
                    voRestResponse.setResult(responseVO);
                    return ApiRes.success(responseVO);
                }
                return voRestResponse;
            }
            return responsePage;
        } catch (HotelConfigExcetion configExcetion) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }

    }

    /**
     * 获取供应商所有城市id
     *
     * @param dto 入参
     * @return RestResponse<HotelInfoResponseVO>
     * @throws SystemException 系统异常
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) throws SystemException {
        long t = System.currentTimeMillis();
        try {
            return getServiceAndConfig(dto, true).getHotelDetailByCityId(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        } catch (Exception e) {
            LOGGER.error("通过城市id获取供应商酒店信息异常，请求参数:【{}】", JsonMapperUtil.toJsonStr(dto), e);
            return ApiRes.fail(e.getMessage());
        } finally {
            LOGGER.info("读取供应商城市数据耗时{}", System.currentTimeMillis() - t);
        }

    }

    /**
     * 获取价格 最低价计算
     *
     * @param dto 入参
     * @return RestResponse<HotelPriceResponseVO>
     * @throws SystemException 系统异常
     */
    public RestResponse<HotelPriceResponseVO> getHotelPrice(HotelPriceDTO dto) throws SystemException {
        try {
            VeHttpRequestRetryHandler.setShouldRetry(Boolean.FALSE);
            IHotelLinkDataSupplyService iHotelLinkDataSupplyService = getServiceAndConfig(dto, true);
            return iHotelLinkDataSupplyService.getHotelPrice(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (Exception e) {
            LOGGER.error("最低价接口获取出现异常,请求参数:{}", JSONObject.toJSONString(dto), e);
            return ApiRes.fail(e.getMessage());
        }finally {
            VeHttpRequestRetryHandler.clearShouldRetry();
        }
    }

    /**
     * 设置代理
     *
     * @param supplier supplier
     */
    private static void setProxy(Map<String, String> supplier) {
        //配置校验
        if (MapUtils.isEmpty(supplier)) {
            return;
        }
        //检查代理配置
        String zdjProxy = supplier.get("zdjProxy");
        if (!StringUtils.startsWith(zdjProxy, "http")) {
            return;
        }
        if (!StringUtils.endsWith(zdjProxy, "/")) {
            zdjProxy = zdjProxy + "/";
        }
        //解析出代理域名 防止重复配置
        String proxyHost = URI.create(zdjProxy).getHost();
        for (Map.Entry<String, String> entry : supplier.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (!StringUtils.startsWithIgnoreCase(value, "http")) {
                continue;
            }
            //如果已经包含
            if (value.contains(proxyHost)) {
                continue;
            }
            String replaceValue = value.replaceFirst("http[s]?://", zdjProxy);
            supplier.put(key, replaceValue);
            LOGGER.info("供应请求通过代理访问{},{}", key, value);
        }
    }


    /**
     * 根据酒店id获取酒店详情
     *
     * @param dto 根据酒店id获取酒店详情入参
     * @return RestResponse
     * @throws SystemException 系统异常
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) throws SystemException {
        try {
            return getServiceAndConfig(dto, true).getHotelDetailByHotelId(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }
    }

    /**
     * 根据城市id获取酒店详情
     *
     * @param dto 酒店基础数据dto
     * @return RestResponse
     * @throws SystemException 系统异常
     */
    public RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) throws SystemException {
        try {

            return getServiceAndConfig(dto, true).getCityIdList(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }

    }


    /**
     * 获取酒店配置和config
     *
     * @param dto 酒店基础数据dto
     * @return IHotelLinkDataSupplyService 返回供应商
     * @throws SupplyServiceException  获取不到供应商异常
     * @throws HotelConfigExcetion     获取配置异常
     * @throws SupplyBusinessException 获取配置异常
     */
    private IHotelLinkDataSupplyService getServiceAndConfig(HotelBaseDTO dto, Boolean addProxyFlag) throws SupplyServiceException, HotelConfigExcetion, SupplyBusinessException {
        setConfig(dto);
        Map<String, String> supplier = dto.getSupplier();
        String fybh = StringUtils.defaultIfBlank(dto.getFybh(), supplier.get("fybh"));
        String fymc = supplier.get("fymc");
        String fyen = supplier.get("fyen");
        FyEnum fyEnum = FyEnum.instanceByFybh(fybh);
        if (Objects.isNull(fyEnum)) {
            LOGGER.error("未找到供应商，供应商:[{}_{}_{}]", fybh, fyen, fymc);
            throw new SupplyBusinessException("未找到供应商");
        }
        if (fyEnum.isTcext()) {
            fyen = "tcext";
        }
        if (Objects.nonNull(addProxyFlag) && addProxyFlag) {
            setProxy(supplier);
        }
        String serviceName = fyen.concat(IHotelLinkDataSupplyService.NAME);
        IHotelLinkDataSupplyService linkStaticDataService = staticDataServiceMap.get(serviceName);
        if (linkStaticDataService == null) {
            LOGGER.error("未找到供应商对应实现，供应商:[{}_{}_{}],供应商bean名称:[{}]", fybh, fyen, fymc, serviceName);
            throw new SupplyServiceException(fybh, serviceName);
        }
        return linkStaticDataService;
    }

    /**
     * 设置配置
     *
     * @param dto 酒店基础vo
     * @throws HotelConfigExcetion     酒店配置异常
     * @throws SupplyBusinessException 酒店配置异常
     */
    private void setConfig(HotelBaseDTO dto) throws HotelConfigExcetion, SupplyBusinessException {
        String pt = dto.getPt();
        String fybh = dto.getFybh();
        String zhmc = dto.getZhmc();

        if (!PtEnum.isExits(pt)) {
            throw new SupplyBusinessException("平台编号不存在");
        }
        if (StringUtils.isNotBlank(fybh) && !FyEnum.isExistByFybh(fybh)) {
            throw new SupplyBusinessException("房源商编号不存在");
        }
        if (StringUtils.isBlank(zhmc)) {
            throw new SupplyBusinessException("账号名称为空");
        }
        LinkHotelDTO hotelDTO = new LinkHotelDTO();
        hotelDTO.setPt(pt);
        hotelDTO.setZhmc(zhmc);
        hotelDTO.setFybh(StringUtils.isBlank(fybh) ? null : fybh);
        //手动处理
        Map<String, String> config = hotelConfigDistributeService.getConfig(hotelDTO);
        if (MapUtil.isEmpty(config)) {
            LOGGER.error("获取供应商配置失败，供应商编号:[{}],请求参数:{}", fybh, JsonMapperUtil.toJsonStr(dto));
            throw new HotelConfigExcetion(fybh, null, null);
        }
        dto.setSupplier(config);
    }

    /**
     * 获取供应商订单列表
     *
     * @param dto dto
     * @return RestResponse<LinkHotelOrderListVO>
     * @throws SystemException e
     */
    public RestResponse<LinkHotelOrderListVO> getOrderList(LinkHotelOrderListDTO dto) throws SystemException {
        try {
            LOGGER.warn("对账接口入参：{}", JacksonUtils.toJsonWithNonEmpty(dto));
            RestResponse<LinkHotelOrderListVO> response = getServiceAndConfig(dto, true).getOrderList(dto);
            LOGGER.warn("对账接口出参：{}", JacksonUtils.toJsonWithNonEmpty(response));
            return response;
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }
    }


    /**
     * 获取供应商酒店id列表 分页
     *
     * @param dto dto
     * @return RestResponse
     * @throws SystemException SystemException
     */
    public RestResponse<HotelIdResponseVO> getIncHotelIdListByPage(HotelListDTO dto) throws SystemException {
        try {
            return getServiceAndConfig(dto, true).getIncrementHotelIdListByPage(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }
    }


    /**
     * 分页获取供应商酒店poi信息列表
     *
     * @param dto dto
     * @return RestResponse
     * @throws SystemException SystemException
     */
    public RestResponse<LinkHotelPoiListVO> getPoiListByPage(HotelPoiListDTO dto) throws SystemException {
        try {
            return getServiceAndConfig(dto, true).getPoiListByPage(dto);
        } catch (HotelConfigExcetion configExcetion) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return new RestResponse<>(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }
    }

    /**
     * 拉取订单支付流水
     *
     * @param dto dto
     * @return RestResponse<LinkHotelOrderFlowVO>
     * @throws SystemException e
     */
    public RestResponse<LinkHotelOrderFlowVO> getOrderFlow(LinkHotelOrderFlowDTO dto) throws SystemException {
        try {
            LOGGER.warn("拉取订单支付流水接口入参：{}", JacksonUtils.toJsonWithNonEmpty(dto));
            RestResponse<LinkHotelOrderFlowVO> response = getServiceAndConfig(dto, true).getOrderFlow(dto);
            LOGGER.warn("拉取订单支付流水接口出参：{}", JacksonUtils.toJsonWithNonEmpty(response));
            return response;
        } catch (HotelConfigExcetion configExcetion) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_CONFIG_GET_FAILED);
        } catch (SupplyServiceException e) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_NOT_IMPLEMENTED);
        } catch (SupplyBusinessException e) {
            return ApiRes.fail(e.getMessage());
        }
    }
}