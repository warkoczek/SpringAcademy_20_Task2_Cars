package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.mongo;

import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.repository.MongoDBUserRepository;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader.CSVFileReaderImpl;

import java.util.List;
@Service
public class MongoDBServiceImpl implements MongoDBService {
    private final CSVFileReaderImpl csvFileReader;
    private final MongoDBUserRepository mongoDBUserRepository;

    public MongoDBServiceImpl(CSVFileReaderImpl csvFileReader, MongoDBUserRepository mongoDBUserRepository) {
        this.csvFileReader = csvFileReader;
        this.mongoDBUserRepository = mongoDBUserRepository;
    }

    @Override
    public List<User> addAllUsers(String path) {
        return null;
    }
}
