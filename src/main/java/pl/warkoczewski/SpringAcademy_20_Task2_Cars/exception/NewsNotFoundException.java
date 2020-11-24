package pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.model.News;

import java.util.List;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(String message) {
        super(message);
    }
}
