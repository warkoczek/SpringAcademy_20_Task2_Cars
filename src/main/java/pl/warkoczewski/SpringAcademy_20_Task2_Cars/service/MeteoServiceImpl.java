package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MeteoDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.TimeDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.WeatherReaderImpl;
@Service
public class MeteoServiceImpl implements MeteoService {
    private final WeatherReaderImpl weatherReader;

    public MeteoServiceImpl(WeatherReaderImpl weatherReader) {
        this.weatherReader = weatherReader;
    }

    @Override
    public Weather showWeather(String city) {
        return weatherReader.getWeather(city);
    }

    @Override
    public void saveMeteo(MeteoDTO meteoDTO) {

    }

    @Override
    public void saveTime(TimeDTO timeDTO) {

    }
}
