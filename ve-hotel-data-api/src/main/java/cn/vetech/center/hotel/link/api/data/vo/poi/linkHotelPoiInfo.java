package cn.vetech.center.hotel.link.api.data.vo.poi;

import java.util.List;
import java.util.Map;

/**
 * @author chengwanshan
 * @since 2025/1/8 15:31
 */
public class linkHotelPoiInfo {
    /**
     * id
     */
    private String id;
    /**
     * type
     */
    private String type;
    /**
     * name
     */
    private String name;
    /**
     * nameFull
     */
    private String nameFull;
    /**
     * descriptor
     */
    private String descriptor;
    /**
     * iata_airport_code
     */
    private String iataAirportCode;
    /**
     * iata_airport_code
     */
    private String iataAirportMetroCode;
    /**
     * countryCode
     */
    private String countryCode;
    /**
     * countrySubdivisionCode
     */
    private String countrySubdivisionCode;
    /**
     * coordinates
     */
    private linkHotelPoiCoordinatesInfo coordinates;
    /**
     * associations
     */
    private Map<String, List<String>> associations;
    /**
     * ancestors
     */
    private List<linkHotelPoiAncestorsInfo> ancestors;
    /**
     * descendants
     */
    private Map<String, List<String>> descendants;
    /**
     * propertyIds
     */
    private List<String> propertyIds;
    /**
     * property_ids_expanded
     */
    private List<String> propertyIdsExpanded;
    /**
     * categories
     */
    private List<String> categories;
    /**
     * tags
     */
    private List<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void set