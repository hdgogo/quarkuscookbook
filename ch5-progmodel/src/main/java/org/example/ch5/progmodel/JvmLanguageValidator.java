package org.example.ch5.progmodel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class JvmLanguageValidator implements ConstraintValidator<JvmLanguage, String> {
    private List<String> favoriteLanguages = Arrays.asList("java");
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return favoriteLanguages.stream().anyMatch(l -> l.equalsIgnoreCase(value));
    }
}
