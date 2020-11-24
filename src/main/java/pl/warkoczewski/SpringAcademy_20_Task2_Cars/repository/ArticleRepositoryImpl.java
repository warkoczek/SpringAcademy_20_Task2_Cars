package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client.NewsReader;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.config.DBConfiguration;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;

import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    private final DBConfiguration dbConfiguration;
    private final NewsReader newsReader;
    private final ModelMapper modelMapper;

    public ArticleRepositoryImpl(DBConfiguration dbConfiguration, NewsReader newsReader, ModelMapper modelMapper) {
        this.dbConfiguration = dbConfiguration;
        this.newsReader = newsReader;
        this.modelMapper = modelMapper;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void initDB(){
        dbConfiguration.dropTable();
        dbConfiguration.createTable();
        initArticles();
    }
    void initArticles(){
        newsReader.getNews().forEach(this::addArticle);
    }
    @Override
    public void addArticle(News news) {
        Article article = getArticle(news);
        dbConfiguration.jdbcTemplate().update(getSqlString()
                , article.getTitle(), article.getUrl(), article.getImageUrl()
                , article.getSummary(), article.getPublishedAt());
    }
    private Article getArticle(News news) {
        return modelMapper.map(news, Article.class);
    }
    private String getSqlString() {
        return "INSERT INTO article(title, url, image_url, summary, published_at) values (?,?,?,?,?)";
    }
    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM article";
        dbConfiguration.jdbcTemplate().queryForList(sql).stream();
        return null;
    }



}
