package cn.vetech.center.hotel.link.elong.data;

import cn.vetech.center.hotel.link.api.constant.SymbolConstant;
import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailCityIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.dto.PageDTO;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.EtlHotelPolicy;
import cn.vetech.center.hotel.link.api.data.vo.HotelCityIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelGJInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelGjExtTextInfo;
import cn.vetech.center.hotel.link.api.data.vo.HotelGjInfoDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelGjRoomVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoGlobalVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeVO;
import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.api.enums.HotelWinTypeEnum;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.data.common.model.RoomBedBaseInfo;
import cn.vetech.center.hotel.link.data.common.util.HotelDataUtils;
import cn.vetech.center.hotel.link.data.common.util.RoomUtils;
import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongHttp;
import cn.vetech.center.hotel.link.elong.common.ElongImageEnum;
import cn.vetech.center.hotel.link.elong.constant.ELongWindowEnum;
import cn.vetech.center.hotel.link.elong.constant.ElongCheckInWayEnum;
import cn.vetech.center.hotel.link.elong.constant.ElongHotelTypeEnum;
import cn.vetech.center.hotel.link.elong.data.request.ElongCityRequest;
import cn.vetech.center.hotel.link.elong.data.request.ElongHotelDetailRequest;
import cn.vetech.center.hotel.link.elong.data.request.ElongHotelListRequest;
import cn.vetech.center.hotel.link.elong.data.response.Tel;
import cn.vetech.center.hotel.link.elong.data.response.staticcity.ElongCityInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticcity.ElongCityResponse;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongBedGroup;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongBedInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongCheckinPolicies;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongDetailInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongFacilityInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongHotelDetailResponse;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongHotelDetailResult;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongHotelTypeInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongImageInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongLocationInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongRoomBed;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongRoomBedDetail;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongRoomBedInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongRoomInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongServiceRankInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongThemeInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticlist.ElongHotelListResponse;
import cn.vetech.center.hotel.link.entity.JdTp;
import cn.vetech.center.hotel.link.enums.CachePrefix;
import cn.vetech.center.hotel.link.enums.HotelPolicyEnum;
import cn.vetech.center.hotel.link.enums.HotelWindowTypeEnum;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongRoomInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongServiceRankInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticdetail.ElongThemeInfo;
import cn.vetech.center.hotel.link.elong.data.response.staticlist.ElongHotelListResponse;
import cn.vetech.center.hotel.link.entity.JdTp;
import cn.vetech.center.hotel.link.enums.CachePrefix;
import cn.vetech.center.hotel.link.enums.HotelPolicyEnum;
import cn.vetech.center.hotel.link.enums.HotelWindowTypeEnum;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import cn.vetech.charge.commdata.LanguageLocalCodeEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum.PARAMETER_IS_EMPTY;
import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;
import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.DISABLE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum.PARAMETER_IS_EMPTY;
import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;
import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.DISABLE;
/**
     * 是否强制更新
     *
     * @param dto 请求数据
     * @return boolean
     */
    public RestResponse<HotelInitVO> loadbaseData(HotelBaseDTO dto) {
        logger.warn("艺龙：初始化开始");
        //获取配置
        ElongConfig config = getConfig(dto.getSupplier());
//        Object cacheObj = hotelBaseDataCacheService.get(CachePrefix.INIT_CACHE_PREFIX, config);
//        if (Objects.nonNull(cacheObj)) {
//            logger.warn("艺龙：初始化进行中...开始时间:{}", cacheObj);
//            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "初始化进行中...开始时间：" + cacheObj);
//        }
//        hotelBaseDataCacheService.put(CachePrefix.INIT_CACHE_PREFIX, config, VeDate.getStringDate(), ElongConstant.DATA_INIT_CACHE_EXPIRED);
        Set<String> allCity = getAllCity(config);
        if (CollectionUtils.isEmpty(allCity)) {
            logger.warn("艺龙：获取所有城市为空");
            return ApiRes.success();
        }
        hotelBaseDataCacheService.pushHotelIds(CachePrefix.CITY_CACHE_PREFIX, config, config.getZhmc(), new ArrayList<>(allCity));
        logger.warn("艺龙：初始化结束");
        return ApiRes.success();
    }

    /**
     * 是否强制更新
     *
     * @param dto 请求数据
     * @return boolean
     */
    public RestResponse<HotelInitVO> loadbaseData(HotelBaseDTO dto) {
        logger.warn("艺龙：初始化开始");
        //获取配置
        ElongConfig config = getConfig(dto.getSupplier());
//        Object cacheObj = hotelBaseDataCacheService.get(CachePrefix.INIT_CACHE_PREFIX, config);
//        if (Objects.nonNull(cacheObj)) {
//            logger.warn("艺龙：初始化进行中...开始时间:{}", cacheObj);
//            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "初始化进行中...开始时间：" + cacheObj);
//        }
//        hotelBaseDataCacheService.put(CachePrefix.INIT_CACHE_PREFIX, config, VeDate.getStringDate(), ElongConstant.DATA_INIT_CACHE_EXPIRED);
        Set<String> allCity = getAllCity(config);
        if (CollectionUtils.isEmpty(allCity)) {
            logger.warn("艺龙：获取所有城市为空");
            return ApiRes.success();
        }
        hotelBaseDataCacheService.pushHotelIds(CachePrefix.CITY_CACHE_PREFIX, config, config.getZhmc(), new ArrayList<>(allCity));
        logger.warn("艺龙：初始化结束");
        return ApiRes.success();
    }
    /**
     * 获取所有酒店ID
     *
     * @param config config
     * @return list
     */
    public List<HotelIdVO> getAllHotelId(ElongConfig config) {
        ElongHotelListRequest request = new ElongHotelListRequest();
        Set<String> ids = getAllCity(config);
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        logger.info("艺龙：初始化拉取城市个数：{};", ids.size());
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        request.setConfig(config);
        for (String id : ids) {
            logger.info("艺龙：通过城市获取酒店:城市Id:{}", id);
            List<HotelIdVO> idVOList = getHotelIdsByCityId(id, request);
            hotelIdVOS.addAll(idVOList);
        }
        return hotelIdVOS;
    }

    /***
     * 根据城市获取酒店列表
     * @param cId 12
     * @param request 12
     * @return data
     */
    public List<HotelIdVO> getHotelIdsByCityId(String cId, ElongHotelListRequest request) {
        int pageIndex = NumConstant.NUM_1;
        int pageSize = NumConstant.NUM_5000;
        int totalCount = NumConstant.NUM_0;
        request.setCityId(cId);
        request.setPageIndex(pageIndex);
        request.setPageSize(pageSize);
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        Optional<ElongHotelListResponse> opResponse = elongHotelApiFunction.getHotelStaticList(request);
        if (!opResponse.isPresent()) {
            return hotelIdVOS;
        }
        ElongHotelListResponse response = opResponse.get();
        totalCount = response.getResult().getCount();
        response.getResult().getHotels().forEach(h -> {
            //hotelStatus =0 的才是有效的
            HotelIdVO idVO = new HotelIdVO();
            idVO.setHotelId(h.getHotelId());
            idVO.setStatus(StringUtils.equalsIgnoreCase(String.valueOf(NumConstant.NUM_0), h.getHotelStatus()) ? AVAILABLE.getValue() : DISABLE.getValue());
            hotelIdVOS.add(idVO);
        });
         for (; ; ) {
            if (pageIndex * pageSize >= totalCount) {
                break;
            }
            request.setPageIndex(++pageIndex);
            Optional<ElongHotelListResponse> opRes = elongHotelApiFunction.getHotelStaticList(request);
            if (!opRes.isPresent()) {
                continue;
            }
            ElongHotelListResponse res = opRes.get();
            totalCount = res.getResult().getCount();
            response.getResult().getHotels().stream().forEach(h -> {
                //hotelStatus =0 的才是有效的
                HotelIdVO idVO = new HotelIdVO();
                idVO.setHotelId(h.getHotelId());
                idVO.setStatus(StringUtils.equalsIgnoreCase(String.valueOf(NumConstant.NUM_0), h.getHotelStatus()) ? AVAILABLE.getValue() : DISABLE.getValue());
                hotelIdVOS.add(idVO);
            });
        }
        logger.info("艺龙：城市ID:{}获取酒店个数：{}", cId, totalCount);
        return hotelIdVOS;
    }
  /***
     * 获取所有城市
     * @param config 配置
     * @return 城市id列表
     */
    public Set<String> getAllCity(ElongConfig config) {
        ElongCityRequest request = buildCityRequest(config);
        Set<String> ids = new HashSet<>();
        int pageIndex = NumConstant.NUM_0;
        int pageSize = NumConstant.NUM_200;
        int totalCount = 0;
        request.setPageIndex(pageIndex);
        request.setPageSize(pageSize);

        Optional<ElongCityResponse> cResponse = Optional.empty();
        logger.warn("艺龙：查询所有城市，请求:{}", JacksonUtils.toJsonWithNonNull(request));
        //循环分页查询城市
        for (; ; ) {
            request.setPageIndex(++pageIndex);
            cResponse = elongHotelApiFunction.getHotelStaticCity(request);
            if (!cResponse.isPresent()) {
                break;
            }
            ElongCityResponse res = cResponse.get();
            totalCount = res.getResult().getCount();
            Set<String> otherIds = res.getResult().getCitys().stream().map(ElongCityInfo::getCityID).collect(Collectors.toSet());
            ids.addAll(otherIds);
            if (pageIndex * pageSize >= totalCount) {
                break;
            }
        }
        logger.warn("艺龙：查询所有城市，城市个数：{}", CollectionUtils.size(ids));
        return ids;
    }

    /***
     * 构建cityrequest
     * @param config config
     * @return data
     */
    private ElongCityRequest buildCityRequest(ElongConfig config) {
        ElongCityRequest cityRequest = new ElongCityRequest();
        cityRequest.setCityIdType(NumberUtils.toInt(config.getContentId(), contentId));
        cityRequest.setConfig(config);
        String countryType = config.getCountryType();
        if (StringUtils.isBlank(countryType)) {
            countryType = "1";
        }
        cityRequest.setCountryType(NumberUtils.toInt(countryType));
        return cityRequest;
    }

 /**
     * 根据酒店ID获取所有酒店详
     *
     * @param dto 入参
     * @return RestResponse<HotelInfoResponseVO>
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto) {

        //获取配置
        ElongConfig config = getConfig(dto.getSupplier());
        List<String> hotelIds = dto.getHotelIds();
        if (ListUtil.isEmpty(hotelIds)) {
            return ApiRes.response(PARAMETER_IS_EMPTY);
        }
        //获取执行结果
        List<ImmutableTriple<HotelInfoVO, HotelGJInfoVO, HotelInfoGlobalVO>> immuHotelInfoList = hotelIds.stream().map(hotelid -> {
            try {
                return getHotelGlobalInfo(config, hotelid);
            } catch (Exception e) {
                logger.error("艺龙获取酒店详详情结果出现异常", e);
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        HotelInfoResponseVO responseVO = new HotelInfoResponseVO();
        List<HotelInfoVO> hotelInfoVOS = new ArrayList<>();
        List<HotelGJInfoVO> hotelGJInfoVOS = new ArrayList<>();
        List<HotelInfoGlobalVO> hotelInfoGlobalVOS = new ArrayList<>();
        for (ImmutableTriple<HotelInfoVO, HotelGJInfoVO, HotelInfoGlobalVO> hotelInfoVOHotelGJInfoVOImmutablePair : immuHotelInfoList) {
            HotelInfoVO left = hotelInfoVOHotelGJInfoVOImmutablePair.getLeft();
            if (Objects.nonNull(left)) {
             hotelInfoVOS.add(left);
            }
            HotelGJInfoVO middle = hotelInfoVOHotelGJInfoVOImmutablePair.getMiddle();
            if (Objects.nonNull(middle)) {
                hotelGJInfoVOS.add(middle);
            }
            HotelInfoGlobalVO right = hotelInfoVOHotelGJInfoVOImmutablePair.getRight();
            if (Objects.nonNull(right)) {
                hotelInfoGlobalVOS.add(right);
            }
        }
        responseVO.setHotelGJInfoVOList(hotelGJInfoVOS);
        responseVO.setHotelInfoVOList(hotelInfoVOS);
        return ApiRes.success(responseVO);
    }

    /**
     * 获取酒店
     *
     * @param config  配置
     * @param hotelid 酒店ID
     * @return immu
     */
    public ImmutablePair<HotelInfoVO, HotelGJInfoVO> getHotelInfo(ElongConfig config, String hotelid) {
        ElongHotelDetailRequest request = new ElongHotelDetailRequest(hotelid, config);
        Optional<ElongHotelDetailResponse> opResponse = elongHotelApiFunction.getHotelStaticDetail(request);
        if (!opResponse.isPresent()) {
            return null;
        }
        ElongHotelDetailResponse response = opResponse.get();
        ElongHotelDetailResult result = response.getResult();
        ElongDetailInfo detail = result.getDetail();
        String countryName = detail.getCountryName();
        if (StringUtils.equalsIgnoreCase(countryName, "中国")) {
            HotelInfoVO hotelInfoVO = buildGnHotel(config, result, hotelid);
            return ImmutablePair.of(hotelInfoVO, null);
        } else {
            HotelGJInfoVO hotelGJInfoVO = buildGjHotel(result, hotelid);
            return ImmutablePair.of(null, hotelGJInfoVO);
        }
    }

    /**
     * 国际酒店详情
     *
     * @param res     酒店信息
     * @param hotelid 酒店ID
     * @return HotelGjInfo
     */
    private HotelGJInfoVO buildGjHotel(ElongHotelDetailResult res, String hotelid) {
        HotelGJInfoVO hotelGJInfoVO = new HotelGJInfoVO();
        ElongDetailInfo detail = res.getDetail();
        hotelGJInfoVO.setHotelInfoResponse(JacksonUtils.toJsonWithDefault(res));
        hotelGJInfoVO.setHotelId(hotelid);
        hotelGJInfoVO.setZwmc(detail.getHotelName());
        hotelGJInfoVO.setYwmc(detail.getHotelNameEn());
        hotelGJInfoVO.setPp(detail.getBrandId());
        hotelGJInfoVO.setPpmc(detail.getBrandName());
        hotelGJInfoVO.setSzgj(detail.getCountryId());
        hotelGJInfoVO.setSzgjywmc(detail.getCountryNameEn());
        hotelGJInfoVO.setSzgjzwmc(detail.getCountryName());
        hotelGJInfoVO.setStatus(StringUtils.equals(detail.getHotelStatus(), "0") ? AVAILABLE.getValue() : DISABLE.getValue());
        //hotelGJInfoVO.setSzsf(detail.get);
//        hotelGJInfoVO.setSzsfywmc();
//        hotelGJInfoVO.setSzsfzwmc();
        hotelGJInfoVO.setSzcs(detail.getCityId());
        hotelGJInfoVO.setSzcsywmc(detail.getCityNameEn());
        hotelGJInfoVO.setSzcszwmc(detail.getCityName());
        hotelGJInfoVO.setZwdz(detail.getAddress());
        hotelGJInfoVO.setYwdz(detail.getAddressEn());
        hotelGJInfoVO.setGddh(detail.getPhone());
        hotelGJInfoVO.setCzhm(detail.getFax());
         //图片
        buildGjtp(hotelGJInfoVO, res.getImages());
        if (Objects.nonNull(detail.getBaiduLat()) || Objects.nonNull(detail.getBaiduLon())) {
            hotelGJInfoVO.setBdjd(detail.getBaiduLon().toString());
            hotelGJInfoVO.setBdwd(detail.getBaiduLat().toString());
        }
        if (Objects.nonNull(detail.getGoogleLat()) && Objects.nonNull(detail.getGoogleLon())) {
            hotelGJInfoVO.setGgjd(detail.getGoogleLon().toString());
            hotelGJInfoVO.setGgwd(detail.getGoogleLat().toString());
        }
        hotelGJInfoVO.setJcssmc(buildFacility(detail.getGeneralFacilities()));
        hotelGJInfoVO.setFwssmc(buildFacility(detail.getServiceFacilities()));
        hotelGJInfoVO.setXxssmc(buildFacility(detail.getRecreationFacilities()));
        hotelGJInfoVO.setJdztmc(buildTheme(detail.getThemes(), detail.getHotelTypes()));
        hotelGJInfoVO.setKysj(detail.getEstablishmentDate());
        hotelGJInfoVO.setZxsj(detail.getRenovationDate());
        hotelGJInfoVO.setTbts(detail.getFeatures());
        hotelGJInfoVO.setZwjj(buildJj(detail));
        HotelGjInfoDetailVO hotelGjInfoDetailVO = new HotelGjInfoDetailVO();
        hotelGjInfoDetailVO.setHotelId(hotelid);
        hotelGjInfoDetailVO.setJcsslb(buildFacility(detail.getGeneralFacilities()));
        hotelGjInfoDetailVO.setFwsslb(buildFacility(detail.getServiceFacilities()));
        hotelGjInfoDetailVO.setXxsslb(buildFacility(detail.getRecreationFacilities()));
        HotelGjExtTextInfo extTextInfo = new HotelGjExtTextInfo();
        extTextInfo.setCheckInFrom(detail.getArrivalTime());
        extTextInfo.setCheckOutUntil(detail.getDepartureTime());
        // 酒店政策
        extTextInfo.setHotelPolicies(convertHotelPolicy(detail));
        // 处理酒店标签
        String hotelLabel = convertHotelLabel(detail.getCheckinPolicies());
        hotelGjInfoDetailVO.setFwsslb(VeStringUtil.joinWithCommaIsNotBlank(hotelGjInfoDetailVO.getFwsslb(), hotelLabel));
        hotelGjInfoDetailVO.setExtText(JacksonUtils.toJsonWithDefault(extTextInfo));
        hotelGJInfoVO.setHotelGjInfoDetailVO(hotelGjInfoDetailVO);
        //房型
        buildGjRoom(hotelGJInfoVO, res);
        return hotelGJInfoVO;
    }


   private String convertHotelLabel(List<ElongCheckinPolicies> checkinPolicies) {
        if (CollectionUtils.isEmpty(checkinPolicies)) {
            return StringUtils.EMPTY;
        }
        for (ElongCheckinPolicies checkinPolicy : checkinPolicies) {
            if (Objects.isNull(checkinPolicy) || StringUtils.isBlank(checkinPolicy.getCheckInWay())) {
                continue;
            }
            boolean sfzzrzwqt = ElongCheckInWayEnum.getSfzzrzwqt(checkinPolicy.getCheckInWay());
            if (sfzzrzwqt) {
                return "自助入住无前台";
            }
        }
        return StringUtils.EMPTY;
    }

    private List<EtlHotelPolicy> convertHotelPolicy(ElongDetailInfo detail) {
        List<EtlHotelPolicy> etlHotelPolicyList = new ArrayList<>();
        // 入住方式
        EtlHotelPolicy checkinPolicy = convertCheckinPolicies(detail.getCheckinPolicies());
        if (Objects.nonNull(checkinPolicy)) {
            etlHotelPolicyList.add(checkinPolicy);
        }
        // 入离政策
        EtlHotelPolicy checkInAndCheckOutPolicy = convertCheckInAndCheckOutPolicy(detail.getArrivalTime(), detail.getDepartureTime());
        if (Objects.nonNull(checkInAndCheckOutPolicy)) {
            etlHotelPolicyList.add(checkInAndCheckOutPolicy);
        }
        return etlHotelPolicyList;
    }

 private EtlHotelPolicy convertCheckInAndCheckOutPolicy(String arrivalTime, String departureTime) {
        if (StringUtils.isAllBlank(arrivalTime, departureTime)) {
            return null;
        }
        List<String> textList = new ArrayList<>();
        if (StringUtils.isNotBlank(arrivalTime)) {
            textList.add(VeStringUtil.joinWithIsNotBlank(SymbolConstant.FULL_COLON, "酒店入住的最早时间", arrivalTime));
        }
        if (StringUtils.isNotBlank(departureTime)) {
            textList.add(VeStringUtil.joinWithIsNotBlank(SymbolConstant.FULL_COLON, "酒店离店的最晚时间", departureTime));
        }
        if (CollectionUtils.isEmpty(textList)) {
            return null;
        }
        String text = VeStringUtil.joinIfNotBlank(SymbolConstant.FULL_SEMICOLON, textList);
        return HotelDataUtils.convertHotelPolicy(text, HotelPolicyEnum.CheckInCheckOut);
    }


 private EtlHotelPolicy convertCheckinPolicies(List<ElongCheckinPolicies> checkinPolicies) {
        if (CollectionUtils.isEmpty(checkinPolicies)) {
            return null;
        }
        List<String> textList = new ArrayList<>();
        for (ElongCheckinPolicies checkinPolicy : checkinPolicies) {
            if (Objects.isNull(checkinPolicy) || StringUtils.isBlank(checkinPolicy.getCheckInNote())) {
                continue;
            }
            textList.add(checkinPolicy.getCheckInNote());
        }
        if (CollectionUtils.isEmpty(textList)) {
            return null;
        }
        String text = VeStringUtil.joinIfNotBlank(SymbolConstant.FULL_SEMICOLON, textList);
        return HotelDataUtils.convertHotelPolicy(text, HotelPolicyEnum.ENTRYTYPE);
    }

    /**
     * 房型
     *
     * @param hotelGJInfoVO vo
     * @param res           res
     */
    private void buildGjRoom(HotelGJInfoVO hotelGJInfoVO, ElongHotelDetailResult res) {
        List<ElongRoomInfo> rooms = res.getRooms();
        if (ListUtil.isEmpty(rooms)) {
            return;
        }
        List<HotelGjRoomVO> roomVOS = rooms.stream().map(room -> roomToRoomVo(room, hotelGJInfoVO.getHotelId(), res.getImages()))
                .collect(Collectors.toList());
        hotelGJInfoVO.setHotelGjRoomVOS(roomVOS);
    }

      /**
     * 解析房型
     *
     * @param roomInfo   info
     * @param hotelId    酒店ID
     * @param imageInfos image
     * @return vo
     */
    private HotelGjRoomVO roomToRoomVo(ElongRoomInfo roomInfo, String hotelId, List<ElongImageInfo> imageInfos) {
        HotelGjRoomVO roomVO = new HotelGjRoomVO();
        roomVO.setHotelId(hotelId);
        roomVO.setRoomId(roomInfo.getRoomID());
        roomVO.setRoomName(roomInfo.getRoomName());
        roomVO.setRoomEname(roomInfo.getRoomNameEn());
        // 处理床型配置
        convertBedType(roomVO, roomInfo);
        roomVO.setFloor(roomInfo.getFloor());
        roomVO.setAcreage(roomInfo.getArea());
        if (!StringUtils.equalsIgnoreCase(roomInfo.getCapacity(), "0")) {
            roomVO.setRecommendOccupancy(roomInfo.getCapacity());
        }

        roomVO.setRoomDesc(roomInfo.getDescription());
        roomVO.setRoomEdesc(roomInfo.getDescriptionEn());
        roomVO.setRoomFacility(buildFxss(roomInfo.getFacilities()));
        roomVO.setSpecialReminder(roomInfo.getComments());
        roomVO.setSpecialEreminder(roomInfo.getCommentsEn());
        Map<String, List<JdTp>> jdTpMap = convertJdTpToMap(hotelId, imageInfos);//先转换酒店图片后面要用
        String key = hotelId + "_" + roomInfo.getRoomID();
        List<JdTp> jdTpList = jdTpMap.get(key);
        if (ListUtil.isNotEmpty(jdTpList)) {
            roomVO.setPic(JacksonUtils.toJsonWithNonEmpty(jdTpList));
        }
        // 处理窗户
        ELongWindowEnum eLongWindowEnum = handleWindow(roomInfo.getWindowTypeId());
        roomVO.setWindowType(HotelWinTypeEnum.getNameByCode(eLongWindowEnum.getCh()));
        roomVO.setWindowDesc(HotelWindowTypeEnum.getNameByCode(eLongWindowEnum.getChlx()));
        return roomVO;
    }

     private void convertBedType(HotelGjRoomVO roomVO, ElongRoomInfo roomInfo) {
        ElongRoomBed roomBed = roomInfo.getRoomBed();
        if (Objects.isNull(roomBed) || CollectionUtils.isEmpty(roomBed.getRoomBedInfoList())) {
            roomVO.setBedType(roomInfo.getBedType());
            return;
        }
        List<String> roomBedList = new ArrayList<>();
        for (ElongRoomBedInfo bedInfo : roomBed.getRoomBedInfoList()) {
            // 卧室床信息
            List<RoomBedBaseInfo> roomBedBaseInfoList = convertRoomBedInfo(bedInfo.getRoomDetailBeds());
            List<RoomBedBaseInfo> bedBaseInfoList = new ArrayList<>(roomBedBaseInfoList);
            // 客厅床信息
            List<RoomBedBaseInfo> livingBedBaseInfoList = convertRoomBedInfo(bedInfo.getLivingRoomBeds());
            bedBaseInfoList.addAll(livingBedBaseInfoList);
            roomBedList.add(RoomUtils.convertBedInfo(bedBaseInfoList));
        }
        roomVO.setBedType(VeStringUtil.joinIfNotBlank(" 或 ", roomBedList));
        roomVO.setBedNumber("");
    }

      private List<RoomBedBaseInfo> convertRoomBedInfo(List<ElongRoomBedDetail> roomDetailBeds) {
        if (CollectionUtils.isEmpty(roomDetailBeds)) {
            return Collections.emptyList();
        }
        List<RoomBedBaseInfo> roomBedBaseInfoList = new ArrayList<>();
        // 和 的关系
        roomDetailBeds.forEach(bedInfo -> {
            List<ElongBedGroup> bedGroups = bedInfo.getBedGroups();
            if (CollectionUtils.isEmpty(bedGroups)) {
                return;
            }
            if (CollectionUtils.size(bedGroups) == NumConstant.NUM_1) {
                List<ElongBedInfo> bedInfosList = bedGroups.get(0).getBedInfos();
                if (CollectionUtils.isEmpty(bedInfosList)) {
                    return;
                }
                // 和 的关系
                for (ElongBedInfo bedInfoNew : bedInfosList) {
                    roomBedBaseInfoList.add(RoomUtils.buildRoomBedBaseInfo(bedInfoNew.getBedName(), bedInfoNew.getBedCount(), bedInfoNew.getBedWidth()));
                }
            } else {
                List<String> bedGroupList = new ArrayList<>();
                // 或 的关系
                for (ElongBedGroup bedGroup : bedGroups) {
                    List<ElongBedInfo> bedInfosList = bedGroup.getBedInfos();
                    if (CollectionUtils.isEmpty(bedInfosList)) {
                        continue;
                    }
                     List<String> bedInfoList = new ArrayList<>();
                    // 和 的关系
                    for (ElongBedInfo bedInfoNew : bedInfosList) {
                        String bedName = bedInfoNew.getBedName();
                        String bedCount = bedInfoNew.getBedCount();
                        String bedWidth = bedInfoNew.getBedWidth();
                        String stringBuilder = (StringUtils.isNotBlank(bedCount) ? bedCount + "张" : null) +
                                (StringUtils.isNotBlank(bedWidth) ? bedWidth + "米" : null) +
                                (StringUtils.isNotBlank(bedName) ? bedName : null);
                        bedInfoList.add(stringBuilder);
                    }
                    bedGroupList.add(VeStringUtil.joinIfNotBlank("和", bedInfoList));
                }
                roomBedBaseInfoList.add(RoomUtils.buildRoomBedBaseInfo(VeStringUtil.joinIfNotBlank("或", bedGroupList), null, null));
            }
        });
        return roomBedBaseInfoList;
    }

       /**
     * 国际酒店图片
     *
     * @param hotelGJInfoVO vo
     * @param imageInfos    图片信息
     */
    private void buildGjtp(HotelGJInfoVO hotelGJInfoVO, List<ElongImageInfo> imageInfos) {
        Map<String, List<JdTp>> jdTpMap = convertJdTpToMap(hotelGJInfoVO.getHotelId(), imageInfos);//先转换酒店图片后面要用
        List<JdTp> jdTpList = jdTpMap.get(hotelGJInfoVO.getHotelId());
        if (ListUtil.isNotEmpty(jdTpList)) {
            hotelGJInfoVO.setTp(JacksonUtils.toJsonWithDefault(jdTpList));
        }
    }

    /**
     * 国内酒店
     *
     * @param res     res
     * @param hotelid 酒店ID
     * @param config  配置
     * @return 国内酒店信息
     */
    private HotelInfoVO buildGnHotel(ElongConfig config, ElongHotelDetailResult res, String hotelid) {
        HotelInfoVO hotelInfoVO = new HotelInfoVO();
        try {
            ElongDetailInfo detail = res.getDetail();

            //接口返回的没有hotelid值  加上加上
            detail.setHotelId(hotelid);
            Map<String, List<JdTp>> jdTpMap = convertJdTpToMap(hotelid, res.getImages());//先转换酒店图片后面要用
            hotelInfoVO = buildHotelInfo(detail);//转换酒店基本信息
            //保存原始返回数据
            hotelInfoVO.setHotelInfoResponse(JacksonUtils.toJsonWithDefault(res));
            HotelInfoDetailVO hotelInfoDetailVO = buildHotelDetail(detail, jdTpMap);//转换酒店明细
            hotelInfoVO.setHotelInfoDetailVO(hotelInfoDetailVO);
            //转换房型信息 和 房型明细
            List<ElongRoomInfo> elongRooms = res.getRooms();
            if (ListUtil.isEmpty(elongRooms)) {
                return null;
            }
             hotelInfoVO.setHotelRoomTypeResponse(JacksonUtils.toJsonWithDefault(elongRooms));
            //定义酒店房型信息数组
            ArrayList<HotelRoomTypeVO> hotelRoomTypeList = new ArrayList<>(elongRooms.size());
            for (ElongRoomInfo room : elongRooms) {
                HotelRoomTypeVO hotelRoomTypeVO = buildRoomType(hotelid, room);//转换房型信息
                HotelRoomTypeDetailVO roomTypeDetailVO = buildRoomTypeDetail(hotelid, hotelRoomTypeVO, room, jdTpMap, config);//转换房型明细
                hotelRoomTypeVO.setHotelRoomTypeDetailVO(roomTypeDetailVO);
                hotelRoomTypeList.add(hotelRoomTypeVO);
            }
            hotelInfoVO.setHotelRoomTypeVOList(hotelRoomTypeList);
            return hotelInfoVO;
        } catch (Exception ex) {
            logger.error("艺龙国内:response:{}", JacksonUtils.toJsonWithDefault(res), ex);
        }
        return hotelInfoVO;
    }

    /**
     * 执行
     *
     * @param config  elong配置信息
     * @param hotelid 酒店ID
     * @return HotelInfoVO
     */
    public HotelInfoVO execute(ElongConfig config, String hotelid) {
        AtomicReference<HotelInfoVO> hotelInfoVO = new AtomicReference<>(new HotelInfoVO());
        ElongHotelDetailRequest request = new ElongHotelDetailRequest(hotelid, config);
        Optional<ElongHotelDetailResponse> opResponse = elongHotelApiFunction.getHotelStaticDetail(request);
        opResponse.ifPresent(response -> {
            ElongHotelDetailResult res = response.getResult();
            ElongDetailInfo detail = res.getDetail();

            //接口返回的没有hotelid值  加上加上
            detail.setHotelId(hotelid);
            Map<String, List<JdTp>> jdTpMap = convertJdTpToMap(hotelid, res.getImages());//先转换酒店图片后面要用
            hotelInfoVO.set(buildHotelInfo(detail));//转换酒店基本信息
            //保存原始返回数据
            
     hotelInfoVO.get().setHotelInfoResponse(JacksonUtils.toJsonWithDefault(res));
            HotelInfoDetailVO hotelInfoDetailVO = buildHotelDetail(detail, jdTpMap);//转换酒店明细
            hotelInfoVO.get().setHotelInfoDetailVO(hotelInfoDetailVO);
            //转换房型信息 和 房型明细
            List<ElongRoomInfo> elongRooms = res.getRooms();
            if (ListUtil.isEmpty(elongRooms)) {
                return;
            }
            //定义酒店房型信息数组
            ArrayList<HotelRoomTypeVO> hotelRoomTypeList = new ArrayList<>(elongRooms.size());
            for (ElongRoomInfo room : elongRooms) {
                HotelRoomTypeVO hotelRoomTypeVO = buildRoomType(hotelid, room);//转换房型信息
                HotelRoomTypeDetailVO roomTypeDetailVO = buildRoomTypeDetail(hotelid, hotelRoomTypeVO, room, jdTpMap, config);//转换房型明细
                hotelRoomTypeVO.setHotelRoomTypeDetailVO(roomTypeDetailVO);
                hotelRoomTypeList.add(hotelRoomTypeVO);
            }
            hotelInfoVO.get().setHotelRoomTypeVOList(hotelRoomTypeList);
        });
        return hotelInfoVO.get();
    }

    
    /**
     * 图片转换为map  key为 酒店id  或 酒店id_房型id  分组之后 提升检索速度 不然每个房型 酒店 都要去循环检索
     *
     * @param hotelId   hotelId
     * @param imageList imageList
     * @return 1
     */
    private Map<String, List<JdTp>> convertJdTpToMap(String hotelId, List<ElongImageInfo> imageList) {
        if (ListUtil.isEmpty(imageList)) {
            return MapUtil.emptyMap();
        }
        return imageList.stream()
                .filter(image -> ListUtil.isNotEmpty(image.getLocations())).
                collect(Collectors.groupingBy(x -> StringUtils.isBlank(x.getRoomID())
                                ? hotelId
                                : hotelId.concat(SymbolConstant.UNDER_LINE).concat(x.getRoomID())
                        , Collectors.mapping(y -> convertJdTp(y), Collectors.toList())));
    }

    /**
     * 酒店基本信息转换
     *
     * @param detail 艺龙数据
     * @return s
     */
    private HotelInfoVO buildHotelInfo(ElongDetailInfo detail) {
        HotelInfoVO hotelInfoVO = new HotelInfoVO();
        hotelInfoVO.setHotelId(detail.getHotelId());
        hotelInfoVO.setZwmc(detail.getHotelName());
        hotelInfoVO.setYwmc(detail.getHotelNameEn());
        hotelInfoVO.setXj(detail.getStarRate());
        hotelInfoVO.setTjxj(detail.getCategory());
        hotelInfoVO.setTjxjly(FYBH);
         hotelInfoVO.setPp(detail.getBrandName());
        hotelInfoVO.setSzgjmc(detail.getCountryName());
        hotelInfoVO.setSzsfcode("");
        hotelInfoVO.setSzsfmc("");
        hotelInfoVO.setSzcscode(detail.getCityId());
        hotelInfoVO.setSzcsmc(detail.getCityName());
        hotelInfoVO.setXzqmc(detail.getDistrictName());
        hotelInfoVO.setSyqmc(detail.getBusinessZoneName());
        hotelInfoVO.setGddh(detail.getPhone());
        //add by xiaotengyu 艺龙电话添加 tellist begin 2021/04/07
        List<String> tels = new ArrayList<>();
        List<Tel> telList = detail.getTelList();
        if (CollectionUtils.isNotEmpty(telList)) {
            for (Tel tel : telList) {
                String dh = getTel(tel);
                tels.add(dh);
            }
            hotelInfoVO.setGddh(StringUtils.join(tels, SymbolConstant.COMMA));
        }
        //add by xiaotengyu 艺龙电话添加 tellist end
        hotelInfoVO.setCzhm(detail.getFax());
        hotelInfoVO.setKysj(detail.getEstablishmentDate());
        hotelInfoVO.setZxsj(detail.getRenovationDate());
        hotelInfoVO.setGngjlb("1");
        if (Objects.nonNull(detail.getBaiduLon()) && Objects.nonNull(detail.getBaiduLat())) {
            hotelInfoVO.setBdjd(detail.getBaiduLon().toString());
            hotelInfoVO.setBdwd(detail.getBaiduLat().toString());
        }
         if (Objects.nonNull(detail.getGoogleLon()) && Objects.nonNull(detail.getGoogleLat())) {
            hotelInfoVO.setGgjd(detail.getGoogleLon().toString());
            hotelInfoVO.setGgwd(detail.getGoogleLat().toString());
        }
        //add by xiaotengyu 2020/12/08 begin 谷歌经纬度转百度 begin
        if (Objects.nonNull(detail.getGoogleLat())
                && Objects.nonNull(detail.getGoogleLon())
                && Objects.isNull(detail.getBaiduLat())
                && Objects.isNull(detail.getBaiduLon())) {
            double[] jwd = LngLonUtil.gdToBd(NumberUtils.toDouble(detail.getGoogleLat()), NumberUtils.toDouble(detail.getGoogleLon()));
            hotelInfoVO.setBdwd(String.valueOf(jwd[0]));
            hotelInfoVO.setBdjd(String.valueOf(jwd[1]));
        }
        //add by xiaotengyu 2020/12/08 begin 谷歌经纬度转百度 end
        ElongServiceRankInfo rank = detail.getServiceRank();
        if (rank != null) {
            hotelInfoVO.setTctsldb(getRank(rank.getComplaintScore()));
            hotelInfoVO.setTccgldb(getRank(rank.getBookingSuccessScore()));
            hotelInfoVO.setTcqrldb(getRank(rank.getInstantConfirmScore()));
            hotelInfoVO.setTczpfdb(getRank(rank.getSummaryScore()));
            hotelInfoVO.setPftsl(getRank(rank.getComplaintScore()));
            hotelInfoVO.setPfcgl(getRank(rank.getBookingSuccessScore()));
            hotelInfoVO.setPfqrl(getRank(rank.getInstantConfirmScore()));
            hotelInfoVO.setPfzpf(getRank(rank.getSummaryScore()));
        }
        hotelInfoVO.setJdlx("2");
        hotelInfoVO.setZt(StringUtils.equalsIgnoreCase(detail.getHotelStatus(), "0") ? AVAILABLE.getValue() : DISABLE.getValue());
        return hotelInfoVO;
    }
/***
     * 获取电话字符串
     * @param tel tel
     * @return data
     */
    public String getTel(Tel tel) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotEmpty(tel.getNationCode()) && !StringUtils.equalsIgnoreCase(tel.getNationCode(), NumConstant.MINUS_86)) {
            sb.append(tel.getNationCode());
            sb.append(SymbolConstant.MIDDLE_LINE);
        }
        if (StringUtils.isNoneEmpty(tel.getAreaCode())) {
            sb.append(tel.getAreaCode());
            sb.append(SymbolConstant.MIDDLE_LINE);
        }
        if (StringUtils.isNoneEmpty(tel.getMainCode())) {
            sb.append(tel.getMainCode());
        }
        if (StringUtils.isNoneEmpty(tel.getExtCode())) {
            sb.append(SymbolConstant.MIDDLE_LINE);
            sb.append(tel.getExtCode());
        }
        return sb.toString();
    }
/**
     * 酒店点明细转换
     *
     * @param detail  1
     * @param jdTpMap 1
     * @return 1
     */
    private HotelInfoDetailVO buildHotelDetail(ElongDetailInfo detail, Map<String, List<JdTp>> jdTpMap) {
        HotelInfoDetailVO hotelInfoDetailVO = new HotelInfoDetailVO();
        hotelInfoDetailVO.setDz(detail.getAddress());
        List<JdTp> jdTpList = jdTpMap.get(detail.getHotelId());
        if (ListUtil.isNotEmpty(jdTpList)) {
            hotelInfoDetailVO.setZy(JacksonUtils.toJsonWithNonEmpty(jdTpList));
        }
        hotelInfoDetailVO.setTbts(detail.getFeatures());
        hotelInfoDetailVO.setJj(buildJj(detail));
        hotelInfoDetailVO.setJcsslb(buildFacility(detail.getGeneralFacilities()));
        //hotelInfoDetailVO.setFxsslb(buildFacility(detail.getro()));
        hotelInfoDetailVO.setFwsslb(buildFacility(detail.getServiceFacilities()));
        hotelInfoDetailVO.setXxsslb(buildFacility(detail.getRecreationFacilities()));
        hotelInfoDetailVO.setJdztlb(buildTheme(detail.getThemes(), detail.getHotelTypes()));
        hotelInfoDetailVO.setZbjt(buildZbjt(detail));
        hotelInfoDetailVO.setHotelid(detail.getHotelId());
        return hotelInfoDetailVO;
    }
 /***
     * 构建酒店主题
     * @param themeInfos 主题集合
     * @return 主题描述
     */
    private String buildTheme(List<ElongThemeInfo> themeInfos, List<ElongHotelTypeInfo> hotelTypes) {
        List<String> themeInfoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(themeInfos)) {
            for (ElongThemeInfo themeInfo : themeInfos) {
                themeInfoList.add(themeInfo.getThemeName());
            }
        }

        if (CollectionUtils.isNotEmpty(hotelTypes)) {
            for (ElongHotelTypeInfo hotelTypeInfo : hotelTypes) {
                String veName = ElongHotelTypeEnum.getVeNameByCode(hotelTypeInfo.getHotelTypeId());
                themeInfoList.add(veName);
            }
        }
        return VeStringUtil.joinIfNotBlank(SymbolConstant.COMMA, themeInfoList);
    }

    /**
     * 周边交通
     *
     * @param detail 1
     * @return 1
     */
    private String buildZbjt(ElongDetailInfo detail) {
        String zbjt = "";
        if (StringUtils.isNotBlank(detail.getTraffic())) {
            zbjt += detail.getTraffic();
        }
        if (StringUtils.isNotBlank(detail.getSurroundings())) {
            zbjt += detail.getSurroundings();
        }
        return zbjt;
    }

    /**
     * 简介
      *
     * @param detail 1
     * @return 1
     */
    private String buildJj(ElongDetailInfo detail) {
        String jj = "";
        if (StringUtils.isNotBlank(detail.getIntroEditor())) {
            jj += detail.getIntroEditor();
        }
        if (StringUtils.isNotBlank(detail.getDescription())) {
            jj += detail.getDescription();
        }
        return jj + " ";
    }

    /**
     * 房型转换
     *
     * @param hotelId 1
     * @param room    1
     * @return 1
     */
    private HotelRoomTypeVO buildRoomType(String hotelId, ElongRoomInfo room) {
        HotelRoomTypeVO hotelRoomTypeVO = new HotelRoomTypeVO();
        hotelRoomTypeVO.setHotelid(hotelId);
        hotelRoomTypeVO.setFyfxid(room.getRoomID());
        hotelRoomTypeVO.setFxmc(room.getRoomName());
        // 处理床型配置
        convertGNBedType(hotelRoomTypeVO, room);
        hotelRoomTypeVO.setLc(room.getFloor());
        hotelRoomTypeVO.setMj(room.getArea());
        hotelRoomTypeVO.setRoomnumber("");
        if (StringUtils.isNotBlank(room.getCapacity()) && !StringUtils.equalsIgnoreCase(room.getCapacity(), "0")) {
            hotelRoomTypeVO.setTjrzrs(room.getCapacity());
        }
        return hotelRoomTypeVO;
    }

    private void convertGNBedType(HotelRoomTypeVO hotelRoomTypeVO, ElongRoomInfo room) {
        ElongRoomBed roomBed = room.getRoomBed();
        if (Objects.isNull(roomBed) || CollectionUtils.isEmpty(roomBed.getRoomBedInfoList())) {
            hotelRoomTypeVO.setCx(room.getBedType());
            return;
        }
        List<String> roomBedList = new ArrayList<>();
        for (ElongRoomBedInfo bedInfo : roomBed.getRoomBedInfoList()) {
            // 卧室床信息
            List<RoomBedBaseInfo> roomBedBaseInfoList = convertRoomBedInfo(bedInfo.getRoomDetailBeds());
            List<RoomBedBaseInfo> bedBaseInfoList = new ArrayList<>(roomBedBaseInfoList);
            // 客厅床信息
            List<RoomBedBaseInfo> livingBedBaseInfoList = convertRoomBedInfo(bedInfo.getLivingRoomBeds());
            bedBaseInfoList.addAll(livingBedBaseInfoList);
            roomBedList.add(RoomUtils.convertBedInfo(bedBaseInfoList));
        }
        hotelRoomTypeVO.setCx(VeStringUtil.joinIfNotBlank(" 或 ", roomBedList));
        hotelRoomTypeVO.setBednumber("");
    }

    /**
     * 房型明细转换
     *
     * @param hotelId         hotelId
     * @param hotelRoomTypeVO jdFx
     * @param room            room
     * @param jdTpMap         jdTpMap
     * @param config          config
     * @return 1
     */
      private HotelRoomTypeDetailVO buildRoomTypeDetail(String hotelId
            , HotelRoomTypeVO hotelRoomTypeVO
            , ElongRoomInfo room
            , Map<String, List<JdTp>> jdTpMap
            , ElongConfig config) {
        HotelRoomTypeDetailVO hotelRoomTypeDetailVO = new HotelRoomTypeDetailVO();
        hotelRoomTypeDetailVO.setHotelid(hotelId);
        hotelRoomTypeDetailVO.setFyfxid(room.getRoomID());
        hotelRoomTypeDetailVO.setFxms(room.getDescription());
        hotelRoomTypeDetailVO.setFxss(buildFxss(room.getFacilities()));
        hotelRoomTypeDetailVO.setYdtbts(room.getComments());
        // 处理窗户
        ELongWindowEnum eLongWindowEnum = handleWindow(room.getWindowTypeId());
        hotelRoomTypeDetailVO.setCh(eLongWindowEnum.getCh());
        hotelRoomTypeDetailVO.setChlx(eLongWindowEnum.getChlx());
        String key = hotelId + "_" + room.getRoomID();
        List<JdTp> jdTpList = jdTpMap.get(key);
        if (ListUtil.isNotEmpty(jdTpList)) {
            hotelRoomTypeDetailVO.setPic(JacksonUtils.toJsonWithNonEmpty(jdTpList));
        }
        return hotelRoomTypeDetailVO;
    }

    /***
     * 数据库存储的id1,id2,id3  需要转换成名称
     * @param facilities f
     * @return dtat
     */
    private String buildFxss(List<ElongFacilityInfo> facilities) {
        if (CollectionUtils.isEmpty(facilities)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        facilities.stream().forEach(f -> sb.append(f.getFacilityName()).append(","));
        return sb.toString();
    }
     /**
     * 各种评分处理
     *
     * @param value value
     * @return s
     */
    private String getRank(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        double d = NumberUtils.toDouble(value.replace("%", ""), 0);
        if (d == 0) {
            return null;
        }
        return d + "";
    }

    /**
     * 转换图片
     *
     * @param image 1
     * @return 1
     */
    private JdTp convertJdTp(ElongImageInfo image) {
        List<ElongLocationInfo> locations = image.getLocations();
        if (ListUtil.isEmpty(locations)) {
            return null;
        }
        String type = image.getType();
        String jdtpType = ElongImageEnum.ElongImageTypeMapEnum.convertType(type);
        ElongLocationInfo location = getLocation(locations);
        JdTp jdTp = new JdTp();
        jdTp.setTpdz(location.getUrl());
        jdTp.setTplx(jdtpType);
        return jdTp;
    }

 /**
     * 各种评分处理
     *
     * @param value value
     * @return s
     */
    private String getRank(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        double d = NumberUtils.toDouble(value.replace("%", ""), 0);
        if (d == 0) {
            return null;
        }
        return d + "";
    }

    /**
     * 转换图片
     *
     * @param image 1
     * @return 1
     */
    private JdTp convertJdTp(ElongImageInfo image) {
        List<ElongLocationInfo> locations = image.getLocations();
        if (ListUtil.isEmpty(locations)) {
            return null;
        }
        String type = image.getType();
        String jdtpType = ElongImageEnum.ElongImageTypeMapEnum.convertType(type);
        ElongLocationInfo location = getLocation(locations);
        JdTp jdTp = new JdTp();
        jdTp.setTpdz(location.getUrl());
        jdTp.setTplx(jdtpType);
        return jdTp;
    }

 /**
     * 各种评分处理
     *
     * @param value value
     * @return s
     */
    private String getRank(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        double d = NumberUtils.toDouble(value.replace("%", ""), 0);
        if (d == 0) {
            return null;
        }
        return d + "";
    }

    /**
     * 转换图片
     *
     * @param image 1
     * @return 1
     */
    private JdTp convertJdTp(ElongImageInfo image) {
        List<ElongLocationInfo> locations = image.getLocations();
        if (ListUtil.isEmpty(locations)) {
            return null;
        }
        String type = image.getType();
        String jdtpType = ElongImageEnum.ElongImageTypeMapEnum.convertType(type);
        ElongLocationInfo location = getLocation(locations);
        JdTp jdTp = new JdTp();
        jdTp.setTpdz(location.getUrl());
        jdTp.setTplx(jdtpType);
        return jdTp;
    }

 /**
     * 获取所有城市
     *
     * @param dto dto
     * @return response
     */
    public RestResponse<List<HotelCityIdVO>> getCityIdList(HotelBaseDTO dto) {
        logger.warn("艺龙：拉取城市开始");
        ElongConfig config = getConfig(dto.getSupplier());

//        Set<String> allCity = getAllCity(config);
        List<String> allCity = getCahceCity(config);
        if (CollectionUtil.isEmpty(allCity)) {
            return ApiRes.success();
        }
        List<String> disCitys = allCity.stream().distinct().collect(Collectors.toList());
        List<HotelCityIdVO> cityIdVOS = new ArrayList<>();
        for (String city : disCitys) {
            HotelCityIdVO cityIdVO = new HotelCityIdVO();
            cityIdVO.setCityId(city);
            cityIdVOS.add(cityIdVO);
        }
        logger.warn("艺龙：拉取城市结束：拉取城市格式：{};distinctcity:{}", allCity.size(), disCitys.size());
        return ApiRes.success(cityIdVOS);
    }

  /**
     * 获取所有城市
     *
     * @param config 配置
     * @return 城市列表
     */
    private List<String> getCahceCity(ElongConfig config) {
        List<String> allCityIds = new ArrayList<>();
        int index = NumConstant.NUM_0;
        while (true) {
            index++;
            if (index > NumConstant.NUM_10_000) {
                break;
            }
            List<String> cityIds = hotelBaseDataCacheService.popHotelIds(CachePrefix.CITY_CACHE_PREFIX, config, config.getZhmc(), NumConstant.NUM_500);
            if (CollectionUtils.isEmpty(cityIds)) {
                break;
            }
            allCityIds.addAll(cityIds);
        }
        return allCityIds;
    }

    /**
     * 通过城市拉取酒店
     *
     * @param dto dto
     * @return response
     */
     public RestResponse<HotelInfoResponseVO> getHotelDetailByCityId(HotelDetailCityIdDTO dto) {
        String cityId = dto.getCityId();
        if (StringUtils.isBlank(cityId)) {
            return ApiRes.success();
        }
        ElongConfig config = getConfig(dto.getSupplier());
        if (GnGjTypeEnum.GJ.getCode().equals(dto.getGngj())) {
            logger.warn("通过城市获取酒店ID，请求参数：{}", JacksonUtils.toJsonWithNonEmpty(dto));
        }
        PageDTO pageDTO = dto.getPageDTO();
        ElongHotelListRequest request = new ElongHotelListRequest();
        int pageSize = NumConstant.NUM_40;
        request.setConfig(config);
        request.setCityId(cityId);
        request.setPageIndex(pageDTO.getCurrent());
        request.setPageSize(pageSize);
        List<HotelIdVO> hotelIdsByCityId = hotelListService.getHotelIdsByCityId(request);
        if (CollectionUtils.isEmpty(hotelIdsByCityId)) {
            return ApiRes.success();
        }
        List<String> hotelIds = hotelIdsByCityId.stream().map(hotel -> hotel.getHotelId()).collect(Collectors.toList());
        //获取执行结果
        List<ImmutableTriple<HotelInfoVO, HotelGJInfoVO, HotelInfoGlobalVO>> immuHotelInfoList = hotelIds.stream().map(hotelid -> {
            try {
                return getHotelGlobalInfo(config, hotelid);
            } catch (Exception e) {
                logger.error("艺龙获取酒店详详情结果出现异常", e);
            }
            return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
        HotelInfoResponseVO responseVO = new HotelInfoResponseVO();
        List<HotelInfoVO> hotelInfoVOS = new ArrayList<>();
        List<HotelGJInfoVO> hotelGJInfoVOS = new ArrayList<>();
        List<HotelInfoGlobalVO> hotelInfoGlobalVOS = new ArrayList<>();
        for (ImmutableTriple<HotelInfoVO, HotelGJInfoVO, HotelInfoGlobalVO> hotelInfoVOHotelGJInfoVOImmutablePair : immuHotelInfoList) {
            HotelInfoVO left = hotelInfoVOHotelGJInfoVOImmutablePair.getLeft();
            if (Objects.nonNull(left)) {
                hotelInfoVOS.add(left);
            }
            HotelGJInfoVO middle = hotelInfoVOHotelGJInfoVOImmutablePair.getMiddle();
            if (Objects.nonNull(middle)) {
                hotelGJInfoVOS.add(middle);
            }
            HotelInfoGlobalVO right = hotelInfoVOHotelGJInfoVOImmutablePair.getRight();
            if (Objects.nonNull(right)) {
                hotelInfoGlobalVOS.add(right);
            }
        }
        responseVO.setHotelGJInfoVOList(hotelGJInfoVOS);
        responseVO.setHotelInfoVOList(hotelInfoVOS);
        responseVO.setHotelInfoGlobalVOS(hotelInfoGlobalVOS);
        responseVO.setPageVO(dealPageVo(hotelIdsByCityId, pageSize));
        return ApiRes.success(responseVO);
    }

     /**
     * 处理 返回pagevo
     *
     * @param hotelIdsByCityId 酒店ID个数
     * @param pageSize         size
     * @return pagevo
     */
    private PageVO dealPageVo(List<HotelIdVO> hotelIdsByCityId, int pageSize) {
        PageVO pageVO = new PageVO();
        if (CollectionUtil.isEmpty(hotelIdsByCityId)) {
            pageVO.setLast(true);
            return pageVO;
        }
        Boolean last = hotelIdsByCityId.size() != pageSize;
        pageVO.setLast(last);
        return pageVO;
    }

    /**
     * 获取酒店
     *
     * @param config  配置
     * @param hotelid 酒店ID
     * @return immu
     */
     public ImmutableTriple<HotelInfoVO, HotelGJInfoVO, HotelInfoGlobalVO> getHotelGlobalInfo(ElongConfig config, String hotelid) {
        ElongHotelDetailRequest request = new ElongHotelDetailRequest(hotelid, config);
        Optional<ElongHotelDetailResponse> opResponse = elongHotelApiFunction.getHotelStaticDetail(request);
        if (!opResponse.isPresent()) {
            return null;
        }
        ElongHotelDetailResponse response = opResponse.get();
        ElongHotelDetailResult result = response.getResult();
        ElongDetailInfo detail = result.getDetail();
        String countryName = detail.getCountryName();
        if (StringUtils.equalsIgnoreCase(countryName, "中国")) {
            //中文信息
            HotelInfoVO hotelInfoVO = buildGnHotel(config, result, hotelid);
            //国际化信息
            HotelInfoGlobalVO globalVO = buildGlobalInfo(result, hotelid);

            return ImmutableTriple.of(hotelInfoVO, null, globalVO);
        } else {
            HotelGJInfoVO hotelGJInfoVO = buildGjHotel(result, hotelid);
            return ImmutableTriple.of(null, hotelGJInfoVO, null);
        }
    }

    /**
     * 获取英文信息
     *
     * @param result  艺龙酒店信息结果
     * @param hotelId 酒店ID
     * @return globalVo
     */
       private HotelInfoGlobalVO buildGlobalInfo(ElongHotelDetailResult result, String hotelId) {
        HotelInfoGlobalVO globalVO = new HotelInfoGlobalVO();
        ElongDetailInfo detail = result.getDetail();
        globalVO.setHotelid(hotelId);
        globalVO.setFybh(FyEnum.ELONG.getFybh());
        globalVO.setLanguageCode(LanguageLocalCodeEnum.ENUS.getCode());
        if (StringUtils.isBlank(detail.getHotelNameEn())
                && StringUtils.isBlank(detail.getAddressEn())
                && StringUtils.isBlank(detail.getDescriptionEn())
                && StringUtils.isBlank(detail.getFeaturesEn())) {
            return null;
        }
        globalVO.setJdmc(detail.getHotelNameEn());
        globalVO.setDz(detail.getAddressEn());
        globalVO.setJj(detail.getDescriptionEn());
        globalVO.setTbts(detail.getFeaturesEn());
        return globalVO;
    }

    /**
     * 获取所有酒店ID
     *
     * @param dto config
     * @return list
     */
      public List<HotelIdVO> getAllHotelId(HotelListDTO dto) {
        ElongConfig config = getConfig(dto.getSupplier());
//        config.setAppKey("48b025569a3b3d1f8cc3a60da297b265");
//        config.setSecretKey("fe6a55ca3d573514ff47872d378b117c");
//        config.setUser("44bf036314314dd0834198944fdd411f");
//        config.setUrl("https://api.elong.com/rest");
        ElongHotelListRequest request = new ElongHotelListRequest();
        request.setStartTime(dto.getStartTime());
        request.setEndTime(dto.getEndTime());
        Set<String> ids = getAllCity(config);
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }
        logger.info("艺龙：初始化拉取城市个数：{};", ids.size());
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        request.setConfig(config);
        for (String id : ids) {
            logger.info("艺龙：通过城市获取酒店:城市Id:{}", id);
            List<HotelIdVO> idVOList = getHotelIdsByCityId(id, request);
            hotelIdVOS.addAll(idVOList);
        }
        return hotelIdVOS;
    }
}

