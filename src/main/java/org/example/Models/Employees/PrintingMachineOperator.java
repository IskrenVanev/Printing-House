package org.example.Models.Employees;

import org.example.Models.Employees.Employee;

import java.io.Serializable;

public class PrintingMachineOperator  extends Employee implements Serializable{
    public PrintingMachineOperator(String name) {
        super(name);
    }

    public double calculateSalary(double baseSalary) {
        return baseSalary;
    }

}
