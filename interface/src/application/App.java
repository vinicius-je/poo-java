package application;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Console cs = System.console();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
		String carModel = cs.readLine("Modelo do carro: ");
		LocalDateTime start = LocalDateTime.parse(cs.readLine("Retirada (dd/MM/yyyy HH:mm): "), fmt);
        LocalDateTime finish = LocalDateTime.parse(cs.readLine("Retorno (dd/MM/yyyy HH:mm): "), fmt);
		
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

		double pricePerHour = Double.parseDouble(cs.readLine("Entre com o preço por hora: "));
        double pricePerDay = Double.parseDouble(cs.readLine("Entre com o preço por dia: "));

		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(cr);

		System.out.println("FATURA:");
		System.out.println("Pagamento basico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().totalPayment()));

    }
}
