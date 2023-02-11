package io.github.matgalv2.numberconverter.domain;


import lombok.Getter;

import java.util.Optional;

@Getter
public class HexadecimalNumber implements AbstractNumber {

    private final String value;

    private HexadecimalNumber(String value) {
        this.value = value;
    }


    public static Optional<HexadecimalNumber> of(long value) {
        return value >= 0 ? Optional.of(new HexadecimalNumber(String.format("%x", value))) : Optional.empty();
    }
}
