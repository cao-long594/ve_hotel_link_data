package cn.vetech.center.hotel.link.api.data.vo;

import java.util.List;

/**
 * @author lipeng on 2019/4/16 14:03
 * 交通信息
 */
public class EtlTransportationInfo {
    /**
     * 类型
     * 1 娱乐
     * 2 机场
     * 3 火车站
     * 4 市中心
     * 5景点
     */
    private String type;
    /**
     * 地点名称
     */
    private String name;
    /**
     * 距离 单位公里
     */
    private String distance;
    /**
     * 到达方式 例如：驾车约3.31公里(约3.0分钟)
     */
    private String directions;
    /**
     * 交通类型
     * 0 驾车
     * 1 步行
     */
    private String transportationType;
    /**
     * 到达花费的时间 单位分钟
     */
    private String timeTaken;
    /**
     *
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

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public List<EtlCoordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<EtlCoordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
