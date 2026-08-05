package cn.vetech.center.hotel.outface.lowprice;

import cn.vetech.center.hotel.link.base.BaseRecordCountSize;
import cn.vetech.center.hotel.link.enums.BusinessKeyEnum;
import cn.vetech.center.hotel.mapping.ReceiveResponse;
import cn.vetech.center.hotel.outface.service.OutFaceUtilService;
import cn.vetech.center.price.hotel.lowprice.IReceiveLowPriceController;
import cn.vetech.center.price.hotel.lowprice.dto.HotelLowPriceDTO;
import cn.vetech.center.price.hotel.lowprice.service.PriceSystemInvokerService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 获取最低价
 *
 * @author houya
 */
@RestController
public class ReceiveLowPriceController extends BaseRecordCountSize implements IReceiveLowPriceController  {

    /**
     * 服务
     */
    @Autowired
    private PriceSystemInvokerService priceSystemInvokerService;
    /**
     * 服务
     */
    @Autowired
    private OutFaceUtilService outFaceUtilService;
    /**
     * request
     */
    @Autowired
    protected HttpServletRequest request;

    /**
     * 接受最低价
     *
     * @param dto dto
      * @return
     */
    @Override
    public cn.vetech.center.price.hotel.lowprice.ReceiveResponse receiveLowPrice(@RequestBody HotelLowPriceDTO dto) {
        boolean accquire = super.defaultTryAccquire(BusinessKeyEnum.PUSH_HOTEPRICE, StringUtils.defaultString( StringUtils.defaultString(dto.getGysbh(),dto.getShbh()),dto.getFybh()));
        if (!accquire){
            return new cn.vetech.center.price.hotel.lowprice.ReceiveResponse(false, "请求超频");
        }
        try {
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            recordCountAndSize("receiveLowPrice" + dto.getGysbh(), dto);
            return priceSystemInvokerService.receiveLowPrice(dto, head);
        } catch (Exception e) {
            logger.error("供应商上传最低价", e);
            return cn.vetech.center.price.hotel.lowprice.ReceiveResponse.fail("接口异常");
        }
    }

    @Override
    public cn.vetech.center.price.hotel.lowprice.ReceiveResponse receiveLowPriceFile(@RequestParam(value = "fileName", required = false) String fileName,
                                                                                     @RequestParam("uploadFile") MultipartFile uploadFile) {
        long t = System.currentTimeMillis();
        String newfilename = "";
        try {
            newfilename = outFaceUtilService.writeFile(uploadFile);
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return priceSystemInvokerService.receiveLowPriceFile(newfilename, head);
        } catch (Exception e) {
            logger.error("接受文件异常", e);
            logger.error("供应商上传最低价,接受文件异常", e);
            return cn.vetech.center.price.hotel.lowprice.ReceiveResponse.fail("接口异常");
        } finally {
            logger.info("接受文件耗时{}保存到{}", System.currentTimeMillis() - t, newfilename);
        }
    }
}
