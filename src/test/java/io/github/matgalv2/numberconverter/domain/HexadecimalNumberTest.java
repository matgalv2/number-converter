package io.github.matgalv2.numberconverter.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HexadecimalNumberTest {

    @Test
    @DisplayName("Fails with invalid value (lower than 0)")
    public void invalidValue() {
        Optional<HexadecimalNumber> hex = HexadecimalNumber.of(-1);
        assertFalse(hex.isPresent());
    }

    @Test
    @DisplayName("Succeeds with correct value (greater or equal to 0)")
    public void correctValue() {
        Optional<HexadecimalNumber> hex = HexadecimalNumber.of(0);
        assertTrue(hex.isPresent());
    }
}
