package model.entities;

public class BusinessAccount extends Account {
    public Double loanLimit;

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount){
        if(amount <= loanLimit)
            balance += amount - 10.0;
    }

    @Override
    public final void withdraw(Double amount){
        super.withdraw(amount);
        balance -= 7.0;
    }

    public String toString(){
        return "\nAccount Type: " + getClass().getSimpleName() +
                "\nNumber: " + getNumber() + 
                "\nHolder: " + getHolder() + 
                "\nBalance: " + balance + 
                "\nLoan limit: " + loanLimit;
    }
}