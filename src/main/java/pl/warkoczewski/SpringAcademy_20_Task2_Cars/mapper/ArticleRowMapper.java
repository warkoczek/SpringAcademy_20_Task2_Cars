package pl.warkoczewski.SpringAcademy_20_Task2_Cars.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<ArticleDTO> {
    @Override
    public ArticleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ArticleDTO(rs.getLong("article_id"), rs.getString("title")
                , rs.getString("url"), rs.getString("summary"));
    }
}
