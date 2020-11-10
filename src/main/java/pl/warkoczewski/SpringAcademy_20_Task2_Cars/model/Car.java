package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.constraint.NextId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    @Range(min = 1, max = 10000, message = "Number out of range")
    @NextId(message = "Not a next id! Do not change the default one, please!")
    private Long id;
    @NotBlank
    private String mark;
    @NotBlank
    private String model;
    @NotNull
    private Color color;

    public Car(String mark, String model, Color color) {
        this.mark = mark;
        this.model = model;
        this.color = color;
    }
}
