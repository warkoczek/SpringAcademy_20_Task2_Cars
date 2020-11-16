package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;

import java.util.*;
@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<Movie> movies;

    public MovieRepositoryImpl() {
        movies = new ArrayList<>();
        initializeMovieList();
    }

    private void initializeMovieList() {
        movies.add(new Movie("Rocky V", "1990", "Irwin Winkler and Robert Chartoff" ));
        movies.add(new Movie("Dirty Dancing", "1987", "Linda Gottlieb" ));
        movies.add(new Movie("Ice Age", "2002", "Lori Forte" ));
        movies.add(new Movie("Apollo 13", "1995", "Brian Grazer" ));
        movies.add(new Movie("Rocky Balboa", "2006", "Charles Winkler" ));
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public Movie addMovie(MovieDTO movieDTO) {
        Long lastId = movies.get(movies.size() - 1).getId();
        Long nextId = lastId + 1;
        Movie newMovie = new Movie();
        newMovie.setId(nextId);
        newMovie.setName(movieDTO.getName());
        newMovie.setReleaseYear(movieDTO.getReleaseYear());
        newMovie.setProducer(movieDTO.getProducer());
        return newMovie;
    }
}
