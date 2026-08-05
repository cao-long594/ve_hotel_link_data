package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author wangkai
 * @since  2020/10/16
 */
public class HotelRoomTypeDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店编号
     */
    @ApiModelProperty(value = "酒店编号", dataType = "string")
    private String hotelid;
    /**
     * 房型编号
     */
    @ApiModelProperty(value = "房型编号", dataType = "string")
    private String fyfxid;
    /**
     * 房型描述
     */
    @ApiModelProperty(value = "房型描述", dataType = "string")
    private String fxms;
    /**
     * 房型设施
     */
    @ApiModelProperty(value = "房型设施", dataType = "string")
    private String fxss;
    /**
     * 预订特别提示
     */
    @ApiModelProperty(value = "预订特别提示", dataType = "string")
    private String ydtbts;
    /**
     * 房型图片
     */
    @ApiModelProperty(value = "房型图片", dataType = "string")
    private String pic;
    /**
     * 是否允许加床 0不可加床 1可加床
     */
    @ApiModelProperty(value = "是否允许加床 0不可加床 1可加床", dataType = "string")
    private String yxjc;
    /**
     * 加床数量
     */
    @ApiModelProperty(value = "加床数量", dataType = "string")
    private Integer jcsl;
    /**
     * 加床尺寸
     */
    @ApiModelProperty(value = "加床尺寸", dataType = "string")
    private String jccc;
    /**
     * 宽带
     */
    @ApiModelProperty(value = "宽带", dataType = "string")
    private String wifi;
    /**
     * 窗户类型
     */
    @ApiModelProperty(value = "窗户类型", dataType = "string")
    private String chlx;
    /**
     * 窗户 0无窗 1有窗 2部分有窗
     */
    @ApiModelProperty(value = "窗户 0无窗 1有窗 2部分有窗", dataType = "string")
    private String ch;
    /**
     * 是否无烟 0不可 1可吸烟
     */
    @ApiModelProperty(value = "是否无烟 0不可 1可吸烟", dataType = "string")
    private String sfwy;
    /**
     * 入住人国籍
     */
    @ApiModelProperty(value = "入住人国籍", dataType = "string")
    private String rzrgj;