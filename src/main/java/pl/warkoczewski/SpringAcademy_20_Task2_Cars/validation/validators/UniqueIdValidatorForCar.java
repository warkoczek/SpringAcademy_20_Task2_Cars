package pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.ValidationServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.constraint.NextId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@RequiredArgsConstructor
@Scope("prototype")
@Slf4j
public class UniqueIdValidatorForCar implements ConstraintValidator<NextId, Long> {
    private final ValidationServiceImpl validationService;
    @Override
    public void initialize(NextId constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        log.debug("Validating next id: {}" , id);
        boolean next = validationService.isIdNext(id);
        log.debug("Is id {} next?: {}", id, next);
        return next;
    }
}
