package org.example;


import java.util.Scanner;

public class Employee {
    private String name;
    private double payRate;

    public Employee(String name, double payRate) {
        this.name = name;
        this.payRate = payRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", payRate=" + payRate +
                '}';
    }

    public static String getName(Scanner scanner) {
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

    public static double getHourlyRate(Scanner scanner) {
        double hourlyRate = 0.0;
        boolean isHourlyRateValid = false;

        while (!isHourlyRateValid) {
            System.out.println("Please enter your hourly rate:");
            if (scanner.hasNextDouble()) {
                hourlyRate = scanner.nextDouble();
                if (hourlyRate < 0) {
                    System.out.println("Hourly rate cannot be negative");
                } else {
                    isHourlyRateValid = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value");
                scanner.next(); // Clear the invalid input
            }
        }
        return hourlyRate;
    }



}//class
