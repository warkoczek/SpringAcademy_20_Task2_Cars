package pl.warkoczewski.SpringAcademy_20_Task2_Cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    private final DataSource dataSource;

    public DBConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
    public void dropTable(){
        String drop = "DROP TABLE if exists article";
        jdbcTemplate().update(drop);
    }
    public void createTable(){
        String create = "CREATE TABLE  article(article_id int AUTO_INCREMENT PRIMARY KEY, title varchar(1000)," +
                "url varchar(1000), image_url varchar(1000), summary varchar(10000), published_at varchar(1000) )";
        jdbcTemplate().update(create);
    }

}
