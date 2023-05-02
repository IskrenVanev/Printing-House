package org.example.Models.Employees;

import org.example.Models.Employees.Employee;
import org.example.Models.PrintingHouse;

public class Manager extends Employee {
    private double bonusPercentage;

    public Manager(String name, double bonusPercentage) {
        super(name);
        this.bonusPercentage = bonusPercentage;
    }

    public double calculateSalary(PrintingHouse printingHouse) {


        double salary = printingHouse.getBaseSalary();

        if (printingHouse.getActualIncome() > printingHouse.getExpectedIncome()) {
            salary += (bonusPercentage / 100) * salary;
        }

        return salary;
    }

}
