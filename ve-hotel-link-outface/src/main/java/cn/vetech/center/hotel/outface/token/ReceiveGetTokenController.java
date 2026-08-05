package cn.vetech.center.hotel.outface.token;

import cn.vetech.center.hotel.mapping.ReceiveResponse;
import cn.vetech.center.hotel.mapping.token.IReceiveGetTokenController;
import cn.vetech.charge.cloud.modules.utils.security.MD5Tool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取授权token
 *
 * @author houya
 */
@RestController
@RequestMapping("/hotelreceive")
public class ReceiveGetTokenController implements IReceiveGetTokenController {
    @Override
    public ReceiveResponse getToken(@RequestParam(value = "gysbh") String gysbh, @RequestParam(value = "secret") String secret) {
        String token = MD5Tool.MD5Encode(gysbh + secret);
        return ReceiveResponse.success(token);
    }
}
