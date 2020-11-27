package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MeteoServiceImpl;


@Controller
@RequestMapping("/meteo")
public class MeteoController {
    private final MeteoServiceImpl weatherService;

    public MeteoController(MeteoServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/home")
    public String home(){
        return "home/home";
    }
    @GetMapping
    public String getMeteo(@RequestParam(defaultValue = "Warsaw") String city, Model model){
        Weather weather = weatherService.showWeather(city);
        model.addAttribute("weather", weather);
        return "/weather/weather";
    }
    @PostMapping()
    public String getMeteoForm(@ModelAttribute(name = "city") String city, Model model){
        Weather weather = weatherService.showWeather(city);
        model.addAttribute("weather", weather);
        return "/weather/weather";
    }
    @GetMapping("/save")
    public String saveMeteo(){
        return "weather/weather";
    }

}
