package org.example;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************STARTING PAYROLL APPLICATION******************\n\n");


        //Create Scanner Object for user input
        Scanner scanner = new Scanner(System.in);

        // GATHER PAYROLL DETAILS
        // Call the method to gather payroll details from the user and store the result in a PayrollDetails object.
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

        // Print employee name and total pay
        System.out.println("Employee Name: " + employee.name());
        System.out.println("Total Pay: " + totalPay);

        scanner.close();

    }




}// class