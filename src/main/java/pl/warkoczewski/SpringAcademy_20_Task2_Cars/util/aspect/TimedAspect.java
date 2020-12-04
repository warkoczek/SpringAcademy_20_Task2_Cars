package pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimedAspect {

    @Around("@annotation(pl.warkoczewski.SpringAcademy_20_Task2_Cars.util.aspect.annotation.Timed)")
    public void measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start = System.currentTimeMillis();
        System.out.println("Started at: " + start);
        joinPoint.proceed();
        Long end = System.currentTimeMillis();
        System.out.println("Ended at: " + start);
        Long executionTime = end - start;
        System.out.println(joinPoint.getSignature() + " executed in: " + executionTime + " ms");

    }

}
