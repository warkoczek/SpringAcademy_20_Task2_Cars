package pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.format.Formatter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Meteo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MeteoMapper {

    public final Meteo convertToMeteo(Weather weather){
            Meteo meteo = new Meteo();
            meteo.setLocation(weather.getLocation().getName());
            meteo.setLocalTime(weather.getLocation().getLocaltime());
            meteo.setObservationTime(weather.getCurrent().getObservationTime());
            meteo.setTemperature(weather.getCurrent().getTemperature());
            meteo.setHumidity(weather.getCurrent().getHumidity());
            meteo.setWindSpeed(weather.getCurrent().getWindSpeed());
            meteo.setPressure(weather.getCurrent().getPressure());
            meteo.setCloudCover(weather.getCurrent().getCloudcover());
         return meteo;
    }


}
