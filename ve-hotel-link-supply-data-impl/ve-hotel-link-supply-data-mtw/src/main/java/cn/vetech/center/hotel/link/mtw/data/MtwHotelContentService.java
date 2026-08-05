package cn.vetech.center.hotel.link.mtw.data.hoteldetail;

import cn.vetech.center.hotel.link.api.constant.SymbolConstant;
import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.EtlArrivalTimeLimitInfo;
import cn.vetech.center.hotel.link.api.data.vo.EtlDepartureTimeLimitInfo;
import cn.vetech.center.hotel.link.api.data.vo.EtlHDescription;
import cn.vetech.center.hotel.link.api.data.vo.EtlHotelDetailExt;
import cn.vetech.center.hotel.link.api.data.vo.EtlHotelPolicy;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeDetailVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeVO;
import cn.vetech.center.hotel.link.api.enums.FyEnum;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.enums.HotelPolicyEnum;
import cn.vetech.center.hotel.link.enums.HotelRzrgjEnum;
import cn.vetech.center.hotel.link.enums.HotelWindowTypeEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwConfig;
import cn.vetech.center.hotel.link.mtw.common.MtwGeneralEnum;
import cn.vetech.center.hotel.link.mtw.common.MtwWindowEnum;
import cn.vetech.center.hotel.link.mtw.constant.MtwHotelTypesEnum;
import cn.vetech.center.hotel.link.mtw.constant.MtwRoomfacilityEnum;
import cn.vetech.center.hotel.link.mtw.constant.MtwWindowBadEnum;
import cn.vetech.center.hotel.link.mtw.data.function.MtwHotelApiFunction;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.request.MtwHotelContentRequest;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.request.MtwHotelRealRoomRequest;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.response.MtwJdTpVo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelAddress;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelAddressCoordinate;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelBreakfastPolicy;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelCodeName;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelContent;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelContentPolicy;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelContentResponse;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelDetailInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelFacility;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelFacilityItem;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelImage;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelImageLink;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelPetPolicy;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelStartEnd;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelTypeValue;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomBaseInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomBedInfo;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomDescription;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomFacility;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomOccupancy;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomResponse;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomResultContent;
import cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.room.MtwHotelRealRoomWindow;
import cn.vetech.center.hotel.link.mtw.enums.MtwApiEnum;
import cn.vetech.center.hotel.link.supply.base.util.SupplierConfigUtils;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.LngLonUtil;
import cn.vetech.center.hotel.link.util.VeStringUtil;
import cn.vetech.charge.cloud.modules.utils.collection.CollectionUtil;
import cn.vetech.charge.cloud.modules.utils.collection.ListUtil;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

**
 * @author xiaotengyu
 * @since 2022-08-18 14:37
 */
@Service
public class MtwHotelContentService {

    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     */
    @Autowired
    private MtwHotelApiFunction mtwHotelApiFunction;

    /***
     * 根据酒店ID集合查询酒店详和房型信息
     * @param dto dto
     * @return RestResponse
     */
    public RestResponse<HotelInfoResponseVO> getHotelDetailByIds(HotelDetailHotleIdDTO dto) {
        HotelInfoResponseVO responseVO = new HotelInfoResponseVO();
        MtwConfig config = SupplierConfigUtils.parse(dto.getSupplier(), MtwConfig.class);
        if (config == null) {
            return ApiRes.fail("未找到房源商或者房源商未开启");
        }
        if (ListUtil.isEmpty(dto.getHotelIds())) {
            return ApiRes.fail("酒店IdList不能为空");
        }
        //每次查询酒店最多20个
        MtwHotelContentRequest request = buildRequest(config);
        List<HotelInfoVO> hotelInfoVOS = Lists.partition(dto.getHotelIds(), NumConstant.NUM_19)
                .stream()
                .flatMap(hotelIds -> {
                    List<Long> longIds = hotelIds.stream().map(NumberUtils::toLong).collect(Collectors.toList());
                    request.setHotelIds(longIds);
                    Optional<MtwHotelContentResponse> opHotelContent = mtwHotelApiFunction.getHotelDetailByIds(request);
                    return opHotelContent
                            .map(hotelContent -> buildHotelAndFx(hotelContent,config))
                            .orElse(ListUtil.emptyList()).stream();
                }).collect(Collectors.toList());
        responseVO.setHotelInfoVOList(hotelInfoVOS);
        return ApiRes.success(responseVO);
    }

    /**
     * 构建请求对象
     *
     * @return request
     */
    private MtwHotelContentRequest buildRequest(MtwConfig config) {
        MtwHotelContentRequest request = new MtwHotelContentRequest();
        request.setConfig(config);
        request.setMtwApiEnum(MtwApiEnum.HOTEL_CONTENT);
        request.setInclude(MtwGeneralEnum.HotelContentTypeEnum.getAllHotelContentTypes());
        return request;
    }

    /***
     * 构建酒店和房型
     * @param response 美团酒店详细信息
     * @return list
     */
    public List<HotelInfoVO> buildHotelAndFx(MtwHotelContentResponse response, MtwConfig config) {
        List<MtwHotelContent> hotelContents = response.getResult().getHotelContents();
        if (ListUtil.isEmpty(hotelContents)) {
            return ListUtil.emptyList();
        }
        return hotelContents.stream().map(hotelContent -> {
            //1.酒店基本信息
            HotelInfoVO hotelInfoVO = buildHotelInfo(hotelContent);
            //2.酒店基本信息明细
            HotelInfoDetailVO jbmx = buildJbxxMx(hotelContent);
            //原始信息
            hotelInfoVO.setHotelInfoResponse(JacksonUtils.toJsonWithDefault(hotelContent));
            //3.酒店图片
            buildTp(jbmx, hotelContent.getImages());
            hotelInfoVO.setHotelInfoDetailVO(jbmx);
            //4.酒店房型
            MtwHotelRealRoomRequest mtwHotelRealRoomRequest = buildRoomRequest(config, hotelContent.getHotelId());
            Optional<MtwHotelRealRoomResponse> opRealroomResponse = mtwHotelApiFunction.getHotelRealRoomById(mtwHotelRealRoomRequest);
            opRealroomResponse.ifPresent(roomResponse->{
                hotelInfoVO.setHotelRoomTypeResponse(JacksonUtils.toJsonWithNonEmpty(roomResponse));
            });
            List<HotelRoomTypeVO> hotelRoomTypeVOS = buildFx(hotelContent,opRealroomResponse);
            hotelInfoVO.setHotelRoomTypeVOList(hotelRoomTypeVOS);
            return hotelInfoVO;
        }).collect(Collectors.toList());
    }

      /**
     * @param hotelContent 美团酒店信息
     * @return JdJbxx
     */
    private HotelInfoVO buildHotelInfo(MtwHotelContent hotelContent) {
        HotelInfoVO hotelInfoVO = new HotelInfoVO();
        cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent.MtwHotelBaseInfo baseInfo = hotelContent.getBaseInfo();
        MtwHotelDetailInfo detailInfo = hotelContent.getDetailInfo();
        //基本信息
        hotelInfoVO.setHotelId(String.valueOf(hotelContent.getHotelId()));
        hotelInfoVO.setZwmc(baseInfo.getName());
        hotelInfoVO.setGddh(baseInfo.getPhone());
        hotelInfoVO.setGngjlb("1");
        hotelInfoVO.setSzgjmc("中国");
        hotelInfoVO.setKysj(detailInfo.getOpenDate());
        hotelInfoVO.setZxsj(detailInfo.getDecorationDate());
        //城市，行政区，经纬度，地址
        buildAddress(hotelInfoVO, baseInfo.getAddress());
        //评分
        handlePfzpf(hotelInfoVO, detailInfo.getRatings());
        //星级
        dealXJ(hotelInfoVO, detailInfo.getStar());
        //酒店状态
        buildZt(hotelInfoVO, baseInfo.getBookable());
        //酒店类型
        buildHotelType(hotelInfoVO, detailInfo.getTypes());
        //品牌
        buildBrand(hotelInfoVO, detailInfo.getBrand());
        return hotelInfoVO;
    }

    /**
     * 品牌
     *
     * @param hotelInfoVO vo
     * @param brand       品牌
     */
    public void buildBrand(HotelInfoVO hotelInfoVO, MtwHotelCodeName brand) {
        if (Objects.isNull(brand)) {
            return;
        }
        hotelInfoVO.setPp(brand.getName());
    }

    /**
     * @param bookable 美团状态 酒店是否可订。false:不可订，true:可订
     */
    private void buildZt(HotelInfoVO hotelInfoVO, String bookable) {
        if (StringUtils.isNotBlank(bookable) && StringUtils.equalsIgnoreCase(bookable, Boolean.FALSE.toString())) {
            hotelInfoVO.setZt(HotelStatusEnum.DISABLE.getValue());
        }
    }

    /**
     * 处理地址信息
     *
     * @param hotelInfoVO vo
     * @param address     美团地址
     */
    private void buildAddress(HotelInfoVO hotelInfoVO, MtwHotelAddress address) {
        if (Objects.isNull(address)) {
            return;
        }
          MtwHotelCodeName country = address.getCountry();
        MtwHotelCodeName province = address.getProvince();
        MtwHotelCodeName city = address.getCity();
        MtwHotelCodeName area = address.getArea();
        List<MtwHotelCodeName> businessDistricts = address.getBusinessDistricts();
        List<MtwHotelAddressCoordinate> coordinates = address.getCoordinates();
        if (Objects.nonNull(country)) {
            hotelInfoVO.setSzgjmc(country.getName());
        }
        if (Objects.nonNull(province)) {
            hotelInfoVO.setSzsfcode(province.getCode());
            hotelInfoVO.setSzsfmc(province.getName());
        }
        if (Objects.nonNull(city)) {
            hotelInfoVO.setSzcscode(city.getCode());
            hotelInfoVO.setSzcsmc(city.getName());
        }
        if (Objects.nonNull(area)) {
            hotelInfoVO.setXzqmc(area.getName());
        }
        if (ListUtil.isNotEmpty(businessDistricts)) {
            hotelInfoVO.setSyqmc(businessDistricts.stream().map(dis -> dis.getName()).findFirst().orElse(StringUtils.EMPTY));
        }
        if (ListUtil.isNotEmpty(coordinates)) {
            //百度经纬度
            coordinates.stream()
                    .filter(coor -> StringUtils.equalsIgnoreCase(coor.getProvider(), MtwGeneralEnum.CoordinateTypeEnum.BAIDU.getVal()))
                    .findFirst().ifPresent(coor -> {
                        double lon = NumberUtils.toDouble(coor.getLongitude()) / NumConstant.D100W;
                        double lat = NumberUtils.toDouble(coor.getLatitude()) / NumConstant.D100W;
                        hotelInfoVO.setBdjd(String.valueOf(lon));
                        hotelInfoVO.setBdwd(String.valueOf(lat));
                    });
                     //谷歌经纬度
            coordinates.stream()
                    .filter(coor -> StringUtils.equalsIgnoreCase(coor.getProvider(), MtwGeneralEnum.CoordinateTypeEnum.GOOGLE.getVal()))
                    .findFirst().ifPresent(coor -> {
                        double lon = NumberUtils.toDouble(coor.getLongitude()) / NumConstant.D100W;
                        double lat = NumberUtils.toDouble(coor.getLatitude()) / NumConstant.D100W;
                        hotelInfoVO.setGgjd(String.valueOf(lon));
                        hotelInfoVO.setGgwd(String.valueOf(lat));
                    });
            //如果百度经纬度为空时
            if ((StringUtils.isBlank(hotelInfoVO.getBdjd()) || StringUtils.isBlank(hotelInfoVO.getBdwd()))
                    && (StringUtils.isNotBlank(hotelInfoVO.getGgwd()) && StringUtils.isNotBlank(hotelInfoVO.getGgjd()))) {
                double[] jwd = LngLonUtil.gdToBd(NumberUtils.toDouble(hotelInfoVO.getGgwd()) / NumConstant.D100W, NumberUtils.toDouble(hotelInfoVO.getGgjd()) / NumConstant.D100W);
                hotelInfoVO.setBdwd(String.valueOf(jwd[0]));
                hotelInfoVO.setBdjd(String.valueOf(jwd[1]));
            }
        }
    }

     /**
     * 图片
     *
     * @param detailVO detailVO
     * @param images   美团图片
     */
    private void buildTp(HotelInfoDetailVO detailVO, List<MtwHotelImage> images) {
        if (ListUtil.isEmpty(images)) {
            return;
        }
        List<MtwJdTpVo> tps = images.stream().flatMap(image -> {
            List<MtwHotelImageLink> links = image.getLinks();
            if (ListUtil.isEmpty(links)) {
                return null;
            }
            MtwGeneralEnum.ImageTypeEnum imageTypeEnum = MtwGeneralEnum.ImageTypeEnum.getByCode(image.getCategory());
            return links.stream().filter(link -> StringUtils.isNotBlank(link.getUrl())).map(link -> {
                MtwJdTpVo mtwJdTpVo = new MtwJdTpVo();
                mtwJdTpVo.setTpcc("1");
                mtwJdTpVo.setTplx(imageTypeEnum.getLocalCode());
                mtwJdTpVo.setTpdz(link.getUrl());
                return mtwJdTpVo;
            });
        }).collect(Collectors.toList());
        detailVO.setZy(JacksonUtils.toJsonWithNonEmpty(tps));
    }

    /**
     * 构建房型
     *
     * @param hotelContent 美团酒店信息
     * @return list
     */
    private List<HotelRoomTypeVO> buildFx(MtwHotelContent hotelContent, Optional<MtwHotelRealRoomResponse> opRealroomResponse) {
        List<MtwHotelRealRoomBaseInfo> realRoomInfos = hotelContent.getRoomBaseInfos();
        if (CollectionUtil.isEmpty(realRoomInfos)) {
            return new ArrayList<>();
        }

        return realRoomInfos.stream().filter(room -> StringUtils.equalsIgnoreCase(MtwGeneralEnum.StatusEnum.T.getVal(), room.getStatus())).map(room -> {
            HotelRoomTypeVO roomTypeVO = new HotelRoomTypeVO();
            HotelRoomTypeDetailVO detailVO = new HotelRoomTypeDetailVO();
            roomTypeVO.setHotelid(hotelContent.getHotelId());
            detailVO.setHotelid(hotelContent.getHotelId());
            buildRoom(roomTypeVO, room);
            buildRoomDetail(detailVO, room, opRealroomResponse);
            roomTypeVO.setHotelRoomTypeDetailVO(detailVO);
            return roomTypeVO;
        }).collect(Collectors.toList());
    }

    /**
     * 构建物理房型
     *
     * @param baseInfo baseInfo
     * @param jdFx     jdfx
     */
    private void buildRoom(HotelRoomTypeVO jdFx, MtwHotelRealRoomBaseInfo baseInfo) {
        jdFx.setFyfxid(baseInfo.getRealRoomId());
        jdFx.setFxmc(baseInfo.getName());
        jdFx.setMj(baseInfo.getUseAbleArea());
        jdFx.setLc(baseInfo.getFloor());
        MtwHotelRealRoomOccupancy occupancy = baseInfo.getOccupancy();
        if (Objects.nonNull(occupancy)) {
            jdFx.setTjrzrs(occupancy.getTotal());
        }

        List<List<MtwHotelRealRoomBedInfo>> bedGroups = baseInfo.getBedGroups();
        if (ListUtil.isEmpty(bedGroups)) {
            return;
        }
        bedGroups.stream().findFirst().ifPresent(bedgroup -> {
            if (ListUtil.isEmpty(bedgroup)) {
                return;
            }
            bedgroup.stream().findFirst().ifPresent(bed -> {
                jdFx.setCx(bed.getType());
                jdFx.setBednumber(bed.getCount());
            });
        });
    }

     /**
     * 房型详细信息
     *
     * @param roombaseInfo 美团房型信息
     * @param detailVO     房型详情
     */
    private void buildRoomDetail(HotelRoomTypeDetailVO detailVO
            , MtwHotelRealRoomBaseInfo roombaseInfo
            ,Optional<MtwHotelRealRoomResponse> opRealroomResponse) {
        detailVO.setFyfxid(roombaseInfo.getRealRoomId());
        //窗户+描述
        buildWindow(detailVO, roombaseInfo);
        //床型描述
        buildBed(detailVO, roombaseInfo);
        //房型图片
        buildRoomPic(detailVO,opRealroomResponse);
        //房型设施
        roomFacility(detailVO,opRealroomResponse);

        detailVO.setWifi(MtwGeneralEnum.MtwInternetWayEnum.getDescByCode(roombaseInfo.getInternetAccess()));
    }

      /**
     * 处理房型设施
     *
     * @param detailVO           vo
     * @param opRealroomResponse response
     */
    private void roomFacility(HotelRoomTypeDetailVO detailVO, Optional<MtwHotelRealRoomResponse> opRealroomResponse) {
        opRealroomResponse.ifPresent(response -> {
            if (Objects.isNull(response) || Objects.isNull(response.getResult()) || CollectionUtils.isEmpty(response.getResult().getRoomContents())) {
                return;
            }
            List<MtwHotelRealRoomResultContent> roomContents = response.getResult().getRoomContents();
            MtwHotelRealRoomResultContent mtwHotelRealRoomResultContent = roomContents.stream().filter(room -> Objects.nonNull(room.getBaseInfo())
                    && StringUtils.equalsIgnoreCase(room.getBaseInfo().getRealRoomId(), detailVO.getFyfxid())).findFirst().orElse(null);
            if (Objects.isNull(mtwHotelRealRoomResultContent)) {
                return;
            }
            Map<String, MtwHotelRealRoomFacility> facilities = mtwHotelRealRoomResultContent.getFacilities();
            if (Objects.isNull(facilities)) {
                return;
            }
            String fcs = facilities.entrySet().stream()
                    .filter(f->Objects.nonNull(f.getValue()))
                    .map(f -> {
                String key = f.getKey();
                MtwHotelRealRoomFacility value = f.getValue();
                Optional<MtwRoomfacilityEnum> byId = MtwRoomfacilityEnum.getById(key);
                return getFacilityName(byId, value);
            }).filter(StringUtils::isNotBlank).collect(Collectors.joining(SymbolConstant.COMMA
            ));
            detailVO.setFxss(fcs);
        });
    }

     private String getFacilityName(Optional<MtwRoomfacilityEnum> mtwRoomfacilityEnum, MtwHotelRealRoomFacility facility) {
        return mtwRoomfacilityEnum.map(f -> {
            if (StringUtils.isBlank(f.getAnalysis())) {
                String value = facility.getValue();
                return StringUtils.equalsIgnoreCase(value, "1") ? "有" + f.getName() : "无" + f.getName();
            } else {
                String analysis = f.getAnalysis();
                String[] arrValues = StringUtils.split(analysis, SymbolConstant.SEMICOLON);
                Map<String, String> mapValue = Arrays.stream(arrValues)
                        .map(v -> StringUtils.split(v, SymbolConstant.HALF_COLON))
                        .filter(v -> CollectionUtils.size(v) == NumConstant.NUM_2)
                        .collect(Collectors.toMap(v -> v[0], v1 -> v1[1], (v1, v2) -> v1));
                String s = mapValue.get(facility.getValue());
                if (StringUtils.isBlank(s)) {
                    return StringUtils.EMPTY;
                }
                if (StringUtils.equalsAnyIgnoreCase(facility.getValue(), "1", "0") && !s.contains(f.getName())) {
                    return s + f.getName();
                } else {
                    return s;
                }
            }
        }).orElse(StringUtils.EMPTY);
    }

     /**
     * 构建酒店房型
     *
     * @param detailVO           vo
     * @param opRealroomResponse response
     */
    private void buildRoomPic(HotelRoomTypeDetailVO detailVO, Optional<MtwHotelRealRoomResponse> opRealroomResponse) {
        opRealroomResponse.ifPresent(response -> {
            List<MtwHotelRealRoomResultContent> roomContents = response.getResult().getRoomContents();
            List<MtwHotelImage> mtwHotelImages = roomContents.stream().filter(room -> {
                if (CollectionUtils.isEmpty(room.getImages()) || Objects.isNull(room.getBaseInfo())) {
                    return false;
                }
                return StringUtils.equalsIgnoreCase(room.getBaseInfo().getRealRoomId(), detailVO.getFyfxid());
            }).findFirst().map(room -> room.getImages()).orElse(new ArrayList<>());
            List<MtwJdTpVo> tps = mtwHotelImages.stream().flatMap(image -> {
                List<MtwHotelImageLink> links = image.getLinks();
                if (ListUtil.isEmpty(links)) {
                    return null;
                }
                MtwGeneralEnum.ImageTypeEnum imageTypeEnum = MtwGeneralEnum.ImageTypeEnum.getByCode(image.getCategory());
                return links.stream().filter(link -> StringUtils.isNotBlank(link.getUrl())).map(link -> {
                    MtwJdTpVo mtwJdTpVo = new MtwJdTpVo();
                    mtwJdTpVo.setTpcc("1");
                    mtwJdTpVo.setTplx(imageTypeEnum.getLocalCode());
                    mtwJdTpVo.setTpdz(link.getUrl());
                    return mtwJdTpVo;
                });
            }).filter(Objects::nonNull).collect(Collectors.toList());
            detailVO.setPic(JacksonUtils.toJsonWithNonNull(tps));
        });
    }

     /**
     * 床型
     *
     * @param jdFxMx       房型明细
     * @param roombaseInfo 房间描述
     */
    private void buildBed(HotelRoomTypeDetailVO jdFxMx, MtwHotelRealRoomBaseInfo roombaseInfo) {
        Boolean allowExtraBed = roombaseInfo.getAllowExtraBed();
        jdFxMx.setYdtbts("不可加床");
        if (Objects.nonNull(allowExtraBed) && allowExtraBed) {
            jdFxMx.setYdtbts("可加床");
        }
        List<List<MtwHotelRealRoomBedInfo>> bedGroups = roombaseInfo.getBedGroups();
        if (ListUtil.isEmpty(bedGroups)) {
            return;
        }
        List<String> bedDescription = Lists.newArrayList(jdFxMx.getFxms());
        bedGroups.stream().findFirst().ifPresent(bedgroup -> {
            if (ListUtil.isEmpty(bedgroup)) {
                return;
            }
            bedgroup.stream().findFirst().ifPresent(bed -> {
                List<String> bedDes = Lists.newArrayList(bed.getType(), bed.getDescription(), String.format("%s张床", bed.getCount()));
                bedDescription.add(String.format("床型描述：%s", bedDes.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(SymbolConstant.COMMA))));
            });
        });
        jdFxMx.setFxms(bedDescription.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(SymbolConstant.SEMICOLON)));
    }

        /**
     * 窗户
     *
     * @param detailVO 房型明细
     * @param baseInfo 美团房型信息
     */
    private void buildWindow(HotelRoomTypeDetailVO detailVO, MtwHotelRealRoomBaseInfo baseInfo) {
        List<String> roomDescription = new ArrayList<>();
        roomDescription.add(detailVO.getFxms());

        MtwHotelRealRoomDescription descriptions = baseInfo.getDescriptions();
        if (Objects.nonNull(descriptions) && StringUtils.isNotBlank(descriptions.getOverview())) {
            roomDescription.add(descriptions.getOverview());
        }

        if (StringUtils.isNotBlank(baseInfo.getFloor())) {
            roomDescription.add(String.format("所在楼层：%s", baseInfo.getFloor()));
        }

        MtwHotelRealRoomWindow window = baseInfo.getWindow();
        if (Objects.isNull(window)) {
            detailVO.setFxms(StringUtils.join(roomDescription, SymbolConstant.SEMICOLON));
            return;
        }
        roomDescription.add(window.getDescription());

        MtwWindowEnum mtwWindowEnum = MtwWindowEnum.getByCode(window.getHasWindow());
        detailVO.setCh(mtwWindowEnum.getLocalCode());
        roomDescription.add(mtwWindowEnum.getName());

        String disadvantage = window.getDisadvantage();
        if (StringUtils.isBlank(disadvantage)) {
            detailVO.setFxms(roomDescription.stream().filter(Objects::nonNull).collect(Collectors.joining(SymbolConstant.SEMICOLON)));
            return;
        }

         String[] splitWindow = StringUtils.split(disadvantage, SymbolConstant.COMMA);
        List<HotelWindowTypeEnum> hotelWindowTypeEnums = MtwWindowBadEnum.toVeWindowType(splitWindow);
        detailVO.setChlx(StringUtils.EMPTY);
        if (ListUtil.isNotEmpty(hotelWindowTypeEnums)) {
            detailVO.setChlx(hotelWindowTypeEnums.get(0).getBh());
            roomDescription.add(hotelWindowTypeEnums.stream().map(HotelWindowTypeEnum::getMc).collect(Collectors.joining(SymbolConstant.COMMA)));
        }
        detailVO.setFxms(roomDescription.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(SymbolConstant.SEMICOLON)));
    }

    /**
     * @param hotelStar   美团星级
     * @param hotelInfoVO vo
     */
    private void dealXJ(HotelInfoVO hotelInfoVO, MtwHotelCodeName hotelStar) {
        if (Objects.isNull(hotelStar)) {
            return;
        }
        String star = String.valueOf(hotelStar.getCode());
        //星级
        if ("0".equals(star)) {
            hotelInfoVO.setXj("5");
        } else if ("1".equals(star)) {
            hotelInfoVO.setTjxj("5");
            hotelInfoVO.setTjxjly(FyEnum.MTW.getFybh());
        } else if ("2".equals(star)) {
            hotelInfoVO.setXj("4");
        } else if ("3".equals(star)) {
            hotelInfoVO.setTjxj("4");
            hotelInfoVO.setTjxjly(FyEnum.MTW.getFybh());
        } else if ("4".equals(star)) {
            hotelInfoVO.setXj("3");
        } else if ("5".equals(star)) {
            hotelInfoVO.setTjxj("3");
            hotelInfoVO.setTjxjly(FyEnum.MTW.getFybh());
        } else {
            hotelInfoVO.setTjxj("2");
            hotelInfoVO.setTjxjly(FyEnum.MTW.getFybh());
        }
    }

      /**
     * @param hotelInfoVO info
     * @return Pfzpf
     */
    private void handlePfzpf(HotelInfoVO hotelInfoVO, List<MtwHotelTypeValue> ratings) {
        if (ListUtil.isEmpty(ratings)) {
            return;
        }
        ratings.stream().findFirst().ifPresent(rat -> {
            String hotelRat = rat.getValue();
            if (StringUtils.isBlank(hotelRat)) {
                return;
            }
            double rating = NumberUtils.toDouble(hotelRat) / NumConstant.NUM_10;
            hotelInfoVO.setPfzpf(String.valueOf(rating));
        });
    }

    /**
     * 构建基础实施列表
     *
     * @param detailVO   mx
     * @param facilities 美团设施
     */
    private void buildJcsslb(HotelInfoDetailVO detailVO, List<MtwHotelFacility> facilities) {
        if (ListUtil.isEmpty(facilities)) {
            return;
        }
        facilities.stream()
                .filter(f -> StringUtils.equalsIgnoreCase(f.getCategory(), MtwGeneralEnum.HotelFacilityTypeEnum.HOTEL_FACILITY.getVal()))
                .findFirst().ifPresent(f -> {
                    List<MtwHotelFacilityItem> facilityItems = f.getFacilityItems();
                    if (ListUtil.isEmpty(facilityItems)) {
                        return;
                    }
                    String facilityStr = facilityItems.stream()
                            .filter(fc->!StringUtils.equalsIgnoreCase(fc.getValue(),"0"))
                            .map(facility -> facility.getName())
                            .filter(Objects::nonNull).collect(Collectors.joining(SymbolConstant.COMMA));
                    facilityStr = facilityStr.replaceAll("中式餐厅", "中餐厅").replaceAll("西式餐厅", "西餐厅");
                    detailVO.setJcsslb(facilityStr);

                });
    }

     /**
     * 获取服务设施列表
     *
     * @param detailVO   jbmx
     * @param facilities 美团设施
     */
    private void buildMxService(HotelInfoDetailVO detailVO, List<MtwHotelFacility> facilities) {
        if (ListUtil.isEmpty(facilities)) {
            return;
        }
        facilities.stream()
                .filter(f -> StringUtils.equalsIgnoreCase(f.getCategory(), MtwGeneralEnum.HotelFacilityTypeEnum.HOTEL_SERVICE.getVal())).findFirst()
                .ifPresent(f -> {
                    List<MtwHotelFacilityItem> facilityItems = f.getFacilityItems();
                    if (ListUtil.isEmpty(facilities)) {
                        return;
                    }
                    String serviceFacility = facilityItems.stream()
                            .filter(fi -> !StringUtils.equalsIgnoreCase(fi.getValue(), "0"))
                            .map(fi -> fi.getName())
                            .collect(Collectors.joining(SymbolConstant.COMMA));
                    detailVO.setFwsslb(serviceFacility);
                });
    }

    /**
     * 主题
     *
     * @param detailVO jbmx
     * @param themes   美团主题
     */
    private void buildTheme(HotelInfoDetailVO detailVO, List<MtwHotelCodeName> themes) {
        if (ListUtil.isEmpty(themes)) {
            return;
        }
        String themeStr = themes.stream().map(MtwHotelCodeName::getName).filter(Objects::nonNull).collect(Collectors.joining(SymbolConstant.COMMA));
        detailVO.setJdztlb(themeStr);
    }

     /**
     * 酒店类型
     *
     * @param hotelInfoVO vo
     * @param types       美团酒店类型
     */
    private void buildHotelType(HotelInfoVO hotelInfoVO, List<MtwHotelCodeName> types) {
        if (ListUtil.isEmpty(types)) {
            return;
        }
        String typeStr = types.stream().map(MtwHotelCodeName::getName).filter(Objects::nonNull).collect(Collectors.joining(SymbolConstant.COMMA));
        hotelInfoVO.setJdlx(typeStr);
    }

    /**
     * 特别提示
     *
     * @param hotelInfoDetailVO vo
     * @param hotelContent      content
     */
    private void buildTbts(HotelInfoDetailVO hotelInfoDetailVO, MtwHotelContent hotelContent) {
        List<String> tbtsStrList = new ArrayList<>();
        List<MtwHotelTypeValue> notices = hotelContent.getNotices();
        if (CollectionUtils.isNotEmpty(notices)) {
            List<String> noticeStrList = notices.stream().map(MtwHotelTypeValue::getValue).collect(Collectors.toList());
            tbtsStrList.addAll(noticeStrList);
        }
        MtwHotelContentPolicy policy = hotelContent.getPolicy();
        if (Objects.nonNull(policy)) {
            MtwHotelStartEnd checkInPolicy = policy.getCheckinPolicy();
            MtwHotelStartEnd checkOutPolicy = policy.getCheckOutPolicy();
            if (Objects.nonNull(checkInPolicy)) {
                List<String> checkInDesc = Lists.newArrayList(StringUtils.isNotBlank(checkInPolicy.getStart()) && !StringUtils.equalsIgnoreCase(checkInPolicy.getStart(), "0") ? String.format("登记入住开始时间:%s", checkInPolicy.getStart()) : StringUtils.EMPTY
                        , StringUtils.isNotBlank(checkInPolicy.getEnd()) && !StringUtils.equalsIgnoreCase(checkInPolicy.getEnd(), "0") ? String.format("登记入住结束时间:%s", checkInPolicy.getEnd()) : StringUtils.EMPTY);
                tbtsStrList.add(checkInDesc.stream().filter(StringUtils::isNotBlank).collect(Collectors.joining(SymbolConstant.COMMA)));
            }
            if (Objects.nonNull(checkOutPolicy)) {
                String checkOutTime = checkOutPolicy.getEnd();
                if ((StringUtils.isBlank(checkOutTime) || StringUtils.equalsIgnoreCase(checkOutTime, "0"))
                        && StringUtils.isNotBlank(checkOutPolicy.getStart())
                        && !StringUtils.equalsIgnoreCase(checkOutPolicy.getStart(), "0")) {
                    checkOutTime = checkOutPolicy.getStart();
                }
                 String timeStr = String.format("离店时间:%s", checkOutTime);
                tbtsStrList.add(timeStr);
            }
        }
        hotelInfoDetailVO.setTbts(String.join(SymbolConstant.SEMICOLON, tbtsStrList));
    }
     /**
     * 酒店详细信息
     *
     * @param hotelContent 美团酒店信息
     * @return n
     */
    private HotelInfoDetailVO buildJbxxMx(MtwHotelContent hotelContent) {
        HotelInfoDetailVO detailVO = new HotelInfoDetailVO();
        MtwHotelDetailInfo detailInfo = hotelContent.getDetailInfo();
        detailVO.setHotelid(String.valueOf(hotelContent.getHotelId()));
        //地址
        buildDz(detailVO, hotelContent.getBaseInfo().getAddress());
        detailVO.setJj(VeStringUtil.filterEmoji(detailInfo.getDescription(), ""));
        //酒店设施
        buildJcsslb(detailVO, hotelContent.getFacilities());
        //服务设施
        buildMxService(detailVO, hotelContent.getFacilities());
        //主题
        buildTheme(detailVO, detailInfo.getThemes());
        // 酒店类型
        buildTypes(detailVO, detailInfo.getTypes());
        //特别提示
        buildTbts(detailVO, hotelContent);
        //扩展信息
        buildDetailExt(detailVO, hotelContent);
        return detailVO;
    }
  /**
     * 酒店类型，解析到主题中
     *
     * @param detailVO detailVO
     * @param types    types
     */
    private void buildTypes(HotelInfoDetailVO detailVO, List<MtwHotelCodeName> types) {
        if (CollectionUtils.isEmpty(types)) {
            return;
        }
        Set<String> typeSet = new HashSet<>();
        for (MtwHotelCodeName type : types) {
            Set<String> hotelSubCategoryNameSet = MtwHotelTypesEnum.getVeNameByCode(type.getCode());
            if (CollectionUtils.isNotEmpty(hotelSubCategoryNameSet)) {
                typeSet.addAll(hotelSubCategoryNameSet);
            }
        }
        String typeDesc = StringUtils.join(typeSet, SymbolConstant.COMMA);
        detailVO.setJdztlb(VeStringUtil.joinWithCommaIsNotBlank(detailVO.getJdztlb(), typeDesc));
    }

    /**
     * 地址
     *
     * @param detailVO vo
     * @param address  美团地址信息
     */
    private void buildDz(HotelInfoDetailVO detailVO, MtwHotelAddress address) {
        StringBuffer dz = new StringBuffer();
        MtwHotelCodeName addressLine = address.getAddressLine();
        MtwHotelCodeName city = address.getCity();
        MtwHotelCodeName area = address.getArea();
        if (Objects.nonNull(city)) {
            dz.append(city.getName());
        }
        if (Objects.nonNull(area)) {
            dz.append(area.getName());
        }
        if (Objects.nonNull(addressLine)) {
            dz.append(addressLine.getName());
        }
        detailVO.setDz(dz.toString());
    }
      /**
     * 统计
     *
     * @param ext        ext
     * @param statistics 美团统计
     */
    private void buildStatics(EtlHotelDetailExt ext, List<MtwHotelTypeValue> statistics) {
        if (ListUtil.isEmpty(statistics)) {
            return;
        }
        //楼层高度
        statistics.stream()
                .filter(sta -> StringUtils.equalsIgnoreCase(sta.getType(), MtwGeneralEnum.StatisticsTypeEnum.FLOOR_COUNT.getVal()))
                .findFirst()
                .ifPresent(sta -> {
                    ext.setFloor(sta.getValue());
                });
        //房间数量
        statistics.stream()
                .filter(sta -> StringUtils.equalsIgnoreCase(sta.getType(), MtwGeneralEnum.StatisticsTypeEnum.ROOM_COUNT.getVal()))
                .findFirst()
                .ifPresent(sta -> {
                    int roomCount = NumberUtils.toInt(sta.getValue(), NumConstant.NUM_0);
                    if (roomCount > 0) {
                        ext.setFjsl(roomCount);
                    }
                });
    }

    /**
     * 入住离店正常
     *
     * @param ext    ext
     * @param policy 政策
     */
    private void checkInOutPolicy(EtlHotelDetailExt ext, MtwHotelContentPolicy policy) {
        MtwHotelStartEnd checkInPolicy = policy.getCheckinPolicy();
        if (Objects.nonNull(checkInPolicy)) {
            EtlArrivalTimeLimitInfo arrivalTimeLimitInfo = new EtlArrivalTimeLimitInfo();
            arrivalTimeLimitInfo.setEarliestTime(checkInPolicy.getStart());
            arrivalTimeLimitInfo.setLatestTime(checkInPolicy.getEnd());
        }
        MtwHotelStartEnd checkOutPolicy = policy.getCheckOutPolicy();
        if (Objects.nonNull(checkOutPolicy)) {
            EtlDepartureTimeLimitInfo limitInfo = new EtlDepartureTimeLimitInfo();
            limitInfo.setEarliestTime(checkOutPolicy.getStart());
            limitInfo.setLatestTime(checkOutPolicy.getEnd());
        }
    }

     /**
     * 酒店政策
     *
     * @param ext    ext
     * @param policy 政策
     */
    private void hotelPolicy(EtlHotelDetailExt ext, MtwHotelContentPolicy policy) {
        List<EtlHotelPolicy> hotelPolicies = new ArrayList<>();
        //早餐政策
        MtwHotelBreakfastPolicy breakfastPolicy = policy.getBreakfastPolicy();
        if (Objects.nonNull(breakfastPolicy) && StringUtils.equalsIgnoreCase(breakfastPolicy.getHasBreakfast(), "1")) {
            StringBuffer breakfast = new StringBuffer();
            EtlHotelPolicy mealPolicy = new EtlHotelPolicy();
            mealPolicy.setCode(HotelPolicyEnum.Meal.getCode());
            if (ListUtil.isNotEmpty(breakfastPolicy.getTypes())) {
                String mealStr = breakfastPolicy.getTypes().stream().map(t -> t.getName()).collect(Collectors.joining(SymbolConstant.COMMA));
                breakfast.append(String.format("早餐类型：%s;", mealStr));
            }
            if (ListUtil.isNotEmpty(breakfastPolicy.getStyles())) {
                String mealStr = breakfastPolicy.getStyles().stream().map(t -> t.getName()).collect(Collectors.joining(SymbolConstant.COMMA));
                breakfast.append(String.format("早餐形式：%s;", mealStr));
            }
            hotelPolicies.add(mealPolicy);
        }
         //宠物
        MtwHotelPetPolicy petPolicy = policy.getPetPolicy();
        if (Objects.nonNull(petPolicy)) {
            String descByCode = MtwGeneralEnum.PetPolicyEnum.getDescByCode(petPolicy.getAllowed());
            if (StringUtils.isNotBlank(descByCode)) {
                EtlHotelPolicy pet = new EtlHotelPolicy();
                pet.setCode(HotelPolicyEnum.Pet.getCode());
                pet.setText(descByCode);
                hotelPolicies.add(pet);
            }
        }
        //早餐
        MtwHotelStartEnd checkInPolicy = policy.getCheckinPolicy();
        MtwHotelStartEnd checkOutPolicy = policy.getCheckOutPolicy();
        if (Objects.nonNull(checkInPolicy) && Objects.nonNull(checkOutPolicy)) {
            EtlHotelPolicy checkInOut = new EtlHotelPolicy();
            checkInOut.setCode(HotelPolicyEnum.CheckInCheckOut.getCode());
            StringBuffer checkBuffer = new StringBuffer();
            checkBuffer.append(String.format("开始入住时间:%s", checkInPolicy.getStart()));
            checkBuffer.append(String.format("次日离店时间:%s", checkOutPolicy.getEnd()));
            checkInOut.setText(checkBuffer.toString());
            hotelPolicies.add(checkInOut);
        }
        ext.setHotelPolicies(hotelPolicies.stream().filter(p -> StringUtils.isNotBlank(p.getCode())).collect(Collectors.toList()));
    }

     /**
     * 扩展信息
     *
     * @param hotelContent 1
     * @return 1
     */
    private void buildDetailExt(HotelInfoDetailVO detailVO, MtwHotelContent hotelContent) {
        EtlHotelDetailExt ext = new EtlHotelDetailExt();
        MtwHotelDetailInfo detailInfo = hotelContent.getDetailInfo();
        if (StringUtils.isNotBlank(detailInfo.getDescription())) {
            List<EtlHDescription> descriptions = new ArrayList<>();
            EtlHDescription description = new EtlHDescription();
            description.setCategory("1");
            description.setText(detailInfo.getDescription());
            descriptions.add(description);
            ext.setDescriptions(descriptions);
        }
        //统计
        buildStatics(ext, detailInfo.getStatistics());
        //入住离店
        checkInOutPolicy(ext, hotelContent.getPolicy());
        //酒店政策
        hotelPolicy(ext, hotelContent.getPolicy());
        // 适用人群
        ext.setApplicablePeople(convertApplicablePeople(hotelContent.getPolicy()));
        detailVO.setDetailExt(ext);
    }

     /**
     * 适用人群
     *
     * @param policy policy
     * @return String
     */
    private String convertApplicablePeople(MtwHotelContentPolicy policy) {
        if (Objects.isNull(policy) || Objects.isNull(policy.getGuestPolicy()) || Objects.isNull(policy.getGuestPolicy().getGuestType())) {
            return null;
        }
        String code = policy.getGuestPolicy().getGuestType().getCode();
        if ("1".equals(code)) {
            return HotelRzrgjEnum.KJDWB.getBh();
        } else if ("2".equals(code)) {
            return HotelRzrgjEnum.JNB.getBh();
        } else if ("3".equals(code)) {
            return HotelRzrgjEnum.GATKR.getBh();
        }
        return null;
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

    /**
     * 构建请求对象
     *
     * @return request
     */
    private MtwHotelRealRoomRequest buildRoomRequest(MtwConfig config, String hotelId) {
        MtwHotelRealRoomRequest request = new MtwHotelRealRoomRequest();
        request.setConfig(config);
        request.setMtwApiEnum(MtwApiEnum.HOTEL_REALROOM_CONTENT);
        request.setHotelId(NumberUtils.toLong(hotelId));
        return request;
    }

}

