package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.movie;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> showMovies();
    Movie postMovie(MovieDTO movieDTO);
}
