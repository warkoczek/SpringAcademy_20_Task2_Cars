package pl.warkoczewski.SpringAcademy_20_Task2_Cars.generator;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.game.GameImpl;
@Service
public class MessageGeneratorImpl implements MessageGenerator {
    private final GameImpl game;

    public MessageGeneratorImpl(GameImpl game) {
        this.game = game;
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You won!!! Congratulations!!";
        } else if (game.isGuessedRateBigger()) {
            return "Your guess is greater than the actual rate";
        } else {
            return "Your guess is smaller than the actual rate";
        }

    }
}
