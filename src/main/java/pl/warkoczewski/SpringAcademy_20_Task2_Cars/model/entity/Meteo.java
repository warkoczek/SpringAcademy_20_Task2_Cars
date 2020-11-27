package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@Entity
public class Meteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meteoId;
    private String location;
    private LocalDateTime localTime;
    private LocalDateTime observationTime;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer windSpeed;
    private Integer cloudCover;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Time> time;

    public Meteo(String location, LocalDateTime localTime, LocalDateTime observationTime, Integer temperature
            , Integer humidity, Integer pressure, Integer windSpeed, Integer cloudCover, List<Time> time) {
        this.location = location;
        this.localTime = localTime;
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.cloudCover = cloudCover;
        this.time = time;
    }

    public Long getMeteoId() {
        return meteoId;
    }

    public void setMeteoId(Long meteoId) {
        this.meteoId = meteoId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDateTime localTime) {
        this.localTime = localTime;
    }

    public LocalDateTime getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(LocalDateTime observationTime) {
        this.observationTime = observationTime;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }
    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    public List<Time> getTime() {
        return time;
    }

    public void setTime(List<Time> time) {
        this.time = time;
    }
}
