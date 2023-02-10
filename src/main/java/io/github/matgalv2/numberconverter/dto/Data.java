package io.github.matgalv2.numberconverter.dto;

import io.github.matgalv2.numberconverter.common.ConversionType;
import io.github.matgalv2.numberconverter.validator.NumberConstraints;
import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NumberConstraints
public class Data {
    private final long value;
    private final ConversionType type;
}
