import java.util.ArrayList;
import java.util.List;

public class ListOfLoanApplication {
    private List<LoanApplication> loanApplication;

    public ListOfLoanApplication() {
        loanApplication = new ArrayList<>();
    }

    public List<LoanApplication> getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(List<LoanApplication> loanApplication) {
        this.loanApplication = loanApplication;
    }

    public void addNewApplicationToList(LoanApplication loanApplication) {
        this.loanApplication.add(loanApplication);
    }

    public String toString() {
        return this.loanApplication.toString();
    }
}