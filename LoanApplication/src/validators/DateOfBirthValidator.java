package validators;

public class DateOfBirthValidator {
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
}
