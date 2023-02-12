package io.github.matgalv2.numberconverter.service;

import io.github.matgalv2.numberconverter.domain.AbstractNumber;
import io.github.matgalv2.numberconverter.dto.Data;

import java.util.Optional;

public interface NumberConverterService {

    Optional<? extends AbstractNumber> convertNumber(Data data);
}
