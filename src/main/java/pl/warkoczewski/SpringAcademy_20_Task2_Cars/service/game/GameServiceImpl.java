package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.game.GameImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
@Service
public class GameServiceImpl implements GameService {
    private final GameImpl game;

    public GameServiceImpl(GameImpl game) {
        this.game = game;
    }

    @Override
    public Exchange randomExchange() {
        return game.getRandomExchange();
    }

    @Override
    public boolean isGameWon(Exchange exchange) {
        return game.isGameWon(exchange);
    }
}
