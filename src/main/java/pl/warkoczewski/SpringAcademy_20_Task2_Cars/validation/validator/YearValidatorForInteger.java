package pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.validator;

import pl.warkoczewski.SpringAcademy_20_Task2_Cars.validation.Year;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidatorForInteger implements ConstraintValidator<Year, Integer> {
    @Override
    public void initialize(Year constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer productionYear, ConstraintValidatorContext context) {
        if(productionYear > 1879 && productionYear < 2100){
            return true;
        }
        return false;
    }
}
