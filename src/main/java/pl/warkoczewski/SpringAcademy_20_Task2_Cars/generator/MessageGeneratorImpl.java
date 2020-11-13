package pl.warkoczewski.SpringAcademy_20_Task2_Cars.generator;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.game.GameImpl;
@Service
public class MessageGeneratorImpl implements MessageGenerator {
    private final GameImpl game;

    public MessageGeneratorImpl(GameImpl game) {
        this.game = game;
    }

}
