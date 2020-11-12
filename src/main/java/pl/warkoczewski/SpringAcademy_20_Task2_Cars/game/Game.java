package pl.warkoczewski.SpringAcademy_20_Task2_Cars.game;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;

public interface Game {
    Exchange getRandomExchange();
    boolean isValidInputCurrency();
    boolean isGameWon(String currency, Double guess);

}
