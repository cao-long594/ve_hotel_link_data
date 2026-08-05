package cn.vetech.center.hotel.outface.hotelinfo;

import cn.vetech.center.hotel.link.base.BaseRecordCountSize;
import cn.vetech.center.hotel.link.enums.BusinessKeyEnum;
import cn.vetech.center.hotel.link.ratelimt.RateLimitClient;
import cn.vetech.center.hotel.link.ratelimt.RateLimiterUtil;
import cn.vetech.center.hotel.mapping.ReceiveResponse;
import cn.vetech.center.hotel.mapping.hotelinfo.IReceiveHotelInfoController;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelInfoDTO;
import cn.vetech.center.hotel.mapping.service.MappingSystemInvokerService;
import cn.vetech.center.hotel.outface.service.OutFaceUtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 酒店详细信息上传
 *
 * @author houya
 */
@Api("酒店详细信息接口(包含映射关系)")
@RestController
@RequestMapping("/hotelreceive")
public class ReceiveHotelInfoController extends BaseRecordCountSize implements IReceiveHotelInfoController {

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

    @Override
    @ApiOperation(value = "供应商酒店静态数据维护接口", notes = "1）当供应商有新增酒店需要上架时；\n" +
            "2）当供应商酒店信息需要修改时；\n" +
            "3）当供应商酒店需要下架时；")
    @PostMapping({"/uploadHotelInfo"})
    public ReceiveResponse hotelInfo(@RequestBody HotelInfoDTO hotelInfoDTO) {
        try {
            boolean accquire = super.defaultTryAccquire(BusinessKeyEnum.PUSH_HOTELINFO, hotelInfoDTO.getGysbh());
            if (!accquire){
                return new ReceiveResponse(false, "请求超频");
            }
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            recordCountAndSize("uploadHotelInfo" + hotelInfoDTO.getGysbh(), hotelInfoDTO);
            return mappingSystemInvokerService.hotelInfo(hotelInfoDTO, head);
        } catch (Exception e) {
            logger.error("供应商酒店静态数据维护接口异常", e);
            return ReceiveResponse.fail("接口异常");
        }
    }

    @Override
    @ApiOperation(value = "供应商酒店静态数据维护接口,全量接口,通过上传映射文件方式", notes = "大批量全量上传,第一次上传资料时使用")
    @PostMapping({"/uploadHotelInfo/file"})
    public ReceiveResponse hotelInfoFile(@RequestParam(value = "fileName", required = false) String s, @RequestParam("uploadFile") MultipartFile multipartFile) {
        try {
            String newfilename = outFaceUtilService.writeFile(multipartFile);
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return mappingSystemInvokerService.hotelInfoFile(newfilename, head);
        } catch (Exception e) {
            logger.error("供应商酒店静态数据维护接口异常", e);
            return ReceiveResponse.fail("接口异常");
        }
    }
}
