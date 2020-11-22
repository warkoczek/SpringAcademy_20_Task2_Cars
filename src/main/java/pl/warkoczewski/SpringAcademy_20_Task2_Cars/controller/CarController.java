package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    @GetMapping
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars/cars";
    }
    @GetMapping("/add")
    public String getAddPage(Model model){
        model.addAttribute("carDTO", new CarDTO());
        return "cars/add";
    }
    @PostMapping("/add")
    public String getAddingForm(@ModelAttribute(value = "carDto") CarDTO carDTO){
        return "cars/add";
    }
}