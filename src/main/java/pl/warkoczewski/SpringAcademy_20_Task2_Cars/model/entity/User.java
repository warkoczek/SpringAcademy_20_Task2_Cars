package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import javax.persistence.Id;

public class User {
    @Id
    private String username;
    private String password;
    private String email;

}
