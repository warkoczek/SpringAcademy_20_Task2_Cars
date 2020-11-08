package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.CarServiceImpl;

import javax.validation.Valid;
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
    @GetMapping("/search")
    public String getSearchPage(){
        return "/car/search";
    }
    @PostMapping("/search")
    public ModelAndView showCarById(@RequestParam(value = "id") Long id, ModelAndView modelAndView){
        Optional<Car> car = carService.showCarById(id);
        if(car.isPresent()){
            modelAndView.addObject("car", car.get());
            modelAndView.setViewName("car/car");
            return modelAndView;
        }
         modelAndView.setViewName("car/noCar");
        return modelAndView;

    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long id){
        Optional<Car> car = carService.showCarById(id);
        if(car.isPresent()){
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //get elements by color
    @GetMapping("/color")
    public ResponseEntity<List<Car>> getCarsByColor(@RequestParam(value = "color") Color color){
        List<Car> cars = carService.showCarsByColor(color);
        if(!cars.isEmpty()){
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //add element
    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView modelAndView){
        modelAndView.setViewName("car/add");
        modelAndView.addObject("car", new Car());
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
    //update element and patchUpdate
    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable(value = "id") Long id, ModelAndView modelAndView){
        Car car = carService.showCarById(id).orElse(null);
        modelAndView.setViewName("/car/update");
        modelAndView.addObject("car", car);
        return modelAndView;

    }
    @PostMapping("/update")
    public String updateCar(@ModelAttribute("car")  Car car, BindingResult bindingResult){

       if(bindingResult.hasErrors()) {
           return "car/add";
       }
       carService.updateCar(car);
       return "car/addingSuccess";
    }
    //delete element
    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable(value = "id") Long id){
        carService.deleteCar(id);
         return "/car/deleted";
    }
}
