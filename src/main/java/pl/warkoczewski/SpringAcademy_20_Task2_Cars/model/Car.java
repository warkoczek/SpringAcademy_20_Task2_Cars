package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private Long id;
    private String mark;
    private String model;
    private String color;

    public Car(String mark, String model, String color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
}
