package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NipValidator {
    public static boolean isNIPValid(String nip) {

        if (nip.length() != 10) {
            System.out.println("NIP is 10 digit long.");
            return false;
        }

        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher matcher = pattern.matcher(nip);
        boolean isStringNip = matcher.find();
        if (isStringNip) {
            System.out.println("NIP contains only digits.");
            return false;
        }

        char[] nipArray = nip.toCharArray();

//        można użyć:
        int x = Character.getNumericValue(nipArray[0]);

        int sum = Integer.parseInt(String.valueOf(nipArray[0])) * 6 + Integer.parseInt(String.valueOf(nipArray[1])) * 5
                + Integer.parseInt(String.valueOf(nipArray[2])) * 7 + Integer.parseInt(String.valueOf(nipArray[3])) * 2
                + Integer.parseInt(String.valueOf(nipArray[4])) * 3 + Integer.parseInt(String.valueOf(nipArray[5])) * 4
                + Integer.parseInt(String.valueOf(nipArray[6])) * 5 + Integer.parseInt(String.valueOf(nipArray[7])) * 6
                + Integer.parseInt(String.valueOf(nipArray[8])) * 7;

        if (Integer.parseInt(String.valueOf(nipArray[9])) != sum % 11 || sum % 11 == 10) {
            System.out.println("NIP is not Valid");
            return false;
        }

        return true;
    }
}
