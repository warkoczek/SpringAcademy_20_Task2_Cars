package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private String mark;
    private String model;
    private String color;
    private int productionYear;
}
