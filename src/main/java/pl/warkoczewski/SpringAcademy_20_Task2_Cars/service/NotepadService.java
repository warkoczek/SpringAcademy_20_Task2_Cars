package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NotepadService {
   void addNote(NoteDTO note);
   List<NoteDTO> findAll();

   Optional<Note> findById(Long id);

   Note editNote(NoteDTO noteDTO);
}
