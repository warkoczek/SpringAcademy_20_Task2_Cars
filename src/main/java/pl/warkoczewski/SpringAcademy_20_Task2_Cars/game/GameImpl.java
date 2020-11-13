package pl.warkoczewski.SpringAcademy_20_Task2_Cars.game;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.exchange.ExchangeServiceImpl;

import java.util.List;
import java.util.Random;
@Service
public class GameImpl implements Game {
    private final ExchangeServiceImpl exchangeService;
    @Getter
    private Exchange exchange;

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
    public boolean isGameWon() {
        return exchangeService.showExchanges().stream().anyMatch(exchange1
                -> exchange1.getExchangeRate().equals(exchange.getExchangeRate()));
    }

    @Override
    public boolean isGuessedRateBigger() {
        return exchangeService.showExchanges().stream().filter(exchange1
                -> exchange1.getExchangeCurrency().equalsIgnoreCase(exchange.getExchangeCurrency())).findFirst().orElseThrow()
                .getExchangeRate() < exchange.getExchangeRate();
    }
    @Override
    public boolean isGuessedRateSmaller() {
        return exchangeService.showExchanges().stream().filter(exchange1
                -> exchange1.getExchangeCurrency().equalsIgnoreCase(exchange.getExchangeCurrency())).findFirst().orElseThrow()
                .getExchangeRate() > exchange.getExchangeRate();
    }

    public void setGuess(Exchange exchange) {
        this.exchange=exchange;
    }
}
