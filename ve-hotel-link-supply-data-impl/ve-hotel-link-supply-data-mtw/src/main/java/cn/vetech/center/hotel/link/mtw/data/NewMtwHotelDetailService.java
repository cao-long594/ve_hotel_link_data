package cn.vetech.center.hotel.link.mtw.data.hoteldetail;

import cn.vetech.center.hotel.link.api.data.dto.HotelBaseDTO;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GetHotelMethodEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.EtlArrivalTimeLimitInfo;
import cn.vetech.center.hotel.link.api.data.vo.EtlDepartureTimeLimitInfo;
import cn.vetech.center.hotel.link.api.data.vo.EtlHDescription;
import cn.vetech.center.hotel.link.api.data.vo.EtlHotelDetailExt;
import cn.vetech.center.hotel.link.api.data.vo.EtlHotelPolicy;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInitVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeVO;
import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.client.gys.mapping.IHotelInitServiceClient;
import cn.vetech.center.hotel.link.client.gys.mapping.dto.VeSearchDictDTO;
import cn.vetech.center.hotel.link.client.gys.mapping.vo.VeJdHomeDictVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.enums.HotelWindowEnum;
import cn.vetech.center.hotel.link.enums.HotelWindowTypeEnum;
import cn.vetech.center.hotel.link.enums.TpTypeEnum;
import cn.vetech.center.hotel.link.enums.TpccTypeEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwGeneralEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwWindowBadEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwWindowEnum;
import cn.vetech.center.hotel.link.mtw.data.function.MtwHotelApiFunction;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelBaseInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelDetail;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelDetailResponseVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelExtendInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwHotelIdVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwJdTpVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwPoiExtInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwPoiImage;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwRoomBedInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom.MtwRealRoomBaseInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom.MtwRealRoomInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.realroom.MtwRealRoomResult;
import cn.vetech.center.hotel.link.mtw.enums.MtwCloseStatusEnum;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.LngLonUtil;
import cn.vetech.center.hotel.link.util.VeStringUtil;
import cn.vetech.charge.cloud.modules.utils.collection.CollectionUtil;
import cn.vetech.charge.cloud.modules.utils.collection.ListUtil;
import cn.vetech.charge.cloud.modules.utils.mapper.BeanMapper;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

;

/**
 * 废弃
 *
 * @author xingyanyan on 2018/1/10.
 */
@Service
public class NewMtwHotelDetailService {

    /**
     * D100W
     */
    private static final double D100W = 1000000D;


    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(NewMtwHotelDetailService.class);
 /**
     * 调用mapping服务
     */
    @Autowired
    private IHotelInitServiceClient iHotelInitServiceClient;
    /**
     * mtwInitBaseDataService
     */
    @Autowired
    private MtwInitBaseDataService mtwInitBaseDataService;

    /**
     * mtwHotelApiFunction
     */
    @Autowired
    private MtwHotelApiFunction mtwHotelApiFunction;

    /**
     * getconfig
     *
     * @param source source
     * @return MtwConfig
     */
    public MtwConfig getConfig(Map<String, String> source) {
        if (source == null || source.size() < 1) {
            logger.error("未找到房源商或者房源商未开启 source:{}", source);
            return null;
        }
        return BeanMapper.map(source, MtwConfig.class);
    }
    /**
     * 获取如家省份城市商圈行政区
     */
    public RestResponse<HotelInitVO> getDateBase(HotelBaseDTO dto) {
        try {
            MtwConfig config = getConfig(dto.getSupplier());
            if (config == null) {
                return ApiRes.fail("生产配置参数失败");
            }
            getFacilitiesMap(config);
            return ApiRes.success(new HotelInitVO(GetHotelMethodEnum.HOTEL_ID));
        } catch (Exception e) {
            logger.error("mtw.getDateBase获取基础数据异常", e);
            return ApiRes.response(DataResponseEnum.SUPPLIER_INIT_FAIL);
        }
    }

    /***
     * 获取酒店ID List
     * @param dto dto
     * @return response
     */
    public RestResponse<List<HotelIdVO>> getHotelIdList(HotelBaseDTO dto) {
        MtwConfig config = getConfig(dto.getSupplier());
        if (config == null) {
            return ApiRes.fail("未找到房源商或者房源商未开启");
        }
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        List<Long> hotelIds = new ArrayList<>();
        Long maxId = (long) NumConstant.NUM_0;
        Long pageSize = (long) NumConstant.NUM_1000;
        for (; ; ) {
            Optional<MtwHotelIdVo> responseVo = mtwHotelApiFunction.getHotelListByPage(config, maxId, pageSize);
            if (!responseVo.isPresent()) {
                break;
            }
            MtwHotelIdVo mtwHotelIdVo = responseVo.get();
            maxId = mtwHotelIdVo.getMaxId();
            hotelIds.addAll(mtwHotelIdVo.getHotelIds());
            if (maxId == -1) {
                logger.warn("基础数据：美团maxId==-1；hotels.length:{}", hotelIds.size());
                break;
            }
        }
        HotelIdVO hotelIdVO = null;
        for (Long hotelId : hotelIds) {
            hotelIdVO = new HotelIdVO(String.valueOf(hotelId), VeDate.getStringTime());
            hotelIdVOS.add(hotelIdVO);
        }
        return ApiRes.success(hotelIdVOS);
    }
     /***
     * 根据酒店ID集合查询酒店详和房型信息
     * @param dto dto
     * @return RestResponse
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByIds(HotelDetailHotleIdDTO dto) {
        HotelInfoResponseVO responseVO = new HotelInfoResponseVO();
        MtwConfig config = getConfig(dto.getSupplier());
        if (config == null) {
            return ApiRes.fail("未找到房源商或者房源商未开启");
        }
        if (ListUtil.isEmpty(dto.getHotelIds())) {
            return ApiRes.fail("酒店IdList不能为空");
        }
        //每次查询酒店最多20个
        List<String> ids = dto.getHotelIds();
        List<Long> longIds = ids.stream().map(id -> NumberUtils.toLong(id)).collect(Collectors.toList());
        List<List<Long>> idids = Lists.partition(longIds, NumConstant.NUM_19);
        List<HotelInfoVO> hotelInfoVOS = new ArrayList<>();
        for (List<Long> idid : idids) {
            Optional<MtwHotelDetailResponseVo> optionalResponseVo = mtwHotelApiFunction.getHotelDetailByIds(config, idid);
            if (!optionalResponseVo.isPresent()) {
                continue;
            }
            MtwHotelDetailResponseVo responseVo = optionalResponseVo.get();
            List<MtwHotelDetail> mtwHotelDetails = responseVo.getResult().getHotelDetails();
            //构建酒店详和房型
            Optional<MtwRealRoomResult> realRoomInfo = mtwHotelApiFunction.getRealRoomInfo(config, idid);
            if (!realRoomInfo.isPresent()) {
                continue;
            }

            List<HotelInfoVO> infoVOS = buildHotelAndFx(mtwHotelDetails, config, realRoomInfo.get());
            hotelInfoVOS.addAll(infoVOS);
        }
        responseVO.setHotelInfoVOList(hotelInfoVOS);
        return ApiRes.success(responseVO);
    }
 /**
     * 加载图片
     *
     * @param hotelInfoDetailVO vo
     * @param config            config
     * @param poiImages         poi
     * @param frontImage        front
     */
    private void buildTp(HotelInfoDetailVO hotelInfoDetailVO
            , MtwConfig config
            , List<MtwPoiImage> poiImages
            , String frontImage) {
        List<MtwJdTpVo> mtwJdTpVos = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(poiImages)) {
            String tplx = "10";
            for (MtwPoiImage image : poiImages) {
                MtwJdTpVo mtwJdTpVo = new MtwJdTpVo();
                mtwJdTpVo.setTpdz(image.getUrl());
                mtwJdTpVo.setTpcc("1");
                mtwJdTpVo.setTplx(tplx);
                String pt = mtwInitBaseDataService.getFacilityBywbbh(config, image.getTypeId());
                if (StringUtils.isNoneEmpty(pt)) {
                    mtwJdTpVo.setTplx(pt);
                }
                mtwJdTpVos.add(mtwJdTpVo);
            }
        }
        if (StringUtils.isNoneEmpty(frontImage)) {
            MtwJdTpVo mtwJdTpVo = new MtwJdTpVo();
            mtwJdTpVo.setTpdz(frontImage);
            mtwJdTpVo.setTpcc("1");
            mtwJdTpVo.setTplx(TpTypeEnum.tp0.getCode());
            mtwJdTpVos.add(mtwJdTpVo);
        }
        if (CollectionUtil.isNotEmpty(mtwJdTpVos)) {
            hotelInfoDetailVO.setZy(JacksonUtils.toJsonWithNonEmpty(mtwJdTpVos));
        }
    }

    /***
     * 构建酒店和房型
     * @param mtwHotelDetails 酒店详细信息
     * @param config config
     * @param realRoomInfo 物理房型
     * @return list
     */
      public List<HotelInfoVO> buildHotelAndFx(List<MtwHotelDetail> mtwHotelDetails
            , MtwConfig config
            , MtwRealRoomResult realRoomInfo) {
        if (mtwHotelDetails == null || mtwHotelDetails.size() < 1) {
            return new ArrayList<>();
        }
        List<HotelInfoVO> hotelInfoVOS = new ArrayList<>();
        HotelInfoVO jbxx = null;
        HotelInfoDetailVO jbmx = null;
        //List<JdHomeDictVO> jdHomeDictVOS = getFacilitiesMap();
        for (MtwHotelDetail etldetail : mtwHotelDetails) {
            try {
                MtwHotelBaseInfo baseInfo = etldetail.getBaseInfo();
                MtwHotelExtendInfo extendInfo = etldetail.getExtendInfo();
                MtwPoiExtInfo poiExtInfo = extendInfo.getPoiExtInfo();
                //1.酒店基本信息
                jbxx = parseHotelInfo(baseInfo, poiExtInfo);
                //原始信息
                jbxx.setHotelInfoResponse(JacksonUtils.toJsonWithDefault(etldetail));
                jbxx.setHotelRoomTypeResponse(JacksonUtils.toJsonWithDefault(realRoomInfo));
                //2.酒店基本信息明细
                //酒店服务
                jbmx = parseJbxxMx(baseInfo, extendInfo, config);
                //3.酒店图片
                buildTp(jbmx, config, etldetail.getPoiImages(), etldetail.getBaseInfo().getFrontImage());
                //扩展信息：
                jbmx.setDetailExt(convertDetailExt(baseInfo, extendInfo));
                //4.酒店房型
                List<HotelRoomTypeVO> hotelRoomTypeVOS = buildFx(realRoomInfo, etldetail.getHotelId(), config);
                jbxx.setHotelInfoDetailVO(jbmx);
                jbxx.setHotelRoomTypeVOList(hotelRoomTypeVOS);
                hotelInfoVOS.add(jbxx);
            } catch (Exception ex) {
                logger.error("构建酒店详和房型异常，{}", etldetail, ex);
                continue;
            }
        }
        return hotelInfoVOS;
    }
      /**
     * 构建房型
     *
     * @param realRoomInfo realRoominfo
     * @param hotelId      酒店iD
     * @param config       config
     * @return list
     */
    private List<HotelRoomTypeVO> buildFx(MtwRealRoomResult realRoomInfo
            , Long hotelId
            , MtwConfig config) {
        Map<Long, List<MtwRealRoomInfo>> mapRealRoomInfos = realRoomInfo.getRealRoomInfos();
        List<MtwRealRoomInfo> realRoomInfos = mapRealRoomInfos.get(hotelId);
        if (CollectionUtil.isEmpty(realRoomInfos)) {
            return new ArrayList<>();
        }
        List<HotelRoomTypeVO> hotelRoomTypeVOS = new ArrayList<>();
        for (MtwRealRoomInfo roomInfo : realRoomInfos) {
            MtwRealRoomBaseInfo roombaseInfo = roomInfo.getRealRoomBaseInfo();
            List<MtwPoiImage> realRoomImageList = roomInfo.getRealRoomImageList();
            List<List<MtwRoomBedInfo>> roomBedInfoList = roomInfo.getRoomBedInfoList();
            Map<String, String> roomFacilities = roomInfo.getRoomFacilities();
            if (StringUtils.equalsIgnoreCase("0", roombaseInfo.getStatus())) {
                continue;
            }
            HotelRoomTypeVO roomTypeVO = new HotelRoomTypeVO();
            HotelRoomTypeDetailVO detailVO = new HotelRoomTypeDetailVO();

            roomTypeVO.setHotelid(String.valueOf(hotelId));
            detailVO.setHotelid(String.valueOf(hotelId));
            parsejdRealFx(roomTypeVO, roombaseInfo);
            parseRealFxmx(detailVO, roombaseInfo);
            opRoomBed(roomTypeVO, detailVO, roomBedInfoList);
            opImage(detailVO, realRoomImageList);
            opRoomFacilities(detailVO, roomFacilities, config);
            roomTypeVO.setHotelRoomTypeDetailVO(detailVO);
            hotelRoomTypeVOS.add(roomTypeVO);
        }
        return hotelRoomTypeVOS;
    }
/**
     * 获取字典表设施字典
     *
     * @return map
     */
    private void getFacilitiesMap(MtwConfig config) {
        VeSearchDictDTO dto = new VeSearchDictDTO();
        dto.setYwlx("1");
        dto.setFyjc(FyEnum.MTW.getFyen());
        RestResponse<List<VeJdHomeDictVO>> listRestResponse = iHotelInitServiceClient.listGysDict(dto);
        if (listRestResponse == null || CollectionUtils.isEmpty(listRestResponse.getResult())) {
            return;
        }
        List<VeJdHomeDictVO> result = listRestResponse.getResult();
        ConcurrentMap<String, Object> collect = result.stream().collect(Collectors.toConcurrentMap(x -> x.getWbbh(), y -> y.getMc(), (x, y) -> x));
        mtwInitBaseDataService.putFacilities(config, collect);
    }

    /**
     * 构建物理房型
     *
     * @param baseInfo baseInfo
     * @param jdFx     jdfx
     */
    private void parsejdRealFx(HotelRoomTypeVO jdFx, MtwRealRoomBaseInfo baseInfo) {
        jdFx.setFyfxid(baseInfo.getRealRoomId());
        jdFx.setFxmc(baseInfo.getRoomName());
        jdFx.setMj(baseInfo.getUseableArea());
        jdFx.setLc(baseInfo.getFloor());
        jdFx.setTjrzrs(baseInfo.getCapacity());
    }

     /**
     * @param roombaseInfo roombaseInfo
     * @param jdFxMx       fxmx
     */
    private void parseRealFxmx(HotelRoomTypeDetailVO jdFxMx, MtwRealRoomBaseInfo roombaseInfo) {
        jdFxMx.setFyfxid(roombaseInfo.getRealRoomId());
        StringBuilder fxms = new StringBuilder();
        if (StringUtils.isNotBlank(roombaseInfo.getRoomDesc())) {
            fxms.append("特色描述：" + roombaseInfo.getRoomDesc() + ";");
        }
        Integer w = roombaseInfo.getWindow();
        String wb = getWindowBad(roombaseInfo.getWindowBad());
        String wname = MtwWindowEnum.instance(w);
        if (StringUtils.isNotEmpty(wname)) {
            fxms.append(wname);
            if (StringUtils.isNoneEmpty(roombaseInfo.getWindowView())) {
                fxms.append(roombaseInfo.getWindowView());
            }
            fxms.append(";");
        }
        String wbname = MtwWindowBadEnum.instance(wb);
        if (StringUtils.isNotEmpty(wbname)) {
            fxms.append(wbname);
            fxms.append(";");
        }
        if (StringUtils.isNotBlank(roombaseInfo.getFloor())) {
            fxms.append("所在楼层：" + roombaseInfo.getFloor() + ";");
        }
        jdFxMx.setFxms(fxms + "");
        //窗户问题
        windowBuild(jdFxMx, roombaseInfo);
        String ydtbts = "";
        int trabed = roombaseInfo.getExtraBed() != null ? roombaseInfo.getExtraBed().intValue() : 0;
        if (0 == trabed) {
            ydtbts = "不可加床";
        } else {
            ydtbts = "可加床";
        }
        if (StringUtils.isNoneEmpty(roombaseInfo.getChildCapacity())
                && !StringUtils.equalsIgnoreCase("0", roombaseInfo.getChildCapacity())) {
            ydtbts = ydtbts + String.format(";房间最大容纳%s个儿童", roombaseInfo.getChildCapacity());
        }
        jdFxMx.setYdtbts(ydtbts);
        jdFxMx.setFxms(fxms.toString());
        jdFxMx.setWifi(MtwGeneralEnum.MtwInternetWayEnum.getDescByCode(roombaseInfo.getInternetWay()));
    }
     /**
     * 房型设施
     *
     * @param detailVO       detailVO
     * @param config         config
     * @param roomFacilities 字典表房型基础设施
     */
    private void opRoomFacilities(HotelRoomTypeDetailVO detailVO, Map<String, String> roomFacilities, MtwConfig config) {
        if (CollectionUtils.isEmpty(roomFacilities)) {
            return;
        }
        List<String> facNames = new ArrayList<>();
        roomFacilities.forEach((x, y) -> {
            if (StringUtils.equalsIgnoreCase(y, "0")) {
                return;
            }
            String name = mtwInitBaseDataService.getFacilityBywbbh(config, x);
            if (StringUtils.isNoneEmpty(name)) {
                facNames.add(name);
            }
        });
        if (CollectionUtil.isNotEmpty(facNames)) {
            String join = StringUtils.join(facNames, ",");
            detailVO.setFxss(join);
        }
    }

    /**
     * 操作房型图片
     *
     * @param detailVO          vo
     * @param realRoomImageList list
     */
    private void opImage(HotelRoomTypeDetailVO detailVO, List<MtwPoiImage> realRoomImageList) {
        if (CollectionUtil.isEmpty(realRoomImageList)) {
            return;
        }
        List<MtwJdTpVo> fxTps = new ArrayList<>();
        for (MtwPoiImage mtwPoiImage : realRoomImageList) {
            MtwJdTpVo mtwJdTpVo = new MtwJdTpVo();
            mtwJdTpVo.setTpdz(mtwPoiImage.getUrl());
            mtwJdTpVo.setTplx(TpTypeEnum.tp8.getCode());
            mtwJdTpVo.setTpcc(TpccTypeEnum.C1.getCode());
            fxTps.add(mtwJdTpVo);
        }
        detailVO.setPic(JacksonUtils.toJsonWithNonEmpty(fxTps));
    }

     /**
     * 操作床型
     *
     * @param roomTypeVO      roomType
     * @param detailVO        roomTypeDetail
     * @param roomBedInfoList list
     */
    private void opRoomBed(HotelRoomTypeVO roomTypeVO
            , HotelRoomTypeDetailVO detailVO
            , List<List<MtwRoomBedInfo>> roomBedInfoList) {
        if (CollectionUtil.isEmpty(roomBedInfoList)) {
            return;
        }
        List<MtwRoomBedInfo> mtwRoomBedInfos = roomBedInfoList.get(0);
        if (CollectionUtil.isEmpty(mtwRoomBedInfos)) {
            return;
        }
        MtwRoomBedInfo mtwRoomBedInfo = mtwRoomBedInfos.get(0);
        roomTypeVO.setCx(mtwRoomBedInfo.getBedType());
        String fxms = detailVO.getFxms();
        if (StringUtils.isNotBlank(mtwRoomBedInfo.getBedDesc())) {
            fxms += "床型描述：" + mtwRoomBedInfo.getBedDesc() + ";";
        }
        if (StringUtils.isNotBlank(mtwRoomBedInfo.getBedCount())) {
            roomTypeVO.setBednumber(mtwRoomBedInfo.getBedCount());
        }
        detailVO.setFxms(fxms);
    }

    /**
     * @param detail     detail
     * @param extendInfo extendInfo
     * @return JdJbxx
     */
    private HotelInfoVO parseHotelInfo(MtwHotelBaseInfo detail, MtwPoiExtInfo extendInfo) {
        HotelInfoVO jbxx = new HotelInfoVO();
        //基本信息
        jbxx.setHotelId(String.valueOf(detail.getHotelId()));
        jbxx.setZwmc(detail.getPointName());
        jbxx.setSzcsmc(detail.getCityName());
        jbxx.setXzqmc(detail.getLocationName());
        jbxx.setSyqmc(detail.getBareaName());
        jbxx.setGddh(detail.getPhone());
        jbxx.setGngjlb("1");
        double[] jwd = LngLonUtil.gdToBd(detail.getLatitude() / D100W, detail.getLongitude() / D100W);
        jbxx.setBdjd(String.valueOf(jwd[1]));
        jbxx.setBdwd(String.valueOf(jwd[0]));
        jbxx.setPfzpf(handlePfzpf(detail.getAvgScore()));
        //拓展信息
        dealXJ(extendInfo.getHotelStar(), jbxx);
        jbxx.setSzgjmc("中国");
        jbxx.setKysj(extendInfo.getOpenDate());
        jbxx.setZxsj(extendInfo.getDecorationDate());
        if (Objects.nonNull(detail.getCloseStatus())
                &&!Objects.equals(detail.getCloseStatus(),MtwCloseStatusEnum.OPEN.getCode())){
            jbxx.setZt(HotelStatusEnum.DISABLE.getValue());
        }
        //酒店类型
        buildHotelType(jbxx, extendInfo);
        return jbxx;
    }

      /**
     * @param hotelStar hotelStar
     * @param jbxx      jbxx
     */
    private void dealXJ(Integer hotelStar, HotelInfoVO jbxx) {
        String star = String.valueOf(hotelStar);
        //星级
        if ("0".equals(star)) {
            jbxx.setXj("5");
        } else if ("1".equals(star)) {
            jbxx.setTjxj("5");
            jbxx.setTjxjly(FyEnum.MTW.getFybh());
        } else if ("2".equals(star)) {
            jbxx.setXj("4");
        } else if ("3".equals(star)) {
            jbxx.setTjxj("4");
            jbxx.setTjxjly(FyEnum.MTW.getFybh());
        } else if ("4".equals(star)) {
            jbxx.setXj("3");
        } else if ("5".equals(star)) {
            jbxx.setTjxj("3");
            jbxx.setTjxjly(FyEnum.MTW.getFybh());
        } else {
            jbxx.setTjxj("2");
            jbxx.setTjxjly(FyEnum.MTW.getFybh());
        }
    }

    /**
     * @param avgScore avgScore
     * @return Pfzpf
     */
    private static String handlePfzpf(Integer avgScore) {
        if (avgScore == null || avgScore == 0) {
            return null;
        }
        double zpf = (double) avgScore / NumConstant.NUM_20;
        if (zpf >= NumConstant.NUM_1 && zpf <= NumConstant.NUM_5) {
            BigDecimal zpfzs = BigDecimal.valueOf(zpf).setScale(0, BigDecimal.ROUND_HALF_UP);
            return zpfzs.toPlainString();
        }
        return null;
    }

     /**
     * 构建基础实施列表
     *
     * @param jbmx       mx
     * @param extendInfo ex
     * @param config     lb
     */
    private void buildJcsslb(HotelInfoDetailVO jbmx
            , MtwHotelExtendInfo extendInfo
            , MtwConfig config) {

        Map<String, String> hotelFacilities = extendInfo.getHotelFacilities();
        if (CollectionUtils.isEmpty(hotelFacilities)) {
            return;
        }
        List<String> jcsss = new ArrayList<>();
        hotelFacilities.forEach((k, v) -> {
            if (StringUtils.equalsIgnoreCase(v, "0")) {
                return;
            }
            String jcss = mtwInitBaseDataService.getFacilityBywbbh(config, k);
            if (StringUtils.isBlank(jcss)) {
                return;
            }
            jcsss.add(jcss);
        });
        if (CollectionUtil.isNotEmpty(jcsss)) {
            String jcsslb = StringUtils.join(jcsss, ",");
            jcsslb = jcsslb.replaceAll("中式餐厅", "中餐厅").replaceAll("西式餐厅", "西餐厅");
            jbmx.setJcsslb(jcsslb);
        }
    }
     /**
     * 获取服务设施列表
     *
     * @param jbmx       jbmx
     * @param extendInfo extendInfo
     * @param config     config
     */
    private void buildMxService(HotelInfoDetailVO jbmx
            , MtwHotelExtendInfo extendInfo
            , MtwConfig config) {
        Map<String, String> hotelService = extendInfo.getHotelService();
        if (CollectionUtils.isEmpty(hotelService)) {
            return;
        }
        List<String> fwss = new ArrayList<>();
        hotelService.forEach((k, v) -> {
            if (StringUtils.equalsIgnoreCase("0", v)) {
                return;
            }
            String service = mtwInitBaseDataService.getFacilityBywbbh(config, k);
            if (StringUtils.isNoneEmpty(service)) {
                fwss.add(service);
            }
        });
        if (CollectionUtils.isEmpty(fwss)) {
            return;
        }
        String join = StringUtils.join(fwss, ",");
        jbmx.setFwsslb(join);
    }

    /**
     * 主题
     *
     * @param jbmx       jbmx
     * @param poiExtInfo poi
     */
    private void buildTheme(HotelInfoDetailVO jbmx, MtwPoiExtInfo poiExtInfo) {
        String themeTag = poiExtInfo.getThemeTag();
        if (StringUtils.isEmpty(themeTag)) {
            return;
        }
        String[] themes = StringUtils.split(themeTag, ",");
        if (themes == null || themes.length < 1) {
            return;
        }
        List<String> themesList = new ArrayList<>();
        for (String theme : themes) {
            String instance = MtwGeneralEnum.ThemeTagEnum.instance(theme);
            if (StringUtils.isEmpty(instance)) {
                return;
            }
            themesList.add(instance);
        }
        if (CollectionUtils.isEmpty(themesList)) {
            return;
        }
        String join = StringUtils.join(themesList, ",");
        jbmx.setJdztlb(join);
    }

      /**
     * 酒店类型
     *
     * @param hotelInfoVO vo
     * @param poiExtInfo  poi
     */
    private void buildHotelType(HotelInfoVO hotelInfoVO, MtwPoiExtInfo poiExtInfo) {
        if (StringUtils.isEmpty(poiExtInfo.getPoiType())) {
            return;
        }
        String[] poiType = StringUtils.split(poiExtInfo.getPoiType(), ",");
        if (poiType == null || poiType.length < 1) {
            return;
        }
        List<String> types = new ArrayList<>();
        for (String ptype : poiType) {
            String instance = StringUtils.EMPTY;
            if (StringUtils.isEmpty(instance)) {
                return;
            }
            types.add(instance);
        }
        if (CollectionUtil.isEmpty(types)) {
            return;
        }
        String join = StringUtils.join(types, ",");
        hotelInfoVO.setJdlx(join);
    }

    /**
     * 特别提示
     *
     * @param hotelInfoDetailVO vo
     * @param poiExtInfo        poiExt
     */
    private void buildTbts(HotelInfoDetailVO hotelInfoDetailVO, MtwPoiExtInfo poiExtInfo) {
        List<String> tbts = new ArrayList<>();
        //StringBuilder tbts = new StringBuilder();
        if (StringUtils.isNotBlank(poiExtInfo.getCheckinTimeBegin())) {
            tbts.add("登记入住开始时间" + poiExtInfo.getCheckinTimeBegin());
        }
        if (StringUtils.isNotBlank(poiExtInfo.getCheckinTimeEnd()) && !"0".equals(poiExtInfo.getCheckinTimeEnd())) {
            tbts.add("登记入住截止时间" + poiExtInfo.getCheckinTimeEnd());
        }
        if (StringUtils.isNotBlank(poiExtInfo.getCheckoutTime())) {
            if (!"0".equals(poiExtInfo.getCheckoutTime())) {
                tbts.add("离店时间" + poiExtInfo.getCheckoutTime());
            } else {
                tbts.add("离店时间为小时制，入住" + poiExtInfo.getCheckoutTimeHours() + "小时后离店");
            }
        }
         if (StringUtils.isNoneEmpty(poiExtInfo.getHotelRemind())) {
            tbts.add(poiExtInfo.getHotelRemind());
        }
        if (CollectionUtil.isNotEmpty(tbts)) {
            String join = StringUtils.join(tbts, "；");
            hotelInfoDetailVO.setTbts(join);
        }
    }

      /**
     * @param baseInfo   baseInfo
     * @param extendInfo extendInfo
     * @param config     config
     * @return n
     */
    private HotelInfoDetailVO parseJbxxMx(MtwHotelBaseInfo baseInfo
            , MtwHotelExtendInfo extendInfo
            , MtwConfig config) {
        HotelInfoDetailVO jbmx = new HotelInfoDetailVO();
        jbmx.setHotelid(String.valueOf(baseInfo.getHotelId()));
        jbmx.setDz(baseInfo.getCityName() + baseInfo.getLocationName() + baseInfo.getAddress());
        jbmx.setJj(VeStringUtil.filterEmoji(baseInfo.getInfo(), ""));
        //酒店设施
        buildJcsslb(jbmx, extendInfo, config);
        buildMxService(jbmx, extendInfo, config);
        buildTheme(jbmx, extendInfo.getPoiExtInfo());
        buildTbts(jbmx, extendInfo.getPoiExtInfo());
        //jbmx.setDetailExt(convertDetailExt(baseInfo,extendInfo));
        return jbmx;
    }

    /**
     * 窗户
     *
     * @param jdFxMx       mx
     * @param roombaseInfo baseInfo
     */
    private void windowBuild(HotelRoomTypeDetailVO jdFxMx, MtwRealRoomBaseInfo roombaseInfo) {
        if (NumConstant.NUM_0 == roombaseInfo.getWindow()) {
            jdFxMx.setCh(HotelWindowEnum.YC.getBh());
        } else if (NumConstant.NUM_1 == roombaseInfo.getWindow()) {
            jdFxMx.setCh(HotelWindowEnum.BFYC.getBh());
        } else if (NumConstant.NUM_2 == roombaseInfo.getWindow()) {
            jdFxMx.setCh(HotelWindowEnum.WC.getBh());
        }
        String wb = getWindowBad(roombaseInfo.getWindowBad());
        HotelWindowTypeEnum hotelWindowTypeEnum = null;
        if (hotelWindowTypeEnum != null) {
            jdFxMx.setChlx(hotelWindowTypeEnum.getBh());
        }
    }

    
         /**
     * @param baseInfo   1
     * @param extendInfo 1
     * @return 1
     */
    private EtlHotelDetailExt convertDetailExt(MtwHotelBaseInfo baseInfo, MtwHotelExtendInfo extendInfo) {
        EtlHotelDetailExt ext = new EtlHotelDetailExt();
        if (StringUtils.isNotBlank(baseInfo.getInfo())) {
            List<EtlHDescription> descriptions = new ArrayList<>();
            EtlHDescription description = new EtlHDescription();
            description.setCategory("1");
            description.setText(baseInfo.getInfo());
            ext.setDescriptions(descriptions);
        }
        if (Objects.isNull(extendInfo)) {
            return ext;
        }
        MtwPoiExtInfo extInfo = extendInfo.getPoiExtInfo();
        ext.setFjsl(extInfo.getRoomNum());
        if (extInfo.getFloorNum() != null) {
            ext.setFloor(extInfo.getFloorNum().toString());
        }
        if (StringUtils.isNotBlank(extInfo.getCheckinTimeBegin())) {
            StringBuilder sb = new StringBuilder();
            EtlArrivalTimeLimitInfo arrivalTimeLimitInfo = new EtlArrivalTimeLimitInfo();
            arrivalTimeLimitInfo.setEarliestTime(extInfo.getCheckinTimeBegin());
            sb.append("入住时间：").append(extInfo.getCheckinTimeBegin()).append("以后&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            if (!"0".equals(extInfo.getCheckinTimeEnd())) {
                arrivalTimeLimitInfo.setLatestTime(extInfo.getCheckinTimeEnd());
            }
             ext.setArrivalTimeLimitInfo(arrivalTimeLimitInfo);
            if (StringUtils.isNotBlank(extInfo.getCheckoutTime())) {
                EtlDepartureTimeLimitInfo departureTimeLimitInfo = new EtlDepartureTimeLimitInfo();
                sb.append("离店时间：");
                if (!"0".equals(extInfo.getCheckoutTime())) {
                    departureTimeLimitInfo.setLatestTime(extInfo.getCheckoutTime());
                    sb.append(extInfo.getCheckoutTime()).append("以前");
                } else {
                    sb.append("入住").append(extInfo.getCheckoutTimeHours()).append("个小时后离店。");
                }
                ext.setDepartureTimeLimitInfo(departureTimeLimitInfo);
            }
            EtlHotelPolicy etlHotelPolicy = new EtlHotelPolicy();
            etlHotelPolicy.setCode("CheckInCheckOut");
            etlHotelPolicy.setText(sb.toString());
            List<EtlHotelPolicy> hotelPolicies = new ArrayList<>();
            hotelPolicies.add(etlHotelPolicy);
            ext.setHotelPolicies(hotelPolicies);
        }
        return ext;
    }

    /**
     * 获取窗户类型
     *
     * @param bad bad
     * @return 类型
     */
    private String getWindowBad(String bad) {
        if (StringUtils.isEmpty(bad)) {
            return bad;
        }
        if (StringUtils.containsAny(bad, "[", "]")) {
            return StringUtils.substringBetween(bad, "[", "]");
        }
        return bad;
    }

}
