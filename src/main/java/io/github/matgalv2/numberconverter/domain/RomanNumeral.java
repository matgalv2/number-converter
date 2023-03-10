package io.github.matgalv2.numberconverter.domain;

import lombok.Getter;

import java.util.Optional;

@Getter
public class RomanNumeral implements AbstractNumber {

    public static final int MAXIMAL_NUMBER = 3999;
    private static final int [] ROMAN_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String [] ROMAN_LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private final String value;

    private RomanNumeral(String value) {
        this.value = value;
    }

    public static Optional<RomanNumeral> of(long value) {
        if (value >= 0 && value <= MAXIMAL_NUMBER)
            return Optional.of(new RomanNumeral(longToRoman(value)));
        else
            return Optional.empty();
    }

    private static String longToRoman(long number) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < ROMAN_VALUES.length; i++) {
            while (number >= ROMAN_VALUES[i]) {
                number = number - ROMAN_VALUES[i];
                roman.append(ROMAN_LETTERS[i]);
            }
        }
        return roman.toString();
    }
}
