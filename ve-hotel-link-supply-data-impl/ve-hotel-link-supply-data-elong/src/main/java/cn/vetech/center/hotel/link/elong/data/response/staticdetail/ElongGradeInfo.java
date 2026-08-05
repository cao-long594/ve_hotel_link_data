package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 11:20
 */
public class ElongGradeInfo {

    /***
     * 订单30分钟内确认率
     */
    @JsonProperty("ConfirmRateOf30Minute")
    private String confirmRateOf30Minute;
    /***
     * 分销过去90天产量得分
     */
    @JsonProperty("GradeOfOrderCountB90")
    private String gradeOfOrderCountB90;
    /***
     * C端过去90天产量得分
     */
    @JsonProperty("GradeOfOrderCountC90")
    private String gradeOfOrderCountC90;
    /***
     * 产品过去30天可卖得分
     */
    @JsonProperty("GradeOfProd30")
    private String gradeOfProd30;
    /***
     * 分销过去90天可定成功率
     */
    @JsonProperty("ValRateOf90")
    private String valRateOf90;

    public String getConfirmRateOf30Minute() {
        return confirmRateOf30Minute;
    }

    public void setConfirmRateOf30Minute(String confirmRateOf30Minute) {
        this.confirmRateOf30Minute = confirmRateOf30Minute;
    }

    public String getGradeOfOrderCountB90() {
        return gradeOfOrderCountB90;
    }

    public void setGradeOfOrderCountB90(String gradeOfOrderCountB90) {
        this.gradeOfOrderCountB90 = gradeOfOrderCountB90;
    }

    public String getGradeOfOrderCountC90() {
        return gradeOfOrderCountC90;
    }

    public void setGradeOfOrderCountC90(String gradeOfOrderCountC90) {
        this.gradeOfOrderCountC90 = gradeOfOrderCountC90;
    }

    public String getGradeOfProd30() {
        return gradeOfProd30;
    }

    public void setGradeOfProd30(String gradeOfProd30) {
        this.gradeOfProd30 = gradeOfProd30;
    }

    public String getValRateOf90() {
        return valRateOf90;
    }

    public void setValRateOf90(String valRateOf90) {
        this.valRateOf90 = valRateOf90;
    }
}
