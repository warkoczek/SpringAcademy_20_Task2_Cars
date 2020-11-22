package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;


import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepository;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByProductionYear(Integer from, Integer to) {
        return carRepository.findAllByProductionYearBetween(from, to);
    }
    @Override
    public void addCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getMark(), carDTO.getModel(), carDTO.getColor(), carDTO.getProductionYear());
        carRepository.save(car);
    }
}
