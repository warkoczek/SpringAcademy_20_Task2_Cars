package pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
