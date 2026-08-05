package cn.vetech.center.hotel.link.api.data.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * <p>
 * 静态数据基类
 * </p>
 *
 * @author wangkai
 * @since  2020/10/16
 */
public class HotelBaseDTO {

    /**
     * 房源商编号
     */
    @ApiModelProperty(value = "房源商编号", required = true, dataType = "string")
    private String fybh;

    /**
     * 请求来源平台 cps charge(费控) cloud(差旅云)
     */
    @ApiModelProperty(value = "请求来源平台 cps charge cloud", required = true, dataType = "string")
    private String pt;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号 如CPS", required = true, dataType = "string")
    private String shbh;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "账号名称", required = true, dataType = "string")
    private String zhmc;


    /**
     * 0开启国际报价查询，1开启国内报价查询 2国内国际都支持
     * 1 当调用初始化 和 获取酒店id 和城市id 方法的时候  是从配置中拿到的值
     * 2 当通过城市id 和 酒店id 获取酒店详情的时候 是从 队列中拿到的值
     */
    @ApiModelProperty(value = "0开启国际报价查询，1开启国内报价查询 2国内国际都支持", required = true, dataType = "string")
    private String gngj;

    /**
     * 房源商账号配置信息
     * CPS客户端不需要传入，只需要传入bh
     * LINK客户端需要根据bh实例化，传入给房源商
     */
    @ApiModelProperty(value = "房源商账号配置信息，客户端不需要传入，只需要传入bh。LINK客户端需要根据bh实例化，传入给房源商", dataType = "string")
    private Map<String, String> supplier;

    public String getFybh() {
        return fybh;
    }

    public void setFybh(String fybh) {
        this.fybh = fybh;
    }

    public Map<String, String> getSupplier() {
        return supplier;
    }

    public void setSupplier(Map<String, String> supplier) {
        this.supplier = supplier;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getPt() {
        return pt;
    }

    public String getShbh() {
        return shbh;
    }

    public void setShbh(String shbh) {
        this.shbh = shbh;
    }


    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc;
    }

    public String getGngj() {
        return gngj;
    }

    public void setGngj(String gngj) {
        this.gngj = gngj;
    }
}

        