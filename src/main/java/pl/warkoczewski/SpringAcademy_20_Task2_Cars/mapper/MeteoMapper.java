package pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Meteo;

import java.time.LocalDateTime;

@Component
public class MeteoMapper {
    public MeteoMapper() {
    }
    public final Converter<Weather, Meteo> convert(){
        Converter<Weather, Meteo> myConverter = context -> {
            Weather weather = context.getSource();
            Meteo meteo = context.getDestination();
            meteo.setLocation(weather.getLocation().getName());
            meteo.setObservationTime(LocalDateTime.parse(weather.getLocation().getLocaltime()));
            meteo.setTemperature(weather.getCurrent().getTemperature());
            meteo.setHumidity(weather.getCurrent().getHumidity());
            meteo.setWindSpeed(weather.getCurrent().getWindSpeed());
            meteo.setPressure(weather.getCurrent().getPressure());
            meteo.setCloudCover(weather.getCurrent().getCloudcover());
            return meteo;
        };
        return myConverter;
    }


}
