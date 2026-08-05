package cn.vetech.center.hotel.link.api.data.vo;

import cn.vetech.charge.cloud.modules.utils.mapper.JsonMapper;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;

/**
 * <p>
 * 对应数据库表jd_jbxx
 * </p>
 *
 * @author wangkai
 * @since  2020/10/16
 */

public class HotelInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商酒店基本信息 原始数据
     */
    @ApiModelProperty(value = "酒店系统对房源商 返回Response", dataType = "string")
    protected String hotelInfoResponse;

    /**
     *供应酒店房型信息 原始数据
     */
    @ApiModelProperty(value = "酒店房型 返回Response", dataType = "string")
    protected String hotelRoomTypeResponse;

    /**
     * 酒店编号
     */
    @ApiModelProperty(value = "酒店ID", dataType = "string")
    private String hotelId;

    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称", dataType = "string")
    private String zwmc;
    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称", dataType = "string")
    private String ywmc;
    /**
     * 酒店类型
     * 0 经济型1 快捷酒店2 商务酒店3 主题酒店4 情侣酒店5 公寓6 客栈7 民宿8 青年旅社9 农家院10 家庭旅馆11 招待所12 度假酒店13 别墅
     * "9,10"表示该酒店即是农家院又是家庭旅馆
     * 默认2商务酒店
     */
    @ApiModelProperty(value = "酒店类型", dataType = "string")
    private String jdlx;
    /**
     * 星级
     */
    @ApiModelProperty(value = "星级", dataType = "string")
    private String xj;
    /**
     * 推荐星级
     */
    @ApiModelProperty(value = "推荐星级", dataType = "string")
    private String tjxj;
    /**
     * 推荐星级房源商
     */
    @ApiModelProperty(value = "推荐星级房源商", dataType = "string")
    private String tjxjly;
    /**
     * 这个值给品牌名称
     */
    @ApiModelProperty(value = "品牌", dataType = "string")
    private String pp;
    /**
     * 所在国家
     */
    @ApiModelProperty(value = "所在国家", dataType = "string")
    private String szgjmc;

    /**
     * 所在省份编号
     */
    @ApiModelProperty(value = "所在省份编号", dataType = "string")
    private String szsfcode;
    /**
     * 所在城市编号
     */
    @ApiModelProperty(value = "所在城市编号", dataType = "string")
    private String szcscode;

    /**
     * 所在省份
     */
    @ApiModelProperty(value = "所在省份", dataType = "string")
    private String szsfmc;
    /**
     * 所在城市名称
     */
    @ApiModelProperty(value = "所在城市名称", dataType = "string")
    private Object szcsmc;
    /**
     * 行政区名称
     */
    @ApiModelProperty(value = "行政区名称", dataType = "string")
    private String xzqmc;
    /**
     * 商业圈名称
     */
    @ApiModelProperty(value = "商业圈名称", dataType = "string")
    private String syqmc;
    /**
     * 固定电话
     */
    @ApiModelProperty(value = "固定电话", dataType = "string")
    private String gddh;
    /**
     * 传真号码
     */
    @ApiModelProperty(value = "传真号码", dataType = "string")
    private String czhm;
    /**
     * 开业时间
     */
    @ApiModelProperty(value = "开业时间", dataType = "string")
    private String kysj;
    /**
     * 装修时间
     */
    @ApiModelProperty(value = "装修时间", dataType = "string")
    private String zxsj;
    /**
     * 国内1 国际0类别
     */
    @ApiModelProperty(value = "国内国际类别", dataType = "string")
    private String gngjlb;
    /**
     * 百度经度
     */
    @ApiModelProperty(value = "百度经度", dataType = "string")
    private String bdjd;
    /**
     * 百度纬度
     */
    @ApiModelProperty(value = "百度纬度", dataType = "string")
    private String bdwd;
    /**
     * 谷歌经度
     */
    @ApiModelProperty(value = "谷歌经度", dataType = "string")
    private String ggjd;
    /**
     * 谷歌纬度
     */
    @ApiModelProperty(value = "谷歌纬度", dataType = "string")
    private String ggwd;
    /**
     * 用户投诉率与同城的水平的对比
     */
    @ApiModelProperty(value = "用户投诉率与同城的水平的对比", dataType = "string")
    private String tctsldb;
    /**
     * 预订成功率与同城的水平的对比
     */
    @ApiModelProperty(value = "预订成功率与同城的水平的对比", dataType = "string")
    private String tccgldb;
    /**
     * 及时确认率与同城的水平的对比
     */
    @ApiModelProperty(value = "及时确认率与同城的水平的对比", dataType = "string")
    private String tcqrldb;
    /**
     * 服务总评分与同城的水平的对比
     */
    @ApiModelProperty(value = "服务总评分与同城的水平的对比", dataType = "string")
    private String tczpfdb;
    /**
     * 用户投诉率
     */
    @ApiModelProperty(value = "用户投诉率", dataType = "string")
    private String pftsl;
    /**
     * 预订成功率
     */
    @ApiModelProperty(value = "预订成功率", dataType = "string")
    private String pfcgl;
    /**
     * 及时确认率
     */
    @ApiModelProperty(value = "及时确认率", dataType = "string")
    private String pfqrl;
    /**
     * 酒店服务总评分
     */
    @ApiModelProperty(value = "酒店服务总评分", dataType = "string")
    private String pfzpf;
    /**
     * 酒店品质（针对携程金牌特牌酒店新增字段） 5金牌 6特牌
     */
    @ApiModelProperty(value = "酒店品质", dataType = "string")
    private String jdpz;

    /**
     * 酒店基本信息详情
     */
    @ApiModelProperty(value = "酒店基本信息详情", dataType = "HotelInfoDetailVO")
    private HotelInfoDetailVO hotelInfoDetailVO;


    /**
     * 酒店房型List
     */
    @ApiModelProperty(value = "酒店房型List", dataType = "HotelRoomTypeVO")
    private List<HotelRoomTypeVO> hotelRoomTypeVOList;

    /**
     * 可用状态
     */
    @ApiModelProperty(value = "可用状态 0- 不可用 1-可用(默认)", dataType = "String")
    private String zt = AVAILABLE.getValue();
    /**
     * 酒店映射
     */
    private List<HotelMapping> hotelMappings;
    /**
     * 数据来源，  TASK:定时任务拉取， PUSH:供应商接口上传， HAND:人工上传
     */
    @ApiModelProperty(value = "数据来源", dataType = "string")
    private String dataSources;

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }

    public List<Hotel
   