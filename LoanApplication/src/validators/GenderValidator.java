package validators;

public class GenderValidator {

    public static boolean isGenderValid(String pesel, String gender) {
        if (!gender.equals("female") && !gender.equals("male")) {
            System.out.println("Gender is not valid.");
            return false;
        }

        boolean genderNotMatchesPeselNumber = Integer.parseInt(pesel.substring(8, 9)) % 2 == 0;

        if (genderNotMatchesPeselNumber && gender.equals("female")) {
            System.out.println("Gender doesn't match Pesel.");
            return false;
        }

        return true;
    }
}
