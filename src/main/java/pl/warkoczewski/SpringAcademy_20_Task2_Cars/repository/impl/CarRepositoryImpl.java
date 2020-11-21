package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarRepositoryImpl implements CarRepository {
    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private void createCarTable() {
        String sql = "CREATE TABLE cars(car_id int, model varchar(255), mark varchar(255), production_year varchar(255))";
        jdbcTemplate.update(sql);

    }
    private void init(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1l, "Fiat", "Maluch", "1990"));
        cars.add(new Car(2l, "Peugeot", "206", "1999"));
        cars.add(new Car(3l, "Toyota", "Yaris", "2005"));
        String sql = "INSERT INTO cars values(?,?,?,?)";
        cars.forEach(car -> jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getProductionYear()));
    }

    @Override
    public void addCar(CarDTO carDTO) {
        Long nextId = findAll().get(findAll().size()-1).getId() +1;
        Car car = new Car(nextId, carDTO.getMark(), carDTO.getModel(), carDTO.getProductionYear());
        String sql = "INSERT INTO cars values(?,?,?,?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getProductionYear());

    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        jdbcTemplate.queryForList(sql).forEach(stringObjectMap -> cars.add(
                new Car(Long.parseLong(String.valueOf(stringObjectMap.get("car_id")))
                        , String.valueOf((stringObjectMap.get("mark")))
                        , String.valueOf(stringObjectMap.get("model"))
                        , String.valueOf(stringObjectMap.get("production_year"))
        )));
        return cars;
    }
}
