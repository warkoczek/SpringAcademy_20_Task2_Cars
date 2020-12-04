package pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimedAspect {

    @Before("@annotation(Timed)")
    public void helloTimed() throws Throwable{
        System.out.println("Hello");
    }

}
