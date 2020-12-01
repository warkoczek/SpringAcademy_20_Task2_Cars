package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.NotepadServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.ViewMessage;

@Controller
@RequestMapping("/notepad")
public class NoteController {
    private final NotepadServiceImpl notepadService;

    public NoteController(NotepadServiceImpl notepadService) {
        this.notepadService = notepadService;
    }

    @GetMapping("/home")
    public String displayHomePage(){
        return "notepad/home";
    }
    @GetMapping("/add")
    public String displayAddNotePage(Model model){
        model.addAttribute("noteDTO", new NoteDTO());
        return "notepad/add";
    }
    @PostMapping("/add")
    public String processAddingNoteForm(@ModelAttribute(name = "noteDTO") NoteDTO noteDTO, Model model){
        notepadService.addNote(noteDTO);
        model.addAttribute("message", ViewMessage.NOTE_ADDED);
        return "notepad/home";
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