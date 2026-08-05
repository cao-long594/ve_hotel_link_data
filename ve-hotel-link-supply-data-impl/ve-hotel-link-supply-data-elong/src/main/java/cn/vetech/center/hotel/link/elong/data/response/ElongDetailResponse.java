package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author gaojin
 */
@XmlRootElement(name = "Hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongDetailResponse implements Serializable {
    /**
     * 酒店编号
     */
    @XmlAttribute(name = "Id")
    private String id;
    /**
     * 详情
     */
    @XmlElement(name = "Detail")
    private ElongHotelDetail detail;
    /**
     * 房型
     */
    @XmlElementWrapper(name = "Rooms")
    @XmlElement(name = "Room")
    private List<ElongRoom> rooms;
    /**
     *
     */
    @XmlElementWrapper(name = "Images")
    @XmlElement(name = "Image")
    private List<ElongImage> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ElongHotelDetail getDetail() {
        return detail;
    }

    public void setDetail(ElongHotelDetail detail) {
        this.detail = detail;
    }

    public List<ElongRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<ElongRoom> rooms) {
        this.rooms = rooms;
    }

    public List<ElongImage> getImages() {
        return images;
    }

    public void setImage(List<ElongImage> images) {
        this.images = images;
    }
}
