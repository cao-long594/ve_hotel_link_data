package cn.vetech.center.hotel.link.mtw.data.hoteldetail.response;

import io.swagger.annotations.ApiModelProperty;

/**酒店门店扩展信息。
 * @author xingyanyan on 2018/9/4.
 */
public class MtwPoiExtInfo {

    /**
     * 酒店id
     */
    @ApiModelProperty(value = "酒店id", dataType = "string")
    private Long hotelId;
    /**
     * 开业时间，格式为yyyy/mm或yyyy/mm/dd
     */
    @ApiModelProperty(value = "开业时间，格式为yyyy/mm或yyyy/mm/dd", dataType = "string")
    private String openDate;
    /**
     * 装修时间，格式为yyyy/mm或yyyy/mm/dd
     */
    @ApiModelProperty(value = "装修时间，格式为yyyy/mm或yyyy/mm/dd", dataType = "string")
    private String decorationDate;
    /**
     * 酒店房间总数
     */
    @ApiModelProperty(value = "酒店房间总数", dataType = "string")
    private Integer roomNum;
    /**
     * 酒店楼层高度
     */
    @ApiModelProperty(value = "酒店楼层高度", dataType = "string")
    private Integer floorNum;
    /**
     * 酒店星级：0?国家旅游局颁布五星级证书1?豪华（按五星级标准建造）2?国家旅游局颁布四星级证书3?高档（按四星级标准建造）4?国家旅游局颁布三星级证书5?舒适型（按三星级标准建造）6?经济型
     */
    @ApiModelProperty(value = "酒店星级：0?国家旅游局颁布五星级证书1?豪华（按五星级标准建造）2?国家旅游局颁布四星级证书3?高档（按四星级标准建造）4?国家旅游局颁布三星级证书5?舒适型（按三星级标准建造）6?经济型", dataType = "string")
    private Integer hotelStar;
    /**
     * 酒店类型：0?经济型1?快捷酒店2?商务酒店3?主题酒店4?情侣酒店5?公寓6?客栈7?民宿8?青年旅社9?农家院10?家庭旅馆11?招待所12?度假酒店13?别墅最多可同时包含两项酒店类型，两项间以半角逗号分隔，如"9,10"表示该酒店即是农家院又是家庭旅馆
     */
    @ApiModelProperty(value = "酒店类型：0?经济型1?快捷酒店2?商务酒店3?主题酒店4?情侣酒店5?公寓6?客栈7?民宿8?青年旅社9?农家院10?家庭旅馆11?招待所12?度假酒店13?别墅最多可同时包含两项酒店类型，两项间以半角逗号分隔，如9,10表示该酒店即是农家院又是家庭旅馆", dataType = "string")
    private String poiType;
    /**
     * 酒店主题标签：0?购物便捷1?培训学习2?蜜月出行3?休闲情调4?交通便利5?离医院近6?商旅之家7?四合院8?园林庭院9?安静优雅10?特色建筑11?周边美景12?家有萌宠13?文艺范儿14?观景露台15?古色古香最多可同时包含三项酒店主题标签，各项间以半角逗号分隔，如"9,13,15"表示该酒店安静优雅又有文艺范儿，还古色古香
     */
    @ApiModelProperty(value = "酒店主题标签：0购物便捷1培训学习2蜜月出行3休闲情调4交通便利5离医院近6商旅之家7四合院8园林庭院9安静优雅10特色建筑11周边美景12家有萌宠13文艺范儿14观景露台15如9,13,15表示该酒店安静优雅又有文艺范儿，还古色古香", dataType = "string")
    private String themeTag;
    /**
     * 登记入住开始时间，格式为hh:mm，取值范围为[06:00, 23:30]，半小时为一个取值点，如"06:00"、"06:30"
     */
    @ApiModelProperty(value = "登记入住开始时间，格式为hh:mm，取值范围为[06:00, 23:30]，半小时为一个取值点，如06:00、06:30", dataType = "string")
    private String checkinTimeBegin;
    /**
     * 登记入住截止时间，checkintimeend="0"表示登记入住没有截止时间非0值则格式为hh:mm，取值范围为[14:30, 23:59]，半小时为一个取值点，如"14:30"、"15:00"当天的最后半个小时特殊处理，表示为"23:59"
     */
    @ApiModelProperty(value = "登记入住截止时间，checkintimeend=0表示登记入住没有截止时间非0值则格式为hh:mm，取值范围为[14:30, 23:59]，半小时为一个取值点，如14:30、15:00当天的最后半个小时特殊处理，表示为23:59", dataType = "string")
    private String checkinTimeEnd;
    /**
     * 离店时间，checkouttime="0"表示固定小时制离店，即入住checkouttimehours小时之后离店；非0值则格式为hh:mm，取值范围为[06:00, 23:59]，半小时为一个取值点，如"14:30"、"15:00"当天的最后半个小时特殊处理，表示为"23:59"
     */
    @ApiModelProperty(value = "离店时间，checkouttime0表示固定小时制离店，即入住checkouttimehours小时之后离店；非0值则格式为hh:mm，取值范围为[06:00, 23:59]，半小时为一个取值点，如14:30、15:00当天的最后半个小时特殊处理，表示为23:59", dataType = "string")
    private String checkoutTime;
    /**
     * 当checkouttime="0"时必填，精度为一位小数，如checkouttimehours=6.5表示入住6个半小时后离店
     */
    @ApiModelProperty(value = "当checkouttime=0时必填，精度为一位小数，如checkouttimehours=6.5表示入住6个半小时后离店", dataType = "string")
    private String checkoutTimeHours;

 /**
     * hotelRemind
     */
    private String hotelRemind;

    public String getForeignPolicy() {
        return foreignPolicy;
    }

    public void setForeignPolicy(String foreignPolicy) {
        this.foreignPolicy = foreignPolicy;
    }

    public String getHotelRemind() {
        return hotelRemind;
    }

    public void setHotelRemind(String hotelRemind) {
        this.hotelRemind = hotelRemind;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getDecorationDate() {
        return decorationDate;
    }

    public void setDecorationDate(String decorationDate) {
        this.decorationDate = decorationDate;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(Integer hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getPoiType() {
        return poiType;
    }

    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    public String getThemeTag() {
        return themeTag;
    }
     public void setThemeTag(String themeTag) {
        this.themeTag = themeTag;
    }

    public String getCheckinTimeBegin() {
        return checkinTimeBegin;
    }

    public void setCheckinTimeBegin(String checkinTimeBegin) {
        this.checkinTimeBegin = checkinTimeBegin;
    }

    public String getCheckinTimeEnd() {
        return checkinTimeEnd;
    }

    public void setCheckinTimeEnd(String checkinTimeEnd) {
        this.checkinTimeEnd = checkinTimeEnd;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getCheckoutTimeHours() {
        return checkoutTimeHours;
    }

    public void setCheckoutTimeHours(String checkoutTimeHours) {
        this.checkoutTimeHours = checkoutTimeHours;
    }
}
