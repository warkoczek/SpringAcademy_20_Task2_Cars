package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MeteoDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper.MeteoMapper;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Meteo;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.WeatherReaderImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MeteoRepository;


@Service
public class MeteoServiceImpl implements MeteoService {

    private final WeatherReaderImpl weatherReader;
    private final MeteoRepository meteoRepository;
    private final ModelMapper modelMapper;

    public MeteoServiceImpl(WeatherReaderImpl weatherReader, MeteoRepository meteoRepository, ModelMapper modelMapper) {
        this.weatherReader = weatherReader;
        this.meteoRepository = meteoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Meteo showWeather(String city) {
        return weatherReader.getWeather(city);
    }

    @Override
    public void save() {
        Weather weather = weatherReader.getWeather()
        meteoRepository.save(meteo);
    }

}
