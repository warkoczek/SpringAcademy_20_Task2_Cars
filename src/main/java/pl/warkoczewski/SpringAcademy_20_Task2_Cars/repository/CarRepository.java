package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    List<Car> findAll();
    Optional<Car> findCarById(Long id);
    List<Car> findCarsByColor(String color);
    boolean addCar(Car car);
    boolean update(Car car);
    Optional<Car> patchUpdate(Long id, String mark, String model, String color);

    boolean removeCar(Long id);
}
