package pl.warkoczewski.SpringAcademy_20_Task2_Cars.converter;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.fetcher.DataFetcherImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.CurrencyData;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Rates;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataConverterImpl implements DataConverter {
    private final DataFetcherImpl fetchService;

    public DataConverterImpl(DataFetcherImpl fetchService) {
        this.fetchService = fetchService;
    }
    @Override
    public List<Exchange> getExchanges() {
        CurrencyData currencyData = fetchService.fetchData();
        Map<String, Double> currencyMap = convertToMap(currencyData);
        return createList(currencyData, currencyMap);

    }
    private List<Exchange> createList(CurrencyData currencyData, Map<String, Double> currencyMap) {
        List<Exchange> exchanges = new ArrayList<>();
        for(Map.Entry<String, Double> entry : currencyMap.entrySet()){
            exchanges.add(new Exchange(currencyData.getBase(), entry.getKey(), roundRate(entry.getValue()), currencyData.getDate()));
        }
        return exchanges;
    }
    private Double roundRate(Double toRound) {
        return BigDecimal.valueOf(toRound)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    private Map<String, Double> convertToMap(CurrencyData data){
        Map<String, Double> map = new HashMap<>();
        Rates rates = data.getRates();
        map.put("AUD", rates.getAUD());
        map.put("BGN", rates.getBGN());
        map.put("BRL", rates.getBRL());
        map.put("CAD", rates.getCAD());
        map.put("CHF", rates.getCHF());
        map.put("CNY", rates.getCNY());
        map.put("DKK", rates.getDKK());
        map.put("CZK", rates.getCZK());
        map.put("GBP", rates.getGBP());
        map.put("HKD", rates.getHKD());
        map.put("HRK", rates.getHRK());
        map.put("HUF", rates.getHUF());
        map.put("IDR", rates.getIDR());
        map.put("ILS", rates.getILS());
        map.put("INR", rates.getINR());
        map.put("ISK", rates.getISK());
        map.put("JPY", rates.getJPY());
        map.put("KRW", rates.getKRW());
        map.put("MXN", rates.getMXN());
        map.put("MYR", rates.getMYR());
        map.put("NOK", rates.getNOK());
        map.put("NZD", rates.getNZD());
        map.put("PHP", rates.getPHP());
        map.put("PLN", rates.getPLN());
        map.put("RON", rates.getRON());
        map.put("RUB", rates.getRUB());
        map.put("SEK", rates.getSEK());
        map.put("SGD", rates.getSGD());
        map.put("THB", rates.getTHB());
        map.put("TRY", rates.getTRY());
        map.put("USD", rates.getUSD());
        map.put("ZAR", rates.getZAR());
        return map;
    }

}
