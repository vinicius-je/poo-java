package application;
import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Console cs = System.console();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int number = Integer.parseInt(cs.readLine("Número: "));
        LocalDate date = LocalDate.parse(cs.readLine("Data (dd/MM/yyyy): "), fmt);
        double totalValue = Double.parseDouble(cs.readLine("Valor do contrato: "));
        int months = Integer.parseInt(cs.readLine("Entre com o numero de parcelas: "));

        Contract contract = new Contract(number, date, totalValue);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, months);

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
    }
}
