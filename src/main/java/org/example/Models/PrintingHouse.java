package org.example.Models;

import org.example.Enums.ColorType;
import org.example.Enums.PageSizeType;
import org.example.Enums.PaperType;
import org.example.Models.Employees.Employee;
import org.example.Models.Employees.Manager;
import org.example.Models.Employees.PrintingMachineOperator;
import org.example.Models.Prints.PrintingHousePublication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintingHouse {
    private List<PrintingHousePublication> PrintingHousePublications;
    private Set<Employee> employees;
    private List<Double> boughtPapers;
    private List<PrintingMachine> PrintingMachines;

    private double expectedIncome;//expected Income
    private double actualIncome;
    private double baseSalary;
    private int numberOfPrintedThingsAfterWhichCustomerGetsDiscount;
    private boolean isNumberOfPrintedThingsAfterWhichCustomerGetsDiscountSet = false;

    private double percentageDiscount;
    private boolean isPercentageDiscountSet = false;


    public PrintingHouse(double expectedIncome, double baseSalary) {
        this.expectedIncome = expectedIncome;
        this.baseSalary = baseSalary;
        this.employees = new HashSet<>();
        this.PrintingHousePublications = new ArrayList<>();
        this.boughtPapers = new ArrayList<>();
        this.PrintingMachines = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addToPrintBookOrPosterOrNewspaper(PrintingHousePublication pSth) {
        PrintingHousePublications.add(pSth);
    }

    public void BuyPrintingMachinesBW(int countBW,  int maxCapacityPaper, int maxPrintedOneMin, int LoadedPaper){
        PrintingMachine printingMachine =
                new PrintingMachine(maxCapacityPaper , ColorType.BLACK_AND_WHITE, maxPrintedOneMin, LoadedPaper);
        for (int i = 0; i<countBW;i++){

            PrintingMachines.add(printingMachine);
        }
    }
    public void BuyPrintingMachinesCLR(int countCLR,  int maxCapacityPaper, int maxPrintedOneMin, int LoadedPaper){
        PrintingMachine printingMachine =
                new PrintingMachine(maxCapacityPaper , ColorType.COLORED, maxPrintedOneMin, LoadedPaper);
        for (int i = 0; i<countCLR;i++){

            PrintingMachines.add(printingMachine);
        }
    }
    public double calculateTotalSalaryExpenses() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof PrintingMachineOperator) {
                totalSalary += employee.calculateSalary(baseSalary);
            } else if (employee instanceof Manager) {
                totalSalary += ((Manager) employee).calculateSalary(this);
            }

        }
        return totalSalary;
    }
    public double calculatePaperExpenses() {
        double sum = 0;
        for(Double boughtPaper : boughtPapers){
            sum+= boughtPaper;
        }
        return sum;
    }
    public double buyPaper(int numberOfPapers, PaperType paperType, PageSizeType pageSizeType) {
        double sum = 0;


        sum += numberOfPapers * paperType.getPrice(pageSizeType);

        boughtPapers.add(sum);
        return sum;
    }


    public double CalculatePrintingHouseIncome(double percentageDiscount){
        double sum = 0;
        if (numberOfPrintedThingsAfterWhichCustomerGetsDiscount > PrintingHousePublications.size()){
            this.setPercentageDiscount(percentageDiscount);
        }

        for (PrintingHousePublication printingHousePublication : PrintingHousePublications) {
            double priceForPrinting = printingHousePublication.getPriceForPrinting(printingHousePublication.getPageSize());
            double priceForSelling = priceForPrinting * (1 + printingHousePublication.getOverchargePercentage() / 100);
            double priceAfterDiscount = priceForSelling * (1 - percentageDiscount / 100);
            sum += priceAfterDiscount - priceForPrinting;
        }
        this.actualIncome = sum;
        return sum;
    }

    public void setExpectedIncome(double expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

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

    public void setPercentageDiscount(double percentageDiscount) throws IllegalArgumentException{
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
