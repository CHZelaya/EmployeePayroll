package org.example;

import java.io.Serializable;
import java.util.List;

public record PayrollDetails(Employee employee, List<Payroll> payrollEntries) {
}
