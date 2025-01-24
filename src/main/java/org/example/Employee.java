package org.example;

/**
 * Class responsible for holding Employee Data (Name and Rate)
 */
public class Employee {
    private String name;
    private double payRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

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

}//class
