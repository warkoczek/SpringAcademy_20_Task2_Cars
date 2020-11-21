package pl.warkoczewski.SpringAcademy_20_Task2_Cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private String mark;
    private String model;
    private String productionYear;
}
