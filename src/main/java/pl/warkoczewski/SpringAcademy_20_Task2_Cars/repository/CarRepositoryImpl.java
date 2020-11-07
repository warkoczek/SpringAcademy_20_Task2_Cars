package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception.CarNotFoundException;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private List<Car> cars;

    public CarRepositoryImpl() {
        cars = new ArrayList<>();
        cars.add(new Car(1l, "Volkswagen", "Golf", Color.BLACK));
        cars.add(new Car(2l, "Renault", "Clio", Color.SILVER));
        cars.add(new Car(3l, "Fiat", "Panda", Color.RED));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    public Optional<Car> findCarById(Long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public List<Car> findCarsByColor(Color color) {
        return cars.stream().filter(car -> color.equals(car.getColor())).collect(Collectors.toList());
    }
    @Override
    public boolean addCar(Car car) {
        if(car == null){
           return false;
        }
        return cars.add(car);
    }

    @Override
    public boolean updateCar(Car car) {
        Car carToUpdate = cars.stream().filter(car1 -> car1.getId().equals(car.getId())).findFirst().orElse(null);
        if(carToUpdate != null){
            carToUpdate.setId(car.getId());
            carToUpdate.setMark(car.getMark());
            carToUpdate.setModel(car.getModel());
            carToUpdate.setColor(car.getColor());
            cars.add(carToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Car> patchUpdate(Long id, String mark, String model, String color) {
        Optional<Car> updatable = cars.stream().filter(car -> (car.getId().equals(id))).findFirst();
        if(!updatable.isPresent()){
            return Optional.empty();
        }
        if(mark != null){
            updatable.get().setMark(mark);
        }
        if(model != null){
            updatable.get().setModel(model);
        }
        if(color != null){
            updatable.get().setMark(color);
        }
        return updatable;
    }

    @Override
    public boolean removeCar(Long id) {
        Optional<Car> toDelete = cars.stream().filter(car -> car.getId().equals(id)).findFirst();
        if(toDelete.isPresent()){
            cars.remove(toDelete.get());
            return true;
        }
        return false;
    }
}
