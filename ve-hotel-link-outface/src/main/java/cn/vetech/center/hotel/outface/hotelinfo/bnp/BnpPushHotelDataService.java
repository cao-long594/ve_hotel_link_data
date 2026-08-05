package cn.vetech.center.hotel.outface.hotelinfo.bnp;

import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelInfo;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelInfoDTO;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.RoomInfo;
import cn.vetech.center.hotel.mapping.service.MappingSystemInvokerService;
import cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo.*;
import cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom.*;
import cn.vetech.center.hotel.outface.service.OutFaceUtilService;
import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import cn.vetech.charge.cloud.modules.utils.mapper.XmlMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 19:21
 */
@Service
public class BnpPushHotelDataService {
    /**
     * LDLLLW
     */
    public static final double LDLLLW = 0.0065;
    /**
     * LDLLL
     */
    public static final double LDLLL = 0.006;
    /**
     * LDLLLLE
     */
    public static final double LDLLLLE = 0.00002;
    /**
     * LDLLLLS
     */
    public static final double LDLLLLS = 0.000003;
    /**
    * xpi
     */
    public static final double X_PI = 3.14159265358979324 * 3000.0 / 180.0;
    /**
     * 日志工具
     */
    private final Logger logger = LoggerFactory.getLogger(BnpPushHotelDataService.class);
    /**
     *
     */
    @Autowired
    private MappingSystemInvokerService mappingSystemInvokerService;
    /**
     * request
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 服务
     */
    @Autowired
    private OutFaceUtilService outFaceUtilService;

    /**
     * BNP酒店数据推送
     *
     * @param req BNP酒店数据
     * @return ReceiveResponse
     */
    public void uploadHotelInfo(String req) {
        req = formatResponseStr(req);
        if (StringUtils.isBlank(req)) {
            logger.warn("BNP酒店数据推送请求参数为空");
            return;
        }
        HotelDescriptiveContentNotifRQ contentNotifRQ = XmlMapper.fromXml(req, HotelDescriptiveContentNotifRQ.class);
        if (Objects.isNull(contentNotifRQ)) {
            logger.warn("BNP酒店数据推送请求参数为空");
            return;
        }
        if (CollectionUtils.isEmpty(contentNotifRQ.getHotelDescriptiveContents())) {
            logger.warn("BNP酒店数据推送酒店列表数据为空【{}】", XmlMapper.toXml(contentNotifRQ));
            return;
        }
        try {
            HotelInfoDTO hotelInfoDTO = convertHotelContentNotifRQ(contentNotifRQ);
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            mappingSystemInvokerService.hotelInfo(hotelInfoDTO, head);
        } catch (Exception e) {
            logger.error("BNP酒店数据推送异常", e);
        }
    }
    
    /**
     * 转换酒店数据
     *
     * @param contentNotifRQ BNP酒店数据
     * @return HotelInfoDTO
     */
    private HotelInfoDTO convertHotelContentNotifRQ(HotelDescriptiveContentNotifRQ contentNotifRQ) {
        HotelInfoDTO hotelInfoDTO = new HotelInfoDTO();
        hotelInfoDTO.setGysbh("bnp");
        List<HotelInfo> hotelInfos = contentNotifRQ.getHotelDescriptiveContents().stream().map(content -> {
            HotelInfo hotelInfo = new HotelInfo();
            //这里存放供应原始数据
            hotelInfo.setThemes(JsonMapper.defaultMapper().toJson(content));
            hotelInfo.setHotelId(content.getHotelCode());
            hotelInfo.setHotelName(content.getHotelName());
            hotelInfo.setState("1");
            //图片
            hotelInfo.setThumbNailUrl(getImageStr(content.getImageMultimediaDescriptions()));
            //地址信息
            convertContactInfo(hotelInfo, content.getContactInfos(), content.getBnpHotelInfo());
            return hotelInfo;
        }).collect(Collectors.toList());
        hotelInfoDTO.setHotel(hotelInfos);
        return hotelInfoDTO;
    }
    /**
     * 地址信息
     *
     * @param hotelInfo    hotelInfo
     * @param contactInfos contactInfos
     */
    private void convertContactInfo(HotelInfo hotelInfo, List<ContactInfo> contactInfos, BnpHotelInfo bnpHotelInfo) {
        if (CollectionUtils.isEmpty(contactInfos)) {
            return;
        }
        ContactInfo contactInfo = contactInfos.get(0);
        if (CollectionUtils.isNotEmpty(contactInfo.getAddresses())) {
            Address address = contactInfo.getAddresses().get(0);
            hotelInfo.setAddress(address.getAddressLine());
            hotelInfo.setCityName(address.getCityName());
            if (StringUtils.equalsIgnoreCase("China", address.getCountryName())) {
                hotelInfo.setIsOverseas("0");
                //坐标
                convertPosition(hotelInfo, bnpHotelInfo, "1");
            } else {
                hotelInfo.setIsOverseas("1");
                //坐标
                convertPosition(hotelInfo, bnpHotelInfo, "0");
            }
            hotelInfo.setDistrictName(address.getCountryName());
        }
        if (CollectionUtils.isNotEmpty(contactInfo.getPhones())) {
            Phone phone = contactInfo.getPhones().get(0);
            if (StringUtils.equals("5", phone.getPhoneTechType())) {
                hotelInfo.setPhone(phone.getPhoneNumber());
            }
        }
    }

/**
     * 处理坐标信息
     *
     * @param hotelInfo    hotelInfo
     * @param bnpHotelInfo bnpHotelInfo
     */
    private void convertPosition(HotelInfo hotelInfo, BnpHotelInfo bnpHotelInfo, String gngj) {
        if (Objects.isNull(bnpHotelInfo) || Objects.isNull(bnpHotelInfo.getPosition())) {
            return;
        }
        Position position = bnpHotelInfo.getPosition();
        //国内
        if (StringUtils.equals("1", gngj)) {
            hotelInfo.setProvider("1");
            double[] doubles = gdToBd(Double.parseDouble(position.getLatitude()), Double.parseDouble(position.getLongitude()));
            hotelInfo.setLongitude(String.valueOf(doubles[1]));
            hotelInfo.setLatitude(String.valueOf(doubles[0]));
            return;
        }
        hotelInfo.setProvider("3");
        hotelInfo.setLongitude(position.getLongitude());
        hotelInfo.setLatitude(position.getLatitude());
    }

     /**
     * 高德 == 》 百度
     *
     * @param lat lat
     * @param lon lon
     * @return zb
     */
    public static double[] gdToBd(double lat, double lon) {
        double x = lon;
        double y = lat;
        double z = Math.sqrt(x * x + y * y) + LDLLLLE * Math.sin(y * X_PI);
        double theta = Math.atan2(y, x) + LDLLLLS * Math.cos(x * X_PI);
        double tempLon = z * Math.cos(theta) + LDLLLW;
        double tempLat = z * Math.sin(theta) + LDLLL;
        double[] gps = {tempLat, tempLon};
        return gps;
    }

    /**
     * BNP房型数据推送
     *
     * @param req BNP房型数据
     * @return ReceiveResponse
     */
    public void uploadRoomInfo(String req) {
        req = formatResponseStr(req);
        if (StringUtils.isBlank(req)) {
            logger.warn("BNP房型数据推送请求参数为空");
            return;
        }
        RoomDescriptiveContentNotifRQ contentNotifRQ = XmlMapper.fromXml(req, RoomDescriptiveContentNotifRQ.class);
        if (Objects.isNull(contentNotifRQ)) {
            logger.warn("BNP房型数据推送请求参数为空");
            return;
        }
        if (CollectionUtils.isEmpty(contentNotifRQ.getRoomDescriptiveContents())) {
            logger.warn("BNP房型数据推送房型列表数据为空【{}】", XmlMapper.toXml(contentNotifRQ));
            return;
        }
        try {
            HotelInfoDTO hotelInfoDTO = new HotelInfoDTO();
            convertRoomInfo(contentNotifRQ.getRoomDescriptiveContents(), hotelInfoDTO);
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return;
        } catch (Exception e) {
            logger.error("BNP房型数据推送异常", e);
            return;
        }
    }
     /**
     * 转换房型数据
     *
     * @param contentList  contentList
     * @param hotelInfoDTO hotelInfoDTO
     */
    private void convertRoomInfo(List<RoomDescriptiveContent> contentList, HotelInfoDTO hotelInfoDTO) {
        hotelInfoDTO.setGysbh("bnp");
        List<HotelInfo> hotel = new ArrayList<>();
        for (RoomDescriptiveContent content : contentList) {
            if (Objects.isNull(content.getFacilityInfo()) || CollectionUtils.isEmpty(content.getFacilityInfo().getGuestRooms())) {
                logger.warn("【{}】BNP房型数据推送房型列表数据为空【{}】", content.getHotelCode(), JsonMapper.nonEmptyMapper().toJson(content));
                continue;
            }
            HotelInfo hotelInfo = new HotelInfo();
            //存房型原始数据
            hotelInfo.setDistrict(JsonMapper.defaultMapper().toJson(content));
            hotelInfo.setHotelId(content.getHotelCode());
            convertRoomList(hotelInfo, content.getFacilityInfo().getGuestRooms());
            hotel.add(hotelInfo);
        }
        hotelInfoDTO.setHotel(hotel);
    }

    /**
     * 转换房型列表
     *
     * @param hotelInfo  hotelInfo
     * @param guestRooms guestRooms
     */
    private void convertRoomList(HotelInfo hotelInfo, List<GuestRoom> guestRooms) {
        List<RoomInfo> roomInfoList = guestRooms.stream().map(guestRoom -> {
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setRoomId(guestRoom.getCode());
            roomInfo.setName(guestRoom.getRoomTypeName());
            roomInfo.setCapcity(guestRoom.getMaxOccupancy());
            if (Objects.nonNull(guestRoom.getTypeRoom())) {
                TypeRoom typeRoom = guestRoom.getTypeRoom();
                roomInfo.setArea(typeRoom.getSizeMeasurement());
                roomInfo.setFloor(typeRoom.getFloor());
            }
            convertBedType(roomInfo, guestRoom.getFeatures());
            roomInfo.setRoomImgUrl(getImageStr(guestRoom.getImageMultimediaDescriptions()));

        /**
     * 处理图片
     *
     * @param imageMultimediaDescriptions imageMultimediaDescriptions
     */
    private String getImageStr(List<ImageMultimediaDescription> imageMultimediaDescriptions) {
        if (CollectionUtils.isEmpty(imageMultimediaDescriptions)) {
            return StringUtils.EMPTY;
        }
        ImageMultimediaDescription description = imageMultimediaDescriptions.get(0);
        if (CollectionUtils.isEmpty(description.getImageItems())) {
            return StringUtils.EMPTY;
        }
        List<ImageItem> imageItems = description.getImageItems().stream().filter(imageItem -> Objects.nonNull(imageItem.getImageFormat())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(imageItems)) {
            return StringUtils.EMPTY;
        }
        List<JdTp> tpList = imageItems.stream().map(imageItem -> {
            JdTp jdTp = new JdTp();
            jdTp.setTplx("8");
            jdTp.setTpdz(imageItem.getImageFormat().getUrl());
            return jdTp;
        }).collect(Collectors.toList());
        return JsonMapper.defaultMapper().toJson(tpList);
    }

    /**
     * 处理床型名称
     *
     * @param roomInfo roomInfo
     * @param features features
     */
    private void convertBedType(RoomInfo roomInfo, List<Feature> features) {
        if (CollectionUtils.isEmpty(features)) {
            return;
        }
        Feature feature = features.get(0);
        if (CollectionUtils.isEmpty(feature.getMultimediaDescriptions())) {
            return;
        }
        MultimediaDescription multimediaDescription = feature.getMultimediaDescriptions().get(0);
        if (CollectionUtils.isEmpty(multimediaDescription.getTextItems())) {
            return;
        }
        TextItem textItem = multimediaDescription.getTextItems().get(0);
        roomInfo.setBedType(textItem.getDescription());
    }
/**
     * 格式化响应
     *
     * @param result 原始返回
     * @return 格式化之后的响应
     */
    private String formatResponseStr(String result) {
        result = xmlStrFormate(result, "xmlns=\"http://www.opentravel.org/OTA/2003/05\"", "");
        result = xmlStrFormate(result, "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
        result = xmlStrFormate(result, "xsi:schemaLocation=\"http://www.opentravel.org/OTA/2003/05\"", "");
        return result;
    }

    /**
     * 格式化xml，替换xml中元素
     *
     * @param oriValue  xml原始文件
     * @param fieldFrom 要替换的元素
     * @param fieldTo   元素替换后的值
     * @return 新的字符串
     */
    public static String xmlStrFormate(String oriValue, String fieldFrom, String fieldTo) {
        if (StringUtils.isEmpty(oriValue)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isEmpty(fieldFrom)) {
            return oriValue;
        }
        if (!StringUtils.contains(oriValue, fieldFrom)) {
            return oriValue;
        }
        return oriValue.replaceAll(fieldFrom, fieldTo);
    }
}
