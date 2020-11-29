package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Note> note;

}
