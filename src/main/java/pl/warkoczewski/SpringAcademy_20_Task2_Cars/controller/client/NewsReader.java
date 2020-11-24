package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception.NewsNotFoundException;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

import java.util.List;
@RestController
public class NewsReader {
    private final static String BASE_URL = "https://test.spaceflightnewsapi.net/api/v2/articles";
    private final static String LIMIT_PARAM = "_limit";
    private final RestTemplate restTemplate;

    public NewsReader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<News> getNews() {
        ParameterizedTypeReference<List<News>> parameterizedTypeReference =
                new ParameterizedTypeReference<>(){};
        ResponseEntity<List<News>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET
                , null, parameterizedTypeReference, LIMIT_PARAM);
        if(responseEntity.hasBody() && responseEntity.getBody() != null){
            return responseEntity.getBody();
        }else{
        throw new NewsNotFoundException("News not found");
        }
        /*UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam(LIMIT_PARAM);
         News[] result = restTemplate.getForObject(builder.toUriString(), News[].class);
        return Arrays.asList(result);*/
    }
}
