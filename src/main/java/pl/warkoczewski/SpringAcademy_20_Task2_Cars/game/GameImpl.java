package pl.warkoczewski.SpringAcademy_20_Task2_Cars.game;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange.ExchangeServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

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

    public boolean isGameWon(Exchange exchange) {
        return exchangeService.showExchanges().stream().anyMatch(exchange1
                -> exchange1.getExchangeCurrency().equalsIgnoreCase(exchange.getExchangeCurrency())
        & exchange1.getExchangeRate().equals(exchange.getExchangeRate()));
    }
}
