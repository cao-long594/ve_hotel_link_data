package cn.vetech.center.hotel.outface.map;

import cn.vetech.center.hotel.link.base.BaseRecordCountSize;
import cn.vetech.center.hotel.link.enums.BusinessKeyEnum;
import cn.vetech.center.hotel.mapping.ReceiveResponse;
import cn.vetech.center.hotel.mapping.map.IReceiveMappingController;
import cn.vetech.center.hotel.mapping.map.dto.MappingInfoDTO;
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
 * 接受mapping映射数据接口
 *
 * @author houya
 */
@Api("酒店映射接口(只有映射关系)")
@RestController
@RequestMapping("/hotelreceive")
public class ReceiveMappingController extends BaseRecordCountSize implements IReceiveMappingController {
;
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
    @ApiOperation(value = "供应商酒店映射", notes = "当供应商酒店信息有变化，需要修改酒店映射关系")
    @PostMapping({"/uploadMapping"})
    public ReceiveResponse mappingInfo(@RequestBody MappingInfoDTO mappingInfoDTO) {
        boolean accquire = super.defaultTryAccquire(BusinessKeyEnum.PUSH_MAPPING, mappingInfoDTO.getGysbh());
        if (!accquire){
            return new ReceiveResponse(false, "请求超频");
        }
        try {
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            recordCountAndSize("mappingInfo" + mappingInfoDTO.getGysbh(), mappingInfoDTO);
            return mappingSystemInvokerService.mappingInfo(mappingInfoDTO, head);
        } catch (Exception e) {
            logger.error("供应商酒店映射", e);
            return ReceiveResponse.fail("接口异常");
        }
    }

    @Override
    @ApiOperation(value = "供应商酒店映射,全量接口,通过上传映射文件方式", notes = "大批量全量上传,第一次上传资料时使用")
    @PostMapping({"/uploadMapping/file"})
    public ReceiveResponse mappingInfoFile(
            @RequestParam(value = "fileName", required = false) String fileName,
            @RequestParam("uploadFile") MultipartFile multipartFile) {
        long t = System.currentTimeMillis();
        String newfilename = "";
        try {
            newfilename = outFaceUtilService.writeFile(multipartFile);
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return mappingSystemInvokerService.mappingInfoFile(newfilename, head);
        } catch (Exception e) {
            logger.error("接受文件异常", e);
            return ReceiveResponse.fail("接口异常");
        } finally {
            logger.info("接受文件耗时{}保存到{}", System.currentTimeMillis() - t, newfilename);
        }
    }
}



