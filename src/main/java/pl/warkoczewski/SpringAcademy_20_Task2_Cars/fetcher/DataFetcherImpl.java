package pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.CurrencyData;
@Service
public class DataFetcherImpl implements DataFetcher {
    @Override
    public CurrencyData fetchData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.ratesapi.io/api/latest?base=PLN", CurrencyData.class);
    }
}
