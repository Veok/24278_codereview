import java.time.LocalDate;

public class Withdrawal extends Operation {

    public Withdrawal(BankAccount account, double amount, LocalDate date) {
        super(account, amount, date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void execute() {
        account.subAmount(amount);
    }

    public String toString() {
        return String.format("%-15s%9.2f%9.2f\t%s", "Withdrawal", this.amount, balanceBeforeTransaction - amount, this.date);
    }
}
