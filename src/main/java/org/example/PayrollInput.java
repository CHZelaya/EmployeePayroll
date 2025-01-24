package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollInput {

    public static double getHoursWorked(Scanner scanner){
        System.out.println("Enter the hours worked: ");
        return Double.parseDouble(scanner.nextLine()); //Validation needed, just setting up the methods to begin.
    }

    public static LocalDate getDateWorked(Scanner scanner){
        System.out.println("Enter the date worked: ");
        return LocalDate.parse(scanner.nextLine()); //Validation needed, just setting up the methods to begin.
    }

    public static List<Payroll> getPayRollEntries(Scanner scanner){
        List<Payroll> payrollEntries = new ArrayList<>();
        boolean areThereMoreEntries = true;

        while(areThereMoreEntries){
            double hoursWorked = getHoursWorked(scanner);
            LocalDate dateWorked = getDateWorked(scanner);
            //! Stopping here, need to add entries to arraylist.
        }


        return payrollEntries;
    }


}//class
