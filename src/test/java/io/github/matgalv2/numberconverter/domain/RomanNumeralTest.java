package io.github.matgalv2.numberconverter.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanNumeralTest {

    @Test
    @DisplayName("Fails with invalid value (lower than 0)")
    public void invalidValueLT() {
        Optional<RomanNumeral> roman = RomanNumeral.of(-1);
        assertFalse(roman.isPresent());
    }

    @Test
    @DisplayName("Succeeds with correct value (greater or equal to 0)")
    public void correctValue() {
        Optional<RomanNumeral> roman = RomanNumeral.of(45);
        String roman45 = "XLV";
        assertTrue(roman.isPresent() && roman.get().getValue().equals(roman45));
    }

    @Test
    @DisplayName("Fails with invalid value (greater than 3999)")
    public void invalidValueGT() {
        Optional<RomanNumeral> roman = RomanNumeral.of(4000);
        assertFalse(roman.isPresent());
    }
}
