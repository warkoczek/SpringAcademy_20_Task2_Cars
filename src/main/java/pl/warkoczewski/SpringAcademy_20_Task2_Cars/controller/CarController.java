package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.CarServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    //home
    @GetMapping("/home")
    public String getHomePage(){
        return "car/home";
    }

    //get all elements
    @GetMapping
    public String getCars(Model model){
        List<Car> cars = carService.showCars();
        model.addAttribute("cars", cars);
        return "car/cars";
    }
    //get elements by id
    @GetMapping("/search/searchById")
    public String getSearchByIdPage(){
        return "/car/searchById";
    }
    @PostMapping("/search/searchById")
    public String showCarById(@RequestParam(value = "id") Long id, Model model){
        Optional<Car> car = carService.showCarById(id);
        List<Car> cars = new ArrayList<>();
        if(car.isPresent()){
            cars.add(car.get());
            model.addAttribute("cars", cars);
            return "/car/cars";
        }
        return "car/noCar";

    }
    //get elements by color
    @GetMapping("/search/searchByColor")
    public String getSearchByColorPage(Model model){
        model.addAttribute("colorTypes", Color.values());
        return "/car/searchByColor";
    }
    @PostMapping("/search/searchByColor")
    public String getCarsByColor(@ModelAttribute(value = "color") Color color, Model model){
        List<Car> cars = carService.showCarsByColor(color);
        if(!cars.isEmpty()){
            model.addAttribute("cars", cars);
            return "/car/cars";
        }
        return "/car/noCar";
    }
    //add element
    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView modelAndView){
        Long nextId = carService.generateNextId() + 1;
        Color[] colors = Color.values();
        modelAndView.setViewName("car/add");
        modelAndView.addObject("car", new Car());
        modelAndView.addObject("nextId", nextId);
        modelAndView.addObject("colors", colors);
        return modelAndView;
    }
    @PostMapping("/add")
    public String addCar(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "car/add";
        }
        carService.createCar(car);
        return "car/addingSuccess";
    }
    //updateCar and patchUpdate
    @GetMapping("/update/{id}")
    public ModelAndView geUpdatePage(@PathVariable(value = "id") Long id, ModelAndView modelAndView){
        Car car = carService.showCarById(id).orElseThrow();
        modelAndView.setViewName("/car/update");
        modelAndView.addObject("car", car);
        return modelAndView;

    }
    @PostMapping("/update")
    public String updateCar(@ModelAttribute("car") Car car, BindingResult bindingResult){

       if(bindingResult.hasErrors()) {
           return "car/cars";
       }
       carService.patchUpdateCar(car);
       return "car/addingSuccess";
    }
    //delete element
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable(value = "id") Long id, Model model){
        boolean deleted = carService.deleteCar(id);
        if(deleted){
            model.addAttribute("message", "Deleted successfully!");
            return "/car/deleted";
        }
        model.addAttribute("message", "I am sorry, could not delete");
        return "/car/deleted";

    }
}
