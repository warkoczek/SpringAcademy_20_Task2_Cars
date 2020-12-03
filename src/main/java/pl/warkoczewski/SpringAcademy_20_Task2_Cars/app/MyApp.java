package pl.warkoczewski.SpringAcademy_20_Task2_Cars.app;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.User;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.UserServiceImpl;

import java.util.List;

@Component
public class MyApp {
    private static final String FILE_PATH = "C:\\Users\\andre\\IdeaProjects\\SpringAcademy_20_Task2_Cars\\src\\main\\resources\\users.csv";
    private final UserServiceImpl userService;

    public MyApp(UserServiceImpl userService) {
        this.userService = userService;
    }
    @EventListener(ApplicationReadyEvent.class)
    public List<User> addUsersToMySQLDB(){
        return userService.addAllUsers(FILE_PATH);
    }
}
