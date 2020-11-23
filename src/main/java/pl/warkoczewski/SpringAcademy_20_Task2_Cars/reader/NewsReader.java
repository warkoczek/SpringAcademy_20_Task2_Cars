package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.New;

public interface NewsReader {
    New getWeather(String city);
}
