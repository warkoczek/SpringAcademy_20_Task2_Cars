package pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.ImageUrl;

@Controller
public class FaceDataImpl {
    private final static String  FACE_API_URL = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=age, gender, smile&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01";

    @EventListener(ApplicationReadyEvent.class)
    public void getFaceFeatures(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange(FACE_API_URL, HttpMethod.POST, getEntity(url), String.class);
        System.out.println(exchange.getBody());
    }

    private HttpEntity<ImageUrl> getEntity(String url) {
        ImageUrl imageURL = new ImageUrl(url);
        HttpHeaders httpHeaders = getHeaders();
        return new HttpEntity(imageURL, httpHeaders);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Ocp-Apim-Subscription-Key", "5e78c21143d04dafacee7a5b498b6e8b");
        return httpHeaders;
    }
}
