package org.example.shopping.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext cxt) {
        if (phone == null) {
            return false;
        }
        if (phone.length() != 10) {
            return false;
        }
        if(phone.matches("\\d{10}")) return true;
        return true;
    }
}
