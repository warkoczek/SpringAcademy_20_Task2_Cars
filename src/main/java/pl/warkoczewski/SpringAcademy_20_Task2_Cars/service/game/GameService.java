package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;

public interface GameService {
    String randomExchangeCurrency();
    boolean isGameWon(String currency, Double guess);
}
