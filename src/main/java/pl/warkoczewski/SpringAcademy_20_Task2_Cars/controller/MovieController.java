package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.movie.MovieServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping(produces = "Application/json")
    public ResponseEntity<List<MovieDTO>> showMovies(){
        return new ResponseEntity<>(movieService.showMovies(), HttpStatus.OK);
    }
    @PostMapping(consumes = "Application/json")
    public ResponseEntity<Movie> addMovie(@RequestBody @Valid MovieDTO movieDTO){
        Movie movie = movieService.postMovie(movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

}
