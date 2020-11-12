package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game.GameImpl;

@Service
public class GameMessageGeneratorImpl implements GameMessageGenerator {
    private final GameImpl game;

    public GameMessageGeneratorImpl(GameImpl game) {
        this.game = game;
    }

    @Override
    public String randomPickMessage() {
        return "Your random pick is: " + game.getRandomExchange().getExchangeCurrency() + "\n" + "Guess the exchange rate: ";
    }

    @Override
    public String getResultMessage() {
        return null;
    }
}
