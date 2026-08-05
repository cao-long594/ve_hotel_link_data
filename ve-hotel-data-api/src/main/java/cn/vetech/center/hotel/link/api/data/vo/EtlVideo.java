package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/22 10:05
 * @comment
 */
public class EtlVideo {

    /**
     * 酒店视频文件大小，单位bytes
     */
    private String fileSize;
    /**
     * 酒店视频长度
     */
    private String length;
    /**
     * 酒店视频单位，Seconds:秒
     */
    private String unit;
    /**
     * 酒店视频URL
     */
    private String url;
    /**
     * 预览视频URL
     */
    private String previewVideoURL;
    /**
     * 视频缩略图URL
     */
    private String thumbnailPictureURL;

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreviewVideoURL() {
        return previewVideoURL;
    }

    public void setPreviewVideoURL(String previewVideoURL) {
        this.previewVideoURL = previewVideoURL;
    }

    public String getThumbnailPictureURL() {
        return thumbnailPictureURL;
    }

    public void setThumbnailPictureURL(String thumbnailPictureURL) {
        this.thumbnailPictureURL = thumbnailPictureURL;
    }
}
