package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Range;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.CarServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    @GetMapping("/home")
    public String home(){
        return "cars/home";
    }
    @GetMapping
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars/cars";
    }
    @GetMapping("/search")
    public String getSearchPage(Model model) {
        model.addAttribute("range", new Range());
        return "cars/search";
    }
    @PostMapping("/search")
    public String getSearchingData(@ModelAttribute(name = "range") Range range, Model model){
        List<Car> cars = carService.findByProductionYear(range.getFrom(), range.getTo());
        if(cars.isEmpty()){
            model.addAttribute("message", "No cars");
            return "cars/search";
        }
        model.addAttribute("cars", cars);
        return "cars/cars";
    }
    @GetMapping("/add")
    public String getAddPage(Model model){
        model.addAttribute("carDTO", new CarDTO());
        return "cars/add";
    }
    @PostMapping("/add")
    public String getAddingForm(@ModelAttribute(value = "carDTO") @Valid CarDTO carDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cars/add";
        }
        carService.addCar(carDTO);
        return "redirect:";
    }
}
