package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;

import java.util.List;

public interface CarRepository {
    void addCar(CarDTO carDTO);
    List<Car> findAll();
}
