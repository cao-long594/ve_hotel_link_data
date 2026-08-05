package cn.vetech.center.hotel.link.mtw.data.hoteldetail.responsecontent;

import java.util.List;

/**
 * @author xiaotengyu
 * @since 2022-08-18 17:47
 */
public class MtwHotelImage {

    /**
     * 图片的类别，参见《图片类别字典表》
     */
    private String category;

    /**
     * 图片标题。如"客房"、"外观"、"公共设施"、"大厅"、"其他"等
     */
    private String title;

    /**
     * 包含所有可用图片尺寸的URL。 大小包括：500x700
     */
    private List<MtwHotelImageLink> links;

    public java.lang.String getCategory() {
        return category;
    }

    public void setCategory(java.lang.String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MtwHotelImageLink> getLinks() {
        return links;
    }

    public void setLinks(List<MtwHotelImageLink> links) {
        this.links = links;
    }
}
