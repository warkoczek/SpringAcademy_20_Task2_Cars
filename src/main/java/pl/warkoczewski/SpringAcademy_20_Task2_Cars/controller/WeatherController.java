package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.WeatherServiceImpl;

import java.util.Optional;


@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String getWeather(@RequestParam(defaultValue = "Warsaw") String city, Model model){
            model.addAttribute("weather", weatherService.showWeather(city));
        return "/weather/weather";
    }
    @PostMapping()
    public String getWeatherForm(@ModelAttribute(name = "city") String city, Model model){
        model.addAttribute("weather", weatherService.showWeather(city));
        return "/weather/weather";
    }

}
