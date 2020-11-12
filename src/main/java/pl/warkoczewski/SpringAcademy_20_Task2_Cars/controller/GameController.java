package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.message.MessageGeneratorImpl;

@Controller
public class GameController {
    private final MessageGeneratorImpl messageGenerator;

    public GameController(MessageGeneratorImpl messageGenerator) {
        this.messageGenerator = messageGenerator;
    }
    @GetMapping("/game/randomPick")
    public String getRandomPick(Model model){
        String mainMessage = messageGenerator.getMainMessage();
        return "/currencyGame/pick";
    }
}
