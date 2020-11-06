package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.CarServiceImpl;

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
    @GetMapping("/car/{id}")
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
    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody Car car){
        boolean added = carService.createCar(car);
        if(added){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //update element
    @PutMapping("/update")
    public ResponseEntity modifyCar(@RequestBody Car car){
       boolean updated = carService.updateCar(car);
       if(updated) {
           return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    // update some car fields
    @PatchMapping("/patchUpdate/{id}")
    public ResponseEntity<Car> modifyCarPartially(@PathVariable(value = "id") Long id
            , @RequestParam(value = "mark", required = false) String mark
            , @RequestParam(value = "model", required = false) String model
            , @RequestParam(value = "color", required = false) String color){
        Optional<Car> updatedCar = carService.patchUpdate(id, mark, model, color);
        if(updatedCar.isPresent()){
            return new ResponseEntity<>(updatedCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //delete element
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable(value = "id") Long id){
        boolean carDeleted = carService.deleteCar(id);
        if(carDeleted){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
