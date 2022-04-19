import java.time.LocalDate;

public class TransferTo extends Operation {

    private final String secondAccount;

    public TransferTo(BankAccount account, String secondAccount, double amount, LocalDate date) {
        super(account, amount, date);
        this.secondAccount = secondAccount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void execute() {
        account.addAmount(amount);
    }

    public String toString() {
        return String.format("%-15s%9.2f%9.2f\t%s\tBank Account Number: %s", "Transfer to", this.amount, balanceBeforeTransaction + amount, this.date, secondAccount);
    }
}
