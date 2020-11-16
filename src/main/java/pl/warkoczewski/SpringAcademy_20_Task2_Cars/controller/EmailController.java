package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("email")
public class EmailController {

    @GetMapping
    public String sendEmailForm(){
        return "email/emailForm";
    }
    @PostMapping
    public String processEmailForm(){

        return "email/emailForm";
    }
}
