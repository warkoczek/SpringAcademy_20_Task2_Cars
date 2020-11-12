package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;

public interface Game {
    Exchange getRandomExchange();
    Double getGuess();
    boolean isValidInputCurrency();
    boolean isGameWon();
    boolean isGameLost();
}
