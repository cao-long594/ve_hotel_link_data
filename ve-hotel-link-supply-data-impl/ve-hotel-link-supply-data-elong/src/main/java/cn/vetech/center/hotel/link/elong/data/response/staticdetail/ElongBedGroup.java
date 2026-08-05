package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author chengwanshan
 * @since 2025/6/23 10:48
 */
public class ElongBedGroup {
    /**
     * 和分组
     * BedInfos链表的每个元素之间为“和”的关系 参见BedInfo节点
     */
    @JsonProperty("BedInfos")
    private List<ElongBedInfo> bedInfos;

    public List<ElongBedInfo> getBedInfos() {
        return bedInfos;
    }

    public void setBedInfos(List<ElongBedInfo> bedInfos) {
        this.bedInfos = bedInfos;
    }
}

