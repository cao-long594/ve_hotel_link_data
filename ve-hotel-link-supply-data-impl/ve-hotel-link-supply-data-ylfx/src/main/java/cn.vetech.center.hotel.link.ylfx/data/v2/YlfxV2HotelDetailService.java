package cn.vetech.center.hotel.link.ylfx.data.v2;

import cn.vetech.center.hotel.link.api.data.dto.HotelDetailHotleIdDTO;
import cn.vetech.center.hotel.link.api.data.enums.DataResponseEnum;
import cn.vetech.center.hotel.link.api.data.enums.GnGjTypeEnum;
import cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelInfoVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelRoomTypeVO;
import cn.vetech.center.hotel.link.supply.ylfx.common.YlfxConfig;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.center.hotel.link.util.JacksonUtils;
import cn.vetech.center.hotel.link.util.UrlUtils;
import cn.vetech.center.hotel.link.http.HttpClientUtilExt;
import cn.vetech.center.hotel.link.http.HttpService;
import cn.vetech.charge.cloud.exception.SystemException;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import cn.vetech.charge.cloud.modules.utils.security.MD5Tool;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/** 易旅分销 V2 酒店静态详情服务。 */
@Service
public class YlfxV2HotelDetailService {
    private static final String URI = "/open/static/hotelinfos";
    @Autowired private HttpService httpService;
    public RestResponse<HotelInfoResponseVO> getHotelDetailByHotelId(HotelDetailHotleIdDTO dto, YlfxConfig config) throws SystemException {
        if (CollectionUtils.isEmpty(dto.getHotelIds())) return ApiRes.response(DataResponseEnum.PARAMETER_IS_EMPTY);
        try {
            List<HotelInfoVO> hotelInfoList = new ArrayList<>();
            for (int start = 0; start < dto.getHotelIds().size(); start += 50) {
                Request request = convertRequest(dto, config, start);
                String responseBody = sendRequest(request, config);
                Response response = JacksonUtils.parseNonEmpty(responseBody, Response.class);
                if (response == null || !"200".equals(response.getCode()) || response.getData() == null) {
                    continue;
                }
                for (Hotel hotel : response.getData()) {
                    HotelInfoVO hotelInfo = convertHotelInfo(hotel, responseBody);
                    hotelInfoList.add(hotelInfo);
                }
            }
            HotelInfoResponseVO result = new HotelInfoResponseVO();
            result.setHotelInfoVOList(hotelInfoList);
            return ApiRes.success(result);
        } catch (Exception e) {
            return ApiRes.response(DataResponseEnum.SUPPLIER_EXCEPTION, "易旅分销 V2 酒店详情接口异常");
        }
    }
    private Request convertRequest(HotelDetailHotleIdDTO dto, YlfxConfig config, int start) {
        Request request = new Request();
        request.setCustomerCode(config.getCustomerCode());
        request.setHotelCodes(dto.getHotelIds().subList(start, Math.min(start + 50, dto.getHotelIds().size())));
        return request;
    }
    private String sendRequest(Request request, YlfxConfig config) throws Exception {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String appid = StringUtils.defaultIfBlank(config.getAppid(), config.getAppId());
        java.util.Map<String, String> headers = HttpClientUtilExt.headMapJson();
        headers.put("appid", appid);
        headers.put("timestamp", timestamp);
        headers.put("signature", MD5Tool.MD5Encode(MD5Tool.MD5Encode(appid + config.getSecret()) + timestamp));
        String baseUrl = StringUtils.defaultIfBlank(config.getNewUrl(), config.getUrl());
        String url = UrlUtils.completeUrl(baseUrl, URI);
        String requestBody = JacksonUtils.toJsonWithNonEmpty(request);
        return httpService.doPostBody(url, requestBody, headers);
    }
    private HotelInfoVO convertHotelInfo(Hotel hotel, String raw) {
        HotelInfoVO vo = new HotelInfoVO();
        vo.setHotelInfoResponse(raw);
        vo.setHotelId(hotel.getHotelCode());
        vo.setZwmc(hotel.getHotelNameCn());
        vo.setYwmc(hotel.getHotelNameEn());
        vo.setGngjlb(GnGjTypeEnum.GN.getCode());
        vo.setSzgjmc(hotel.getCountryName());
        vo.setSzsfcode(hotel.getProvinceCode());
        vo.setSzsfmc(hotel.getProvinceName());
        vo.setSzcscode(hotel.getCityCode());
        vo.setSzcsmc(hotel.getCityName());
        vo.setGddh(hotel.getTelephone());
        vo.setBdjd(hotel.getLongitude());
        vo.setBdwd(hotel.getLatitude());
        if (Integer.valueOf(2).equals(hotel.getSaleStatus())) {
            vo.setZt(HotelStatusEnum.DISABLE.getValue());
        }
        vo.setHotelRoomTypeVOList(convertRoomInfo(hotel));
        return vo;
    }
    private List<HotelRoomTypeVO> convertRoomInfo(Hotel hotel) {
        List<HotelRoomTypeVO> rooms = new ArrayList<>();
        if (hotel.getRooms() == null) {
            return rooms;
        }
        for (Room source : hotel.getRooms()) {
            HotelRoomTypeVO room = new HotelRoomTypeVO();
            room.setHotelid(hotel.getHotelCode());
            room.setFyfxid(source.getRoomCode());
            room.setFxmc(source.getRoomNameCn());
            rooms.add(room);
        }
        return rooms;
    }
    public static class Request { private String customerCode; private List<String> hotelCodes; public String getCustomerCode(){return customerCode;} public void setCustomerCode(String v){customerCode=v;} public List<String> getHotelCodes(){return hotelCodes;} public void setHotelCodes(List<String> v){hotelCodes=v;} }
    public static class Response { private String code; private List<Hotel> data; public String getCode(){return code;} public void setCode(String v){code=v;} public List<Hotel> getData(){return data;} public void setData(List<Hotel> v){data=v;} }
    public static class Hotel { private String hotelCode,hotelNameCn,hotelNameEn,countryName,provinceCode,provinceName,cityCode,cityName,telephone,longitude,latitude; private Integer saleStatus; private List<Room> rooms; public String getHotelCode(){return hotelCode;} public void setHotelCode(String v){hotelCode=v;} public String getHotelNameCn(){return hotelNameCn;} public void setHotelNameCn(String v){hotelNameCn=v;} public String getHotelNameEn(){return hotelNameEn;} public void setHotelNameEn(String v){hotelNameEn=v;} public String getCountryName(){return countryName;} public void setCountryName(String v){countryName=v;} public String getProvinceCode(){return provinceCode;} public void setProvinceCode(String v){provinceCode=v;} public String getProvinceName(){return provinceName;} public void setProvinceName(String v){provinceName=v;} public String getCityCode(){return cityCode;} public void setCityCode(String v){cityCode=v;} public String getCityName(){return cityName;} public void setCityName(String v){cityName=v;} public String getTelephone(){return telephone;} public void setTelephone(String v){telephone=v;} public String getLongitude(){return longitude;} public void setLongitude(String v){longitude=v;} public String getLatitude(){return latitude;} public void setLatitude(String v){latitude=v;} public Integer getSaleStatus(){return saleStatus;} public void setSaleStatus(Integer v){saleStatus=v;} public List<Room> getRooms(){return rooms;} public void setRooms(List<Room> v){rooms=v;} }
    public static class Room { private String roomCode,roomNameCn; public String getRoomCode(){return roomCode;} public void setRoomCode(String v){roomCode=v;} public String getRoomNameCn(){return roomNameCn;} public void setRoomNameCn(String v){roomNameCn=v;} }
}
