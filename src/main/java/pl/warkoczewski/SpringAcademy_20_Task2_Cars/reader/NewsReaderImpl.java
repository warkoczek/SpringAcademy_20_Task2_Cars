package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.New;

@Service
public class NewsReaderImpl implements NewsReader {
    @Override
    public New getWeather(String city) {
        return null;
    }
}
