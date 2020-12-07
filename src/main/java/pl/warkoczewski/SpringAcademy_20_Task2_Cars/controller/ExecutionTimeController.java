package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MethodService;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MongoDBServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.MySQLUserServiceImpl;

@Controller
public class ExecutionTimeController {
    private final MySQLUserServiceImpl mySQLUserService;
    private final MongoDBServiceImpl mongoDBService;
    private final MethodService methodService;

    public ExecutionTimeController(MySQLUserServiceImpl mySQLUserService, MongoDBServiceImpl mongoDBService, MethodService methodService) {
        this.mySQLUserService = mySQLUserService;
        this.mongoDBService = mongoDBService;
        this.methodService = methodService;
    }

    @GetMapping("/executionTime")
    public String displayExecutionTimePage(Model model){
        model.addAttribute("methods", methodService.getMethods());
        return "executionTime";
    }

}
