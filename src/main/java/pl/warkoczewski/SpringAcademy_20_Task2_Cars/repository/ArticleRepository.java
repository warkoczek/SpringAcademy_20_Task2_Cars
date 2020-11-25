package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

import java.util.List;

public interface ArticleRepository {
    void addArticle(News news);
    List<ArticleDTO> findAll();
    ArticleDTO findById(Long article_id);
    void update(ArticleDTO articleDTO);


}
