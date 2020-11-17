package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.movie;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.aspect.SendEmailAspect;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.MovieDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Movie;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MovieRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepositoryImpl movieRepository;
    private final ModelMapper modelMapper;

    public MovieServiceImpl(MovieRepositoryImpl movieRepository, ModelMapper modelMapper) {

        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MovieDTO> showMovies() {
        return movieRepository.getMovies().stream().map(movie -> modelMapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    @Override
    @SendEmailAspect
    public Movie postMovie(MovieDTO movieDTO) {
        return movieRepository.addMovie(movieDTO);
    }
}
