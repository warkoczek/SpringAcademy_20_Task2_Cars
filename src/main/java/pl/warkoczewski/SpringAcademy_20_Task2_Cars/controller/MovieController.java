package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.movie.MovieServiceImpl;

@RestController
public class MovieController {
    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

}
