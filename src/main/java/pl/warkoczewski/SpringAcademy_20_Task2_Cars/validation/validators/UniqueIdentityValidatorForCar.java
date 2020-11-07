package pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.ValidationService;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.service.ValidationServiceImpl;
import pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.constraint.UniqueIdentity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
@RequiredArgsConstructor
@Scope("prototype")
@Slf4j
public class UniqueIdentityValidatorForCar implements ConstraintValidator<UniqueIdentity, Long> {
    private final ValidationServiceImpl validationService;
    @Override
    public void initialize(UniqueIdentity constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        log.debug("Validating unique id: {}" , id);
        boolean unique = validationService.isIdUnique(id);
        log.debug("Is id {} unique?: {}", id, unique);
        return unique;
    }
}
