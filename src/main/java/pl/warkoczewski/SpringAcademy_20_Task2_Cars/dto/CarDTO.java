package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.Year;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    private String mark;
    private String model;
    private String color;
    private Integer productionYear;
}
