package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game;

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
    public Double getGuess() {
        return null;
    }

    @Override
    public boolean isValidInputCurrency() {
        return false;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public boolean isGameLost() {
        return false;
    }
}
