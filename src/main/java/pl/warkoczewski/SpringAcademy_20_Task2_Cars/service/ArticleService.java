package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> showArticles();
    ArticleDTO findById(Long article_id);
    void update(ArticleDTO articleDTO);
}
