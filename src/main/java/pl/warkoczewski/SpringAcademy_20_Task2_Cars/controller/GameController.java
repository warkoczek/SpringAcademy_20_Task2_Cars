package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Exchange;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.game.GameServiceImpl;

import javax.validation.Valid;
import java.util.Optional;


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
    public String play(Model model){
        Exchange exchange = gameService.randomExchange();
        model.addAttribute("exchange", exchange);
        return "currencyGame/play";
    }
    @PostMapping("/play")
    public String getGuessRateForm(@ModelAttribute(name = "exchange") Exchange exchange, Model model){
        boolean gameWon = gameService.isGameWon(exchange);
        if(gameWon){
            return "/currencyGame/congrats";
        }
        model.addAttribute("message", "Lost! Try again!");
            return "currencyGame/play";

    }

}
