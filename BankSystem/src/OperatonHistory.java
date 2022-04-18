import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperatonHistory {
    LocalDate dateFrom;
    LocalDate dateTo;
    List<Operation> operations;
    BankAccount account;

    public OperatonHistory(LocalDate dateFrom, LocalDate dateTo, BankAccount account) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.account = account;
        this.operations = new ArrayList<>();
    }

    public void filterByDateRange (){
        for (Operation operation:account.getOperations()){
            if (operation.getDate().isAfter(dateFrom) && operation.getDate().isBefore(dateTo)){
                operations.add(operation);
            }
        }
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
