package org.example.shopping.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class RoleSubSetValidator implements ConstraintValidator<RoleSubset,Role> {
    private Role[] roles;
    @Override
    public void initialize(RoleSubset constraintAnnotation) {
        this.roles=constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
        return role==null|| Arrays.asList(roles).contains(role);
    }
}
