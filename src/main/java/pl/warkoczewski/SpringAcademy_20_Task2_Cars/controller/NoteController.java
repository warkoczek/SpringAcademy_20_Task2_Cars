package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;

@Controller
@RequestMapping("/notepad")
public class NoteController {
    @GetMapping
    public String displayHomePage(){
        return "notepad/home";
    }
    @GetMapping("/add")
    public String displayAddNotePage(Model model){
        model.addAttribute("noteDTO", new NoteDTO());
        return "notepad/add";
    }
    @PostMapping("/add")
    public String processAddingNoteForm(){
        return "notepad/add";
    }
    @GetMapping("/open")
    public String displayOpenedNotePage(){
        return "notepad/opened";
    }
    @PostMapping("/open")
    public String processOpenNoteForm(){
        return "notepad/opened";
    }


}
