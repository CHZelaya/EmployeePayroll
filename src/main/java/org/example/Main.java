package org.example;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************STARTING PAYROLL APPLICATION******************\n\n");


        //Create Scanner Object for user input
        Scanner scanner = new Scanner(System.in);


        // GATHER PAYROLL DETAILS
        PayrollDetails payrollDetails = PayrollInput.getPayRollEntries(scanner);

        // Retrieve the Employee object from the PayrollDetails record for further processing.
        Employee employee = payrollDetails.employee();

        // Get the list of Payroll entries associated with the employee from the PayrollDetails record.
        List<Payroll> payrollEntries = payrollDetails.payrollEntries();

       // CALCULATE AND DISPLAY TOTAL PAY
        double totalPay = 0;
        for (Payroll payroll : payrollEntries) {
            totalPay += payroll.calculatePay();
        }

        // Format total pay as currency using the first Payroll instance
        String formattedTotalPay = payrollEntries.get(0).formatCurrency(totalPay); // Call the method on the first instance


        // Print employee name and total pay
        System.out.println("Employee Name: " + employee.name());
        System.out.println("Total Pay: " + formattedTotalPay);

        scanner.close();

    }




}// class