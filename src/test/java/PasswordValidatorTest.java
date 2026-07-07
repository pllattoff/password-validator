import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldReturnFalse_whenGiven8() {
        assertFalse(PasswordValidator.hasMinLength("Abc1def", 8));
    }
    @Test
    void hasMinLength_shouldReturnTrue_whenGiven8() {
        assertTrue(PasswordValidator.hasMinLength("Abc1defg", 8));
    }
    @Test
    void hasMinLength_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.hasMinLength(null, 8));
    }
    @Test
    void hasMinLength_shouldReturnFalse_whenGivenEmptyString() {
        assertFalse(PasswordValidator.hasMinLength("         ", 8));
    }

    @Test
    void containsDigit_shouldReturnFalse_whenGivenNoDigit() {
        assertFalse(PasswordValidator.containsDigit("Abcdefgh"));
    }
    @Test
    void containsDigit_shouldReturnTrue_whenGivenDigit() {
        assertTrue(PasswordValidator.containsDigit("Abcde1fgh"));
    }
    @Test
    void containsDigit_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.containsDigit(null));
    }
    @Test
    void containsDigit_shouldReturnFalse_whenGivenEmptyString() {
        assertFalse(PasswordValidator.containsDigit("         "));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenLowerCaseOnly() {
        assertFalse(PasswordValidator.containsUpperAndLower("abcdefg1"));
    }
    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenUpperCaseOnly() {
        assertFalse(PasswordValidator.containsUpperAndLower("ABCDEFG1"));
    }
    @Test
    void containsUpperAndLower_shouldReturnTrue_whenGivenUpperAndLowerCase() {
        assertTrue(PasswordValidator.containsUpperAndLower("Abc1defg"));
    }
    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.containsUpperAndLower(null));
    }
    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenEmptyString() {
        assertFalse(PasswordValidator.containsUpperAndLower("         "));
    }
}