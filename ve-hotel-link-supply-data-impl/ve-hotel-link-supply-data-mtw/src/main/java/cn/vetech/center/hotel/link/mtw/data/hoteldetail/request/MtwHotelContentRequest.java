package cn.vetech.center.hotel.link.mtw.data.hoteldetail.request;

import cn.vetech.center.hotel.link.mtw.common.MtwBaseRequest;
import cn.vetech.center.hotel.link.util.JacksonUtils;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 14:23
 */
public class MtwHotelContentRequest extends MtwBaseRequest {

    /**
     * 需要查询酒店内容的酒店ID列表，一次最多查询20个
     */
    private List<Long> hotelIds;

    private List<String> include;

    public List<Long> getHotelIds() {
        return hotelIds;
    }

    public void setHotelIds(List<Long> hotelIds) {
        this.hotelIds = hotelIds;
    }

    public List<String> getInclude() {
        return include;
    }

    public void setInclude(List<String> include) {
        this.include = include;
    }

    /**
     * 转换成json字符串
     * @return json str
     */
    @Override
    public String toJson(){
        return JacksonUtils.toJsonWithDefault(this);
    }
}
