package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccountNumberValidator {

    public static boolean isBankAccountValid(String account) {
        if (account.length() != 26) {
            System.out.println("Bank account number is 26 digit long.");
            return false;
        }

        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher matcher = pattern.matcher(account);
        boolean isStringAccount = matcher.find();
        if (isStringAccount) {
            System.out.println("Bank account number contains only digits.");
            return false;
        }

        return true;
    }
}
