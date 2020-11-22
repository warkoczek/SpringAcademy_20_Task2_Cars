package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Car;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.CarDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.CarRepository;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CarRepositoryImpl implements CarRepository {
    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        //createCarTable();
        //init();
        //deleteTable();
        findAll().forEach(System.out::println);
    }
    private void createCarTable() {
        String sql = "CREATE TABLE cars(car_id int, mark varchar(255), model varchar(255), color varchar(255), production_year YEAR )";
        jdbcTemplate.update(sql);
    }
    private void init(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1l, "Fiat", "Maluch", "white", 1990));
        cars.add(new Car(2l, "Peugeot", "206", "blue", 1999));
        cars.add(new Car(3l, "Toyota", "Yaris", "black", 2005));
        String sql = "INSERT INTO cars values(?,?,?,?,?)";
        cars.forEach(car -> jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getProductionYear()));
    }
    private void deleteTable(){
        String sql = "DROP TABLE  cars";
        jdbcTemplate.update(sql);
    }

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO cars values(?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getProductionYear());

    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";
        jdbcTemplate.queryForList(sql).forEach(stringObjectMap -> cars.add(
                new Car(Long.parseLong(String.valueOf(stringObjectMap.get("car_id")))
                        , String.valueOf((stringObjectMap.get("mark")))
                        , String.valueOf(stringObjectMap.get("model"))
                        , String.valueOf(stringObjectMap.get("color"))
                        , Integer.parseInt(String.valueOf(stringObjectMap.get("production_year")).substring(0,4))
        )));
        return cars;
    }
}
