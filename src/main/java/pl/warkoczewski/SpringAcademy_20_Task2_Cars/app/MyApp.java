package pl.warkoczewski.SpringAcademy_20_Task2_Cars.app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MongoDBServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.UserServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.aspect.annotation.Timed;

import java.util.List;

@Component
public class MyApp {
    private static final String FILE_PATH = "C:\\Users\\andre\\IdeaProjects\\SpringAcademy_20_Task2_Cars\\src\\main\\resources\\users.csv";
    private final UserServiceImpl userService;
    private final MongoDBServiceImpl mongoDBService;

    public MyApp(UserServiceImpl userService, MongoDBServiceImpl mongoDBService) {
        this.userService = userService;
        this.mongoDBService = mongoDBService;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Timed
    public List<User> addUsersToMySQLDB(){
        return userService.addAllUsers(FILE_PATH);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Timed
    public List<pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.document.User> addUsersToMongoDB(){
        return mongoDBService.addAllUsers(FILE_PATH);
    }
}
