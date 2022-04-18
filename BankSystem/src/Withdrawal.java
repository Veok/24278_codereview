import java.time.LocalDate;

public class Withdrawal implements Operation {
    BankAccount account;
    double amount;
    LocalDate date;
    private double balanceBeforeTransaction;

    public Withdrawal(BankAccount account, double amount, LocalDate date) {
        this.balanceBeforeTransaction = account.getBalance();
        this.account = account;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getAccount() {
        return account;
    }

    public LocalDate getDate() {
        return date;
    }

    public void execute(){
        account.subAmount(amount);
    }

    public String toString(){
        return String.format("%-15s%9.2f%9.2f\t%s", "Withdrawal", this.amount, balanceBeforeTransaction - amount, this.date);
    }
}
