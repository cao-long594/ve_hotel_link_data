package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 15:36
 */
public class ElongNotices {
    /**
     * 分类
     * Hotel:酒店维度 City:城市维度
     */
    @JsonProperty("Category")
    private String category;
    /**
     * 开始日期
     */
    @JsonProperty("Start")
    private String start;
    /**
     * 结束日期
     */
    @JsonProperty("End")
    private String end;
    /**
     * 中文文本
     */
    @JsonProperty("Text")
    private String text;
    /**
     * 英文文本
     */
    @JsonProperty("TextEn")
    private String textEn;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }
}
