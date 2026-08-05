package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 16:26
 */
public class EtlRangeLimit {
    /**
     * 类型
     * Age:年龄；Height:身高
     */
    private String type;
    /**
     * 起始
     */
    private String start;
    /**
     * 截止
     */
    private String end;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
