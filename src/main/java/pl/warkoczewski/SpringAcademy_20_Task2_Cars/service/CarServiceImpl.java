package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> findByProductionYear(Integer from, Integer to) {
        return carRepository.findAllByProductionYearBetween(from, to)
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public void addCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getMark(), carDTO.getModel(), Color.valueOf(carDTO.getColor()), carDTO.getProductionYear());
        carRepository.save(car);
    }
}
