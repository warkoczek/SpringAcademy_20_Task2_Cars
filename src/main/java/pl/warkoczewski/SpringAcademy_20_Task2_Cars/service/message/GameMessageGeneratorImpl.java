package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game.GameServiceImpl;

@Service
public class GameMessageGeneratorImpl implements GameMessageGenerator {
    private final GameServiceImpl gameService;

    public GameMessageGeneratorImpl(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @Override
    public String randomPickMessage() {
        return "Your random pick is: Guess the exchange rate: ";
    }

    @Override
    public String getResultMessage() {
        return null;
    }
}
