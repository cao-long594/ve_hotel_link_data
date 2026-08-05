package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author gaojin
 */
@XmlRootElement(name = "Location")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongLocation implements Serializable {
    /**
     * 酒店id
     */
    @XmlTransient
    private String hotelid;
    /**
     * 关联房型id
     */
    @XmlTransient
    private String roomid;
    /**
     * 图片类型的id
     */
    @XmlTransient
    private String imageid;
    /**
     * 图片规格。
     * 1：jpg图片，固定长边350，固定长边350缩放(用于详情页图片展示)
     * 2：jpg图片，尺寸70x70(用于详情页图片列表的缩微图)
     * 3：jpg图片，尺寸120x120(用于列表页) 5：png图片，尺寸70x70
     * 6：png图片，尺寸120x120 7：png图片，固定长边640放缩
     */
    @XmlAttribute(name = "Size")
    private String size;
    /**
     * 是否有水印。0-N,1-Y
     */
    @XmlAttribute(name = "WaterMark")
    private String watermark;
    /**
     * 图片的http地址
     */
    @XmlValue
    private String location;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
