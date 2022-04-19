import java.time.LocalDate;

public class Deposit extends Operation {

    public Deposit(BankAccount account, double amount, LocalDate date) {
        super(account, amount, date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void execute() {
        account.addAmount(amount);
    }

    public String toString() {
        return String.format("%-15s%9.2f%9.2f\t%s", "Deposit", this.amount, amount + balanceBeforeTransaction, this.date);
    }

}
