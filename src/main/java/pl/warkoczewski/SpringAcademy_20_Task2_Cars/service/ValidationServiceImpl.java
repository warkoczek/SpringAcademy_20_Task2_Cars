package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepositoryImpl;
@Service
public class ValidationServiceImpl implements ValidationService {
    private final CarRepositoryImpl carRepository;

    public ValidationServiceImpl(CarRepositoryImpl carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean isIdUnique(Long id) {
        return carRepository.findAll().stream().noneMatch(car -> car.getId().equals(id));
    }
}
