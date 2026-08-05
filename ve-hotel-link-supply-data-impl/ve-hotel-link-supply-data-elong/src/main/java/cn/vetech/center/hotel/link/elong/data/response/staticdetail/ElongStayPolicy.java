package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:43
 */
public class ElongStayPolicy {
    /**
     * 安静时间
     */
    @JsonProperty("QuietTime")
    private List<String> quietTime;
    /**
     * 是否允许派对
     */
    @JsonProperty("PartyAllowed")
    private String partyAllowed;
    /**
     * 是否允许拍照
     */
    @JsonProperty("PhotoAllowed")
    private String photoAllowed;

    public List<String> getQuietTime() {
        return quietTime;
    }

    public void setQuietTime(List<String> quietTime) {
        this.quietTime = quietTime;
    }

    public String getPartyAllowed() {
        return partyAllowed;
    }

    public void setPartyAllowed(String partyAllowed) {
        this.partyAllowed = partyAllowed;
    }

    public String getPhotoAllowed() {
        return photoAllowed;
    }

    public void setPhotoAllowed(String photoAllowed) {
        this.photoAllowed = photoAllowed;
    }
}
