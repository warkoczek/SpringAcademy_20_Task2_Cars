package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model;

public class Movie {
    private Long id;
    private String name;
    private String releaseYear;
    private String producer;

    public Movie(String name, String releaseYear, String producer) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.producer = producer;
    }

    public Movie() {
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
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
