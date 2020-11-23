package pl.warkoczewski.SpringAcademy_20_Task2_Cars.reader;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

import java.util.Arrays;
import java.util.List;

@Service
public class NewsReaderImpl implements NewsReader {
    private final static String BASE_URL = "https://test.spaceflightnewsapi.net/api/v2/articles";
    private final static String LIMIT_PARAM = "_limit";
    private final static String LIMIT_VALUE = "8";
    private final RestTemplate restTemplate;

    public NewsReaderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<News> getNews() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam(LIMIT_PARAM)
                .queryParam(LIMIT_VALUE);
        News[] result = restTemplate.getForObject(builder.toUriString(), News[].class);
        return Arrays.asList(result);
    }
}
