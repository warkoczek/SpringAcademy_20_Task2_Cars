package pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.ImageUrl;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.faceObject.FaceObject;

import java.util.Arrays;

import java.util.Optional;

@Controller
public class FaceDataImpl implements FaceData{
    private final static String  FACE_API_URL = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&returnFaceAttributes=age, gender, smile&recognitionModel=recognition_01&returnRecognitionModel=false&detectionModel=detection_01";
    private final static String IMAGE_URL = "https://scontent-frx5-1.xx.fbcdn.net/v/t31.0-8/883459_10151467534867696_473521144_o.jpg?_nc_cat=105&ccb=2&_nc_sid=2c4854&_nc_ohc=vEAkuK7yntAAX9VYMH3&_nc_ht=scontent-frx5-1.xx&oh=79faf689fd7ef89a1e84cbf5ac750b62&oe=600E6F17";

    @Override
    public Optional<FaceObject> getFaceData(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FaceObject[]> exchange = restTemplate.exchange(FACE_API_URL, HttpMethod.POST
                , getEntity(url), FaceObject[].class);
       //Stream.of(Objects.requireNonNull(exchange.getBody())).collect(Collectors.toList()).forEach(System.out :: println);
       //Stream.ofNullable(exchange.getBody()).collect(Collectors.toList())
        return Arrays.stream(exchange.getBody()).findFirst();

    }

    private HttpEntity<ImageUrl> getEntity(String url) {
        ImageUrl imageURL = new ImageUrl(url);
        HttpHeaders httpHeaders = getHeaders();
        return new HttpEntity<>(imageURL, httpHeaders);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Ocp-Apim-Subscription-Key", "5e78c21143d04dafacee7a5b498b6e8b");
        return httpHeaders;
    }
}
