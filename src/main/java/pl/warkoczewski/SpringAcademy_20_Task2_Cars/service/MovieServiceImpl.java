package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MovieRepositoryImpl;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepositoryImpl movieRepository;

    public MovieServiceImpl(MovieRepositoryImpl movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> showMovies() {
        return movieRepository.getMovies();
    }

    @Override
    public Movie postMovie(MovieDTO movieDTO) {
        return movieRepository.addMovie(movieDTO);
    }
}
