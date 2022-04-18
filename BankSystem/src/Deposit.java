import java.time.LocalDate;

public class Deposit implements Operation {
    private BankAccount account;
    private double amount;
    private LocalDate date;
    private double balanceBeforeTransaction;

    public Deposit(BankAccount account, double amount, LocalDate date) {
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
        account.addAmount(amount);
    }

    public String toString(){
        return String.format("%-15s%9.2f%9.2f\t%s", "Deposit", this.amount, amount + balanceBeforeTransaction, this.date);
    }

}
