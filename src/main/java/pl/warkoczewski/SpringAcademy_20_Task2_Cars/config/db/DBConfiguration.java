package pl.warkoczewski.SpringAcademy_20_Task2_Cars.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {
    private DataSource dataSource;
    @Autowired
    public DBConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    public void updateDB(){
        String statement = "CREATE TABLE videos(video_id int, title varchar(255), url varchar(255), PRIMARY KEY(video_id))";
        getJdbcTemplate().update(statement);
    }
}
