package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeselValidator {
    public static boolean isPeselValid(String pesel) {

        if (pesel.length() != 11) {
            System.out.println("Pesel is 11 digit long.");
            return false;
        }

        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher matcher = pattern.matcher(pesel);
        boolean isStringPesel = matcher.find();
        if (isStringPesel) {
            System.out.println("Pesel contains only digits.");
            return false;
        }

        if (Integer.parseInt(pesel.substring(2, 4)) < 1 || Integer.parseInt(pesel.substring(2, 4)) > 32 ||
                Integer.parseInt(pesel.substring(4, 6)) < 1 || Integer.parseInt(pesel.substring(4, 6)) > 31) {
            System.out.println("Pesel is not valid.");
            return false;
        }

        char[] peselArray = pesel.toCharArray();
        int sum = Integer.parseInt(String.valueOf(peselArray[0])) + (Integer.parseInt(String.valueOf(peselArray[1])) * 3) % 10
                + (Integer.parseInt(String.valueOf(peselArray[2])) * 7) % 10 + (Integer.parseInt(String.valueOf(peselArray[3])) * 9) % 10
                + Integer.parseInt(String.valueOf(peselArray[4])) + (Integer.parseInt(String.valueOf(peselArray[5])) * 3) % 10
                + (Integer.parseInt(String.valueOf(peselArray[6])) * 7) % 10 + (Integer.parseInt(String.valueOf(peselArray[7])) * 9) % 10
                + Integer.parseInt(String.valueOf(peselArray[8])) + (Integer.parseInt(String.valueOf(peselArray[9])) * 3) % 10;

        sum = 10 - (sum % 10);

        int cn = Integer.parseInt(String.valueOf(peselArray[10]));

        if (cn != sum) {
            System.out.println("CN: " + cn + " Sum CN: " + sum % 10);
            System.out.println("Pesel is not valid.");
            return false;
        }
        return true;
    }
}
