package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper.MeteoMapper;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.WeatherReaderImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MeteoRepository;



@Service
public class MeteoServiceImpl implements MeteoService {

    private final WeatherReaderImpl weatherReader;
    private final MeteoRepository meteoRepository;
    private final MeteoMapper meteoMapper;

    public MeteoServiceImpl(WeatherReaderImpl weatherReader, MeteoRepository meteoRepository, MeteoMapper meteoMapper) {
        this.weatherReader = weatherReader;
        this.meteoRepository = meteoRepository;
        this.meteoMapper = meteoMapper;
    }

    @Override
    public void save() {
        weatherReader.getWeather().ifPresent(weather1 -> meteoRepository.save(meteoMapper.convertToMeteo(weather1)));
    }

}
