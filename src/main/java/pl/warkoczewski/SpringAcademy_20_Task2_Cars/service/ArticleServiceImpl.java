package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.ArticleRepositoryImpl;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepositoryImpl articleRepository;

    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article showArticle() {
        return articleRepository.getArticle();
    }
}
