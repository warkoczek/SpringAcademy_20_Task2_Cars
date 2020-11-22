package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    void addCar(CarDTO carDTO);

}
