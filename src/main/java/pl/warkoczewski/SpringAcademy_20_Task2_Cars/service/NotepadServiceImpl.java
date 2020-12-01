package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto.NoteDTO;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Topic;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Note;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.NoteRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotepadServiceImpl implements NotepadService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;

    public NotepadServiceImpl(UserRepository userRepository, NoteRepository noteRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
        this.modelMapper = modelMapper;
    }
    @EventListener(ApplicationReadyEvent.class)
    private void addInitialUsersAndNotes() {
        List<User> users = Arrays.asList(new User("warki", "11w1","warama@gmail.com")
        , new User("czula", "333w", "czula@gmail.com"));
        userRepository.saveAll(users);
        List<Note> notes = Arrays.asList(new Note("Buy your sis a birthday present", Topic.REMINDER, users.get(0))
                , new Note("I am Sagittarius", Topic.HOROSCOPE, users.get(1)));
        noteRepository.saveAll(notes);
    }
    @Override
    public Optional<NoteDTO> findById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if(note.isPresent()){
            modelMapper.map(note.get(), NoteDTO.class);
        }
        return Optional.empty();
    }
    @Override
    public List<NoteDTO> findAll() {
        return noteRepository.findAll().stream()
                .map(note -> modelMapper.map(note, NoteDTO.class)).collect(Collectors.toList());
    }
    @Override
    public void addNote(NoteDTO noteDTO) {
        userRepository.findById(noteDTO.getUsername())
                .ifPresent(value -> noteRepository.save(new Note(noteDTO.getText(), noteDTO.getTopic(), value)));
    }
    @Override
    public Note editNote(NoteDTO noteDTO) {
        noteRepository.deleteById(noteDTO.getId());
        return noteRepository.save(modelMapper.map(noteDTO, Note.class));
    }
}
