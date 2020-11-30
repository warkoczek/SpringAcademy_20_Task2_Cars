package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Topic topic;
    @ManyToOne
    private User user;

    public Note(String text, Topic topic, User user) {
        this.text = text;
        this.topic = topic;
        this.user = user;
    }
}
