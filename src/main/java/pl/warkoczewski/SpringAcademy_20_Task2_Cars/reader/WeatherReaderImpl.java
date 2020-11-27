package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;

import java.util.Optional;

@Service
public class WeatherReaderImpl implements WeatherReader {
    private final static String CITY = "Bydgoszcz";
    @Override
    public Optional<Weather> getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl("http://api.weatherstack.com/current")
                .queryParam("access_key", "816bcfe6f01568d8ca039f7bc58d7547")
                .queryParam("query", CITY);
        return Optional.ofNullable(restTemplate.getForObject(urlBuilder.toUriString(), Weather.class));
    }
}
