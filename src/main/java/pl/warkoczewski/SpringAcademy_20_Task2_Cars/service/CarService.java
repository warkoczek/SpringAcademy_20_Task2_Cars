package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> showCars();
    Long generateNextId();
    Optional<Car> showCarById(Long id);
    List<Car> showCarsByColor(Color color);
    boolean createCar(Car car);
    Car patchUpdateCar(Car car);
    Optional<Car> patchUpdate(Long id, String mark, String model, String color);
    boolean deleteCar(Long id);
}
