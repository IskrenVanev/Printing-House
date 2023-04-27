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
    private List<PrintingMachine> PrintingMachines;

    private double expectedIncome;//expected Income
    private double actualIncome;//TODO: implement the logic about it
    private double baseSalary;
    private int numberOfPrintedThingsAfterWhichCustomerGetsDiscount;
    private boolean isNumberOfPrintedThingsAfterWhichCustomerGetsDiscountSet = false;

    private double percentageDiscount;
    private boolean isPercentageDiscountSet = false;


    public PrintingHouse(double expectedIncome, double baseSalary) {
        this.expectedIncome = expectedIncome;
        this.baseSalary = baseSalary;
        this.employees = new HashSet<>();
        this.PrintBookOrPosterOrNewspaper = new ArrayList<>();
        this.boughtPapers = new ArrayList<>();
        this.PrintingMachines = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addToPrintBookOrPosterOrNewspaper(PrintBookOrPosterOrNewspaper pSth) {
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
    public double CalculatePrintingHouseIncome(double percentageDiscount){
        double sum = 0;
        if (numberOfPrintedThingsAfterWhichCustomerGetsDiscount > PrintBookOrPosterOrNewspaper.size()){
            this.setPercentageDiscount(percentageDiscount);
        }
        for (PrintBookOrPosterOrNewspaper printBookOrPosterOrNewspaper : PrintBookOrPosterOrNewspaper) {
            sum += (printBookOrPosterOrNewspaper.GetPriceForPrintingSomething(printBookOrPosterOrNewspaper, printBookOrPosterOrNewspaper.getPageSize()))
                    - (percentageDiscount/100 *
                    printBookOrPosterOrNewspaper.GetPriceForPrintingSomething(printBookOrPosterOrNewspaper, printBookOrPosterOrNewspaper.getPageSize()));
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

    public void setNumberOfPrintedThingsAfterWhichCustomerGetsDiscount(int numberOfPrintedThingsAfterWhichCustomerGetsDiscount) {
        if (isNumberOfPrintedThingsAfterWhichCustomerGetsDiscountSet){
            return;
        }
        this.numberOfPrintedThingsAfterWhichCustomerGetsDiscount = numberOfPrintedThingsAfterWhichCustomerGetsDiscount;
        isNumberOfPrintedThingsAfterWhichCustomerGetsDiscountSet = true;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        if (isPercentageDiscountSet){
            return;
        }
        if (percentageDiscount <0 || percentageDiscount >100){
            throw new IllegalArgumentException("Percentage must be between 0 and 100");//TODO:catch this
        }
        this.percentageDiscount = percentageDiscount;
        isPercentageDiscountSet = true;
    }
}
