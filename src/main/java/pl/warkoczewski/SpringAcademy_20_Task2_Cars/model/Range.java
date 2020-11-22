package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Range {
    private Integer from;
    private Integer to;
}
