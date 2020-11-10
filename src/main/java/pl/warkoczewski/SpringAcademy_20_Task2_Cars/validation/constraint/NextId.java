package pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.constraint;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.validators.NextIdValidatorForCar;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NextIdValidatorForCar.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NextId {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
