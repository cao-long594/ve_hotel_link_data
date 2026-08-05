package cn.vetech.center.hotel.link.supply.service.distribute.init;

import java.io.Serializable;

/**
 * 初始化时控制并发的对象
 *
 * @author houya
 */
public class HotelDataInitVO implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 访问时间
     */
    private String accessTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 耗时
     */
    private Integer consum;
    /**
     * 状态  0 未开始 1 正在执行  2 执行完成
     */
    private String status;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getConsum() {
        return consum;
    }

    public void setConsum(Integer consum) {
        this.consum = consum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }
}
