package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    private String mark;
    private String model;
    private String color;
    private String productionYear;
}
