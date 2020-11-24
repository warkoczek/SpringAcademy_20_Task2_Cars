package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;

import java.util.List;

public interface ArticleRepository {
    void addArticle(News news);
    List<Article> findAll();




}
