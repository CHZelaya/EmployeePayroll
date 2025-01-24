package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Payroll {
    private static Employee employee;
    private String date;
    private int hoursWorked;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Payroll(String date, int hoursWorked) {
        this.date = date;
        this.hoursWorked = hoursWorked;
    }


    /**
     * Method to get the date of the hours worked from the user
     * @param scanner
     * @return The date as a String.
     */
    public static String getDate(Scanner scanner) {
        //Method variables
        String dateString = "";
        Boolean isDateValid = false;

        // Ask user for input while isDateValid is false.
        while (!isDateValid) {
            System.out.println("Please enter a valid date in dd-mm-yyyy format. ");
            scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            //TODO: Validate date, as user can input any combination of numbers, as long as it starts in xx-xx-xxxx format.
            //! MAJOR BUG HERE: DATE VALIDATION REQUIRED

            dateString = scanner.nextLine();
            //Initial dateString validation by checking length
                try {
                    Date date = formatter.parse(dateString);
                    System.out.println("You entered: " + formatter.format(date));
                } catch (Exception e) {
                    System.out.println("Invalid date, please enter a valid date in dd-mm-yyyy format. ");
                    scanner.nextLine();
                }
                isDateValid = true;
                System.out.println("Closing function successfully");
            }

            return dateString;
    }






//Creating an array list to store the hours worked.


    //? Haven't decided on the array list yet.
    //private ArrayList<Double> hoursWorked = new ArrayList<>();



} //class

