package io.github.matgalv2.numberconverter.validator;


import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.domain.RomanNumeral;
import io.github.matgalv2.numberconverter.dto.Data;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberConstraintsValidator implements ConstraintValidator<NumberConstraints, Data> {


    @Override
    public boolean isValid(Data data, ConstraintValidatorContext context) {
        //TODO: simplify expression
        if (data.getValue() < 0)
            return false;
        else if(data.getType() == ConversionType.ROMAN_NUMERAL && data.getValue() > RomanNumeral.MAXIMAL_NUMBER)
            return false;
        else
            return true;
    }
}
