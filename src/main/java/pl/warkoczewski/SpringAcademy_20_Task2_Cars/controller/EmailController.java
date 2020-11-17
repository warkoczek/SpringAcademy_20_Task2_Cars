package pl.warkoczewski.SpringAcademy_20_Task2_Cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("email")
public class EmailController {
    /*
    @Autowired
    private JavaMailSender javaMailSender;*/

    @GetMapping
    public String sendEmailForm(){
        return "email/emailForm";
    }
    /*
    @PostMapping
    public String processEmailForm(HttpServletRequest request){
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("andresik82@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
        return "email/emailForm";
    }*/
}
