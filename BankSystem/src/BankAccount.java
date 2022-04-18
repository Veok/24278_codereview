import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    double balance;
    List<Operation> operations;

    public BankAccount() {
        this.balance = 0.0;
        operations = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
        operation.execute();
    }

    public void addAmount(double amount){
        balance += amount;
    }

    public void  subAmount(double amount){
        balance -= amount;
    }

    public String toString(){
        String formatted = "";

        formatted += String.format("%-15s%-12s%-12s\t%s\n", "Operation", "Amount", "Balance", "Date");

        for (Operation op : operations) {
            formatted += op.toString() + "\n";
        }

        return formatted;
    }
}
