package pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
