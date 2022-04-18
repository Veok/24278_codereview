import java.time.LocalDate;

public class TransferFrom implements Operation {

    private BankAccount account;
    String secondAccount;
    double amount;
    LocalDate date;
    private double balanceBeforeTransaction;

    public TransferFrom(BankAccount account, String secondAccount, double amount, LocalDate date) {
        this.balanceBeforeTransaction = account.getBalance();
        this.account = account;
        this.secondAccount = secondAccount;
        this.amount = amount;
        this.date = date;
    }

    public String getSecondAccount() {
        return secondAccount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void execute(){
        account.subAmount(amount);
    }

    public String toString(){
        return String.format("%-15s%9.2f%9.2f\t%s\tBank Account Number: %s", "Transfer from", this.amount, balanceBeforeTransaction - amount, this.date, secondAccount);
    }
}
