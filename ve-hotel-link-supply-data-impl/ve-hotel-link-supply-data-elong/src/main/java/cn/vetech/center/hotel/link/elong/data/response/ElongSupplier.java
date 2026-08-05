package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author gaojin
 */
@XmlRootElement(name = "Supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongSupplier implements Serializable {
    /**
     *
     */
    @XmlAttribute(name = "WeekendStart")
    private String weekendStart; // 星期开始设置。用于房价的周末价计算。 为0表示周末设置从周一开始
    /**
     *
     */
    @XmlAttribute(name = "WeekendEnd")
    private String weekendEnd; // 星期结束设置。为0表示到周日结束，但是两个都为0表示无周末设置；
    // 如果开始为3，结束为1，表示从周三到下周1都是周末设置 1代表周一，7代表周日
    /**
     *
     */
    @XmlAttribute(name = "InstantRoomTypes")
    private String instantRoomTypes;    // 即时确认的销售房型。多个房型以逗号分隔
    // 订单是否即时订单还受订单使用库存的影响，最终下单后通过即时接口查询
    /**
     *
     */
    @XmlAttribute(name = "ID")
    private String suppId; // 序号，保留以后使用
    /**
     *
     */
    @XmlAttribute(name = "HotelCode")
    private String hotelCode; // 酒店编码
    /**
     *
     */
    @XmlAttribute(name = "Status")
    private String status; // 有效状态。是否有效；无效的供应商关联的产品和库存不能销售
    /**
     *
     */
    @XmlAttribute(name = "InvokeType")
    private String invokeType; //酒店使用库存和价格的方式为空默认为DATA;DATA： 使用data接口；SEARCH：使用搜索接口。
    /**
     *
     */
    @XmlElement(name = "AvailPolicy")
    private ElongAvailPolicy availPolicy; //特殊政策
    /**
     *
     */
    @XmlElement(name = "HelpfulTips")
    private ElongHelpfulTips helpfulTips; //温馨提示

    public String getWeekendStart() {
        return weekendStart;
    }

    public void setWeekendStart(String weekendStart) {
        this.weekendStart = weekendStart;
    }

    public String getWeekendEnd() {
        return weekendEnd;
    }

    public void setWeekendEnd(String weekendEnd) {
        this.weekendEnd = weekendEnd;
    }

    public String getInstantRoomTypes() {
        return instantRoomTypes;
    }

 public void setInstantRoomTypes(String instantRoomTypes) {
        this.instantRoomTypes = instantRoomTypes;
    }

    public String getSuppId() {
        return suppId;
    }

    public void setSuppId(String suppId) {
        this.suppId = suppId;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType;
    }

    public ElongAvailPolicy getAvailPolicy() {
        return availPolicy;
    }

    public void setAvailPolicy(ElongAvailPolicy availPolicy) {
        this.availPolicy = availPolicy;
    }

    public ElongHelpfulTips getHelpfulTips() {
        return helpfulTips;
    }

    public void setHelpfulTips(ElongHelpfulTips helpfulTips) {
        this.helpfulTips = helpfulTips;
    }
}
