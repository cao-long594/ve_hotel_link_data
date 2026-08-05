package cn.vetech.center.hotel.link.api.data.vo.poi;

/**
 * @author chengwanshan
 * @since 2025/1/8 15:32
 */
public class linkHotelPoiCoordinatesInfo {
    /**
     * centerLongitude
     */
    private Double centerLongitude;
    /**
     * centerLatitude
     */
    private Double centerLatitude;
    /**
     * boundingPolygon
     */
    private linkHotelPoiBoundingPolygonInfo boundingPolygon;

    public Double getCenterLongitude() {
        return centerLongitude;
    }

    public void setCenterLongitude(Double centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    public Double getCenterLatitude() {
        return centerLatitude;
    }

    public void setCenterLatitude(Double centerLatitude) {
        this.centerLatitude = centerLatitude;
    }

    public linkHotelPoiBoundingPolygonInfo getBoundingPolygon() {
        return boundingPolygon;
    }

    public void setBoundingPolygon(linkHotelPoiBoundingPolygonInfo boundingPolygon) {
        this.boundingPolygon = boundingPolygon;
    }
}
