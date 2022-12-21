package aplication;

import java.io.Console;

import entities.Bank;

public class App {
    public static void main(String[] args) throws Exception {
        Console con = System.console();
        Bank bank = new Bank();

        int option = 0;
        while(option != 7){
            bank.displayOptions();
            option = Integer.parseInt(con.readLine("\nOption: "));
            bank.controller(option);
            con.readLine("\nEnter to continue...");
            //Clean console
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
        }
    }
}
