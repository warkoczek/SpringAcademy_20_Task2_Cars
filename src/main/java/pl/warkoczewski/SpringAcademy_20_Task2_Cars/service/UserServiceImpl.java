package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.UserRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader.CSVFileReaderImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CSVFileReaderImpl csvFileReader;

    public UserServiceImpl(UserRepository userRepository, CSVFileReaderImpl csvFileReader) {
        this.userRepository = userRepository;
        this.csvFileReader = csvFileReader;
    }

    @Override
    public List<User> addAllUsers() {
        List<User> users = csvFileReader.read();
        return userRepository.saveAll(users);
    }
}
