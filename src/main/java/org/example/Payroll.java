package org.example;

public record Payroll(Employee employee, String date, double hoursWorked) {

    public double calculatePay() {
        return hoursWorked * employee.payRate();
        //TODO: Implement overtime and holiday/weekend modification.
    }


} //class

