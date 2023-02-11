package io.github.matgalv2.numberconverter.validator;


import io.github.matgalv2.numberconverter.domain.RomanNumeral;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NumberConstraintsValidator.class})
public @interface NumberConstraints {
    String message() default "Constraint 1 - field \"value\" has to be non negative. Constraint 2 - roman numerals works only for numbers in range (0, " + RomanNumeral.MAXIMAL_NUMBER + ")";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
