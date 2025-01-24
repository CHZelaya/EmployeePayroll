package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************STARTING PAYROLL APPLICATION******************\n\n");


        //Create Scanner Object for user input
        Scanner scanner = new Scanner(System.in);
        // GATHER EMPLOYEE DETAILS - Get Name and Rate
        String name = EmployeeInput.getName(scanner);
        double rate = EmployeeInput.getRate(scanner);
        // Create an object of Employee with input from user
        Employee employee = new Employee(name, rate);

        // GATHER PAYROLL DETAILS - Get Date and hours worked
        String date = Payroll.getDate(scanner);

        //Get Hours worked
        ArrayList<Integer> hoursWorked = Payroll.getHoursWorked(scanner);




        //Create an object of Payroll with input from user
        Payroll payroll = new Payroll(date, 5);

            // Print to test
            System.out.println(employee.toString());
    }




}// class