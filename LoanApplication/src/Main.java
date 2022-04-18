import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ListOfLoanApplication list = new ListOfLoanApplication();
        String commandNew = "STOP";

        do {
            System.out.println("New account - Loan Apllication");
            String nameNew = "BLANK";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter name: ");
                nameNew = nameObj.nextLine();
            } while (!isNameValid(nameNew));

            String surnameNew = "BLANK";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter surname: ");
                surnameNew = nameObj.nextLine();
            } while (!isNameValid(surnameNew));

            String peselNew = "00000000000";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter PESEL: ");
                peselNew = nameObj.nextLine();
            } while (!isPeselValid(peselNew));

            String nipNew = "0000000000";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter NIP: ");
                nipNew = nameObj.nextLine();
            } while (!isNIPValid(nipNew));

            String accountNew = "00000000000000000000";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter Bank Account Number: ");
                accountNew = nameObj.nextLine();
            } while (!isBankAccountValid(accountNew));

            String yearNew = "1999";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter Year of Birth [XXXX]: ");
                yearNew = nameObj.nextLine();
            } while (!isYearOfBirthValid(peselNew, yearNew));

            String monthNew = "01";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter Month of Birth [XX]: ");
                monthNew = nameObj.nextLine();
            } while (!isMonthOfBirthValid(peselNew, monthNew, yearNew));

            String dayNew = "01";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter Day of Birth [XX]: ");
                dayNew = nameObj.nextLine();
            } while (!isDayOfBirthValid(peselNew, dayNew));

            String genderNew = "female";
            do {
                Scanner nameObj = new Scanner(System.in);
                System.out.println("Enter Gender: ");
                genderNew = nameObj.nextLine();
            } while (!isGenderValid(peselNew, genderNew));

            int intYearNew = Integer.parseInt(yearNew);
            int intMonthNew = Integer.parseInt(monthNew);
            int intDayNew = Integer.parseInt(dayNew);
            LocalDate date = LocalDate.of(intYearNew, intMonthNew, intDayNew);
            LoanApplication application = new LoanApplication(nameNew, surnameNew, peselNew, nipNew, accountNew, date, genderNew);
            list.addNewApplicationToList(application);
            System.out.println("Application added. To start new application type NEW. To show list of applications type LIST. To end program type END.");

            do {
                Scanner commend = new Scanner(System.in);
                commandNew = commend.nextLine();
                if (commandNew.equals("LIST")) {
                    System.out.println(list);
                    System.out.println("To start new application type NEW. To show list of applications type LIST. To end program type END.");
                } else {
                    System.out.println("Use command NEW, LIST or END");
                }
            } while (!commandNew.equals("END") && !commandNew.equals("NEW"));

        } while (!commandNew.equals("END"));

    }

    public static boolean isNameValid(String name) {
        if (name.isEmpty()) {
            System.out.println("This position cannot be empty. Use at least 2 characters.");
            return false;
        }

        if (name.length() < 2) {
            System.out.println("Use at least 2 characters.");
            return false;
        }

        char[] nameArray = name.toCharArray();
        if (!Character.isUpperCase(nameArray[0])){
            System.out.println("Must be uppercase.");
            return false;
        }

        Pattern pattern = Pattern.compile("[^A-Za-z]+");
        Matcher matcher = pattern.matcher(name);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter) {
            System.out.println("Don't use numbers or special characters.");
            return false;
        }

        return true;
    }

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
        if (Integer.parseInt(String.valueOf(peselArray[10])) != sum) {
            System.out.println("CN: " + Integer.parseInt(String.valueOf(peselArray[10])) + " Sum CN: " + sum % 10);
            System.out.println("Pesel is not valid.");
            return false;
        }
        return true;
    }

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

    public static boolean isYearOfBirthValid(String pesel, String yearDate) {
        if (Integer.parseInt(yearDate) < 1900 || Integer.parseInt(yearDate) > 2020) {
            System.out.println("Year of Birth is not valid.");
            return false;
        }

        int peselYear = Integer.parseInt(pesel.substring(0, 1));
        int year = Integer.parseInt(yearDate.substring(2, 3));
        if (peselYear != year) {
            System.out.println("Year of Birth doesn't match Pesel.");
            return false;
        }
        return true;
    }

    public static boolean isMonthOfBirthValid(String pesel, String monthDate, String yearDate) {
        if (Integer.parseInt(monthDate) < 1 || Integer.parseInt(monthDate) > 12) {
            System.out.println("Month of Birth is not valid.");
            return false;
        }

        int peselMonth = Integer.parseInt(pesel.substring(2, 3));
        int month = Integer.parseInt(monthDate.substring(0, 1));
        if (Integer.parseInt(yearDate) > 1999) {
            month = month + 20;
        }

        if (peselMonth != month) {
            System.out.println("Month of Birth doesn't match Pesel.");
            return false;
        }
        return true;
    }

    public static boolean isDayOfBirthValid(String pesel, String dayDate) {
        if (Integer.parseInt(dayDate) < 1 || Integer.parseInt(dayDate) > 31) {
            System.out.println("Day of Birth is not valid.");
            return false;
        }

        int peselDay = Integer.parseInt(pesel.substring(4, 5));
        int day = Integer.parseInt(dayDate.substring(0, 1));
        if (peselDay != day) {
            System.out.println("Day of Birth doesn't match Pesel.");
            return false;
        }
        return true;
    }

    public static boolean isGenderValid(String pesel, String gender) {
        if (!gender.equals("female") && !gender.equals("male")) {
            System.out.println("Gender is not valid.");
            return false;
        }

        if (Integer.parseInt(pesel.substring(8, 9)) % 2 == 0 && gender.equals("female")) {
            System.out.println("Gender doesn't match Pesel.");
            return false;
        }
        if (Integer.parseInt(pesel.substring(8, 9)) % 2 == 0 && gender.equals("male")) {
            System.out.println("Gender doesn't match Pesel.");
            return false;
        }
        return true;
    }
}
