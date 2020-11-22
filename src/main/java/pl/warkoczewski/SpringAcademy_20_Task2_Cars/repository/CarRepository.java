package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;

import java.util.List;

public interface CarRepository {
    void addCar(Car car);
    List<Car> findAll();
    List<Car> findByProductionYear(Integer from, Integer to);
}
