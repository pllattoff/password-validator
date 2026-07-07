public class PasswordValidator {

    static final String[] COMMON_PASSWORDS = {"password", "Passwort1", "12345678", "Aa345678"};
    static final String ALLOWED_SPECIAL_CHARS = "!@#$%^&*()-_+=?.,;:";
    static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean hasMinLength(String password, int min) {

        if (password == null || password.isBlank()) {
            return false;
        }

        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsUpperAndLower(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
                break;
            }
        }

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
                break;
            }
        }

        return hasUpperCase && hasLowerCase;
    }

    public static boolean isCommonPassword(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        password = password.trim();

        for (String commonPassword : COMMON_PASSWORDS) {
            if (commonPassword.equalsIgnoreCase(password)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSpecialChar(String password, String allowed) {

        if (password == null || password.isBlank() || allowed == null || allowed.isBlank()) {
            return false;
        }

        for (char ch : allowed.toCharArray()) {
            if (password.indexOf(ch) >= 0) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValid(String password) {

        return hasMinLength(password, MIN_PASSWORD_LENGTH)
                && containsDigit(password)
                && containsUpperAndLower(password)
                && !isCommonPassword(password)
                && containsSpecialChar(password, ALLOWED_SPECIAL_CHARS);
    }


}
