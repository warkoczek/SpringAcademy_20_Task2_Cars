package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private Long id;
    private String mark;
    private String model;
    private Color color;

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
}
