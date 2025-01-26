package org.example;
import java.util.List;

public record PayrollDetails(Employee employee, List<Payroll> payrollEntries) { }
