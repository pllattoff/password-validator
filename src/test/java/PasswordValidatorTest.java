import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldReturnFalse_whenGiven7CharactersAnd8() {
        assertFalse(PasswordValidator.hasMinLength("1234567", 8));
    }
    @Test
    void hasMinLength_shouldReturnTrue_whenGiven8CharactersAnd8() {
        assertTrue(PasswordValidator.hasMinLength("12345678", 8));
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
    void containsUpperAndLower_shouldReturnFalse_whenGivenOneLetter() {
        assertFalse(PasswordValidator.containsUpperAndLower("a"));
    }
    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.containsUpperAndLower(null));
    }
    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenEmptyString() {
        assertFalse(PasswordValidator.containsUpperAndLower("         "));
    }

    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenCommonPassword() {
        assertTrue(PasswordValidator.isCommonPassword("Password"));
    }
    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenCommonPasswordWithSpace() {
        assertTrue(PasswordValidator.isCommonPassword(" password "));
    }
    @Test
    void isCommonPassword_shouldReturnFalse_whenGivenNotCommonPassword() {
        assertFalse(PasswordValidator.isCommonPassword("Abc1defg"));
    }
    @Test
    void isCommonPassword_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.isCommonPassword(null));
    }
    @Test
    void isCommonPassword_shouldReturnFalse_whenGivenEmptyString() {
        assertFalse(PasswordValidator.isCommonPassword("         "));
    }

    @Test
    void containsSpecialChar_shouldReturnFalse_whenNoSpecialCharIsPresent() {
        assertFalse(PasswordValidator.containsSpecialChar("Abc1defg", "!@#$%^&*()-_+=?.,;:"));
    }
    @Test
    void containsSpecialChar_shouldReturnTrue_whenSpecialCharIsPresent() {
        assertTrue(PasswordValidator.containsSpecialChar("Abc(1defg", "!@#$%^&*()-_+=?.,;:"));
    }
    @Test
    void containsSpecialChar_shouldReturnFalse_whenGivenNullAndSpecialChars() {
        assertFalse(PasswordValidator.containsSpecialChar(null, "!@#$%^&*()-_+=?.,;:"));
    }
    @Test
    void containsSpecialChar_shouldReturnFalse_whenGivenEmptyStrindAndSpecialChars() {
        assertFalse(PasswordValidator.containsSpecialChar(" ", "!@#$%^&*()-_+=?.,;:"));
    }
    @Test
    void containsSpecialChar_shouldReturnFalse_whenGivenPasswordAndNull() {
        assertFalse(PasswordValidator.containsSpecialChar("Abc1defg", null));
    }
    @Test
    void containsSpecialChar_shouldReturnFalse_whenGivenPasswordAndEmptyString() {
        assertFalse(PasswordValidator.containsSpecialChar("Abc1defg", " "));
    }

    @Test
    void isValid_shouldReturnFalse_whenGiven7LetterPassword() {
        assertFalse(PasswordValidator.isValid("Abc1de*"));
    }
    @Test
    void isValid_shouldReturnFalse_whenGivenNoDigit() {
        assertFalse(PasswordValidator.isValid("Abccdef*"));
    }
    @Test
    void isValid_shouldReturnFalse_whenGivenUpperCaseOnly() {
        assertFalse(PasswordValidator.isValid("ABCDEFG1*"));
    }
    @Test
    void isValid_shouldReturnFalse_whenNoSpecialCharIsPresent() {
        assertFalse(PasswordValidator.isValid("Abc1def"));
    }
    @Test
    void isValid_shouldReturnFalse_whenGivenCommonPassword() {
        assertFalse(PasswordValidator.isValid("Password"));
    }
    @Test
    void isValid_shouldReturnTrue_whenGiven8LetterPassword() {
        assertTrue(PasswordValidator.isValid("Abc1de3*"));
    }
    @Test
    void isValid_shouldReturnTrue_whenGivenDigit() {
        assertTrue(PasswordValidator.isValid("Abcc0def*"));
    }
    @Test
    void isValid_shouldReturnTrue_whenSpecialCharIsPresent() {
        assertTrue(PasswordValidator.isValid("Abc1def*"));
    }
    @Test
    void isValid_shouldReturnTrue_whenGivenLongPassword() {
        assertTrue(PasswordValidator.isValid("Abc1def*877hliIIklji76)lnln8896gkKJLhh!;kbb(hqrtIUY8kdef*877hlif*877hliIIklji76)lnln8896gklji76)lnln8896gkKJLhh!;kbb(hqrtIUY8kdef*877hlif"));
    }
}