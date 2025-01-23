package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************STARTING PAYROLL APPLICATION******************\n\n");


        //Create Scanner Object for user input
        Scanner scanner = new Scanner(System.in);
        // Get NAME and HOURLY RATE
        String name = Employee.getName(scanner);
        double hourlyRate = Employee.getHourlyRate(scanner);

        // Create an object of Employee with input from user
        Employee employee = new Employee(name, hourlyRate);
            // Print to test
            System.out.println(employee.toString());
    }




}// class