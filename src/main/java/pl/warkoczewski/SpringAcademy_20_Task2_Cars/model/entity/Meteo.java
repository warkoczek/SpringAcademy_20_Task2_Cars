package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@Entity
@Data
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

}
