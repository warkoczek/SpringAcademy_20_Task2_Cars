package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game.GameServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message.GameMessageGeneratorImpl;

@Controller
@RequestMapping("/game")
public class GameController {
    private final GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }
    @GetMapping()
    public String gamePage(){
        return "/currencyGame/game";
    }
    @GetMapping("/play")
    public String getRandomPick(Model model){
        String randomPickCurrency = gameService.randomExchangeCurrency();
        model.addAttribute("currency", randomPickCurrency);
        return "/currencyGame/randomPick";
    }
    @PostMapping("/play")
    public String getGuessRateForm(@RequestParam(name = "currency") String currency, @RequestParam(name = "guess") Double guess){
        boolean gameWon = gameService.isGameWon(currency, guess);
        return "/currencyGame/randomPick";
    }

}
