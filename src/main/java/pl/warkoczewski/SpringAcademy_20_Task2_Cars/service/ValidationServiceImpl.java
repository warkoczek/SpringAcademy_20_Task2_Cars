package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepositoryImpl;
@Service
public class ValidationServiceImpl implements ValidationService {
    private final CarRepositoryImpl carRepository;
    private final CarServiceImpl carService;

    public ValidationServiceImpl(CarRepositoryImpl carRepository, CarServiceImpl carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }
    @Override
    public boolean isIdNext(Long id) {
        Long nextId = carService.generateNextId();
        return id.equals(nextId);
    }
}
