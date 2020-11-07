package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Range(min = 1, max = 10000, message = "Number out of range")
    private Long id;
    @NotBlank
    private String mark;
    @NotBlank
    private String model;
    @NotBlank
    private Color color;

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
}
