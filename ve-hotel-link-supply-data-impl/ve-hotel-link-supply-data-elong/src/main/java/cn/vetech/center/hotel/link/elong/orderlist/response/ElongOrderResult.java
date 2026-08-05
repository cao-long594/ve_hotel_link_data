package cn.vetech.center.hotel.link.elong.orderlist.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author pengyefei
 * @version 1.0
 * @since 2023/8/30 17:35
 */
public class ElongOrderResult {
    /**
     * 总订单数
     */
    @JsonProperty("Count")
    private int count;
    /**
     * 订单数组
     */
    @JsonProperty("Orders")
    private List<ElongOrder> orders;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ElongOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ElongOrder> orders) {
        this.orders = orders;
    }
}
