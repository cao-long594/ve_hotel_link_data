package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 14:35
 */
public class ElongLocationInfo {

    /**
     * 是否有水印
     */
    @JsonProperty("WaterMark")
    private String waterMark;
    /**
     * 图片规格
     */
    @JsonProperty("Size")
    private String size;
    /**
     * 图片地址
     */
    @JsonProperty("Url")
    private String url;

    public String getWaterMark() {
        return waterMark;
    }

    public void setWaterMark(String waterMark) {
        this.waterMark = waterMark;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
