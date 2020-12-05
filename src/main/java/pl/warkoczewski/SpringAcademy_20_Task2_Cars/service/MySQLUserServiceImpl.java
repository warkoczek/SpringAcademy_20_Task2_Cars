package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.SQLUserRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader.CSVFileReaderImpl;

import java.util.List;
@Service
public class MySQLUserServiceImpl implements MySQLUserService {
    private final SQLUserRepository sqlUserRepository;
    private final CSVFileReaderImpl csvFileReader;

    public MySQLUserServiceImpl(SQLUserRepository SQLUserRepository, CSVFileReaderImpl csvFileReader) {
        this.sqlUserRepository = SQLUserRepository;
        this.csvFileReader = csvFileReader;
    }

    @Override
    public List<User> addAllUsers(String path) {
        List<User> users = csvFileReader.readForSQL(path);
        return sqlUserRepository.saveAll(users);
    }

    @Override
    public List<User> findAll() {
        return sqlUserRepository.findAll();
    }
}
