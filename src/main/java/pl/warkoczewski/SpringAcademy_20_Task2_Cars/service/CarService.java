package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> showCars();
    Optional<Car> showCarById(Long id);
    List<Car> showCarsByColor(String color);
    boolean createCar(Car car);
    boolean updateColor(Car car);
    Optional<Car> updateColor(Long id, String color);

    boolean deleteCar(Long id);
}
