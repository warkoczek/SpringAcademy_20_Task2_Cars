package pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.email;

public interface EmailService {

    void sendEmail(String to, String subject, String content);
}
