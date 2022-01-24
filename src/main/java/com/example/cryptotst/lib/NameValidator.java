package com.example.cryptotst.lib;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {
    private List<String> correctNames = List.of("BTC", "ETH", "XRP");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return correctNames.contains(s);
    }
}
