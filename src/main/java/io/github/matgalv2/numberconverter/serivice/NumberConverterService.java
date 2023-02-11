package io.github.matgalv2.numberconverter.serivice;


import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.domain.AbstractNumber;
import io.github.matgalv2.numberconverter.domain.HexadecimalNumber;
import io.github.matgalv2.numberconverter.domain.RomanNumeral;
import io.github.matgalv2.numberconverter.dto.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NumberConverterService {


    public Optional<? extends AbstractNumber> convertNumber(Data data) {

        if (data.getType().equals(ConversionType.HEXADECIMAL))
            return HexadecimalNumber.of(data.getValue());
        else
            return RomanNumeral.of(data.getValue());
    }

//    private Optional<HexadecimalNumber> convertToHexadecimal(long value){
//        return HexadecimalNumber.of(value);
//    }
//
//    private Optional<RomanNumeral> convertToRomanNumeral(long value){
//        return RomanNumeral.of(value);
//    }
}
