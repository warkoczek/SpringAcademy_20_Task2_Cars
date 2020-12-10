package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception.WeatherDataNotFoundException;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class WeatherAdvisor {
    @ExceptionHandler(WeatherDataNotFoundException.class)
    public String getErrorPage(WeatherDataNotFoundException exception, Model model){
        log.warn("An exception was caught: {}", exception.getMessage(), exception);
        model.addAttribute("exception", exception.getMessage());
        return "errors/error";
    }

}
