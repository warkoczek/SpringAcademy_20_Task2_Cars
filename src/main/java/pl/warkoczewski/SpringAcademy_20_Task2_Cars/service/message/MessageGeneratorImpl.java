package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game.GameImpl;

@Service
public class MessageGeneratorImpl implements MessageGenerator {
    private final GameImpl game;

    public MessageGeneratorImpl(GameImpl game) {
        this.game = game;
    }

    @Override
    public String getMainMessage() {
        return "Your random pick is: " + game.getRandomExchange().getExchangeCurrency();
    }

    @Override
    public String getResultMessage() {
        return null;
    }
}
