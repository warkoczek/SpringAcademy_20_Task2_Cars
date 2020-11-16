package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

public class MovieDTO {
    private String name;
    private String releaseYear;
    private String producer;

    public MovieDTO(String name, String releaseYear, String producer) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.producer = producer;
    }

    public MovieDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
