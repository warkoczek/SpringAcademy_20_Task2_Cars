package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
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

    public Optional<Car> showCarById(Long id) {
        return carRepository.findCarById(id);

    }

    @Override
    public List<Car> showCarsByColor(String color) {
        return carRepository.findCarsByColor(color);
    }
    @Override
    public boolean createCar(Car car) {
        return carRepository.addCar(car);
    }

    @Override
    public boolean updateColor(Car car) {
        return carRepository.update(car);
    }

    @Override
    public Optional<Car> updateColor(Long id, String color) {
        return carRepository.updateColor(id, color);
    }

    @Override
    public boolean deleteCar(Long id) {
        return carRepository.removeCar(id);
    }
}
