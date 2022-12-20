package application;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Aplication {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Console c = System.console();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String departmentName = c.readLine("Enter department's name: ");
        String workerName = c.readLine("Enter worker's name: ");
        String workerLevel = c.readLine("Enter worker's level: ");
        double baseSalary = Double.parseDouble(c.readLine("Base salary: "));

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

		int n = Integer.parseInt(c.readLine("How many contracts to this worker? "));

        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract: " + i + "º data:");
            Date date = sdf.parse(c.readLine("Date (DD/MM/YYYY): "));
            double valuePerHour = Double.parseDouble(c.readLine("Value per hour: "));
            int hours = Integer.parseInt(c.readLine("Duration (hours): "));

            HourContract hc = new HourContract(date, valuePerHour, hours);
            worker.addContract(hc);
        }

		String monthAndYear = c.readLine("Enter month and year to calculate income (MM/YYYY): ");

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    }
}
