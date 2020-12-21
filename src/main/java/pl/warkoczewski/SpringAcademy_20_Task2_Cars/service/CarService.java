package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> showCars();
    Optional<Car> showCarById(Long id);
    List<Car> showCarsByColor(Color color);
    boolean createCar(Car car);
    boolean updateCar(Car car);
    Optional<Car> patchUpdate(Car car);
    boolean deleteCar(Long id);
}
