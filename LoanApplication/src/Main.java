import validators.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListOfLoanApplication list = new ListOfLoanApplication();
        String commandNew;

        do {
            System.out.println("New account - Loan Apllication");
            String nameNew;
            do {
                nameNew = readInput("Enter name: ");
            } while (NameValidator.isNameValid(nameNew));

            String surnameNew;
            do {
                surnameNew = readInput("Enter surname: ");
            } while (NameValidator.isNameValid(surnameNew));

            String peselNew;
            do {
                peselNew = readInput("Enter PESEL: ");
            } while (!PeselValidator.isPeselValid(peselNew));

            String nipNew;
            do {
                nipNew = readInput("Enter NIP: ");
            } while (!NipValidator.isNIPValid(nipNew));

            String accountNew;
            do {
                accountNew = readInput("Enter Bank Account Number: ");
            } while (!BankAccountNumberValidator.isBankAccountValid(accountNew));

            String yearNew;
            do {
                yearNew = readInput("Enter Year of Birth [XXXX]: ");
            } while (!DateOfBirthValidator.isYearOfBirthValid(peselNew, yearNew));

            String monthNew;
            do {
                monthNew = readInput("Enter Month of Birth [XX]: ");
            } while (!DateOfBirthValidator.isMonthOfBirthValid(peselNew, monthNew, yearNew));

            String dayNew;
            do {
                dayNew = readInput("Enter Day of Birth [XX]: ");
            } while (!DateOfBirthValidator.isDayOfBirthValid(peselNew, dayNew));

            String genderNew;
            do {
                genderNew = readInput("Enter Gender: ");
            } while (!GenderValidator.isGenderValid(peselNew, genderNew));

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

    private static String readInput(String s) {
        String inputString;
        Scanner nameObj = new Scanner(System.in);
        System.out.println(s);
        inputString = nameObj.nextLine();
        return inputString;
    }

}
