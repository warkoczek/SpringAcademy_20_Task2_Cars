package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.config.EmailConfiguration;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailConfiguration emailConfiguration;
    private final JavaMailSenderImpl javaMailSender;

    public EmailServiceImpl(EmailConfiguration emailConfiguration, JavaMailSenderImpl javaMailSender) {
        this.emailConfiguration = emailConfiguration;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendEmail() {
        //create a mail sender
        createJavaMailSender();
    }

    private void createJavaMailSender() {
        javaMailSender.setHost(this.emailConfiguration.getHost());
        javaMailSender.setPort(this.emailConfiguration.getPort());
        javaMailSender.setUsername(this.emailConfiguration.getUsername());
        javaMailSender.setPassword(this.emailConfiguration.getPassword());

        javaMailSender.send(createMessage());
    }

    //create a simple message
    private SimpleMailMessage createMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("waros455@gmail.com");
        simpleMailMessage.setTo("awarkoczewski@yahoo.com");
        simpleMailMessage.setSubject("AddingMovie");
        simpleMailMessage.setText("Your movie was successfully added");
        return simpleMailMessage;
    }
}
