package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Method {
    private String name;
    private String sample1;
    private String sample2;
    private String sample3;
    private String sample4;
}
