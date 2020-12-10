package pl.warkoczewski.SpringAcademy_20_Task2_Cars.exception;

public class WeatherDataNotFoundException extends RuntimeException {
    public WeatherDataNotFoundException() {
        super("I am sorry, data could not be found");
    }
}
