package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author xiaotengyu
 * @since  2021/2/8 15:49
 */
public class ElongHotelDetailResult {
    /***
     * 详情
     */
    @JsonProperty("Detail")
    private ElongDetailInfo detail;
    /***
     * 供应商列表
     */
    @JsonProperty("Suppliers")
    private List<ElongSupplierInfo> suppliers;
    /***
     * 房间列表
     */
    @JsonProperty("Rooms")
    private List<ElongRoomInfo> rooms;
    /***
     * 图片列表
     */
    @JsonProperty("Images")
    private List<ElongImageInfo> images;
    /***
     * 点评
     */
    @JsonProperty("Review")
    private ElongReviewInfo review;
    /***
     * 评分
     */
    @JsonProperty("Grade")
    private ElongGradeInfo grade;

    public ElongDetailInfo getDetail() {
        return detail;
    }

    public void setDetail(ElongDetailInfo detail) {
        this.detail = detail;
    }

    public List<ElongSupplierInfo> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<ElongSupplierInfo> suppliers) {
        this.suppliers = suppliers;
    }

    public List<ElongRoomInfo> getRooms() {
        return rooms;
    }

    public void setRooms(List<ElongRoomInfo> rooms) {
        this.rooms = rooms;
    }

    public List<ElongImageInfo> getImages() {
        return images;
    }

    public void setImages(List<ElongImageInfo> images) {
        this.images = images;
    }

    public ElongReviewInfo getReview() {
        return review;
    }

    public void setReview(ElongReviewInfo review) {
        this.review = review;
    }

    public ElongGradeInfo getGrade() {
        return grade;
    }

    public void setGrade(ElongGradeInfo grade) {
        this.grade = grade;
    }
}
