package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.food;

public class PlaceQuery {
    private Location location;
    private Long radius;
    private PLACE_TYPE place_type;

    public PlaceQuery() {
    }

    public PlaceQuery(Location location, Long radius, PLACE_TYPE place_type) {
        this.location = location;
        this.radius = radius;
        this.place_type = place_type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
