package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author chengwanshan
 * @since 2025/9/1 16:30
 */
public class ElongRangeLimit {
    /**
     * 起始值
     */
    @JsonProperty("Start")
    private String start;
    /**
     * 截止值
     */
    @JsonProperty("End")
    private String end;
    /**
     * 类型
     * Age：年龄；Height：身高
     */
    @JsonProperty("Type")
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
