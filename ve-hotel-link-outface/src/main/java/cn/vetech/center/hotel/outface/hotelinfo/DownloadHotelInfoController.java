package cn.vetech.center.hotel.outface.hotelinfo;

import cn.vetech.center.hotel.mapping.ReceiveResponse;
import cn.vetech.center.hotel.mapping.hotelinfo.IDownloadHotelInfoController;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelInfoDownloadDTO;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelInfoIncDownloadDTO;
import cn.vetech.center.hotel.mapping.service.MappingSystemInvokerService;
import cn.vetech.center.hotel.outface.service.OutFaceUtilService;
import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xiaotengyu
 * @since 2024-12-03 19:43
 */
@Api("获取酒店清单")
@RestController
@RequestMapping("/hoteldownload")
public class DownloadHotelInfoController implements IDownloadHotelInfoController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OutFaceUtilService outFaceUtilService;

    /**
     * service
     */
    @Autowired
    private MappingSystemInvokerService mappingSystemInvokerService;
    /**
     * request
     */
    @Autowired
    protected HttpServletRequest request;

    @Override
    @PostMapping({"/downloadHotelData"})
    public ReceiveResponse downloadHotelData(@RequestBody HotelInfoDownloadDTO dto) {
        try{
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return mappingSystemInvokerService.downloadHotelInfo(dto, head);
        }catch (Exception ex){
            logger.error("下载酒店列表接口异常：{}", JsonMapper.nonNullMapper().toJson(dto), ex);
            return ReceiveResponse.fail("接口异常");
        }

    }

    @Override
    @PostMapping({"/downloadHotelDataInc"})
    public ReceiveResponse downloadHotelDataInc(@RequestBody HotelInfoIncDownloadDTO dto) {
        try{
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return mappingSystemInvokerService.downloadHotelDataInc(dto, head);
        }catch (Exception ex){
            logger.error("查询酒店增量ID列表接口异常：{}", JsonMapper.nonNullMapper().toJson(dto), ex);
            return ReceiveResponse.fail("接口异常");
        }
    }
}
