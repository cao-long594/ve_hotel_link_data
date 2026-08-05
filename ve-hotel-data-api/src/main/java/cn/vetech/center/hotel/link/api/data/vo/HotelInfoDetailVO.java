package cn.vetech.center.hotel.link.api.data.vo;



import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 对应数据库表jd_jbxx_mx
 * </p>
 *
 * @author wangkai
 */
public class HotelInfoDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店id
     */
    @ApiModelProperty(value = "酒店id", dataType = "string")
    private String hotelid;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", dataType = "string")
    private String dz;
    /**
     * 酒店图片，将实体类 JdTp 转为json存储 存图片集合
     */
    @ApiModelProperty(value = "酒店图片 JdTp类json格式字符串", dataType = "string")
    private String zy;
    /**
     * 特别提示
     */
    @ApiModelProperty(value = "特别提示", dataType = "string")
    private String tbts;
    /**
     * 简介
     */
    @ApiModelProperty(value = "简介", dataType = "string")
    private String jj;
    /**
     * 基础设施列表
     */
    @ApiModelProperty(value = "基础设施列表", dataType = "string")
    private String jcsslb;
    /**
     * 房型设施列表
     */
    @ApiModelProperty(value = "房型设施列表", dataType = "string")
    private String fxsslb;
    /**
     * 服务设施列表
     */
    @ApiModelProperty(value = "服务设施列表", dataType = "string")
    private String fwsslb;
    /**
     * 休闲设施列表
     */
    @ApiModelProperty(value = "休闲设施列表", dataType = "string")
    private String xxsslb;
    /**
     * 主题列表
     */
    @ApiModelProperty(value = "主题列表", dataType = "string")
    private String jdztlb;
    /**
     * 周边交通
     */
    @ApiModelProperty(value = "周边交通", dataType = "string")
    private String zbjt;
    /**
     * 扩展字段1
     */
    @ApiModelProperty(value = "扩展字段1", dataType = "string")
    private String ext1;
    /**
     * 扩展字段2
     */
    @ApiModelProperty(value = "扩展字段2", dataType = "string")
    private String ext2;
    /**
     * 扩展字段3
     */
    @ApiModelProperty(value = "扩展字段3", dataType = "string")
    private String ext3;

    /**
     * 扩展字段
     */
    @ApiModelProperty(value = "EtlHotelDetailExt", dataType = "EtlHotelDetailExt")
    private EtlHotelDetailExt detailExt;