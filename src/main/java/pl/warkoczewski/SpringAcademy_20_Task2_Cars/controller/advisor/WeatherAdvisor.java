package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.WeatherController;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client.WeatherDataController;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception.WeatherDataNotFoundException;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class WeatherAdvisor {
    @ExceptionHandler(WeatherDataNotFoundException.class)
    public ModelAndView getErrorPage(WeatherDataNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView();
        log.warn("An exception was caught: {}", exception.getMessage(), exception);
        modelAndView.setViewName("errors/error");
        modelAndView.addObject("exception", exception.getMessage());
        return modelAndView;
    }

}
