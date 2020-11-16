package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getMovies();
    Movie addMovie(MovieDTO movieDTO);
}
