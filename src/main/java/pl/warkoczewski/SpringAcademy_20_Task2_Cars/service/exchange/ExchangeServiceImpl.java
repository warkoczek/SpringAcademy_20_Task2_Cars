package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.converter.DataConverterImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange.ExchangeService;

import java.util.List;
@Service
public class ExchangeServiceImpl implements ExchangeService {
    private final DataConverterImpl dataConverter;

    public ExchangeServiceImpl(DataConverterImpl dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public List<Exchange> showExchanges() {

        return dataConverter.getExchanges();
    }
}
