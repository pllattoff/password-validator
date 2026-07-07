public class PasswordValidator {

    public static boolean hasMinLength(String password, int min) {
        if (password == null || password.isBlank()) {
            return false;
        }

        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {

        return true;
    }

}
