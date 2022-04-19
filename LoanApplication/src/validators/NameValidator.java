package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    public static boolean isNameValid(String name) {
        if (name.isEmpty()) {
            System.out.println("This position cannot be empty. Use at least 2 characters.");
            return true;
        }

        if (name.length() < 2) {
            System.out.println("Use at least 2 characters.");
            return true;
        }

        char[] nameArray = name.toCharArray();

        if (!Character.isUpperCase(nameArray[0])) {
            System.out.println("Must be uppercase.");
            return true;
        }

        Pattern pattern = Pattern.compile("[^A-Za-z]+");
        Matcher matcher = pattern.matcher(name);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter) {
            System.out.println("Don't use numbers or special characters.");
            return true;
        }

        return false;
    }
}
