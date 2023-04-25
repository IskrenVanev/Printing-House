package org.example.Models.Employees;

import org.example.Models.Employees.Employee;
import org.example.Models.PrintingHouse;

public class Manager  extends Employee {
    private double bonusPercentage;
    public Manager(String name, int id, double bonusPercentage) {
        super(name, id);
        this.bonusPercentage = bonusPercentage;
    }
    public double calculateSalary(double baseSalary, PrintingHouse printingHouse) {
       //TODO: Check if the income is better than expected!!!
        double salary = baseSalary + ((this.bonusPercentage/100)*baseSalary);
      //  double salary = baseSalary;
      //  if (printingHouse.getIncome() > printingHouse.getRevenueThreshold()) {
      //      salary += (bonusPercentage / 100) * baseSalary;
      //  }
      //  return salary;
        return salary;
    }

}
