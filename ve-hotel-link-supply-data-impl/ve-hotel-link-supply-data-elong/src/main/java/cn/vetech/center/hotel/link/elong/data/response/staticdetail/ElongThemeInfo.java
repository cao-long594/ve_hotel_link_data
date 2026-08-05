package cn.vetech.center.hotel.link.elong.data.response.staticdetail;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotengyu
 * @since  2021/2/5 14:08
 */
public class ElongThemeInfo {

    /***
     *  主题ID
     */
    @JsonProperty("ThemeId")
    private String themeId;
    /***
     *  主题中文名称
     */
    @JsonProperty("ThemeName")
    private String themeName;
    /***
     *  主题英文名称
     */
    @JsonProperty("ThemeNameEn")
    private String themeNameEn;

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeNameEn() {
        return themeNameEn;
    }

    public void setThemeNameEn(String themeNameEn) {
        this.themeNameEn = themeNameEn;
    }
}





