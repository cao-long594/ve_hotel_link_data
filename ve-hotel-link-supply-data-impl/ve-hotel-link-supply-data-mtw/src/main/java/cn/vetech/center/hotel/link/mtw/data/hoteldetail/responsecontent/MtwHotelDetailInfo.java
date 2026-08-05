package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 16:29
 */
public class MtwHotelDetailInfo {

    /**
     * 开业时间，格式为yyyy/MM或yyyy/MM/dd
     */
    private String openDate;
    /**
     * 装修时间，格式为yyyy/MM或yyyy/MM/dd
     */
    private String decorationDate;
    /**
     * 酒店填写的营业时间，无固定格式，可能是12小时制或24小时制
     */
    private String openHours;
    /**
     *
     * 描述信息
     */
    private String description;

    /**
     * 酒店统计信息，包括的统计信息如下：
     * ROOM_COUNT：客房总数
     * FLOOR_COUNT：酒店楼层高度
     * MEETING_ROOM_COUNT：会议室数量
     * RESTAURANT_COUNT：餐厅数量
     */
    private List<MtwHotelTypeValue> statistics;

    /**
     * 酒店评分，目前只有平均评分：
     * AVG_SCORE: 平均评分
     */
    private List<MtwHotelTypeValue> ratings;

    /**
     * 品牌信息
     */
    private MtwHotelCodeName brand;

    /**
     *
     * 集团信息
     */
    private MtwHotelCodeName group;
    /**
     *酒店主题：
     * 0-购物便捷；
     * 1-培训学习；
     * 2-蜜月出行；
     * 3-休闲情调；
     * 4-交通便利；
     * 5-离医院近；
     * 6-商旅之家；
     * 7-四合院；
     * 8-园林庭院；
     * 9-安静优雅；
     * 10-特色建筑；
     * 11-周边美景；
     * 12-家有萌宠；
     * 13-文艺范儿；
     * 14-观景露台；
     * 15-古色古香；
     * 16-亲子酒店；
     * 17-温泉酒店；
     */
    private List<MtwHotelCodeName> themes;

    /**
     * 酒店类型：
     * 1-快捷酒店;
     * 2-商务酒店;
     * 3-主题酒店;
     * 4-情侣酒店;
     * 5-公寓;
     * 6-客栈;
     * 7-民宿;
     * 8-青年旅舍;
     * 9-农家院;
     * 10-家庭旅馆;
     * 11-招待所;
     * 12-度假酒店;
     * 13-别墅;
     * 14-汽车旅馆;
     * 15-小木屋;
     * 16-牧人小屋;
     * 17-山间小屋;
     * 18-船屋;
     * 19-树屋;
     * 20-旅行车停车场;
     * 21-排屋;
     * 22-城堡;
     * 23-帐篷屋;
     * 24-宫殿;
     * 25-观光农业旅游;
     * 26-游轮;
     * 27-日式旅馆;
     */
    private List<MtwHotelCodeName> types;

    /**
    *
     * 酒店星级:
     * 0-国家旅游局颁布五星级证书;
     * 1-豪华（按五星级标准建造）;
     * 2-国家旅游局颁布四星级证书;
     * 3-高档（按四星级标准建造）;
     * 4-国家旅游局颁布三星级证书;
     * 5-舒适型（按三星级标准建造）;
     * 6-经济型;
     * 7-低档;
     * 8-民宿;
     */
    private MtwHotelCodeName star;

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

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MtwHotelTypeValue> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<MtwHotelTypeValue> statistics) {
        this.statistics = statistics;
    }

    public List<MtwHotelTypeValue> getRatings() {
        return ratings;
    }

    public void setRatings(List<MtwHotelTypeValue> ratings) {
        this.ratings = ratings;
    }

    public MtwHotelCodeName getBrand() {
        return brand;
    }

    public void setBrand(MtwHotelCodeName brand) {
        this.brand = brand;
    }

    public MtwHotelCodeName getGroup() {
        return group;
    }

    public void setGroup(MtwHotelCodeName group) {
        this.group = group;
    }

    public List<MtwHotelCodeName> getThemes() {
        return themes;
    }

    public void setThemes(List<MtwHotelCodeName> themes) {
        this.themes = themes;
    }

    public List<MtwHotelCodeName> getTypes() {
        return types;
    }

    public void setTypes(List<MtwHotelCodeName> types) {
        this.types = types;
    }

    public MtwHotelCodeName getStar() {
        return star;
    }

    public void setStar(MtwHotelCodeName star) {
        this.star = star;
    }
}
