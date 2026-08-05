package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 15:51
 */
public class MtwHotelContentResult {

    /**
     * 酒店内容信息列表
     */
    private List<MtwHotelContent> hotelContents;

    public List<MtwHotelContent> getHotelContents() {
        return hotelContents;
    }

    public void setHotelContents(List<MtwHotelContent> hotelContents) {
        this.hotelContents = hotelContents;
    }
}
