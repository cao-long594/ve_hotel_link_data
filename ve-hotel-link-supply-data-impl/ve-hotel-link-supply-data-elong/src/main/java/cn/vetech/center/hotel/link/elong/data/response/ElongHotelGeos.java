package cn.vetech.center.hotel.link.elong.data.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * <p>
 * 酒店所有Geo
 * </p>
 * @author wangkai
 * @since 2020/10/23
 */
@XmlRootElement(name = "HotelGeos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElongHotelGeos {
    /**
     * 国家
     */
    @XmlElementWrapper(name = "HotelGeoList")
    @XmlElement(name = "HotelGeo")
    private List<ElongHotelGeo> elongHotelGeo;


    public List<ElongHotelGeo> getElongHotelGeo() {
        return elongHotelGeo;
    }

    public void setElongHotelGeo(List<ElongHotelGeo> elongHotelGeo) {
        this.elongHotelGeo = elongHotelGeo;
    }
}
