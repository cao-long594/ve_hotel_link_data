package cn.vetech.center.hotel.link.api.data.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

import static cn.vetech.center.hotel.link.api.data.enums.HotelStatusEnum.AVAILABLE;

/***
 * @author xiaotengyu
 * @since 2021/06/02
 */
public class HotelGJInfoVO implements Serializable {


    /**
     * 供应商酒店基本信息 原始数据
     */
    @ApiModelProperty(value = "酒店系统对房源商 返回Response", dataType = "string")
    protected String hotelInfoResponse;

    /**
     * 酒店编号
     */
    private String hotelId;
    /**
     * 酒店中文名称
     */
    private String zwmc;
    /**
     * 酒店英文名称
     */
    private String ywmc;
    /**
     * 星级  数字0,1,2,3,4,5，0表示无  国家旅游局认定星级
     */
    private String xj;
    /**
     * 推荐星级  数字0,1,2,3,4,5，0表示无  供应推荐
     */
    private String tjxj;
    /**
     * 品牌id
     */
    private String pp;
    /**
     * 品牌名称
     */
    private String ppmc;
    /**
     * 酒店中文地址
     */
    private String zwdz;
    /**
     * 酒店英文地址
     */
    private String ywdz;
    /**
     * 所在国家代码
     */
    private String szgj;
    /**
     * 所在国家中文名称
     */
    private String szgjzwmc;
    /**
     * 所在国家英文名称
     */
    private String szgjywmc;
    /**
     * 所在省份代码
     */
    private String szsf;
    /**
     * 所在省份中文名称
     */
    private String szsfzwmc;
    /**
     * 所在省份英文名称
     */
    private String szsfywmc;
    /**
     * 所在城市
     */
    private String szcs;
    /**
     * 所在城市中文名称
     */
    private String szcszwmc;
    /**
     * 所在城市英文名称
     */
    private String szcsywmc;
    /**
     * 商业区ID
     */
    private String syq;
    /**
     * 商业区中文名称
     */
    private String syqzwmc;
    /**
     * 商业区英文名称
     */
    private String syqywmc;
    /**
     * 行政区ID
     */
    private String xzq;
    /**
     * 行政区中文名称
     */
    private String xzqzwmc;
    /**
     * 行政区英文名称
     */
    private String xzqywmc;
    /**
     * 区号-号码，手机号码，区号连着号码，座机-分机，如：027-59599999
     */
    private String gddh;
    /**
     * 传真号码
     */
    private String czhm;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 酒店主图,url，如：http://pavo.elongstatic.com/i/API350_350/f5b08ed938d524efb4aa277fa797d89f.jpg
     */
    private String zy;
    /**
     * 图片列表 json格式
     */
    private String tp;
    /**
     * 开业时间,年-月，如2017-06，2017年6月， 异常： 1900-01，9999-12
     */
    private String kysj;
    /**
     * 装修时间,年-月，如2017-06，2017年6月， 异常： 1900-01，9999-12，处理成无
     */
    private String zxsj;
    /**
     * 特别提示，文字，不能有乱码
     */
    private String tbts;
    /**
     * 酒店简介中文，不能有乱码
     */
    private String zwjj;
    /**
     * 酒店简介英文
     */
    private String ywjj;
    /**
     * 基础设施列表，数字，用英文逗号隔开  废弃解析到详情
     */
    private String jcsslb;
    /**
     * 基础设施名称，用英文逗号隔开  废弃解析到详情
     */
    private String jcssmc;
    /**
     * 房型设施列表，数字，用英文逗号隔开  废弃解析到详情
     */
    private String fxsslb;
    /**
     * 房型设施名称，用英文逗号隔开  废弃解析到详情
     */
    private String fxssmc;
    /**
     * 服务设施列表，数字，用英文逗号隔开  废弃解析到详情
     */
    private String fwsslb;
    /**
     * 服务设施名称，用英文逗号隔开  废弃解析到详情
     */
    private String fwssmc;
    /**
     * 休闲设施列表，数字，用英文逗号隔开  废弃解析到详情
     */
    private String xxsslb;
    /**
     * 休闲设施名称，用英文逗号隔开  废弃解析到详情
     */
    private String xxssmc;
    /**
     * 酒店主题列表，数字，用英文逗号隔开
     */
    private String jdztlb;
    /**
     * 酒店主题名称，用英文逗号隔开
     */
    private String jdztmc;
    /**
     * 百度经度
     */
    private String bdjd;
    /**
     * 百度纬度
     */
    private String bdwd;
    /**
     * 谷歌经度
     */
    private String ggjd;
    /**
     * 谷歌纬度
     */
    private String ggwd;
    /**
     * 可用状态 0- 不可用 1-可用(默认)
     */
    private String status = AVAILABLE.getValue();
    /***
     * 儿童政策中文
     */
    private String etzczw;
    /***
* 儿童政策英文
     */
    private String etzcyw;
    /**
     * 评分, 5分制
     */
    private String ratingAverage;

    /**
     * 国际酒店详情
     */
    private HotelGjInfoDetailVO hotelGjInfoDetailVO;
    /**
     * 房型信息
     */
    private List<HotelGjRoomVO> hotelGjRoomVOS;
    /**
     * 酒店映射
     */
    private List<HotelMapping> hotelMappings;

    public List<HotelMapping> getHotelMappings() {
        return hotelMappings;
    }

    public void setHotelMappings(List<HotelMapping> hotelMappings) {
        this.hotelMappings = hotelMappings;
    }

    public HotelGjInfoDetailVO getHotelGjInfoDetailVO() {
        return hotelGjInfoDetailVO;
    }

    public void setHotelGjInfoDetailVO(HotelGjInfoDetailVO hotelGjInfoDetailVO) {
        this.hotelGjInfoDetailVO = hotelGjInfoDetailVO;
    }

    public List<HotelGjRoomVO> getHotelGjRoomVOS() {
        return hotelGjRoomVOS;
    }

    public void setHotelGjRoomVOS(List<HotelGjRoomVO> hotelGjRoomVOS) {
        this.hotelGjRoomVOS = hotelGjRoomVOS;
    }

    public String getEtzczw() {
        return etzczw;
    }

    public void setEtzczw(String etzczw) {
        this.etzczw = etzczw;
    }

    public String getEtzcyw() {
        return etzcyw;
    }

    public void setEtzcyw(String etzcyw) {
        this.etzcyw = etzcyw;
    }
