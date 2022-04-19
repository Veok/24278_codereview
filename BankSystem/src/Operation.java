import java.time.LocalDate;

public abstract class Operation {

    protected BankAccount account;
    protected double amount;
    protected LocalDate date;
    protected double balanceBeforeTransaction;

    public Operation(BankAccount account, double amount, LocalDate date) {
        this.balanceBeforeTransaction = account.getBalance();
        this.account = account;
        this.amount = amount;
        this.date = date;
    }

    abstract void execute();
    abstract LocalDate getDate();
}
