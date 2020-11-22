package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    @Enumerated(value = EnumType.STRING)
    private Color color;
    private Integer productionYear;

    public Car() {
    }
    public Car(String mark, String model, Color color, Integer productionYear){
        this.mark=mark;
        this.model=model;
        this.color=color;
        this.productionYear=productionYear;
    }
}
