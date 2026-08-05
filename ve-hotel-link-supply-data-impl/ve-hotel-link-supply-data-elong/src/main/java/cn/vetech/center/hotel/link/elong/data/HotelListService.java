package cn.vetech.center.hotel.link.elong.data;

import cn.vetech.center.hotel.link.api.data.dto.HotelListDTO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdResponseVO;
import cn.vetech.center.hotel.link.api.data.vo.HotelIdVO;
import cn.vetech.center.hotel.link.api.data.vo.PageVO;
import cn.vetech.center.hotel.link.constant.NumConstant;
import cn.vetech.center.hotel.link.elong.common.ElongConfig;
import cn.vetech.center.hotel.link.elong.common.ElongHttp;
import cn.vetech.center.hotel.link.elong.data.request.ElongHotelListRequest;
import cn.vetech.center.hotel.link.elong.data.response.staticlist.ElongHotelListResponse;
import cn.vetech.center.hotel.link.util.ApiRes;
import cn.vetech.charge.cloud.springcloud.api.RestResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;
import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.DISABLE;

/**
 * @author xiaotengyu
 * @since 2021/12/3 10:13
 */
@Service
public class HotelListService extends ElongHttp {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(HotelListService.class);

    /**
     * api service
     */
    @Autowired
    private ElongHotelApiFunction elongHotelApiFunction;
    /**
     * detail service
     */
    @Autowired
    private ElongHotelDetailService elongHotelDetailService;

    /***
     * 根据城市获取酒店列表
     * @param request 12
     * @return data
     */
      public List<HotelIdVO> getHotelIdsByCityId(ElongHotelListRequest request) {
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        Optional<ElongHotelListResponse> opResponse = elongHotelApiFunction.getHotelStaticList(request);
        if (!opResponse.isPresent()) {
            return hotelIdVOS;
        }
        ElongHotelListResponse response = opResponse.get();
        if (Objects.nonNull(response.getLast()) && !response.getLast() && Objects.isNull(response.getResult())) {
            HotelIdVO idVO = new HotelIdVO();
            idVO.setHotelId("0");
            idVO.setStatus(DISABLE.getValue());
            hotelIdVOS.add(idVO);
            return hotelIdVOS;
        }
        response.getResult().getHotels().forEach(h -> {
            //hotelStatus =0 的才是有效的
            HotelIdVO idVO = new HotelIdVO();
            idVO.setHotelId(h.getHotelId());
            idVO.setStatus(StringUtils.equalsIgnoreCase(String.valueOf(NumConstant.NUM_0), h.getHotelStatus()) ? AVAILABLE.getValue() : DISABLE.getValue());
            hotelIdVOS.add(idVO);
        });
        return hotelIdVOS;
    }

    /**
     * 获取所有酒店ID
     *
     * @param dto config
     * @return list
     */
       public RestResponse<HotelIdResponseVO> getIncrHotelId(HotelListDTO dto) {
        HotelIdResponseVO responseVO = new HotelIdResponseVO();
        PageVO pageVO = new PageVO(true);
        responseVO.setPageVO(pageVO);

        ElongConfig config = getConfig(dto.getSupplier());
        Set<String> ids = elongHotelDetailService.getAllCity(config);
        if (CollectionUtils.isEmpty(ids)) {
            logger.info("艺龙增量接口：查询城市个数为0");
            return ApiRes.success(responseVO);
        }

        ElongHotelListRequest request = new ElongHotelListRequest();
        logger.info("艺龙增量接口：初始化拉取城市个数：{};", ids.size());
        request.setEndTime(dto.getEndTime());
        request.setStartTime(dto.getStartTime());
        List<HotelIdVO> hotelIdVOS = new ArrayList<>();
        request.setConfig(config);
        for (String id : ids) {
            logger.info("艺龙增量接口：通过城市获取酒店城市Id:{}", id);
            List<HotelIdVO> idVOList = elongHotelDetailService.getHotelIdsByCityId(id, request);
            hotelIdVOS.addAll(idVOList);
        }
        responseVO.setHotelIdVOList(hotelIdVOS);

        return ApiRes.success(responseVO);
    }


}
