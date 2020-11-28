package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MeteoDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper.MeteoMapper;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.WeatherReaderImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MeteoRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MeteoServiceImpl implements MeteoService {

    private final WeatherReaderImpl weatherReader;
    private final MeteoRepository meteoRepository;
    private final MeteoMapper meteoMapper;
    private final ModelMapper modelMapper;

    public MeteoServiceImpl(WeatherReaderImpl weatherReader
            , MeteoRepository meteoRepository, MeteoMapper meteoMapper, ModelMapper modelMapper) {
        this.weatherReader = weatherReader;
        this.meteoRepository = meteoRepository;
        this.meteoMapper = meteoMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MeteoDTO> getAllRecords() {
        return meteoRepository.findAll().stream().map(meteo -> modelMapper.map(meteo, MeteoDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Scheduled(fixedDelay = 3600000)
    public void save() {
        weatherReader.getWeather().ifPresent(weather1 -> meteoRepository.save(meteoMapper.convertToMeteo(weather1)));
    }

}
