package org.example;

import java.util.Scanner;

public class EmployeeInput {

    /**
     * Prompting the user for their name
     * @param scanner - used grab user input
     * @return The user's name, as inputted by the user.
     */
    public static String getName(Scanner scanner){
        String name = "";
        String regex = "^[A-Za-zÀ-ÿ' -]+$";
        boolean isNameValid = false;

        while (!isNameValid) {
            System.out.println("Please enter your name:");
            name = scanner.nextLine();
            if (name.isBlank()) {
                System.out.println("Name cannot be blank");
            } else if (name.matches(regex)) {
                isNameValid = true;
            } else {
                System.out.println("Please enter a valid name");
            }
        }
        return name;
    }


    /**
     * Prompting the user for their hourly rate
     * @param scanner - used to grab user input
     * @return The users rate, as inputted by the user
     */
    public static double getRate(Scanner scanner){
        double rate = 0.0;
        boolean isRateValid = false;

        while (!isRateValid) {
            System.out.println("Please enter your hourly rate:");
            if (scanner.hasNextDouble()) {
                rate = scanner.nextDouble();
                if (rate < 0) {
                    System.out.println("Hourly rate cannot be negative");
                } else {
                    isRateValid = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value");
                scanner.next(); // Clear the invalid input
            }
        }

        return rate;

    }


}
