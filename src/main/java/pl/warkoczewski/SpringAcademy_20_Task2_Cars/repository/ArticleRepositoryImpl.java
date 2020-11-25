package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client.NewsReader;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.config.DBConfiguration;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper.ArticleRowMapper;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<ArticleDTO> findAll() {
        List<ArticleDTO> articles = new ArrayList<>();
        String sql = "SELECT * FROM article";
        dbConfiguration.jdbcTemplate().queryForList(sql).stream().forEach(stringObjectMap -> {
            articles.add(createArticle(stringObjectMap));
        });
        return articles;
    }
    private ArticleDTO createArticle(Map<String, Object> stringObjectMap) {
        return new ArticleDTO(Long.parseLong(String.valueOf(stringObjectMap.get("article_id")))
                , String.valueOf(stringObjectMap.get("title"))
                , String.valueOf(stringObjectMap.get("url"))
                , String.valueOf(stringObjectMap.get("summary")));
    }
    @Override
    public ArticleDTO findById(Long article_id) {
        String sql = "SELECT * FROM article WHERE article_id= ?";
        return dbConfiguration.jdbcTemplate().queryForObject(sql, new ArticleRowMapper(),article_id);
    }
    @Override
    public void update(ArticleDTO articleDTO) {
        String sql = "UPDATE article SET title= ?, summary= ? WHERE article_id= ?";
        dbConfiguration.jdbcTemplate().update(sql, articleDTO.getTitle(), articleDTO.getSummary(), articleDTO.getArticle_id());
    }


}
