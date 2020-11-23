package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

public interface NewsReader {
    News getNews(String city);
}
