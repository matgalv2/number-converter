package io.github.matgalv2.numberconverter.validator;

import io.github.matgalv2.numberconverter.dto.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static io.github.matgalv2.numberconverter.common.ConversionType.HEXADECIMAL;
import static io.github.matgalv2.numberconverter.common.ConversionType.ROMAN_NUMERAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberConstraintsTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    @DisplayName("Fails with incorrect value (lower than 0)")
    public void invalidValueHex() {

        Data data = new Data(-1, HEXADECIMAL);

        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("Succeeds with correct value (greater or equal to 0)")
    public void correctValueHex() {

        Data data = new Data(16, HEXADECIMAL);

        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        assertEquals(0, violations.size());
    }

    @Test
    @DisplayName("Fails with incorrect value (lower than 0)")
    public void invalidValueRomanLT() {

        Data data = new Data(-1, ROMAN_NUMERAL);

        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("Succeeds with correct value (in range [0,3999])")
    public void correctValueRoman() {

        Data data = new Data(0, ROMAN_NUMERAL);
        Data data2 = new Data(3999, ROMAN_NUMERAL);

        Set<ConstraintViolation<Data>> violations = validator.validate(data);
        violations.addAll(validator.validate(data2));

        assertEquals(0, violations.size());
    }

    @Test
    @DisplayName("Fails with incorrect value (greater than 3999)")
    public void invalidValueRomanGT() {

        Data data = new Data(4000, ROMAN_NUMERAL);

        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        assertEquals(1, violations.size());
    }


}
