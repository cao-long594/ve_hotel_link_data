package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/16 10:11
 * 周边设施类
 */
public class EtlHotelNear {
    /**
     * 设施类型
     * 1 餐饮
     * 2 购物
     * 3 娱乐
     * 201 地铁站
     * 102 景点
     * 104 医院
     */
    private String type;
    /**
     * 名称
     */
    private String name;
    /**
     * 距离
     */
    private String distance;
    /**
     * 坐标提供者
     */
    private List<EtlCoordinate> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<EtlCoordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<EtlCoordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
