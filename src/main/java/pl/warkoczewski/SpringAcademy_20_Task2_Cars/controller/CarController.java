package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
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
    @GetMapping("/productionYear")
    public String showCarsByProductionYear(@RequestParam(name = "min") Integer min
            , @RequestParam(name = "max") Integer max, Model model){
        List<Car> byProductionYear = carService.findByProductionYear(min, max);
        model.addAttribute("cars", byProductionYear);
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
