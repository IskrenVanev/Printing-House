package org.example.Models;

import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Enums.ThingType;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintingHouse {
    private List<PrintBookOrPosterOrNewspaper> PrintBookOrPosterOrNewspaper;
    private Set<Employee> employees;
    private List<Double> boughtPapers;

    private double expectedIncome;//expected Income
    private double actualIncome;//TODO: implement the logic about it
    private double baseSalary;

    public PrintingHouse(double expectedIncome, double baseSalary) {
        this.expectedIncome = expectedIncome;
        this.baseSalary = baseSalary;
        this.employees = new HashSet<>();
        this.PrintBookOrPosterOrNewspaper = new ArrayList<>();
        this.boughtPapers = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addToPrintSomethingList(PrintBookOrPosterOrNewspaper pSth) {
        PrintBookOrPosterOrNewspaper.add(pSth);
    }

    public double calculateTotalSalaryExpenses() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof PrintingMachineOperator) {
                totalSalary += employee.calculateSalary(baseSalary);
            } else if (employee instanceof Manager) {
                totalSalary += ((Manager) employee).calculateSalary(baseSalary, this);
            }

        }
        return totalSalary;
    }

    public double buyPaper(int numberOfPapers, PaperType paperType, PageSizeType pageSizeType) {
        double sum = 0;


        sum += numberOfPapers * paperType.getPrice(pageSizeType);

        boughtPapers.add(sum);
        return sum;
    }

    public double calculatePaperExpenses() {
        double sum = 0;
        for(Double boughtPaper : boughtPapers){
            sum+= boughtPaper;
        }
        return sum;
    }

    //   public double calculatePaperExpenses() {
    //       double sum = 0;
    //       for (PrintBookOrPosterOrNewspaper printSomething : PrintBookOrPosterOrNewspaper) {
    //           sum += printSomething.GetPriceForPrintingSomething(printSomething, printSomething.getPageSize());
    //       }
    //       return sum;
    //   }

    public double getExpectedIncome() {
        return expectedIncome;
    }

    public double getActualIncome() {
        return actualIncome;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
