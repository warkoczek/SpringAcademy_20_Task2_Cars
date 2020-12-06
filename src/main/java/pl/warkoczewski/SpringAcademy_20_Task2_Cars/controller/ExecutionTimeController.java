package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MongoDBServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MySQLUserServiceImpl;

@Controller
public class ExecutionTimeController {
    private final MySQLUserServiceImpl mySQLUserService;
    private final MongoDBServiceImpl mongoDBService;

    public ExecutionTimeController(MySQLUserServiceImpl mySQLUserService, MongoDBServiceImpl mongoDBService) {
        this.mySQLUserService = mySQLUserService;
        this.mongoDBService = mongoDBService;
    }

    @GetMapping("/executionTime")
    public String displayExecutionTimePage(){
        return "executionTime";
    }
}
