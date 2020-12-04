package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;

    public User() {
    }

    public User(String id, String first_name, String last_name, String email, String gender, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
    }
}
