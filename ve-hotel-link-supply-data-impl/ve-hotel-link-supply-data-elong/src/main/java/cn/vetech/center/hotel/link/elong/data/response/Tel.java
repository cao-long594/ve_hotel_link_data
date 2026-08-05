package cn.vetech.center.hotel.link.elong.data.response;

/**
 * @author xiaotengyu
 * @since 2021/4/7 14:26
 */
public class Tel {
    /***
         * 	国家码	Y
      */
    private String nationCode;
    /***
     * 	区域码   Y
      */
    private String areaCode;
    /***
     * 	 主机号	N
      */
    private String mainCode;
    /***
     * 分机号	Y
      */
    private String extCode;
    /***
     *  类型 1:座机 2:手机号 N
      */
    private String type;

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getExtCode() {
        return extCode;
    }

    public void setExtCode(String extCode) {
        this.extCode = extCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
