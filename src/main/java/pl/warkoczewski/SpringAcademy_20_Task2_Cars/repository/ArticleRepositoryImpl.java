package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client.NewsReader;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.config.DBConfiguration;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                , article.getTitle(), article.getUrl(), article.getImage_url()
                , article.getSummary(), article.getPublished_at());
    }
    private Article getArticle(News news) {
        return modelMapper.map(news, Article.class);
    }
    private String getSqlString() {
        return "INSERT INTO article(title, url, image_url, summary, published_at) values (?,?,?,?,?)";
    }
    @Override
    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT * FROM article";
        dbConfiguration.jdbcTemplate().queryForList(sql).forEach(stringObjectMap -> {
            articles.add(createArticle(stringObjectMap));
        });
        return articles;
    }

    private Article createArticle(Map<String, Object> stringObjectMap) {
        return new Article(Long.parseLong(String.valueOf(stringObjectMap.get("article_id"))), String.valueOf(stringObjectMap.get("title"))
                , String.valueOf(stringObjectMap.get("url"))
                , String.valueOf(stringObjectMap.get("image_url")), String.valueOf(stringObjectMap.get("summary"))
                , String.valueOf(stringObjectMap.get("published_at")));
    }


}
