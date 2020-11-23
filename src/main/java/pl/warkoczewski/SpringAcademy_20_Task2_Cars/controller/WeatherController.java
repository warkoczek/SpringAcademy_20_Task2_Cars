package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.NewsServiceImpl;


@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final NewsServiceImpl weatherService;

    public WeatherController(NewsServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String getWeather(@RequestParam(defaultValue = "Warsaw") String city, Model model){
        Weather weather = weatherService.showWeather(city);
        model.addAttribute("weather", weather);
        return "/weather/weather";
    }
    @PostMapping()
    public String getWeatherForm(@ModelAttribute(name = "city") String city, Model model){
        Weather weather = weatherService.showWeather(city);
        model.addAttribute("weather", weather);
        return "/weather/weather";
    }

}
