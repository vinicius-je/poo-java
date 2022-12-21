package entities;

public abstract class Account {
    private Integer number;
    private String holder;
    protected Double balance;

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    //Getters
    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    //Setters
    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    //Métodos
    public void withdraw(Double amount){
        if(balance >= amount)
            this.balance -= amount;
    }
    
    public void deposit(Double amount){
        this.balance += amount;
    }   

    public abstract String toString();
}