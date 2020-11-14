package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Weather;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    @GetMapping
    public ResponseEntity<Weather> getWeather(@RequestParam(defaultValue = "Warsaw") String city){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl("http://api.weatherstack.com/current")
        .queryParam("accessKey", "816bcfe6f01568d8ca039f7bc58d7547")
                .queryParam("query", city);
        return new ResponseEntity(restTemplate.getForEntity(urlBuilder.toUriString(), Weather.class), HttpStatus.OK);
    }

}
