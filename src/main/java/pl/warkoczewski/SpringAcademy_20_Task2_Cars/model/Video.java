package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

public class Video {
    private Long videoId;
    private String title;
    private String url;

    public Video(Long videoId, String title, String url) {
        this.videoId = videoId;
        this.title = title;
        this.url = url;
    }

    public Video() {
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
