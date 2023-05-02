package org.example.Models.Employees;

import org.example.Models.Employees.Employee;

public class PrintingMachineOperator extends Employee {
    public PrintingMachineOperator(String name) {
        super(name);
    }

    public double calculateSalary(double baseSalary) {
        return baseSalary;
    }

}
