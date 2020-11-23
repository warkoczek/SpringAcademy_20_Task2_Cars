package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

import java.util.List;

public interface NewsReader {
    List<News> getNews();
}
