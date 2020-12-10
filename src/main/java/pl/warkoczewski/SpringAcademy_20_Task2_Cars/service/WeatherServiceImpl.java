package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception.WeatherDataNotFoundException;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.WeatherReaderImpl;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherReaderImpl weatherReader;

    public WeatherServiceImpl(WeatherReaderImpl weatherReader) {
        this.weatherReader = weatherReader;
    }

    @Override
    public Weather showWeather(String city) {
        return weatherReader.getWeather(city).orElseThrow(WeatherDataNotFoundException::new);
    }
}
