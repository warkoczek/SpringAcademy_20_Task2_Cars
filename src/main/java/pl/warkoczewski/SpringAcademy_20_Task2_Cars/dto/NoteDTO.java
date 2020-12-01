package pl.warkoczewski.SpringAcademy_20_Task2_Cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.Topic;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDTO {
    private Long id;
    private String text;
    private Topic topic;
    private String username;


}
