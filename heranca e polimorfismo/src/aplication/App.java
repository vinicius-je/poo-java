package aplication;

import java.io.Console;
import java.util.Locale;

import model.entities.Bank;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
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
