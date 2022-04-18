import java.time.LocalDate;

public class Main {

    public static void  main (String [] args){
        System.out.println("Account History: ");
        BankAccount account = new BankAccount ();
        account.addOperation(new Deposit(account, 12000, LocalDate.of(2021,05,18)));
        account.addOperation(new Withdrawal(account, 1000, LocalDate.of(2021,06,20)));
        account.addOperation(new TransferFrom(account, "Bank XYZ", 15.56, LocalDate.of(2021,07,01)));
        account.addOperation(new Withdrawal(account, 50.50, LocalDate.of(2021,10,05)));
        account.addOperation(new Deposit(account, 150.99, LocalDate.of(2022,01,02)));
        account.addOperation(new Withdrawal(account, 12.99, LocalDate.of(2022,02,01)));
        account.addOperation(new TransferFrom(account, "Adam Nowak", 2000, LocalDate.of(2022,03,25)));
        account.addOperation(new TransferTo(account, "Surprise", 30000.50, LocalDate.of(2022,04,17)));

        System.out.println(account.toString());
        System.out.println("Filtered Account History: ");
        OperatonHistory dates = new OperatonHistory(LocalDate.of(2021,07,01), LocalDate.of(2022,03,25), account);
        dates.filterByDateRange();
        System.out.println(dates.toString());
    }
}
