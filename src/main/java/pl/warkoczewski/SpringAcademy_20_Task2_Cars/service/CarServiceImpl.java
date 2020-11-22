package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;


import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.impl.CarRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepositoryImpl carRepository;

    public CarServiceImpl(CarRepositoryImpl carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByProductionYear(Integer from, Integer to) {
        return carRepository.findByProductionYear(from, to);
    }



    @Override
    public void addCar(CarDTO carDTO) {
        Long nextId = findAll().get(findAll().size()-1).getId() +1;
        Car car = new Car(nextId, carDTO.getMark(), carDTO.getModel(), carDTO.getColor(), carDTO.getProductionYear());
        carRepository.addCar(car);
    }
}
