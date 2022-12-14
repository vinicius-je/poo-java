package model.entities;

import java.io.Console;
import java.util.ArrayList;

import model.exceptions.DomainException;

public class Bank {
    ArrayList <Account> accounts = new ArrayList<>(); 
    Console con = System.console();
    
    public void displayOptions(){
        System.out.println("\n\t1 - Savings Account"
                            + "\n\t2 - Business Account"
                            + "\n\t3 - Withdraw"
                            + "\n\t4 - Deposit"
                            + "\n\t5 - Report"
                            + "\n\t6 - Loan"
                            + "\n\t7 - Exit");
    }

    public void controller(int option){
        switch(option){
            case 1:
                newSavingsAcc();
                break;
            case 2:
                newBusinessAcc();
                break;
            case 3:
                accWithdraw();
                break;
            case 4:
                accDeposit();
                break;
            case 5:
                report();
                break;
            case 6:
                accLoan();
                break;
            case 7:
                System.out.println("End Of Application");
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void newSavingsAcc(){
        System.out.println(" ------------- Savings Account ------------- ");

        boolean conditional = true;

        while(conditional){
            try {
                int number = Integer.parseInt(con.readLine("Account number: "));
                String holder = con.readLine("Account's holder: ");
                double balance = Double.parseDouble(con.readLine("Balance: "));
                double interestRate = Double.parseDouble(con.readLine("Interest rate: "));

                conditional = !conditional;
                SavingsAccount sa = new SavingsAccount(number, holder, balance, interestRate);
                accounts.add(sa);
            } catch (NumberFormatException e) {
                System.out.println("Error >> " + e.getMessage());
            }
        }
    }

    public void newBusinessAcc(){
        System.out.println(" ------------- Business Account ------------- ");

        boolean conditional = true;

        while(conditional){
            try {
                int number = Integer.parseInt(con.readLine("Account number: "));
                String holder = con.readLine("Account's holder: ");
                double balance = Double.parseDouble(con.readLine("Balance: "));
                double loanLimit = Double.parseDouble(con.readLine("Loan limit: "));
                
                conditional = !conditional;
                BusinessAccount ba = new BusinessAccount(number, holder, balance, loanLimit);
                accounts.add(ba); 
            } 
            catch (NumberFormatException e) {
                System.out.println("Error >> " + e.getMessage());
            }
        }
    }

    public int findIndex(int number){
        boolean find = false;
        int index = 0;

        for(int i = 0; !find; i++){
            if (accounts.get(i).getNumber() == number){
                find = !find;
                index = i;
            }
        }

        if(!find) throw new IndexOutOfBoundsException();

        return index;
    }
    
    public void accWithdraw(){
        boolean conditional = true;

        while(conditional){
            try{
                int number = Integer.parseInt(con.readLine("Account number: "));
                int index = findIndex(number);
                System.out.println(accounts.get(index));
                System.out.println("Withdraw in Savings Account has a fee of $5.00\n"
                                    + "Withdraw in Business Account has a fee of $7.00\n");

                double amount = Double.parseDouble(con.readLine("Withdraw amount: "));
                accounts.get(index).withdraw(amount);

                conditional = !conditional;
                System.out.println(accounts.get(findIndex(number)));
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Number account does not exist");
            }
            catch(DomainException e){
                System.out.println("Error: " + e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println("Error >> " + e.getMessage());
            }
        }
    }
    
    public void accDeposit(){

        boolean conditional = true;

        while(conditional){
            try{
                int number = Integer.parseInt(con.readLine("Account number: "));
                double amount = Double.parseDouble(con.readLine("Deposit amount: "));
                accounts.get(findIndex(number)).deposit(amount);

                conditional = !conditional;
                System.out.println(accounts.get(findIndex(number)));
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Number account does not exist");
            }
            catch (NumberFormatException e) {
                System.out.println("Error >> " + e.getMessage());
            }
        }
    }

    public void report(){
        for(Account acc : accounts)
            System.out.println(acc);
    }

    public void accLoan(){
        System.out.println("Only Business Account has loan operation\n");
        System.out.println("Loan operation has a fee of $10.00\n");

        boolean conditional = true;

        while(conditional){
            try {
                int number = Integer.parseInt(con.readLine("Account number: "));
                int index = findIndex(number);

                conditional = !conditional;
                
                if(accounts.get(index).getClass().getSimpleName().equals("BusinessAccount")){
                    System.out.println(accounts.get(index));
                    double amount = Double.parseDouble(con.readLine("Loan amount: "));
                    ((BusinessAccount)accounts.get(index)).loan(amount);
                }else{
                    System.out.println("Not a Business Account");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Error >> " + e.getMessage());
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Number account does not exist");
            }
        }
    }
}