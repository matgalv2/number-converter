package io.github.matgalv2.numberconverter.service;


import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.domain.AbstractNumber;
import io.github.matgalv2.numberconverter.domain.HexadecimalNumber;
import io.github.matgalv2.numberconverter.domain.RomanNumeral;
import io.github.matgalv2.numberconverter.dto.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;


@Service
public class SimpleNumberConverterService implements NumberConverterService {
    private final Map<ConversionType, Function<Long, Optional<? extends AbstractNumber>>> mapping;

    public SimpleNumberConverterService() {
        mapping = new HashMap<>();
        mapping.put(ConversionType.HEXADECIMAL, HexadecimalNumber::of);
        mapping.put(ConversionType.ROMAN_NUMERAL, RomanNumeral::of);
    }

    @Override
    public Optional<? extends AbstractNumber> convertNumber(Data data) {
        ConversionType type = data.getType();
        if (mapping.containsKey(type))
            return mapping.get(type).apply(data.getValue());
        else
            return Optional.empty();
    }
}
