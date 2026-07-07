public class PasswordValidator {

    static final String[] COMMON_PASSWORDS = {"password", "Passwort1", "12345678", "Aa345678"};

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

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
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

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
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


}
