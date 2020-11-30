package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Note;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.Topic;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.NoteRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class NotepadServiceImpl implements NotepadService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public NotepadServiceImpl(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
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

}
