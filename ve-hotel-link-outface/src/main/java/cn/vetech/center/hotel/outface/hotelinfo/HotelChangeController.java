package cn.vetech.center.hotel.outface.hotelinfo;

import cn.vetech.center.hotel.mapping.HotelChangeResponse;
import cn.vetech.center.hotel.mapping.hotelinfo.IHotelChangeControllter;
import cn.vetech.center.hotel.mapping.hotelinfo.dto.HotelChangeDTO;
import cn.vetech.center.hotel.mapping.service.MappingSystemInvokerService;
import cn.vetech.center.hotel.outface.service.OutFaceUtilService;
import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author xiaotengyu
 * @since 2024-12-11 17:47
 */
@Api("酒店变更通知")
@RestController
@RequestMapping("/hotelchange")
public class HotelChangeController implements IHotelChangeControllter {

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
    @PostMapping(value = "/changeHotelInfo/{zhmc}")
    public HotelChangeResponse changeHotelInfo(@PathVariable("zhmc") String zhmc,@RequestBody HotelChangeDTO dto) {
        try{
            Map<String, String> head = outFaceUtilService.getMappingHead(request);
            return mappingSystemInvokerService.changeHotel(zhmc, dto, head);
         }catch (Exception ex){
            logger.error("变更酒店异常：{}", JsonMapper.nonNullMapper().toJson(dto), ex);
            return HotelChangeResponse.fail("接口异常");
        }
    }
}
