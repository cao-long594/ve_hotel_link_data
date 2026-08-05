package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:19
 */
public class ElongReviewInfo {

    /**
     * 点评总数
     */
    @JsonProperty("ReviewCount")
    private String reviewCount;
    /**
     * 点评好评数
     */
    @JsonProperty("ReviewGoodsCount")
    private String reviewGoodsCount;
    /**
     * 差评数
     */
    @JsonProperty("ReviewPoorCount")
    private String reviewPoorCount;
    /**
     * 评分
     */
    @JsonProperty("ReviewScore")
    private String reviewScore;

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getReviewGoodsCount() {
        return reviewGoodsCount;
    }

    public void setReviewGoodsCount(String reviewGoodsCount) {
        this.reviewGoodsCount = reviewGoodsCount;
    }

    public String getReviewPoorCount() {
        return reviewPoorCount;
    }

    public void setReviewPoorCount(String reviewPoorCount) {
        this.reviewPoorCount = reviewPoorCount;
    }

    public String getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(String reviewScore) {
        this.reviewScore = reviewScore;
    }
}
