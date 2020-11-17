package pl.warkoczewski.SpringAcademy_20_Task2_Cars.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.email.EmailServiceImpl;
@Aspect
@Component
public class EmailAspect {
    private final EmailServiceImpl emailService;
    public EmailAspect(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }
    @After("@annotation(SendEmailAspect)")
    public void sendEmailAfterPostingMovie(){
        emailService.sendEmail();
    }
}
