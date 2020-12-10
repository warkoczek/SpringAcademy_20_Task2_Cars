package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;

import java.util.Optional;

public interface WeatherReader {
   Optional<Weather> getWeather(String city);
}
