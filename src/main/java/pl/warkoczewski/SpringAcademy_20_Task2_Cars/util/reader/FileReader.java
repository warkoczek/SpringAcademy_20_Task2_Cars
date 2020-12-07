package pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.reader;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.entity.User;

import java.util.List;

public interface FileReader {
    List<User> readForSQL(String path);
    List<pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User> readForMongo(String path);
    //List<User> readStream(String path);

}
