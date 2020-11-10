package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepositoryImpl;
@Service
public class ValidationServiceImpl implements ValidationService {

    private final CarServiceImpl carService;

    public ValidationServiceImpl(CarServiceImpl carService) {
        this.carService = carService;
    }
    @Override
    public boolean isIdNext(Long id) {
        Long nextId = carService.generateNextId();
        return id.equals(nextId);
    }
}
