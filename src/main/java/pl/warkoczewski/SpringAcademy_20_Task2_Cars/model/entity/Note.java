package pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    private User user;
}
