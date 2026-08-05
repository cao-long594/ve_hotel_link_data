package cn.vetech.center.hotel.link.ylfx.data;

import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.*;
import cn.vetech.center.hotel.link.constant.HotelLinkConstant;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxConfig;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxUtilsService;
import cn.vetech.center.hotel.link.supply.ylfx.enums.YlfxMethodEnum;
import cn.vetech.center.hotel.link.supply.ylfx.hotelstatic.YlfxHotelStaticCommonSercive;
import cn.vetech.center.hotel.link.supply.ylfx.hotelstatic.response.GetRoomListByHotelIdData;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.ylfx.data.request.YlfxHotelIdListRequest;
import cn.vetech.center.hotel.link.ylfx.data.request.YlfxHotelInfoRequest;
import cn.vetech.center.hotel.link.ylfx.data.response.YlfxHotelIdListData;
import cn.vetech.center.hotel.link.ylfx.data.response.YlfxHotelIdListResponse;
import cn.vetech.center.hotel.link.ylfx.data.response.YlfxHotelInfo;
import cn.vetech.center.hotel.link.ylfx.data.response.YlfxHotelInfoResponse;
import cn.vetech.charge.base.CommonMagicNumber;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.modules.utils.time.VeDate;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 6161
 * @date 2024/07/19
 */
@Service
public class YlfxHotelDetailService {
    /**
     * 日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(YlfxHotelDetailService.class);
    /**
     * 工具类
     */
    @Autowired
    private YlfxUtilsService utilsService;

    /**
     * 静态公共服务
     */
    @Autowired
    private YlfxHotelStaticCommonSercive hotelStaticCommonSercive;

    /**
     * 酒店列表
     *
     * @param config config
     * @return RestResponse<List < HotelIdVO>>
     * @throws SystemException SystemException
     */
    public RestResponse<List<HotelIdVO>> getHotelIdList(YlfxConfig config) throws SystemException {
        logger.warn("【{}】酒店ID列表拉取开始", config.getZhmc());
        Integer currentPage = CommonMagicNumber.INT1;//当前页数
        Integer pages = CommonMagicNumber.INT3;//总页数
        List<HotelIdVO> voList = new ArrayList<>();
        do {
            YlfxHotelIdListRequest request = new YlfxHotelIdListRequest();
            request.setCurrentPage(currentPage);
            request.setPageSize(CommonMagicNumber.INT1000);
            String res = utilsService.sendPost(request, config, YlfxMethodEnum.PAGE_HOTEL);
            YlfxHotelIdListResponse response = JacksonUtils.parseNonEmpty(res, YlfxHotelIdListResponse.class);
            ImmutablePair<Boolean, String> immutablePair = utilsService.checkResponse(response);
            if (Boolean.FALSE.equals(immutablePair.getLeft())) {
                logger.warn("页数【{}】获取酒店列表数据接口失败【{}】", currentPage, immutablePair.getRight());
                continue;
            }
            YlfxHotelIdListData data = response.getData();
            if (Objects.isNull(data) || CollectionUtils.isEmpty(data.getHotelInfoList())) {
                logger.warn("页数【{}】获取酒店列表hotelInfoList数据为空【{}】", currentPage, immutablePair.getRight());
                continue;
            }
            data.getHotelInfoList().forEach(hotelInfo -> {
                //只要国内
                if (!StringUtils.equals(hotelInfo.getCountryId(),CommonMagicNumber.STRING1)){
                    return;
                }
                HotelIdVO idVO = new HotelIdVO();
                idVO.setGngj(GnGjTypeEnum.GN.getCode());
                idVO.setHotelId(hotelInfo.getHotelId());
                if (!CommonMagicNumber.INT1.equals(hotelInfo.getActive())) {
                    idVO.setStatus(HotelStatusEnum.DISABLE.getValue());
                }
                idVO.setUpdatedTime(VeDate.getStringDate());
                voList.add(idVO);
            });
        } while (currentPage++ < pages);
        if (CollectionUtils.isEmpty(voList)) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "酒店ID列表为空");
        }
        logger.warn("【{}】酒店ID列表拉取结束:酒店个数【{}】", config.getZhmc(), voList.size());
        return ApiRes.success(voList);
    }

    /**
     * 酒店ID获取酒店详情
     *
     * @param dto    dto
     * @param config config
     * @return RestResponse<HotelInfoResponseVO>
     * @throws SystemException SystemException
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto, YlfxConfig config) throws SystemException {
        logger.warn("【{}】酒店详情拉取开始【{}】", config.getZhmc(), JacksonUtils.toJsonWithDefault(dto.getHotelIds()));
        List<String> hotelIds = dto.getHotelIds();
        if (CollectionUtils.isEmpty(hotelIds)) {
            return ApiRes.response(DataResponseEnum.PARAMETER_IS_EMPTY);
        }
        HotelInfoResponseVO responseVO = new HotelInfoResponseVO();
        List<HotelInfoVO> hotelInfoVOList = new ArrayList<>();
        hotelIds.forEach(hotelId -> {
            try {
              YlfxHotelInfoRequest request = new YlfxHotelInfoRequest();
                request.setHotelId(hotelId);
                String res = utilsService.sendPost(request, config, YlfxMethodEnum.GET_HOTEL_INFO);
                YlfxHotelInfoResponse response = JacksonUtils.parseNonEmpty(res, YlfxHotelInfoResponse.class);
                ImmutablePair<Boolean, String> immutablePair = utilsService.checkResponse(response);
                if (Boolean.FALSE.equals(immutablePair.getLeft())) {
                    logger.warn("酒店ID【{}】获取酒店详情接口失败【{}】", hotelId, immutablePair.getRight());
                    return;
                }
                if (Objects.isNull(response.getHotelInfo())) {
                    logger.warn("酒店ID【{}】获取酒店详情数据为空【{}】", hotelId, res);
                    return;
                }
                HotelInfoVO infoVO = new HotelInfoVO();
                infoVO.setHotelInfoResponse(res);
                //处理酒店详情数据
                convertHotelInfo(infoVO, response.getHotelInfo());
                //处理房型数据
                convertRoomInfo(infoVO, config);
                hotelInfoVOList.add(infoVO);
            } catch (Exception e) {
                logger.warn("酒店ID【{}】获取酒店详情数据异常【{}】", hotelId, e.getMessage(),e);
            }
        });
        responseVO.setHotelInfoVOList(hotelInfoVOList);
        return ApiRes.success(responseVO);
    }

    /**
     * 处理房型数据
     *
     * @param infoVO infoVO
     * @param config config
     */
    private void convertRoomInfo(HotelInfoVO infoVO, YlfxConfig config) {
        List<GetRoomListByHotelIdData> roomDataList = hotelStaticCommonSercive.getRoomListByHotelId(infoVO.getHotelId(), config);
        if (CollectionUtils.isEmpty(roomDataList)) {
            logger.warn("酒店ID【{}】获取酒店房型数据为空", infoVO.getHotelId());
            return;
        }
        String roomRes = JacksonUtils.toJsonWithNonEmpty(roomDataList);
        infoVO.setHotelRoomTypeResponse(roomRes);
        List<HotelRoomTypeVO> roomTypeVOList = new ArrayList<>();
        roomDataList.forEach(roomData -> {
            HotelRoomTypeVO roomTypeVO = new HotelRoomTypeVO();
            if (!CommonMagicNumber.INT1.equals(roomData.getActive())) {
                return;
            }
            roomTypeVO.setHotelid(roomData.getHotelId());
            roomTypeVO.setFyfxid(roomData.getRoomtypeId());
            roomTypeVO.setFxmc(roomData.getRoomtypeName());
            roomTypeVOList.add(roomTypeVO);
        });
        if (CollectionUtils.isEmpty(roomTypeVOList)) {
            logger.warn("酒店ID【{}】酒店房型数据无效【{}】", infoVO.getHotelId(), roomRes);
            return;
        }
        infoVO.setHotelRoomTypeVOList(roomTypeVOList);
    }
 /**
     * 处理酒店详情数据
     *
     * @param infoVO    infoVO
     * @param hotelInfo hotelInfo
     */
    private void convertHotelInfo(HotelInfoVO infoVO, YlfxHotelInfo hotelInfo) {
        infoVO.setHotelId(hotelInfo.getHotelId());
        infoVO.setZwmc(hotelInfo.getHotelName());
        infoVO.setGngjlb(GnGjTypeEnum.GN.getCode());
        infoVO.setSzgjmc(HotelLinkConstant.COUNTRY_CHINA_NAME);
        if (!CommonMagicNumber.INT1.equals(hotelInfo.getActive())) {
            infoVO.setZt(HotelStatusEnum.DISABLE.getValue());
        }
        infoVO.setSzsfcode(hotelInfo.getStateId());
        infoVO.setSzsfmc(hotelInfo.getStateName());
        infoVO.setSzcscode(hotelInfo.getCityId());
        infoVO.setSzcsmc(hotelInfo.getCityName());
        infoVO.setGddh(hotelInfo.getTel());
        infoVO.setBdjd(hotelInfo.getLongitude());
        infoVO.setBdwd(hotelInfo.getLatitude());
        HotelInfoDetailVO infoDetailVO = new HotelInfoDetailVO();
        infoDetailVO.setHotelid(hotelInfo.getHotelId());
        infoDetailVO.setDz(hotelInfo.getAddress());
        infoVO.setHotelInfoDetailVO(infoDetailVO);
    }
}
