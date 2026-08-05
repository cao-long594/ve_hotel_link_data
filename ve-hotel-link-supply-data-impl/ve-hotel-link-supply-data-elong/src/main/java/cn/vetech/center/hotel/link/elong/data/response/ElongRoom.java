package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 艺龙房型
 *
 * @author gaojin
 */
@XmlRootElement(name = "Room")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongRoom implements Serializable {
    /**
     * 酒店id
     */
    @XmlTransient
    private String hotelid;
    /**
     * 房型编号
     */
    @XmlAttribute(name = "Id")
    private String id;
    /**
     * 名称
     */
    @XmlAttribute(name = "Name")
    private String name;
    /**
     * 面积
     */
    @XmlAttribute(name = "Area")
    private String area;
    /**
     * 楼层
     */
    @XmlAttribute(name = "Floor")
    private String floor;
    /**
     * 上网情况
     */
    @XmlAttribute(name = "BroadnetAccess")
    private String broadnetaccess;
    /**
     * 0表示免费，1 表示收费
     */
    @XmlAttribute(name = "BroadnetFee")
    private String broadnetfee;
    /**
     * 床型
     */
    @XmlAttribute(name = "BedType")
    private String bedtype;
    /**
     * 包括大床、双床、宽带等一类描述
     */
    @XmlAttribute(name = "Description")
    private String description;
    /**
     * 备注
     */
    @XmlAttribute(name = "Comments")
    private String comments;
    /**
     * 如没有提供请根据房间名称判断：单人间或有单字的为1人，三人间的为3人，其他的默认2人；
     * 7表示6人以上；精确的请参考下方的Facilities
     */
    @XmlAttribute(name = "Capacity")
    private String capacity;
    /**
     * 房间设施。结构化的设施，逗号分隔的数字；具体数字对应的属性请参考Amenities
     */
    @XmlAttribute(name = "Facilities")
    private String facilitie;
    /**
     * 房型数量
     */
    @XmlAttribute(name = "Amount")
    private String amount;

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBroadnetaccess() {
        return broadnetaccess;
    }

    public void setBroadnetaccess(String broadnetaccess) {
        this.broadnetaccess = broadnetaccess;
    }

    public String getBroadnetfee() {
        return broadnetfee;
    }

    public void setBroadnetfee(String broadnetfee) {
        this.broadnetfee = broadnetfee;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFacilitie() {
        return facilitie;
    }

    public void setFacilitie(String facilitie) {
        this.facilitie = facilitie;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
