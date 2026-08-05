package cn.vetech.center.hotel.link.api.data.vo;


import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lixuan
 * @since 2017-12-19
 */

public class EtlHotelRoom implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 房源商房型id 必传
     */
    private String fyfxid;
    /**
     * 房型名称
     */
    private String fxmc;
    /**
     * 房型描述
     */
    private String fxms;
    /**
     * 房型设施
     */
    private String fxss;
    /**
     * 床型
     */
    private String cx;
    /**
     * 床型名称
     */
    private String cxmc;
    /**
     * 床型张数
     */
    private Integer cxzs;
    /**
     * 床型尺寸
     */
    private Double cxcc;
    /**
     * 楼层
     */
    private String lc;
    /**
     * 面积
     */
    private String mj;
    /**
     * 预订特别提示
     */
    private String ydtbts;
    /**
     * 推荐入住人数
     */
    private Integer tjrzrs;
    /**
     * 图片
     */
    private String tps;
    /**
     * 允许加床
     */
    private String yxjc;
    /**
     * `
     * 加床数量
     */
    private Integer jcsl;
    /**
     * 加床尺寸
     */
    private Double jccc;
    /**
     * 加床费用
     */
    private Double jcfy;
    /**
     * 宽带
     */
    private String wifi;
    /**
     * 窗户类型
     */
    private String chlx;
    /**
     * 窗户
     */
    private String ch;
    /**
     * 是否无烟
     */
    private String sfwy;
    /**
     * 入住人国籍
     */
    private String rzrgj;
    /**
     * 房间数量
     */
    private Integer fjsl;
    /**
     * 儿童推荐入住人数
     */
    private Integer ettjrzrs;
    /**
     * 儿童最大年龄
     */
    private Integer etzdnl;
    /**
     * 儿童最小年龄
     */
    private Integer etzxnl;
    /**
     * 房型名称格式化，这个字段房源商不用给值，整合这边处理
     */
    private String fxmcfmt;
    /**
     * 床型格式化，这个字段房源商不用给值，整合这边处理
     */
    private String cxfmt;

    public String getFyfxid() {
        return fyfxid;
    }

    public void setFyfxid(String fyfxid) {
        this.fyfxid = fyfxid;
    }

    public String getFxmc() {
        return fxmc;
    }

    public void setFxmc(String fxmc) {
        this.fxmc = fxmc;
    }

    public String getFxms() {
        return fxms;
    }

    public void setFxms(String fxms) {
        this.fxms = fxms;
    }

    public String getFxss() {
        return fxss;
    }

    public void setFxss(String fxss) {
        this.fxss = fxss;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getCxmc() {
        return cxmc;
    }

    public void setCxmc(String cxmc) {
        this.cxmc = cxmc;
    }

    public Integer getCxzs() {
        return cxzs;
    }

    public void setCxzs(Integer cxzs) {
        this.cxzs = cxzs;
    }

    public Double getCxcc() {
        return cxcc;
    }

    public void setCxcc(Double cxcc) {
        this.cxcc = cxcc;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getMj() {
        return mj;
    }

    public void setMj(String mj) {
        this.mj = mj;
    }

    public String getYdtbts() {
        return ydtbts;
    }

    public void setYdtbts(String ydtbts) {
        this.ydtbts = ydtbts;
    }

    public Integer getTjrzrs() {
        return tjrzrs;
    }

    public void setTjrzrs(Integer tjrzrs) {
        this.tjrzrs = tjrzrs;
    }


    public String getYxjc() {
        return yxjc;
    }

    public void setYxjc(String yxjc) {
        this.yxjc = yxjc;
    }

    public Integer getJcsl() {
        return jcsl;
    }

    public void setJcsl(Integer jcsl) {
        this.jcsl = jcsl;
    }

    public Double getJccc() {
        return jccc;
    }

  public void setJccc(Double jccc) {
        this.jccc = jccc;
    }

    public Double getJcfy() {
        return jcfy;
    }

    public void setJcfy(Double jcfy) {
        this.jcfy = jcfy;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getChlx() {
        return chlx;
    }

    public void setChlx(String chlx) {
        this.chlx = chlx;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getSfwy() {
        return sfwy;
    }

    public void setSfwy(String sfwy) {
        this.sfwy = sfwy;
    }

    public String getRzrgj() {
        return rzrgj;
    }

    public void setRzrgj(String rzrgj) {
        this.rzrgj = rzrgj;
    }

    public Integer getFjsl() {
        return fjsl;
    }

    public void setFjsl(Integer fjsl) {
        this.fjsl = fjsl;
    }

    public Integer getEttjrzrs() {
        return ettjrzrs;
    }

    public void setEttjrzrs(Integer ettjrzrs) {
        this.ettjrzrs = ettjrzrs;
    }

    public Integer getEtzdnl() {
        return etzdnl;
    }

    public void setEtzdnl(Integer etzdnl) {
        this.etzdnl = etzdnl;
    }

    public Integer getEtzxnl() {
        return etzxnl;
    }

    public void setEtzxnl(Integer etzxnl) {
        this.etzxnl = etzxnl;
    }

    public String getFxmcfmt() {
        return fxmcfmt;
    }

    public void setFxmcfmt(String fxmcfmt) {
        this.fxmcfmt = fxmcfmt;
    }

    public String getCxfmt() {
        return cxfmt;
    }

    public void setCxfmt(String cxfmt) {
        this.cxfmt = cxfmt;
    }

    public String getTps() {
        return tps;
    }

    public void setTps(String tps) {
        this.tps = tps;
    }


}
