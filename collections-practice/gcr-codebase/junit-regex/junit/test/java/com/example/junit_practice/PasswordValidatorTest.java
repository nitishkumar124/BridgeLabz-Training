package com.example.junit_practice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    @ParameterizedTest
    @ValueSource(strings = {"Pass1234", "Secure789", "Admin_2026"})
    void testValidPasswords(String password) {
        assertTrue(validator.isValid(password), "Should be valid: " + password);
    }

    @ParameterizedTest
    @CsvSource({
        "short1A, Password too short",
        "lowercase1, No uppercase letter",
        "NoDigitsHere, No digits",
        "'', Empty string"
    })
    void testInvalidPasswords(String password, String reason) {
        assertFalse(validator.isValid(password), "Should be invalid (" + reason + "): " + password);
    }
}