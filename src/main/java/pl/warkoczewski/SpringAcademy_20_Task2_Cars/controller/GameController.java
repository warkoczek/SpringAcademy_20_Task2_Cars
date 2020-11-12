package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message.GameMessageGeneratorImpl;

@Controller
public class GameController {
    private final GameMessageGeneratorImpl messageGenerator;

    public GameController(GameMessageGeneratorImpl messageGenerator) {
        this.messageGenerator = messageGenerator;
    }
    @GetMapping("/game/randomPick")
    public String getRandomPick(Model model){
        String randomPickMessage = messageGenerator.randomPickMessage();
        model.addAttribute("randomPick", randomPickMessage);
        return "/currencyGame/randomPick";
    }
}
