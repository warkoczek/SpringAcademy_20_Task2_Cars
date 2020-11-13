package pl.warkoczewski.SpringAcademy_20_Task2_Cars.game;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange.ExchangeServiceImpl;

import java.util.List;
import java.util.Random;
@Service
public class GameImpl implements Game {
    private final ExchangeServiceImpl exchangeService;

    public GameImpl(ExchangeServiceImpl exchangeService) {
        this.exchangeService = exchangeService;
    }

    @Override
    public Exchange getRandomExchange() {
        List<Exchange> exchanges = exchangeService.showExchanges();
        Random random = new Random();
        return exchanges.get(random.nextInt(exchanges.size()));

    }
    @Override
    public boolean isGameWon(Exchange exchange) {
        return exchangeService.showExchanges().stream().anyMatch(exchange1
                -> exchange1.getExchangeRate().equals(exchange.getExchangeRate()));
    }
}
