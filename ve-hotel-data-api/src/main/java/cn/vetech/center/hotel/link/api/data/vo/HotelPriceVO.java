package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 对应数据库表jd_jbxx
 * </p>
 *
 * @author wangkai
 * @since 2020/10/16
 */

public class HotelPriceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店编号
     */
    @ApiModelProperty(value = "酒店ID", dataType = "string")
    private String hotelId;

    /**
     * 酒店编号
     */
    @ApiModelProperty(value = "酒店id类型", dataType = "string")
    private String hotelIdType;

    /**
     * 当天日期
     * 格式：2020-12-12
     */
    @ApiModelProperty(value = "当天日期", dataType = "string")
    private String date;
    /**
     * 税后价,-1表示不能销售
     */
    @ApiModelProperty(value = "价格,元为单位,精确小数点后2位", dataType = "double")
    private double price;
    /**
     * 币种 CurrencyEnum
     */
    @ApiModelProperty(value = "币种", dataType = "string")
    private String currencyCode;
    /**
     * 支付类型:0现付 1预付
     */
    @ApiModelProperty(value = "支付类型:0现付 1预付 只能是 HotelPriceEnum中的 PAYMENT_*", dataType = "string")
    private String payment;
    /**
     * 房型名称
     */
    @ApiModelProperty(value = "双床房  房型名称 单人房/双床房/套房/其他  只能是 HotelPriceEnum中的 ROOMNAME_*", dataType = "string")
    private String roomName;
    /**
     * 取消规则类型
     * 不可取消/限时取消/免费取消  参考 SuffixTypeEnum
     */
    @ApiModelProperty(value = "取消规则类型  不可取消/限时取消/免费取消  只能是 HotelPriceEnum中的 CANCEL_* ", dataType = "string")
    private String cancelType;
    /**
     * 活动类型
     * 0 其他
     * 1 早订优惠，
     * 2 多间优惠，
     * 3 连住优惠
     * 4 钟点房
     */
    @ApiModelProperty(value = "活动类型 只能是 HotelPriceEnum中的 ACTIVITY_*", dataType = "string")
    private String activityType;
    /**
     * STATUS_FULL("2","满房"),
     * STATUS_OK("0","可预订"),
     * STATUS_NO("7","不可预订"),
     * STATUS_NOSEE("8","不展示"),
     */
    @ApiModelProperty(value = "房态 只能是 HotelPriceEnum中的 STATUS_*", dataType = "string")
    private String status;
    /**
     * 0无早 1单早 2 双早 3其他
     */
    @ApiModelProperty(value = "早餐 只能是 HotelPriceEnum中的 breakfast_*", dataType = "string")
    private String breakfast;

    /**
     * 开票类型 开票类型    //0：酒店开票；1：服务商开票 INVOICE_HOTEL
     */
    @ApiModelProperty(value = "开票类型 HotelPriceEnum中的 INVOICE_*", dataType = "string")
    private String invoiceModel;