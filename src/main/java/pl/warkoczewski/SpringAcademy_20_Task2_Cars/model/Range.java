package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Range {
    @NotNull
    private Integer from;
    @NotNull
    private Integer to;
}
