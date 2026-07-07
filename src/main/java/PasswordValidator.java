public class PasswordValidator {

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


}
