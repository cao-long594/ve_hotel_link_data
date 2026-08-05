package cn.vetech.center.hotel.link.api.data.vo;


import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 酒店房型jd_fxxx
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */
public class HotelRoomTypeVO {

    private static final long serialVersionUID = 1L;
    /**
     * 酒店id
     */
    @ApiModelProperty(value = "酒店id", dataType = "string")
    private String hotelid;
    /**
     * 房型编号
     */
    @ApiModelProperty(value = "房型编号", dataType = "string")
    private String fyfxid;
    /**
     * 房型名称
     */
    @ApiModelProperty(value = "房型名称", dataType = "string")
    private String fxmc;
    /**
     * 床型
     */
    @ApiModelProperty(value = "床型", dataType = "string")
    private String cx;
    /**
     * 楼层
     */
    @ApiModelProperty(value = "楼层", dataType = "string")
    private String lc;
    /**
     * 推荐入住人数
     */
    @ApiModelProperty(value = "推荐入住人数", dataType = "string")
    private String tjrzrs;
    /**
     * 面积
     */
    @ApiModelProperty(value = "面积", dataType = "string")
    private String mj;
    /**
     * 房间数量
     */
    @ApiModelProperty(value = "房间数量", dataType = "string")
    private String roomnumber;
    /**
     * 床数
     */
    @ApiModelProperty(value = "床数", dataType = "string")
    private String bednumber;
    /**
     * 房型类型0 大床间（单间）1 单人间（单间）2 双床间（单间）3 三人间（单间）4 套房5 独栋6 床位房没有则为空
     */
    @ApiModelProperty(value = "房间类型", dataType = "string")
    private String roomType;

    /**
     * 酒店房型详情
     */
    @ApiModelProperty(value = "酒店房型详情", dataType = "HotelRoomTypeDetailVO")
    private HotelRoomTypeDetailVO hotelRoomTypeDetailVO;

    public String getBednumber() {
        return bednumber;
    }

    public void setBednumber(String bednumber) {
        this.bednumber = bednumber;
    }

    public String getMj() {
        return mj;
    }

    public void setMj(String