package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.ArticleDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.ArticleRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepositoryImpl articleRepository;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        showArticles().forEach(System.out::println);
    }
    @Override
    @EventListener(ApplicationReadyEvent.class)
    public List<ArticleDTO> showArticles() {
        return articleRepository.findAll()
                .stream()
                .map(article -> modelMapper.map(article,ArticleDTO.class))
                .collect(Collectors.toList());
    }
}
