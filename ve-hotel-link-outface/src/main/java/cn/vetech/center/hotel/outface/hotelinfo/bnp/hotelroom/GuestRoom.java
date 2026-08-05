package cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelroom;

import cn.vetech.center.hotel.outface.hotelinfo.bnp.hotelinfo.ImageMultimediaDescription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/10/12 17:50
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestRoom {
    /**
     * 房型ID
     */
    @XmlAttribute(name = "Code")
    private String code;
    /**
     * 最多入住人数
     */
    @XmlAttribute(name = "MaxOccupancy")
    private String maxOccupancy;
    /**
     * 房型名称
     */
    @XmlAttribute(name = "RoomTypeName")
    private String roomTypeName;
    /**
     * 房型信息
     */
    @XmlElement(name = "TypeRoom")
    private TypeRoom typeRoom;
    /**
     * 特性列表
     */
    @XmlElementWrapper(name = "Features")
    @XmlElement(name = "Feature")
    private List<Feature> features;
    /**
     * 图片
     */
    @XmlElementWrapper(name = "MultimediaDescriptions")
    @XmlElement(name = "MultimediaDescription")
    private List<ImageMultimediaDescription> imageMultimediaDescriptions;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(String maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<ImageMultimediaDescription> getImageMultimediaDescriptions() {
        return imageMultimediaDescriptions;
    }

    public void setImageMultimediaDescriptions(List<ImageMultimediaDescription> imageMultimediaDescriptions) {
        this.imageMultimediaDescriptions = imageMultimediaDescriptions;
    }
}
