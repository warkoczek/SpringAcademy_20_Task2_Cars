package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Note> noteSet;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
