package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Topic;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Note;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.NotepadServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.ViewMessage;

import javax.validation.Valid;
import java.util.Optional;

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
    @GetMapping("/notes")
    public String displayNotesPage(Model model){
        model.addAttribute("notes", notepadService.findAll());
        return "notepad/notes";
    }
    @GetMapping("/add")
    public String displayAddNotePage(Model model){
        model.addAttribute("noteDTO", new NoteDTO());
        model.addAttribute("topics", Topic.values());
        return "notepad/add";
    }
    @PostMapping("/add")
    public String processAddingNoteForm(@ModelAttribute(name = "noteDTO") @Valid NoteDTO noteDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "notepad/add";
        }
        notepadService.addNote(noteDTO);
        model.addAttribute("message", ViewMessage.NOTE_ADDED);
        return "notepad/home";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView displayAddNotePage(@PathVariable(name = "id") Long id, ModelAndView modelAndView){
        Optional<Note> note = notepadService.findById(id);
        if(note.isPresent()){
            modelAndView.addObject("noteDTO", note.get());
            modelAndView.addObject("topics", Topic.values());
            modelAndView.setViewName("notepad/edit");
            return modelAndView;
        }
         modelAndView.setViewName("notepad/notes");
        return modelAndView;
    }
    @PostMapping("/edit")
    public String processEditingNoteForm(@ModelAttribute(name = "noteDTO") @Valid NoteDTO noteDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "notepad/notes";
        }
        notepadService.editNote(noteDTO);
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
