package model.entities;
/******************************************************************************
*   Nota de aula
*   Final em Classe: Não permite que a classe SavingsAccount seja herdada
*   Final em Método: Não permite sobreposição de método(evitar inconsistência)
******************************************************************************/
public final class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance(){
        balance += balance * interestRate; 
    }

    @Override
    public final void withdraw(Double amount){
        super.withdraw(amount);
        balance -= 5.00;
    }

    public String toString(){
        return "\nAccount Type: " + getClass().getSimpleName() +
                "\nNumber: " + getNumber() + 
                "\nHolder: " + getHolder() + 
                "\nBalance: " + balance +
                "\nInterest Rate: " + interestRate;
    }
}
