package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.New;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader.NewsReaderImpl;
@Service
public class NewsServiceImpl implements NewsService {
    private final NewsReaderImpl weatherReader;

    public NewsServiceImpl(NewsReaderImpl weatherReader) {
        this.weatherReader = weatherReader;
    }

    @Override
    public New showWeather(String city) {
        return weatherReader.getWeather(city);
    }
}
