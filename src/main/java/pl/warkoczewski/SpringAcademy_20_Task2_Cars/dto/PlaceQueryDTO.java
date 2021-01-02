package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.food.PLACE_TYPE;

public class PlaceQueryDTO {
    private String lat;
    private String lon;
    private Long radius;
    private PLACE_TYPE place_type;

    public PlaceQueryDTO() {
    }

    public PlaceQueryDTO(String lat, String lon, Long radius, PLACE_TYPE place_type) {
        this.lat = lat;
        this.lon = lon;
        this.radius = radius;
        this.place_type = place_type;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

    public PLACE_TYPE getPlace_type() {
        return place_type;
    }

    public void setPlace_type(PLACE_TYPE place_type) {
        this.place_type = place_type;
    }
}
