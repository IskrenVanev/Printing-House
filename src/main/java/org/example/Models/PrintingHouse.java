package org.example.Models;

import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;

import java.util.ArrayList;
import java.util.List;

public class PrintingHouse {
    //private PrintSomething printSomething; // that may be a method instead of field!!!//TODO: think about it
    private List<Employee> employees;

    private double expectedIncome;//expected Income
    private double baseSalary;

    public PrintingHouse(double expectedIncome, double baseSalary) {
        this.expectedIncome = expectedIncome;
        this.baseSalary = baseSalary;
        this.employees = new ArrayList<>();
    }
    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof PrintingMachineOperator){
                totalSalary += employee.calculateSalary(baseSalary);
            }
            else if (employee instanceof Manager) {
                totalSalary += ((Manager) employee).calculateSalary(baseSalary, this);
            }

        }
        return totalSalary;
    }

    public double getExpectedIncome() {
        return expectedIncome;
    }
}
