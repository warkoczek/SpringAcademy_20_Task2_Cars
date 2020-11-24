package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "article_Id")
public class Article {

    private Long article_Id;
    private String title;
    private String url;
    private String imageUrl;
    private String summary;
    private String publishedAt;

    public Article(String title, String url, String imageUrl, String summary, String publishedAt) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.publishedAt = publishedAt;
    }
}
