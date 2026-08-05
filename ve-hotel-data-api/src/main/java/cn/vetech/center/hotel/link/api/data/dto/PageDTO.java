package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 分页基本信息
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class PageDTO {

    /**
     * 其他条件，根据供应商实际情况而定
     */
    @ApiModelProperty(value = "其他条件，根据供应商实际情况而定", dataType = "String")
    private String condition;
    /**
     * 当前多少页 从1开始
     */
    @ApiModelProperty(
            value = "当前多少页 从1开始",
            example = "1",
            dataType = "int"
    )
    private int current = 1;

    public PageDTO() {
    }

    /**
     * 构造函数
     *
     * @param current 当前页码
     */
    public PageDTO(int current) {
        this.current = current;
    }

    /**
     * 构造函数
     *
     * @param condition 分页条件
     * @param current   当前页码
     */
    public PageDTO(String condition, int current) {
        this.condition = condition;
        this.current = current;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
