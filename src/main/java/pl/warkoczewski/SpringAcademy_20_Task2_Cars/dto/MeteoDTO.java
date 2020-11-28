package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeteoDTO {

    private String location;
    private String localTime;
    private String observationTime;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private Integer windSpeed;
    private Integer cloudCover;
}
