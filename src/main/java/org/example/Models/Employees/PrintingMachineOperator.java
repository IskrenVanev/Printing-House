package org.example.Models.Employees;

import org.example.Models.Employees.Employee;

public class PrintingMachineOperator extends Employee {
    public PrintingMachineOperator(String name, int id) {
        super(name);
    }

    public double calculateSalary(double baseSalary) {
        return baseSalary;
    }

}
