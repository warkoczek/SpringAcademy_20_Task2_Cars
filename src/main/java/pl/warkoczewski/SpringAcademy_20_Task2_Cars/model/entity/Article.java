package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {

    private Long article_id;
    private String title;
    private String url;
    private String image_url;
    private String summary;
    private String published_at;

}
