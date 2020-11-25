package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDTO {
    private Long article_id;
    private String title;
    private String url;
    private String summary;

}
