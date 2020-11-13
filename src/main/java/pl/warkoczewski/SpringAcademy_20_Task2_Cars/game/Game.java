package pl.warkoczewski.SpringAcademy_20_Task2_Cars.game;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;

public interface Game {
    Exchange getRandomExchange();
    boolean isGameWon(Exchange exchange);

}
