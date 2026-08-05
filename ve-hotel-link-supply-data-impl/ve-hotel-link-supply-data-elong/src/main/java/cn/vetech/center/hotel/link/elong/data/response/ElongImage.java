package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * 艺龙图片
 *
 * @author gaojin
 */
@XmlRootElement(name = "Image")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongImage implements Serializable {
    /**
     * 酒店id
     */
    @XmlTransient
    private String hotelid;
    /**
     * 图片id
     */
    @XmlTransient
    private String imageid;
    /**
     * 关联的房型，有值则表示这是对应房型的图片
     */
    @XmlAttribute(name = "RoomId")
    private String roomid;
    /**
     * 图片类型
     * 1 - 餐厅 (Restaurant) 2 - 休闲 (Recreation Facilities)
     * 3 - 会议室 (Meeting/Conference) 5 - 外观 (Exterior)
     * 6 -大堂/接待台 (Lobby/ Reception) 8 - 客房 (Guest Room) 10 - 其他 (Other Facilities)
     * 11 - 公共区域 (Public Area) 12 - 周边景点 (Nearby Attractions)
     */
    @XmlAttribute(name = "Type")
    private String type;
    /**
     * 是否是主图
     */
    @XmlAttribute(name = "IsCoverImage")
    private String iscoverimage;
    /**
     * 是否为房间主图
     */
    @XmlElement(name = "IsRoomCoverImage")
    private String isroomcoverimage;
    /**
     * 作者类型，Hotel - 酒店； User - 用户
     */
    @XmlAttribute(name = "AuthorType")
    private String authortype;
    /**
     * 图片地址
     */
    @XmlElementWrapper(name = "Locations")
    @XmlElement(name = "Location")
    private List<ElongLocation> locations;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getImageid() {
        return imageid;
    }


    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIscoverimage() {
        return iscoverimage;
    }

    public void setIscoverimage(String iscoverimage) {
        this.iscoverimage = iscoverimage;
    }

    public String getIsroomcoverimage() {
        return isroomcoverimage;
    }

    public void setIsroomcoverimage(String isroomcoverimage) {
        this.isroomcoverimage = isroomcoverimage;
    }

    public String getAuthortype() {
        return authortype;
    }

    public void setAuthortype(String authortype) {
        this.authortype = authortype;
    }

    public List<ElongLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ElongLocation> locations) {
        this.locations = locations;
    }
}
