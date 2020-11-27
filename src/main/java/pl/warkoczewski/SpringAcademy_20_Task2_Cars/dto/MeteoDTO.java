package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class MeteoDTO {

    private String location;
    private LocalDateTime localTime;
    private LocalDateTime observationTime;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer windSpeed;
    private Integer cloudCover;
}
