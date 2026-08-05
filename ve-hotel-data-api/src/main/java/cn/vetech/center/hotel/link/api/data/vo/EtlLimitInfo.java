package cn.vetech.center.hotel.link.api.data.vo;

/**
 * @author lipeng on 2019/4/17 16:44
 * @comment
 */
public class EtlLimitInfo {
    /**
     * 类型
     * Age:年龄；Height:身高
     */
    private String type;
    /**
     * 最小值
     */
    private String min;
    /**
     * 最大值
     */
    private String max;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
