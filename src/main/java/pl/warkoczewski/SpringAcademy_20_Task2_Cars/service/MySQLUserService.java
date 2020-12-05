package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;

import java.util.List;

public interface MySQLUserService {
    List<User> addAllUsers(String path);
    List<User> findAll();
}
