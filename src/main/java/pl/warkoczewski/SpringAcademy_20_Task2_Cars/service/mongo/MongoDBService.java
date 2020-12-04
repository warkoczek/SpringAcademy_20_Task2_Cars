package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.mongo;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;

import java.util.List;

public interface MongoDBService {
    List<User> addAllUsers(String path);
}
