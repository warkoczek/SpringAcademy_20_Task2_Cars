package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;

public interface GameService {
    Exchange randomExchange();
    boolean isGameWon(Exchange exchange);
}
