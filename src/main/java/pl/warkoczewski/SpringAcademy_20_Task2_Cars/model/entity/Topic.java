package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "topic")
    private Set<Note> noteSet;
}
