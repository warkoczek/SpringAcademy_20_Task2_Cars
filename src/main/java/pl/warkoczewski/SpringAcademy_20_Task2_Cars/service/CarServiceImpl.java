package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepositoryImpl carRepository;

    public CarServiceImpl(CarRepositoryImpl carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> showCars() {
        return carRepository.findAll();
    }

    @Override
    public Long generateNextId() {
        return showCars().stream().map(Car::getId).max(Long::compareTo).orElse(1L);
    }

    public Optional<Car> showCarById(Long id) {
        return carRepository.findCarById(id);
    }

    @Override
    public List<Car> showCarsByColor(Color color) {
        return carRepository.findCarsByColor(color);
    }
    @Override
    public boolean createCar(Car car) {
        return carRepository.addCar(car);
    }

    @Override
    public Car patchUpdateCar(Car car) {
        return carRepository.patchUpdateCar(car);
    }

    @Override
    public Optional<Car> patchUpdate(Long id, String mark, String model, String color) {
        return carRepository.patchUpdate(id, mark, model, color);
    }

    @Override
    public boolean deleteCar(Long id) {
        return carRepository.removeCar(id);
    }
}
