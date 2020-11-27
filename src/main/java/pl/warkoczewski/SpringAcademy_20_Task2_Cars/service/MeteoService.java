package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MeteoDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.TimeDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;

public interface MeteoService {
    Weather showWeather(String city);
    void saveMeteo(MeteoDTO meteoDTO);
    void saveTime(TimeDTO timeDTO);
}
