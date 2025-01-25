package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollInput {

    /**
     * Method to prompt user for input, hours worked
     * @param scanner - Object used as a parameter to prompt user for input
     * @return hoursWorked, which holds the users input (hours) in double type
     */
    public static double getHoursWorked(Scanner scanner){

        double hoursWorked = 0;
        int hoursLimit = 16;
        boolean isHoursValid = false;

        while(!isHoursValid){
            System.out.print("Please enter the hours that you worked: ");
            if (scanner.hasNextDouble()){
                hoursWorked = scanner.nextDouble();
                if (hoursWorked < 0 || hoursWorked > hoursLimit){
                    System.out.println("Hours worked cannot be less than zero, or more than sixteen hours in a day!");
                } else {
                    isHoursValid = true;
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number for hours worked");
                scanner.next();
            }
        }
        return hoursWorked;
    }

    /**
     * Method used to grab the date the user worked
     * @param scanner - Object passed as a parameter grab the input from the user
     * @return dateString that holds the users input (date) in a String type.
     */
    public static String getDateWorked(Scanner scanner){
        scanner.nextLine();
        String dateString = "";
        LocalDate date = null;

        while (date == null){
            System.out.println("Please enter the date that you worked (dd-mm-yyyy): ");
            dateString = scanner.nextLine();

            date = parseDateUsingLocalDate(dateString);

            if (date == null){
                System.out.println("Please enter the date that you worked (dd-mm-yyyy): ");
            }
        }

        return dateString;  //Validation needed, just setting up the methods to begin.
    }


    /**
     * Parses the dateString inputed by the user to make sure its in the right format.
     * @param dateString - the string inputted by the user
     * @return The date in dd-mm-yyyy format.
     */
    private static LocalDate parseDateUsingLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;

        try{
            date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e){
            System.out.println("Invalid date format! Please use dd-mm-yyyy format");
        }
        return date;
    }



    public static PayrollDetails getPayRollEntries(Scanner scanner){
        ArrayList<Payroll> payrollEntries = new ArrayList<>();
        boolean areThereMoreEntries = true;

        String employeeName = EmployeeInput.getName(scanner);
        double payRate = EmployeeInput.getRate(scanner);
        scanner.nextLine();

        Employee employee = new Employee(employeeName, payRate);

        while (areThereMoreEntries){
            double hoursWorked = getHoursWorked(scanner);
            String dateWorked = getDateWorked(scanner);
            payrollEntries.add(new Payroll(employee, dateWorked, hoursWorked));

            System.out.println("Are there any more entries to enter? (y/n)");
            String answer = scanner.next();
            areThereMoreEntries = answer.equalsIgnoreCase("y");
            scanner.nextLine();
        }

        return new PayrollDetails(employee, payrollEntries);
    }


}//class
