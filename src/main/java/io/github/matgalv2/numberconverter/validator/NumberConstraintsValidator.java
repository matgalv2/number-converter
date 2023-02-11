package io.github.matgalv2.numberconverter.validator;


import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.domain.RomanNumeral;
import io.github.matgalv2.numberconverter.dto.Data;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NumberConstraintsValidator implements ConstraintValidator<NumberConstraints, Data> {

    @Override
    public void initialize(NumberConstraints numberConstraints) {
    }

    @Override
    public boolean isValid(Data data, ConstraintValidatorContext context) {

        boolean lowerThanZero = data.getValue() < 0;
        boolean romanNumeralCase = data.getType() == ConversionType.ROMAN_NUMERAL && data.getValue() > RomanNumeral.MAXIMAL_NUMBER;

        return !(lowerThanZero || romanNumeralCase);
    }
}
