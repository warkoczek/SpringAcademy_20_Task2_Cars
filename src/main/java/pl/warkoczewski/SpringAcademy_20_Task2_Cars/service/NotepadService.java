package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;

import java.util.List;

public interface NotepadService {
   void addNote(NoteDTO note);
   List<NoteDTO> findAll();
}
