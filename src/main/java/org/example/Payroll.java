package org.example;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public record Payroll(Employee employee, String date, double hoursWorked) {

    public double calculatePay() {
        double regularPay = 0;
        double bonusPay = 0;
        double overtimePay = 0;
        double holidayPay = 0;
        double differentialPay = 0;
        double totalPay = 0;
        double payRate = employee.payRate();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Adjust the pattern as needed
        LocalDate localDate = LocalDate.parse(date, formatter);

        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            differentialPay = calculateWeekendPay(hoursWorked);
        } else if (isHoliday(localDate)) {
            holidayPay = calculateHolidayPay(hoursWorked);
        } else if (hoursWorked > 7.5) {
            regularPay = payRate * 7.5;
            overtimePay = calculateOvertimePay(hoursWorked);
        } else {
            String currency = formatCurrency(payRate * hoursWorked);
            System.out.println("RegularPay: " + currency + " -- " + "Date: " + date);
            regularPay = payRate * hoursWorked;
        }

        bonusPay = overtimePay + holidayPay + differentialPay;

        totalPay = regularPay + bonusPay;

        //String currency = formatCurrency(totalPay);

        return totalPay;
    }

    private double calculateOvertimePay(double hoursWorked) {
        double overTimeCutOff = 7.5;
        double totalOverTime = (hoursWorked - overTimeCutOff);
        String overtimeCurrency = formatCurrency(totalOverTime * (employee.payRate() * 1.5));
        String regPayCurrency = formatCurrency(employee.payRate() * 7.5);
        System.out.println("Total overtime pay: " + overtimeCurrency + " -- " + "Date: " + date);
        System.out.println("Regular Pay: " + regPayCurrency + " -- " + "Date: " + date);
        return totalOverTime * (employee.payRate() * 1.5);
    }

    private double calculateWeekendPay(double hoursWorked) {
        String currency = formatCurrency(hoursWorked * (employee.payRate() * 1.5));
        System.out.println("Total weekend pay: " + currency + " -- " + "Date: " + date);
        return hoursWorked  * (employee.payRate() * 1.5);
    }

    private double calculateHolidayPay(double hoursWorked) {
        String currency = formatCurrency(hoursWorked * (employee.payRate() * 1.5));
        System.out.println("Total holiday pay: " + currency + " -- " + "Date: " + date);
        return hoursWorked  * (employee.payRate() * 1.5);
    }

    private boolean isHoliday(LocalDate localDate) {
        for (AlbertaHoliday holiday : AlbertaHoliday.values()) {
            if (localDate.equals(holiday.getDate())) {
                return true; // It's a holiday
            }
        }
        return false; // Not a holiday
    }

    public String formatCurrency(double amount) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.CANADA); // Change Locale as needed
        return currencyFormatter.format(amount);
    }


} //class

